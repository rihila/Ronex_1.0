package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;
import  java.util.Random;

class returnstruct {
   int day1,day2,day3;
   int time11,time12,time13,time21,time22,time23,time31,time32,time33;

    // Constructor
    public returnstruct(int day1,int day2,int day3,int time11,int time12,int time13,int time21,int time22,int time23,int time31,int time32,int time33) {
        this.day1 = day1;
        this.day2 = day2;
        this.day3=day3;

        this.time11=time11;
        this.time12=time12;
        this.time13=time13;

        this.time21=time21;
        this.time22=time22;
        this.time23=time23;

        this.time31=time31;
        this.time32=time32;
        this.time33=time33;
    }
}

class returndata {

    String day,time,coursename,coursecode;

    // Constructor
    public returndata(String day,String time,String coursename,String coursecode) {
        this.day=day;
        this.time=time;
        this.coursename=coursename;
        this.coursecode=coursecode;


    }
}

public class Routine_Database extends SQLiteOpenHelper{


    public Routine_Database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context,"routinedatabase" , factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String qry1="create table routine(day text,time  text,course text,coursename text,courseid int,credit double)";
        db.execSQL(qry1);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public int finddata(String day,String time)
    {
        String returnres=null;
        int result=0;
        String str[]=new String[2];

        str[0]=day;
        str[1]=time;

        SQLiteDatabase db=getReadableDatabase();
        Cursor c=db.rawQuery("select * from routine where day=? and time=?",str);

        if(c.moveToFirst())
        {
            result=1;

        }
        return result;

    }

    public String slot(int time)
    {
        String times=null;
        if(time==0)
        {
            times="8:00-8:50am";
        } else if (time==1) {
            times="8:50-9:40am";
        }

        else if (time==2) {
            times="9:40-10:30am";
        }

        else if (time==3) {
            times="10:50-11:40am";
        }

        else if (time==4) {
            times="11:40-12:30pm";
        }

        else if (time==5) {
            times="12:30-1:20pm";
        }

        else if (time==6) {
            times="2:30-3:20pm";
        }

        else if (time==7) {
            times="3:20-4:10pm";
        }

        else if (time==8) {
            times="4:10-5:00pm";
        }


        return times;
    }

