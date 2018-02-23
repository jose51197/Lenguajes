package com.example.jose5.lenguajes;

import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by jose5 on 2/21/2018.
 */

public class New_Activity extends AppCompatActivity {

    User logged;
    ArrayList<User> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_event);

        logged = (User) getIntent().getSerializableExtra("User");//get the loggedIn user object back from previous intent
        users = (ArrayList<User>) getIntent().getSerializableExtra("Users");
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }


        final EditText location =  (EditText) findViewById(R.id.nameText);
        final EditText name =  (EditText) findViewById(R.id.locationText);
        final DatePicker date = (DatePicker) findViewById(R.id.datePicker);

        Button buttonSave  = (Button) findViewById(R.id.saveButton);
        //When the user presses the filter button
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logged.addEvent(new Event(getDateFromDatePicker(date),name.getText().toString(),location.getText().toString()));
                Intent next = new Intent(New_Activity.this, Logged_in_activity.class);
                next.putExtra("User",logged);
                next.putExtra("Users",users);
                startActivity(next);
                finish();
            }
        });


    }

    public static java.util.Date getDateFromDatePicker(DatePicker datePicker){
        int day = datePicker.getDayOfMonth();
        int month = datePicker.getMonth();
        int year =  datePicker.getYear();

        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);

        return calendar.getTime();
    }

    private void notificate(String notification) {
        Toast.makeText(getApplicationContext(), notification, Toast.LENGTH_LONG).show();
    }

}