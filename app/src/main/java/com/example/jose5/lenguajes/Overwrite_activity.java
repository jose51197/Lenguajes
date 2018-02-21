package com.example.jose5.lenguajes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class Overwrite_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.overwrite);

        final EditText user =  (EditText) findViewById(R.id.owUser);
        final EditText pass =  (EditText) findViewById(R.id.owPass);

        //user.setText(getIntent().getStringExtra("user"));
        //pass.setText(getIntent().getStringExtra("pass"));




    }

    private void notificate(String notification){
        Toast.makeText(getApplicationContext(), notification, Toast.LENGTH_LONG).show();
    }
}
