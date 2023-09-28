package com.example.pickme;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPass extends AppCompatActivity {
    EditText resetemail;
    Button resetpass;
    String email;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgotpassword);
        getSupportActionBar().hide();
        resetemail=findViewById(R.id.resetemail);
        resetpass=findViewById(R.id.resetpass);
        resetpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email = resetemail.getText().toString();

                if (email.isEmpty()){
                    Toast.makeText(ForgotPass.this, "Please enter your email !", Toast.LENGTH_SHORT).show();
                } else {
                    fogotpassword();
                }
            }
        });

    }

    private void fogotpassword() {
        FirebaseAuth auth=FirebaseAuth.getInstance();
        auth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    Toast.makeText(ForgotPass.this, "Check your email", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(ForgotPass.this,LoginActivity.class));
                    finish();
                }else {
                    Toast.makeText(ForgotPass.this, "Error :"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
