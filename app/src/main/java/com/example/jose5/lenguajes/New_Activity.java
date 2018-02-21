package com.example.jose5.lenguajes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by jose5 on 2/21/2018.
 */

public class New_Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_event);
    }

    private void notificate(String notification) {
        Toast.makeText(getApplicationContext(), notification, Toast.LENGTH_LONG).show();
    }
}
