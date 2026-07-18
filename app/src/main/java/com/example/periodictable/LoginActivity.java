package com.example.periodictable;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

public class LoginActivity extends AppCompatActivity {
    EditText etUsername, etPassword;
    Button btnLogin;
    TextView tvRegister;

    FirebaseAuth fAuth;
    FirebaseFirestore fStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        new ThemeManager(this).applyTheme();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Bind standard layout IDs
        etUsername = findViewById(R.id.main_et_username);
        etPassword = findViewById(R.id.main_et_password);
        btnLogin = findViewById(R.id.main_btn_login);
        tvRegister = findViewById(R.id.main_tv_newuser);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        if(fAuth.getCurrentUser() != null) {
            startActivity(new Intent(LoginActivity.this, HomeActivity.class));
            finish();
            return;
        }


        btnLogin.setOnClickListener(v -> {
            String identifier = etUsername.getText().toString().trim();
            String pass = etPassword.getText().toString().trim();

            if (identifier.isEmpty() || pass.isEmpty()) {
                Toast.makeText(this, "Please enter all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            if (identifier.contains("@")) {
                loginWithEmail(identifier, pass);
            } else {
                fStore.collection("users").whereEqualTo("Username", identifier).get()
                    .addOnCompleteListener(task -> {
                        if (task.isSuccessful() && task.getResult() != null && !task.getResult().isEmpty()) {
                            String resolvedEmail = task.getResult().getDocuments().get(0).getString("Email");
                            if (resolvedEmail != null) {
                                loginWithEmail(resolvedEmail, pass);
                            } else {
                                Toast.makeText(this, "Internal database mapping error", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(this, "Username not found!", Toast.LENGTH_SHORT).show();
                        }
                    });
            }
        });

        tvRegister.setOnClickListener(v -> {
            startActivity(new Intent(LoginActivity.this, Register.class));
        });
    }
    private void loginWithEmail(String email, String password) {
        fAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                Toast.makeText(LoginActivity.this, "Login Successful!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                finish();
            } else {
                Toast.makeText(LoginActivity.this, "Error: " + task.getException().getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}