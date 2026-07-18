package com.example.periodictable;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ElementDetail extends AppCompatActivity {

    private FavoritesManager favManager;
    private boolean isFav = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        new ThemeManager(this).applyTheme();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_element_detail);

        favManager = new FavoritesManager(this);

        Element element = (Element) getIntent().getSerializableExtra("element");

        if (element != null) {
            TextView tvNumber = findViewById(R.id.tv_detail_number);
            TextView tvSymbol = findViewById(R.id.tv_detail_symbol);
            TextView tvName = findViewById(R.id.tv_detail_name);
            TextView tvMass = findViewById(R.id.tv_detail_mass);

            TextView tvProtons = findViewById(R.id.tv_protons);
            TextView tvElectrons = findViewById(R.id.tv_electrons);
            TextView tvNeutrons = findViewById(R.id.tv_neutrons);

            TextView tvMelting = findViewById(R.id.tv_melting);
            TextView tvBoiling = findViewById(R.id.tv_boiling);
            TextView tvDesc = findViewById(R.id.tv_description);
            TextView tvUses = findViewById(R.id.tv_uses);
            TextView tvFact = findViewById(R.id.tv_fact);
            TextView tvDiscoverer = findViewById(R.id.tv_discoverer);
            TextView tvYear = findViewById(R.id.tv_discovery_year);
            TextView tvOrigin = findViewById(R.id.tv_discovery_origin);
            
            ImageButton btnFavorite = findViewById(R.id.btn_favorite);

            tvNumber.setText(String.valueOf(element.number));
            tvSymbol.setText(element.symbol);
            tvName.setText(element.name);
            tvMass.setText(element.mass);

            // 1. Calculate Proton/Electron (= Atomic Number)
            tvProtons.setText(String.valueOf(element.number));
            tvElectrons.setText(String.valueOf(element.number));

            // 2. Calculate Neutron (= Mass - Number)
            int neutrons = calculateNeutrons(element.mass, element.number);
            tvNeutrons.setText(String.valueOf(neutrons));

            ExtendedData data = ExtendedData.get(element.number, element.name);
            tvMelting.setText(data.mp);
            tvBoiling.setText(data.bp);
            tvDesc.setText(data.funFact); // Using Fact as desc intro
            tvUses.setText(data.uses);
            tvFact.setText(data.funFact);
            tvDiscoverer.setText("Discoverer: " + data.discoverer);
            tvYear.setText("Year: " + data.year);
            tvOrigin.setText("Location: " + data.origin);

            // Set up Favorites
            isFav = favManager.isFavorite(element.number);
            updateFavoriteIcon(btnFavorite);

            btnFavorite.setOnClickListener(v -> {
                favManager.toggleFavorite(element.number);
                isFav = !isFav;
                updateFavoriteIcon(btnFavorite);
                if (isFav) {
                    Toast.makeText(this, element.name + " added to Favorites!", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    private void updateFavoriteIcon(ImageButton btn) {
        if (isFav) {
            btn.setImageResource(android.R.drawable.btn_star_big_on);
            btn.setImageTintList(ColorStateList.valueOf(Color.parseColor("#FFC107")));
        } else {
            btn.setImageResource(android.R.drawable.btn_star_big_off);
            btn.setImageTintList(ColorStateList.valueOf(Color.parseColor("#AAAAAA")));
        }
    }

    private int calculateNeutrons(String massStr, int atomicNumber) {
        try {

            String cleanMass = massStr.replaceAll("[^0-9.]", "");
            double mass = Double.parseDouble(cleanMass);
            int roundedMass = (int) Math.round(mass);
            return roundedMass - atomicNumber;
        } catch (Exception e) {
            return 0;
        }
    }
}
