package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Admin_Database extends SQLiteOpenHelper {
    public Admin_Database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String qry1="create table adminusers(username text,email text,password text)";
        db.execSQL(qry1);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void register(String username,String email,String password)
    {
        ContentValues cv=new ContentValues();
        cv.put("username",username);
        cv.put("email",email);
        cv.put("password",password);

        SQLiteDatabase db=getWritableDatabase();
        db.insert("adminusers",null,cv);


    }

    public int login(String usernames,String password)
    {
        int result=0;
        String str[]=new String[2];

        str[0]=usernames;
        str[1]=password;

        SQLiteDatabase db=getReadableDatabase();
        Cursor c=db.rawQuery("select * from adminusers where email=? and password=?",str);

        if(c.moveToFirst())
        {
            result=1;

        }
        return result;

    }
}

