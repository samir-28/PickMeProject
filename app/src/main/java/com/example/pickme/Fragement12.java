package com.example.pickme;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Fragement12 extends AppCompatActivity {


    ListView list;
    ArrayList<Datamodel> data=new ArrayList<>();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.btn12_fragment);
        getSupportActionBar().setTitle("My Selections");
        list=findViewById(R.id.list);
        DataBaseHelper2 display=new DataBaseHelper2(Fragement12.this);
        data=display.readdata();
        list.setAdapter(new Customclass2(Fragement12.this,data));


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu2,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id==R.id.item_back){
            Intent intent=new Intent(Fragement12.this,MenuList.class);
            startActivity(intent);
            Toast.makeText(this, "Returned home", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i=new Intent(Fragement12.this,MenuList.class);
        startActivity(i);
    }
}

