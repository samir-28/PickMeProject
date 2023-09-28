package com.example.pickme;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    Button login,register;
    TextView reset ;
    EditText email, password;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);
        getSupportActionBar().hide();
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        login=findViewById(R.id.signin);
        register= findViewById(R.id.signup);
        reset=findViewById(R.id.forgotpass);

     //   reset.setPaintFlags(reset.getPaintFlags()  | Paint.UNDERLINE_TEXT_FLAG );
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent clr=new Intent(LoginActivity.this,ForgotPass.class);
                startActivity(clr);
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(i);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (valid()) {
                    FirebaseAuth auth = FirebaseAuth.getInstance();
                    auth.signInWithEmailAndPassword(email.getText().toString(),
                            password.getText().toString()).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                        @Override
                        public void onSuccess(AuthResult authResult) {
                            Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(LoginActivity.this,MenuList.class);
                            startActivity(i);
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(LoginActivity.this, "Unable to Login,Please check your email and password!!", Toast.LENGTH_SHORT).show();
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
    @Override
    public void onBackPressed() {
        AlertDialog.Builder alertDialog=new AlertDialog.Builder(LoginActivity.this);
        alertDialog.setTitle("Exit App");
        alertDialog.setMessage("Do you want to exit app?");
        alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finishAffinity();


            }
        });
        alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();

            }
        });
        alertDialog.show();

    }
}
