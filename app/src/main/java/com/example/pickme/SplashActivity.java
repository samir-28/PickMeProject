package com.example.pickme;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {
    Thread timer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen);
        getSupportActionBar().hide();
        timer = new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    sleep(1600);
                } catch (Exception e) {
                } finally {


                    Intent i = new Intent(SplashActivity.this, LoginActivity.class);
                    startActivity(i);
                    finish();  // yesle jaba maile back garxu taba yo splash screen ma audaina

                }
            }
        };
        timer.start();

    }
}
