package com.example.periodictable;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import com.google.firebase.auth.FirebaseAuth;

public class HomeActivity extends AppCompatActivity {

    TextView _home_tv_welcome;
    Button _home_btn_explore, _home_btn_settings;
    private ThemeManager themeManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        themeManager = new ThemeManager(this);
        themeManager.applyTheme();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        _home_tv_welcome = findViewById(R.id.home_tv_welcome);
        _home_btn_explore = findViewById(R.id.home_btn_explore);
        _home_btn_settings = findViewById(R.id.home_btn_settings);

        _home_tv_welcome.setText("Welcome!");

        _home_btn_explore.setOnClickListener(v -> {
            startActivity(new Intent(HomeActivity.this, Periodic_table.class));
        });

        _home_btn_settings.setOnClickListener(v -> {
            startActivity(new Intent(HomeActivity.this, SettingsActivity.class));
        });
    }
}