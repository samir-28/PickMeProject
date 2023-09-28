package com.example.pickme;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DataBaseHelper2 extends SQLiteOpenHelper {
    public DataBaseHelper2( Context context) {
        super(context,"Itemlist",null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table if not exists Itemlist(id integer primary key autoincrement,selected varchar )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists Itemlist");
        onCreate(sqLiteDatabase);

    }
    public void insertdata(Datamodel d) {
        SQLiteDatabase b = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("selected", d.selected);
        b.insert("Itemlist", null, values);
    }

    public ArrayList<Datamodel> readdata() {
        ArrayList<Datamodel> data = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("select * from  Itemlist", null);
        if (c.moveToFirst()) {
            do {
                Datamodel d = new Datamodel();
                d.id = c.getInt(0);
                d.selected = c.getString(1);
                data.add(d);
            }
            while (c.moveToNext());
        }

        return data;
    }

    public void deletedata(int id) {
        SQLiteDatabase remove=getWritableDatabase();
        remove.execSQL("delete from Itemlist where id="+id);

    }
}


