package com.example.pickme;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Fragement10 extends AppCompatActivity {
    private EditText editText;
    private CalendarView calendarView;
    private String stringDateSelected;
    private DatabaseReference databaseReference;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.btn10_fragment);
        getSupportActionBar().setTitle("Calendar");
        calendarView=findViewById(R.id.calendar);
        editText=findViewById(R.id.event);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
               stringDateSelected=Integer.toString(i)+Integer.toString(i1+1)+Integer.toString(i2);
               calenderClicked();
            }
        });

        databaseReference= FirebaseDatabase.getInstance().getReference("Calendar");

    }
    private  void  calenderClicked(){
        databaseReference.child(stringDateSelected).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.getValue()!=null){
                    editText.setText(snapshot.getValue().toString());
                }else{
                  editText.setText("");
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }
    public void buttonSaveEvent(View view){
        databaseReference.child(stringDateSelected).setValue(editText.getText().toString());
        Toast.makeText(this, "Event saved successfully", Toast.LENGTH_SHORT).show();
        Intent i=new Intent(Fragement10.this,Fragement10.class);
        startActivity(i);
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
            Intent intent=new Intent(Fragement10.this,MenuList.class);
            startActivity(intent);
            Toast.makeText(this, "Returned home", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i=new Intent(Fragement10.this,MenuList.class);
        startActivity(i);
    }
}