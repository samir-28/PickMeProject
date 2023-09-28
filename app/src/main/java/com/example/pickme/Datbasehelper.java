package com.example.pickme;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class Datbasehelper extends SQLiteOpenHelper {
    public Datbasehelper(Context Context) {
        super(Context, "Customlist", null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table if not exists Customlist(id integer primary key autoincrement,name varchar )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists Customlist");
        onCreate(sqLiteDatabase);

    }

    public void insertdata(Datamodel d) {
        SQLiteDatabase b = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("Name", d.name);
        b.insert("Customlist", null, values);
    }

    public ArrayList<Datamodel> readdata() {
        ArrayList<Datamodel> data = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("select * from  Customlist", null);
        if (c.moveToFirst()) {
            do {
                Datamodel d = new Datamodel();
                d.id = c.getInt(0);
                d.name = c.getString(1);
                data.add(d);
            }
            while (c.moveToNext());
        }

        return data;
    }

    public void updatedata(Datamodel d) {
        SQLiteDatabase fill=this.getWritableDatabase();
        ContentValues content=new ContentValues();
        content.put("Name",d.name);
        fill.update("Customlist",content,"id="+d.id,null);

    }

    public void deletedata(int id) {
        SQLiteDatabase remove=getWritableDatabase();
        remove.execSQL("delete from Customlist where id="+id);

    }
}
