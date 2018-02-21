package com.example.jose5.lenguajes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by jose5 on 2/21/2018.
 */

public class Filter_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.filter);
    }

    private void notificate(String notification) {
        Toast.makeText(getApplicationContext(), notification, Toast.LENGTH_LONG).show();
    }
}
