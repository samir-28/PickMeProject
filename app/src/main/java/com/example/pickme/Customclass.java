package com.example.pickme;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;

import java.util.ArrayList;

public class Customclass extends BaseAdapter {
    Context s;
    ArrayList<Datamodel> info=new ArrayList<>();
    public Customclass(Fragement11 fragement11, ArrayList<Datamodel> data) {
        info=data;
        s=fragement11;

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
        title.setText(""+info.get(i).name);
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder build=new AlertDialog.Builder(s);
                View x=LayoutInflater.from(s).inflate(R.layout.editdata,null);
                build.setView(x);
                EditText name=x.findViewById(R.id.name);
                Button edit=x.findViewById(R.id.edit);
                Button delete=x.findViewById(R.id.delete);
                name.setText(info.get(i).name);
                AlertDialog alert=build.create();
                alert.show();
                edit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(valid()) {
                            Context c;
                            Datamodel d = new Datamodel();
                            d.id = info.get(i).id;
                            d.name = name.getText().toString();
                            Datbasehelper help = new Datbasehelper(s);
                            help.updatedata(d);
                            Intent i = new Intent(s, Fragement11.class);
                            s.startActivity(i);
                        }

                    }

                    private boolean valid() {
                        boolean validity = true;
                        if (TextUtils.isEmpty(name.getText().toString())) {
                            name.setError("Please write something!");
                            validity = false;
                        }
                        return validity;
                    }
                });
                delete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Datbasehelper drop=new Datbasehelper(s);
                        drop.deletedata(info.get(i).id);
                        Intent i=new Intent(s,Fragement11.class);
                        alert.dismiss();
                        s.startActivity(i);
                    }
                });
            }
        } );
        return c;
    }
}
