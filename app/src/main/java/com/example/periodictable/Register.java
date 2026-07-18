package com.example.periodictable;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;
import android.graphics.Color;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Register extends AppCompatActivity {
    EditText etUsername, etPassword, etEmail, etContact;
    RadioGroup rgGender;
    Spinner spinnerStatus;
    CheckBox cbTerms;
    Button btnSubmit;

    FirebaseAuth fAuth;
    FirebaseFirestore fStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        new ThemeManager(this).applyTheme();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etUsername = findViewById(R.id.et_username);
        etPassword = findViewById(R.id.et_password);
        etEmail = findViewById(R.id.et_email);
        etContact = findViewById(R.id.et_contact);
        rgGender = findViewById(R.id.rg_gender);
        spinnerStatus = findViewById(R.id.spinner_status);
        cbTerms = findViewById(R.id.cb_terms);
        btnSubmit = findViewById(R.id.btn_submit);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        String[] statuses = {"Active", "Inactive"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, statuses);
        spinnerStatus.setAdapter(adapter);

        cbTerms.setOnCheckedChangeListener((buttonView, isChecked) -> {
            btnSubmit.setEnabled(isChecked);
        });

        btnSubmit.setOnClickListener(v -> {
            String username = etUsername.getText().toString().trim();
            String password = etPassword.getText().toString().trim();
            String email = etEmail.getText().toString().trim();
            String contact = etContact.getText().toString().trim();
            String status = spinnerStatus.getSelectedItem().toString();

            int selectedGenderId = rgGender.getCheckedRadioButtonId();
            String gender = "Not Selected";
            if (selectedGenderId == R.id.rb_male) gender = "Male";
            else if (selectedGenderId == R.id.rb_female) gender = "Female";

            if(TextUtils.isEmpty(username)) { etUsername.setError("Username required"); return; }
            if(TextUtils.isEmpty(email)) { etEmail.setError("Email required"); return; }
            if(TextUtils.isEmpty(password) || password.length() < 6) { etPassword.setError("Password must be >= 6 chars"); return; }
            if(TextUtils.isEmpty(contact)) { etContact.setError("Contact required"); return; }

            String finalGender = gender;
            fAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(task -> {
                if (task.isSuccessful()) {
                    FirebaseUser user = fAuth.getCurrentUser();
                    if(user != null) {
                        String uid = user.getUid();

                        Map<String, Object> userData = new HashMap<>();
                        userData.put("Username", username);
                        userData.put("Email", email);
                        userData.put("Contact", contact);
                        userData.put("Gender", finalGender);
                        userData.put("Status", status);

                        fStore.collection("users").document(uid).set(userData).addOnSuccessListener(aVoid -> {
                            Toast.makeText(Register.this, "Registration Successful!", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                            finish();
                        }).addOnFailureListener(e -> {
                            Toast.makeText(Register.this, "Firestore Error: " + e.getMessage(), Toast.LENGTH_LONG).show();
                        });
                    }
                } else {
                    Exception ex = task.getException();
                    String errorCode = "unknown";
                    String errorMsg = ex != null ? ex.getMessage() : "null exception";
                    if (ex instanceof com.google.firebase.auth.FirebaseAuthException) {
                        errorCode = ((com.google.firebase.auth.FirebaseAuthException) ex).getErrorCode();
                    }
                    Toast.makeText(Register.this,
                        "Code: " + errorCode + "\nMsg: " + errorMsg,
                        Toast.LENGTH_LONG).show();
                }
            });
        });
    }
}