    public String date(int day)
    {
        String times=null;
        if(day==0)
        {
            times="Sunday";
        } else if (day==1) {
            times="Monday";
        }

        else if (day==2) {
            times="Tuesday";
        }

        else if (day==3) {
            times="Wednesday";
        }

        else if (day==4) {
            times="Thursday";
        }

        return times;
    }
    public returnstruct generateroutine(String course, String coursename,Integer courseid,double credit)
    {

        int count=0;

        returnstruct structure = new returnstruct(-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1);

        //routine generation for lab


        if(course.charAt(0)=='L' || course.charAt(0)=='l')
        {

            //routine generation for 0.75lab


            if(credit==0.75) {
                while (true) {
                    if(count!=0) break;
                    String dayst = null;
                    Random day = new Random();
                    int days1 = day.nextInt(5);
                    dayst = date(days1);

                    for (int i = 0; i < 7; i++) {
                        if(i==1 || i==2 || i==4 || i==5)
                        {
                            continue;
                        }
                        String times = slot(i);
                        String times2 = slot(i + 1);
                        String times3 = slot(i + 2);
                        if (finddata(dayst, times) == 0 && finddata(dayst, times2) == 0 && finddata(dayst, times3) == 0) {
                            ContentValues cv = new ContentValues();
                            cv.put("day", dayst);
                            cv.put("time", times);
                            cv.put("course", course);
                            cv.put("coursename", coursename);
                            cv.put("courseid", courseid);
                            cv.put("credit", credit);
                            structure.day1=days1;
                            structure.time11=i;
                            structure.time12=i+1;
                            structure.time13=i+2;

                            SQLiteDatabase db = getWritableDatabase();
                            db.insert("routine", null, cv);

                            ContentValues cv2 = new ContentValues();
                            cv2.put("day", dayst);
                            cv2.put("time", times2);
                            cv2.put("course", course);
                            cv2.put("coursename", coursename);
                            cv2.put("courseid", courseid);
                            cv2.put("credit", credit);

                            db.insert("routine", null, cv2);

                            ContentValues cv3 = new ContentValues();
                            cv3.put("day", dayst);
                            cv3.put("time", times3);
                            cv3.put("course", course);
                            cv3.put("coursename", coursename);
                            cv3.put("courseid", courseid);
                            cv3.put("credit", credit);

                            db.insert("routine", null, cv3);

                            break;
                        }

                    }

                    count++;
                }
            }

            else if(credit==1.5)
            {

                while (true) {
                    if(count==2) break;
                    String dayst = null;
                    Random day = new Random();
                    int days1 = day.nextInt(5);

                    while(true)
                    {
                        day=new Random();
                        days1=day.nextInt(5);
                        if(days1!=structure.day1 && days1!=structure.day2 && days1!=structure.day3 ) break;
                    }
                    dayst = date(days1);

                    for (int i = 0; i < 7; i++) {
                        if(i==1 || i==2 || i==4 || i==5)
                        {
                            continue;
                        }
                        String times = slot(i);
                        String times2 = slot(i + 1);
                        String times3 = slot(i + 2);
                        if (finddata(dayst, times) == 0 && finddata(dayst, times2) == 0 && finddata(dayst, times3) == 0) {
                            ContentValues cv = new ContentValues();
                            cv.put("day", dayst);
                            cv.put("time", times);
                            cv.put("course", course);
                            cv.put("coursename", coursename);
                            cv.put("courseid", courseid);
                            cv.put("credit", credit);
                            if(count==0)
                            {
                                structure.day1=days1;
                                structure.time11=i;
                                structure.time12=i+1;
                                structure.time13=i+2;


                            } else if (count==1) {
                                structure.day2=days1;
                                structure.time21=i;
                                structure.time22=i+1;
                                structure.time23=i+2;
                            }



                            SQLiteDatabase db = getWritableDatabase();
                            db.insert("routine", null, cv);

                            ContentValues cv2 = new ContentValues();
                            cv2.put("day", dayst);
                            cv2.put("time", times2);
                            cv2.put("course", course);
                            cv2.put("coursename", coursename);
                            cv2.put("courseid", courseid);
                            cv2.put("credit", credit);

                            db.insert("routine", null, cv2);

                            ContentValues cv3 = new ContentValues();
                            cv3.put("day", dayst);
                            cv3.put("time", times3);
                            cv3.put("course", course);
                            cv3.put("coursename", coursename);
                            cv3.put("courseid", courseid);
                            cv3.put("credit", credit);

                            db.insert("routine", null, cv3);
                            count++;
                            break;
                        }
                    }


                }
            }





        }



        else
        {
            while (true) {
                if(count==3) break;
                String dayst = null;
                Random day = new Random();
                int days1 = day.nextInt(5);
                while(true)
                {
                    day=new Random();
                    days1=day.nextInt(5);
                    if(days1!=structure.day1 && days1!=structure.day2 && days1!=structure.day3 ) break;
                }
                dayst = date(days1);

                for (int i = 0; i < 9; i++) {
                    String times = slot(i);

                    if (finddata(dayst, times) == 0 ) {
                        ContentValues cv = new ContentValues();
                        cv.put("day", dayst);
                        cv.put("time", times);
                        cv.put("course", course);
                        cv.put("coursename", coursename);
                        cv.put("courseid", courseid);
                        cv.put("credit", credit);
                        if (count==0)
                        {
                            structure.day1=days1;
                            structure.time11=i;
                        } else if (count==1) {
                            structure.day2=days1;
                            structure.time21=i;
                        }

                        else if (count==2) {
                            structure.day3=days1;
                            structure.time31=i;
                        }


                        SQLiteDatabase db = getWritableDatabase();
                        db.insert("routine", null, cv);
                        count++;
                        break;
                    }
                }


            }
        }
        return structure;
    }

    public int deletedata(String coursename,Integer coursecode)
    {
        String str[]=new String[2];

        str[0]=coursename;
        str[1]=coursecode.toString();


        SQLiteDatabase db=this.getWritableDatabase();
        return db.delete("routine", "coursename=? AND courseid=?", new String[]{coursename, String.valueOf(coursecode)});
    }

    public int deletedataall()
    {

        SQLiteDatabase db=this.getWritableDatabase();
        return db.delete("routine", null,null);
    }


    public returndata getdata(String day,String time)
    {
        int result=0;
        String str[]=new String[2];

        str[0]=day;
        str[1]=time;
        returndata structs=new returndata(null,null,null,null);
        SQLiteDatabase db=getReadableDatabase();
        Cursor c=db.rawQuery("select * from routine where day=? and time=?",str);

        if(c.moveToFirst())
        {
            structs.day=c.getString(1);
            structs.time=c.getString(2);
            structs.coursename=c.getString(3);
            structs.coursecode=c.getString(4);


        }
        return structs;

    }




}