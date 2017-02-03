package com.example.kanchha.sharedpreferencesdemo;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
SharedPreferences sharedPerferences;
    String  MYOERFERENCES ="ASMT";
    String Name="user_name";
    String Phone="user_phone";
    String Email="user_email";
    EditText editName, editPhone,editEmail;
    Button save,reset,read;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        editName=(EditText)findViewById(R.id.editName);
        editPhone=(EditText)findViewById(R.id.editPhone);
        editEmail=(EditText)findViewById(R.id.editEmail);
        save=(Button)findViewById(R.id.save);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user= editName.getText().toString();
                String PhoneN= editPhone.getText().toString();
                String EmailAd= editEmail.getText().toString();
                sharedPerferences=getSharedPreferences(MYOERFERENCES,MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPerferences.edit();
                editor.putString(Name,user);
                editor.putString(Phone,PhoneN);
                editor.putString(Email,EmailAd);
                Toast.makeText(MainActivity.this, "Data Entered Successfully", Toast.LENGTH_SHORT).show();
                editName.setText("");
                editPhone.setText("");
                editEmail.setText("");
                editor.commit();
            }
        });

        reset=(Button)findViewById(R.id.reset);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPerferences =getSharedPreferences(MYOERFERENCES,MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPerferences.edit();
                String na=sharedPerferences.getString(Name, "No name");
                String ph=sharedPerferences.getString(Phone,"No name");
                String em=sharedPerferences.getString(Email,"No name");
                editName.setText(na);
                editPhone.setText(ph);
                editEmail.setText(em);
                Toast.makeText(MainActivity.this,"Data Reset Sucessfully",Toast.LENGTH_SHORT).show();
                editor.commit();
            }
        });

        read=(Button)findViewById(R.id.read);
        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPerferences =getSharedPreferences(MYOERFERENCES,MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPerferences.edit();
                editor.clear();
                editName.setText("");
                editPhone.setText("");
                editEmail.setText("");
                Toast.makeText(MainActivity.this,"Data read",Toast.LENGTH_SHORT).show();
                editor.commit();
            }
        });
    }


}
