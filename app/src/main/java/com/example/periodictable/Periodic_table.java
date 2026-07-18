package com.example.periodictable;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector; // NEW
import android.view.View;
import android.graphics.Color;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.cardview.widget.CardView;
import java.util.ArrayList;
import java.util.List;

public class Periodic_table extends AppCompatActivity implements Fragment_filter.FilterListener {
    GridLayout gridLayout;
    SearchView searchView;
    Button btnFilter, btnSettings, btnFavorites;
    private ThemeManager themeManager;

    ArrayList<Element> allElements;
    String currentQuery = "";
    String currentCategory = "All";
    String currentBlock = "All";

    private ScaleGestureDetector scaleGestureDetector;
    private float scaleFactor = 1.0f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        themeManager = new ThemeManager(this);
        themeManager.applyTheme();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_periodic_table);

        gridLayout = findViewById(R.id.gridLayout);
        searchView = findViewById(R.id.searchView);
        btnFilter = findViewById(R.id.btn_filter);
        btnSettings = findViewById(R.id.btn_settings);
        btnFavorites = findViewById(R.id.btn_favorites);

        scaleGestureDetector = new ScaleGestureDetector(this, new ScaleListener());

        allElements = ElementData.getElements();
        updateGrid(allElements);

        // Search Logic
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override public boolean onQueryTextSubmit(String query) { return false; }
            @Override public boolean onQueryTextChange(String newText) {
                currentQuery = newText.toLowerCase();
                applyFilters();
                return true;
            }
        });

        // Filter Logic
        btnFilter.setOnClickListener(v -> {
            try {
                Fragment_filter dialog = new Fragment_filter();
                dialog.show(getSupportFragmentManager(), "FilterDialog");
            } catch (Exception e) {
                Toast.makeText(this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        // Settings Button
        btnSettings.setOnClickListener(v -> {
            Intent i = new Intent(this, SettingsActivity.class);
            startActivity(i);
        });

        // Favorites Logic
        btnFavorites.setOnClickListener(v -> {
            if (currentCategory.equals("Favorites")) {
                currentCategory = "All";
                btnFavorites.setText("★Favs");
            } else {
                currentCategory = "Favorites";
                btnFavorites.setText("★All");
            }
            applyFilters();
        });
    }

    // --- ZOOM LOGIC (Intercept Touches) ---
    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        // Let the Zoom Detector see the touch event FIRST
        super.dispatchTouchEvent(event);
        return scaleGestureDetector.onTouchEvent(event);
    }

    // Private Zoom Handler Class
    private class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        @Override
        public boolean onScale(ScaleGestureDetector detector) {
            scaleFactor *= detector.getScaleFactor();

            // Limit Zoom: Min 0.5x, Max 3.0x
            scaleFactor = Math.max(0.5f, Math.min(scaleFactor, 3.0f));

            // Apply Scale to the Grid
            gridLayout.setScaleX(scaleFactor);
            gridLayout.setScaleY(scaleFactor);

            return true;
        }
    }

    // --- FILTER & GRID LOGIC ---
    @Override
    public void onFilterApplied(String category, String block) {
        currentCategory = category;
        currentBlock = block;
        applyFilters();
        Toast.makeText(this, "State: " + category + "  Block: " + block, Toast.LENGTH_SHORT).show();
    }

    private void applyFilters() {
        ArrayList<Element> filteredList = new ArrayList<>();
        FavoritesManager favs = new FavoritesManager(this);
        for (Element e : allElements) {
            boolean matchesSearch = e.name.toLowerCase().contains(currentQuery) ||
                    e.symbol.toLowerCase().contains(currentQuery) ||
                    String.valueOf(e.number).contains(currentQuery);

            boolean matchesCategory;
            if (currentCategory.equals("Favorites")) {
                matchesCategory = favs.isFavorite(e.number);
            } else {
                matchesCategory = currentCategory.equals("All") || e.getState().equals(currentCategory);
            }

            boolean matchesBlock = true;
            if (!currentBlock.equals("All") && !e.getBlock().equals("Label")) {
                if (e.getBlock().equals("Placeholder")) {
                    matchesBlock = currentBlock.equals("f-block");
                } else {
                    matchesBlock = e.getBlock().equals(currentBlock);
                }
            }

            if (matchesSearch && matchesCategory && matchesBlock) {
                filteredList.add(e);
            }
        }
        updateGrid(filteredList);
    }



    private void updateGrid(ArrayList<Element> elements) {
        gridLayout.removeAllViews(); // Clear old items

        for (Element e : elements) {
            String block = e.getBlock();

            if (block.equals("Label")) {
                TextView tv = new TextView(this);
                tv.setText(e.name);
                tv.setTextSize(18f);
                tv.setTextColor(Color.parseColor("#888888"));
                tv.setGravity(Gravity.CENTER);
                
                GridLayout.LayoutParams labelParams = new GridLayout.LayoutParams();
                labelParams.rowSpec = GridLayout.spec(e.row, 1f);
                labelParams.columnSpec = GridLayout.spec(e.col, 1f);
                labelParams.setMargins(8, 8, 8, 8);
                labelParams.setGravity(Gravity.CENTER);
                tv.setLayoutParams(labelParams);
                
                gridLayout.addView(tv);
                continue;
            }


            View card = getLayoutInflater().inflate(R.layout.element_item, gridLayout, false);

            TextView tvNum = card.findViewById(R.id.tv_atomic_number);
            TextView tvSym = card.findViewById(R.id.tv_symbol);
            TextView tvName = card.findViewById(R.id.tv_name);

            if (block.equals("Placeholder")) {
                tvNum.setVisibility(View.GONE);
                tvSym.setText(e.symbol);
                tvSym.setTextSize(16f);
                tvName.setText(e.name);
                tvName.setTextSize(11f);
            } else {
                tvNum.setVisibility(View.VISIBLE);
                tvNum.setText(String.valueOf(e.number));
                tvSym.setText(e.symbol);
                tvName.setText(e.name);
            }

            int color;

            if (block.equals("s-block")) {
                color = Color.parseColor("#EF5350");
            } else if (block.equals("p-block")) {
                color = Color.parseColor("#F57C00");
            } else if (block.equals("d-block")) {
                color = Color.parseColor("#42A5F5");
            } else if (block.equals("f-block")) {
                color = Color.parseColor("#66BB6A");
            } else if (block.equals("Placeholder")) {
                color = Color.parseColor("#444444");
            } else {
                color = Color.parseColor("#1976D2");
            }

            ((CardView) card).setCardBackgroundColor(color);

            GridLayout.LayoutParams params = new GridLayout.LayoutParams();
            params.rowSpec = GridLayout.spec(e.row, 1f);
            params.columnSpec = GridLayout.spec(e.col, 1f);
            params.setMargins(8, 8, 8, 8);
            card.setLayoutParams(params);

            if (block.equals("Placeholder")) {
                card.setOnClickListener(null);
                ((CardView) card).setCardElevation(0f);
            } else {
                card.setOnClickListener(v -> {
                    Intent i = new Intent(Periodic_table.this, ElementDetail.class);
                    i.putExtra("element", e);
                    startActivity(i);
                });
            }

            gridLayout.addView(card);
        }
    }
}
