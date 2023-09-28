package com.example.pickme;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {
    Button login,register;
    EditText email, password;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registerpage);
        getSupportActionBar().hide();
        login=findViewById(R.id.login);
        register=findViewById(R.id.register);
        email = findViewById(R.id.reg_email);
        password = findViewById(R.id.reg_password);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(i);
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (valid()) {
                    FirebaseAuth auth = FirebaseAuth.getInstance();
                    auth.createUserWithEmailAndPassword(email.getText().toString(), password.getText().toString()).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                        @Override
                        public void onSuccess(AuthResult authResult) {
                            Toast.makeText(RegisterActivity.this,"Register Successfully",Toast.LENGTH_SHORT).show();
                            Intent i=new Intent(RegisterActivity.this,LoginActivity.class);
                            startActivity(i);
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(RegisterActivity.this,"Something Went Wrong.. ",Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });
    }

    private boolean valid() {
        boolean validity = true;
        if (TextUtils.isEmpty(email.getText().toString())) { //type vako test empty xa ki  nai
            email.setError("You must enter your email..!");
            validity = false;
        }
        if (!email.getText().toString().contains("@")) {
            email.setError("Your email must contain'@'");
            validity = false;
        }
        if (TextUtils.isEmpty(password.getText().toString())) {
            password.setError("You must enter your password..!");
            validity = false;
        }

        return validity;




    }
}
