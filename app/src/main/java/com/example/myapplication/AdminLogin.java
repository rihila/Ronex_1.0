package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AdminLogin<Database> extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        EditText edEmail, edPassword;
        Button login;
        CheckBox remember;

        TextView texts;
        edEmail = findViewById(R.id.adminemailinput);
        edPassword = findViewById(R.id.editTextTextPassword);

        login = findViewById(R.id.loginadminbutton);
        remember = findViewById(R.id.checkBox);

        texts=findViewById(R.id.textView5);

        texts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AdminLogin.this, RegisterActivity.class));
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = edEmail.getText().toString();
                String password = edPassword.getText().toString();

                Admin_Database db=new Admin_Database(getApplicationContext(),"Admindatabase",null,1);



                if (email.length() == 0 || password.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Please fill All details", Toast.LENGTH_SHORT).show();
                } else {
                    if(db.login(email,password)==1) {
                        Toast.makeText(getApplicationContext(), "Login Success", Toast.LENGTH_SHORT).show();

                        SharedPreferences sharedPreferences=getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor= sharedPreferences.edit();
                        editor.putString("email",email);
                        editor.apply();

                        startActivity(new Intent(AdminLogin.this,AdminActivity.class));
                    }
                    else
                        Toast.makeText(getApplicationContext(), "Invalid Username and Password", Toast.LENGTH_SHORT).show();
                }
            }
        });








    }
}