package com.example.pickme;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;

import java.util.ArrayList;

public class Customclass2 extends BaseAdapter {
    Context s;
    ArrayList<Datamodel> info=new ArrayList<>();
    public Customclass2(Fragement12 fragement12, ArrayList<Datamodel> data) {
        info=data;
        s=fragement12;
    }

    @Override
    public int getCount() {
        return info.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View c= LayoutInflater.from(s).inflate(R.layout.show,null);
      TextView title=c.findViewById(R.id.name);  //title = object name
       title.setText(""+info.get(i).selected);
       c.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               AlertDialog.Builder build = new AlertDialog.Builder(s);
               View x = LayoutInflater.from(s).inflate(R.layout.alert2, null);
               build.setView(x);
               Button cancel = x.findViewById(R.id.cancel);
               Button delete = x.findViewById(R.id.delete);
               AlertDialog alert = build.create();
               alert.show();
               delete.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View view) {
                       DataBaseHelper2 drop = new DataBaseHelper2(s);
                       drop.deletedata(info.get(i).id);
                       Intent i = new Intent(s, Fragement12.class);
                       alert.dismiss();
                       s.startActivity(i);
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

        return c;
    }
}
