package com.example.jose5.lenguajes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by jose5 on 2/21/2018.
 */

public class Filter_Activity extends AppCompatActivity {
    User logged;
    ArrayList<User> users;
    ListView list;
    int selected =0;
    ArrayAdapter<String> arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.filter);
        logged = (User) getIntent().getSerializableExtra("User");


        list = (ListView) findViewById(R.id.filterList);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        List<String> list = new ArrayList<String>();
        list.add("Dates");
        list.add("Location");
        list.add("Name");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                searchFilter(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                notificate("Nothing selected");
            }

        });


    }

    //applies the filter on the touch event of the spinner
    private void searchFilter(int i){
        switch(i){
            case 0:searchBydate();
            case 1:searchByLocation();
            case 2:searchByName();
        }
    }

    private void searchByName() {
        String  filter =  ((EditText) findViewById(R.id.textFilter)).getText().toString();
        ArrayList<Event> filtered = new ArrayList<>();
        ArrayList<String> eventList = new ArrayList<>();

        for(Event e : logged.getEvents()){
            if(e.getName().contains(filter)) {
                eventList.add(e.toString());
                filtered.add(e);
            }
        }
        arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                eventList );

        list.setAdapter(arrayAdapter);
    }

    private void searchByLocation() {
        String  filter =  ((EditText) findViewById(R.id.textFilter)).getText().toString();
        ArrayList<Event> filtered = new ArrayList<>();
        ArrayList<String> eventList = new ArrayList<>();

        for(Event e : logged.getEvents()){
            if(e.getLocation().contains(filter)) {
                eventList.add(e.toString());
                filtered.add(e);
            }
        }
        arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                eventList );

        list.setAdapter(arrayAdapter);
    }

    private void searchBydate() {
        String[]  filter =  ((EditText) findViewById(R.id.textFilter)).getText().toString().split("-");
        try{
            Date date1 = new Date(filter[0]);
            Date date2 = new Date(filter[1]);
            ArrayList<Event> filtered = new ArrayList<>();
            ArrayList<String> eventList = new ArrayList<>();
            notificate(date1.toString() + date2.toString());

            for(Event e : logged.getEvents()){
                notificate(e.getDate().toString());
                if(date1.compareTo(e.getDate()) * e.getDate().compareTo(date2) >= 0) {
                    eventList.add(e.toString());
                    filtered.add(e);
                }
            }
            arrayAdapter = new ArrayAdapter<String>(
                    this,
                    android.R.layout.simple_list_item_1,
                    eventList );

            list.setAdapter(arrayAdapter);
        }
        catch (Exception ev){
            notificate("Error");
            return;
        }


    }

    private void notificate(String notification) {
        Toast.makeText(getApplicationContext(), notification, Toast.LENGTH_LONG).show();
    }
}
