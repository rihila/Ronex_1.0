package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class StudentRegister extends AppCompatActivity {

    EditText edUsername,edstudentid,edEmail,edPassword,edConfirm;
    Button reg;
    CheckBox accept;
    TextView have;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_register);
        edUsername=findViewById(R.id.adminemailinput);
        edstudentid=findViewById(R.id.adminemailinput2);


        edEmail=findViewById(R.id.adminemailinput3);
        edPassword=findViewById(R.id.editTextTextPassword);
        edConfirm=findViewById(R.id.editTextTextPassword2);

        accept=findViewById(R.id.checkBox);

        have=findViewById(R.id.textView5);

        reg=findViewById(R.id.loginadminbutton);

        have.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StudentRegister.this, LoginActivity.class));
            }
        });

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = edUsername.getText().toString();
                String studentid=edstudentid.getText().toString();
                String password = edPassword.getText().toString();
                String email = edEmail.getText().toString();
                String confirm = edConfirm.getText().toString();

                Student_Database db=new Student_Database(getApplicationContext(),"StudentDatabase",null,1);

                if (username.length() == 0 || password.length() == 0 || email.length() == 0 || confirm.length() == 0 || studentid.length()==0 ) {
                    Toast.makeText(getApplicationContext(), "Please fill All details", Toast.LENGTH_SHORT).show();
                } else if (password.compareTo(confirm)!=0) {
                    Toast.makeText(getApplicationContext(), "Password and Confirm Password didn't match", Toast.LENGTH_SHORT).show();
                } else
                {
                    db.register(username,studentid,email,password);

                    Toast.makeText(getApplicationContext(), "Registration Successful", Toast.LENGTH_SHORT).show();


                    startActivity(new Intent(StudentRegister.this,StudentLogin.class));

                }




            }
        });

    }


}