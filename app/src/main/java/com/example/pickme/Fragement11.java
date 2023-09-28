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

public class Fragement11 extends AppCompatActivity {

   // Button add;
    ListView list;
   // ArrayAdapter<String> adapter;
    //String[] array = {"Samir", "cr7"};
    ArrayList<Datamodel> data=new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.btn11_fragment);
        //   listViewData=findViewById(R.id.listview_data);
        getSupportActionBar().setTitle("My Lists");
        //  add=findViewById(R.id.add);

        list=findViewById(R.id.list);
        Datbasehelper display=new Datbasehelper(Fragement11.this);
        data=display.readdata();
        list.setAdapter(new Customclass(Fragement11.this,data));

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
            Intent intent=new Intent(Fragement11.this,MenuList.class);
            startActivity(intent);
            Toast.makeText(this, "Returned home", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i=new Intent(Fragement11.this,MenuList.class);
        startActivity(i);
    }
}

