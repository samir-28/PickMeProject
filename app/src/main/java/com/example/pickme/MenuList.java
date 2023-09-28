package com.example.pickme;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MenuList extends AppCompatActivity {
    LinearLayout btn1;
    LinearLayout btn2;
    LinearLayout btn3;
    LinearLayout btn4;
    LinearLayout btn5;
    LinearLayout btn6;
    LinearLayout btn7;
    LinearLayout btn8;
    LinearLayout btn9;
    LinearLayout btn10;
    LinearLayout btn11;
    LinearLayout btn12;




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newdashboard);
        getSupportActionBar().hide();
        btn1=findViewById(R.id.one);
        btn2=findViewById(R.id.two);
        btn3=findViewById(R.id.three);
        btn4=findViewById(R.id.four);
        btn5=findViewById(R.id.five);
        btn6=findViewById(R.id.six);
        btn7=findViewById(R.id.seven);
        btn8=findViewById(R.id.eight);
        btn9=findViewById(R.id.nine);
        btn10=findViewById(R.id.ten);
        btn11=findViewById(R.id.eleven);
        btn12=findViewById(R.id.twelve);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MenuList.this,Fragement1.class);
                startActivity(i);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MenuList.this,Fragement2.class);
                startActivity(i);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MenuList.this,Fragement3.class);
                startActivity(i);
    }
});
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MenuList.this,Fragement4.class);
                startActivity(i);
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MenuList.this,Fragement5.class);
                startActivity(i);
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MenuList.this,Fragement6.class);
                startActivity(i);
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MenuList.this,Fragement7.class);
                startActivity(i);
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MenuList.this,Fragement8.class);
                startActivity(i);
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MenuList.this,Fragement9.class);
                startActivity(i);
            }
        });
        btn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MenuList.this,Fragement10.class);
                startActivity(i);
            }
        });
        btn11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MenuList.this,Fragement11.class);
                startActivity(i);
            }
        });
        btn12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MenuList.this,Fragement12.class);
                startActivity(i);
            }
        });
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i=new Intent(MenuList.this,LoginActivity.class);
        startActivity(i);
    }
}
