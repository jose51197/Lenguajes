package com.example.jose5.lenguajes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

public class Logged_in_activity extends AppCompatActivity implements Serializable {
    User logged;
    ArrayAdapter<String> arrayAdapter;
    ListView list;
    int selected=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logged_in);
        logged = (User) getIntent().getSerializableExtra("User");//get the loggedIn user object back from previous intent

        Button buttonDelete  = (Button) findViewById(R.id.delete);
        list = (ListView) findViewById(R.id.listView);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1,int position, long arg3)
            {
                selected= position;
                notificate(logged.consult(selected));
            }
        });

        //When the user presses the delete button
        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logged.deleteEvent(selected);
                update();
            }
        });


        Button buttonNew  = (Button) findViewById(R.id.newEvent);
        //When the user presses the new button
        buttonNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent next = new Intent(Logged_in_activity.this, New_Activity.class);
                next.putExtra("User",logged);
                startActivity(next);
                notificate("Creating new");
                finish();
            }
        });

        Button buttonFilter  = (Button) findViewById(R.id.filter);
        //When the user presses the filter button
        buttonFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        update();




    }
    public void update(){
        //get every activity from user
        ArrayList<String> eventList = new ArrayList<>();

        for(Event e: logged.events){
            eventList.add(e.toString());
        }
        arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                eventList );

        list.setAdapter(arrayAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        this.getMenuInflater().inflate(R.menu.change_pass, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        notificate("entered");
        switch (item.getItemId()) {
            case R.id.Overwrite:
                Intent next = new Intent(Logged_in_activity.this, Overwrite_activity.class);
                startActivity(next);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void notificate(String notification){
        Toast.makeText(getApplicationContext(), notification, Toast.LENGTH_LONG).show();
    }
}
