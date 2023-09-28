package com.example.pickme;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Fragement5 extends AppCompatActivity {

    Button add;
    ListView listViewData;
    ArrayAdapter<String> adapter;
    String[] array = {"First Aid Kit", "Band-aids", "Antiseptic", "Tweezers",
            "Thermometer", "Pain relievers ",
            "Prescription medications ",
            "Allergy medication ",
            "Cough syrup or lozenges",
            "Cold and flu medication",
            "Digestive aids",
            "Adhesive tape", "Gauze pads", "Medical gloves",
            "Cotton balls", "Cotton swabs",
            "Insect repellent ",
            "Sunscreen", "Lip balm with SPF",
            "Throat lozenges",
            "Eye drops ",
            "Ace bandage ",
            "Health insurance information", "Medical history"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.btn5_fragment);
        listViewData=findViewById(R.id.listview_data);
        getSupportActionBar().setTitle("Health Care");
        add=findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder build=new AlertDialog.Builder(Fragement5.this);
                View v= LayoutInflater.from(Fragement5.this).inflate(R.layout.alert,null);
                build.setView(v);
                AlertDialog alert=build.create();
                alert.show();
                EditText editText=v.findViewById(R.id.name);
                Button cancel=v.findViewById(R.id.cancel);
                Button save=v.findViewById(R.id.save);
                save.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (valid()) {
                            Datamodel d = new Datamodel();
                            d.name = editText.getText().toString();
                            Datbasehelper help = new Datbasehelper(Fragement5.this);
                            help.insertdata(d);
                            Toast.makeText(Fragement5.this, "Data added successfully", Toast.LENGTH_SHORT).show();
                            alert.dismiss();

                            Intent i = new Intent(Fragement5.this, Fragement5.class);
                            startActivity(i);
                        }
                    }
                    private boolean valid() {
                        boolean validity = true;
                        if (TextUtils.isEmpty(editText.getText().toString())) {
                            editText.setError("Please write something!");
                            validity = false;
                        }
                        return validity;
                    }
                });
                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        alert.dismiss();
                    }
                });
            }
        });
        adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice,array);
        listViewData.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.item_done) {
            Datamodel d=new Datamodel();
            for (int i = 0; i < listViewData.getCount();i++) {
                if (listViewData.isItemChecked(i)) {
                    d.selected =listViewData.getItemAtPosition(i).toString();
                    DataBaseHelper2 help=new DataBaseHelper2(Fragement5.this);
                    help.insertdata(d);
                }
            }
            Toast.makeText(this, "Items Selected Successfully", Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(Fragement5.this,MenuList.class);
            startActivity(intent);
        }
        if(id==R.id.item_back){
            Intent intent=new Intent(Fragement5.this,MenuList.class);
            startActivity(intent);
            Toast.makeText(this, "Returned home", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i=new Intent(Fragement5.this,MenuList.class);
        startActivity(i);
    }
}

