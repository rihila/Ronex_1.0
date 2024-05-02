package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;


import androidx.annotation.Nullable;

public class Student_Database extends SQLiteOpenHelper {
    public Student_Database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String qry1="create table studentusers(username text,studentid text,email text,password text)";
        db.execSQL(qry1);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


        public void register(String username, String studentid, String email, String password) {
        SQLiteDatabase db = null;

        try {
            ContentValues cv = new ContentValues();
            cv.put("username", username);
            cv.put("email", email);
            cv.put("password", password);

            db = getWritableDatabase();
            db.insert("studentusers", null, cv);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (db != null) {
                db.close();
            }
        }
    }




    public int login(String email,String password)
    {
        int result=0;
        String str[]=new String[2];

        str[0]=email;
        str[1]=password;

        Cursor c=null;
        SQLiteDatabase db=null;
        try {
              db = getReadableDatabase();
             c = db.rawQuery("SELECT * FROM studentusers WHERE email=? AND password=?", str);

            if (c.moveToFirst()) {
                result = 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the cursor and database in finally block to ensure they are always closed
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }

        return result;
    }
}

