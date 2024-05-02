package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class TeacherActivity extends AppCompatActivity {

    public void settextview(String day, String time, TextView T1)
    {
        Routine_Database db=new Routine_Database(getApplicationContext(),"routinedatabase",null,1);
        com.example.myapplication.returndata structs=db.getdata(day,time);
        if(structs.day!=null && structs.time!=null)
        {
            T1.setText(structs.coursename+" "+structs.coursecode);

        }
        else
        {
            T1.setText("");
        }
        return;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher);

        TextView sunday1,sunday2,sunday3,sunday4,sunday5,sunday6,sunday7,sunday8,sunday9;

        TextView monday1,monday2,monday3,monday4,monday5,monday6,monday7,monday8,monday9;

        TextView tuesday1,tuesday2,tuesday3,tuesday4,tuesday5,tuesday6,tuesday7,tuesday8,tuesday9;

        TextView wednesday1,wednesday2,wednesday3,wednesday4,wednesday5,wednesday6,wednesday7,wednesday8,wednesday9;

        TextView thursday1,thursday2,thursday3,thursday4,thursday5,thursday6,thursday7,thursday8,thursday9;

        sunday1=findViewById(R.id.sunday1);
        settextview("Sunday","8:00-8:50am",sunday1);


        sunday2=findViewById(R.id.sunday2);
        settextview("Sunday","8:50-9:40am",sunday2);


        sunday3=findViewById(R.id.sunday3);
        settextview("Sunday","9:40-10:30am",sunday3);

        sunday4=findViewById(R.id.sunday4);
        settextview("Sunday","10:50-11:40am",sunday4);


        sunday5=findViewById(R.id.sunday5);
        settextview("Sunday","11:40-12:30pm",sunday5);

        sunday6=findViewById(R.id.sunday6);
        settextview("Sunday","12:30-1:20pm",sunday6);

        sunday7=findViewById(R.id.sunday7);
        settextview("Sunday","2:30-3:20pm",sunday7);


        sunday8=findViewById(R.id.sunday8);
        settextview("Sunday","3:20-4:10pm",sunday8);


        sunday9=findViewById(R.id.sunday9);
        settextview("Sunday","4:10-5:00pm",sunday9);

        monday1=findViewById(R.id.monday1);
        monday2=findViewById(R.id.monday2);
        monday3=findViewById(R.id.monday3);
        monday4=findViewById(R.id.monday4);
        monday5=findViewById(R.id.monday5);
        monday6=findViewById(R.id.monday6);
        monday7=findViewById(R.id.monday7);
        monday8=findViewById(R.id.monday8);
        monday9=findViewById(R.id.monday9);

        settextview("Monday","8:00-8:50am",monday1);
        settextview("Monday","8:50-9:40am",monday2);
        settextview("Monday","9:40-10:30am",monday3);
        settextview("Monday","10:50-11:40am",monday4);
        settextview("Monday","11:40-12:30pm",monday5);
        settextview("Monday","12:30-1:20pm",monday6);
        settextview("Monday","2:30-3:20pm",monday7);
        settextview("Monday","3:20-4:10pm",monday8);
        settextview("Monday","4:10-5:00pm",monday9);

        tuesday1=findViewById(R.id.tuesday1);
        tuesday2=findViewById(R.id.tuesday2);
        tuesday3=findViewById(R.id.tuesday3);
        tuesday4=findViewById(R.id.tuesday4);
        tuesday5=findViewById(R.id.tuesday5);
        tuesday6=findViewById(R.id.tuesday6);
        tuesday7=findViewById(R.id.tuesday7);
        tuesday8=findViewById(R.id.tuesday8);
        tuesday9=findViewById(R.id.tuesday9);

        settextview("Tuesday","8:00-8:50am",tuesday1);
        settextview("Tuesday","8:50-9:40am",tuesday2);
        settextview("Tuesday","9:40-10:30am",tuesday3);
        settextview("Tuesday","10:50-11:40am",tuesday4);
        settextview("Tuesday","11:40-12:30pm",tuesday5);
        settextview("Tuesday","12:30-1:20pm",tuesday6);
        settextview("Tuesday","2:30-3:20pm",tuesday7);
        settextview("Tuesday","3:20-4:10pm",tuesday8);
        settextview("Tuesday","4:10-5:00pm",tuesday9);

        wednesday1=findViewById(R.id.wednesday1);
        wednesday2=findViewById(R.id.wednesday2);
        wednesday3=findViewById(R.id.wednesday3);
        wednesday4=findViewById(R.id.wednesday4);
        wednesday5=findViewById(R.id.wednesday5);
        wednesday6=findViewById(R.id.wednesday6);
        wednesday7=findViewById(R.id.wednesday7);
        wednesday8=findViewById(R.id.wednesday8);
        wednesday9=findViewById(R.id.wednesday9);

        settextview("Wednesday","8:00-8:50am",wednesday1);
        settextview("Wednesday","8:50-9:40am",wednesday2);
        settextview("Wednesday","9:40-10:30am",wednesday3);
        settextview("Wednesday","10:50-11:40am",wednesday4);
        settextview("Wednesday","11:40-12:30pm",wednesday5);
        settextview("Wednesday","12:30-1:20pm",wednesday6);
        settextview("Wednesday","2:30-3:20pm",wednesday7);
        settextview("Wednesday","3:20-4:10pm",wednesday8);
        settextview("Wednesday","4:10-5:00pm",wednesday9);

        thursday1=findViewById(R.id.thursday1);
        thursday2=findViewById(R.id.thursday2);
        thursday3=findViewById(R.id.thursday3);
        thursday4=findViewById(R.id.thursday4);
        thursday5=findViewById(R.id.thursday5);
        thursday6=findViewById(R.id.thursday6);
        thursday7=findViewById(R.id.thursday7);
        thursday8=findViewById(R.id.thursday8);
        thursday9=findViewById(R.id.thursday9);

        settextview("Thursday","8:00-8:50am",thursday1);
        settextview("Thursday","8:50-9:40am",thursday2);
        settextview("Thursday","9:40-10:30am",thursday3);
        settextview("Thursday","10:50-11:40am",thursday4);
        settextview("Thursday","11:40-12:30pm",thursday5);
        settextview("Thursday","12:30-1:20pm",thursday6);
        settextview("Thursday","2:30-3:20pm",thursday7);
        settextview("Thursday","3:20-4:10pm",thursday8);
        settextview("Thursday","4:10-5:00pm",thursday9);


    }
}