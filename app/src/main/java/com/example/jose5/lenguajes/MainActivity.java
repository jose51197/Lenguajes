package com.example.jose5.lenguajes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<User> users= new ArrayList<>();//Here we are gonna load every user we have

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText user =  (EditText) findViewById(R.id.loginUserText);
        final EditText pass =  (EditText) findViewById(R.id.loginPassText);

        Button buttonLogin = (Button) findViewById(R.id.loginOk);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(User u : users){
                    if(u.getUser().equals(user.getText().toString()) && u.login(pass.getText().toString())){//if the user exists open the new window with the user
                        Intent next = new Intent(MainActivity.this, Logged_in_activity.class);
                        next.putExtra("User",u.getUser());
                        startActivity(next);
                        notificate("Logged in");
                        break;
                    }
                }
                notificate("User not found/wrong pass");


            }
        });

        Button buttonRegister = (Button) findViewById(R.id.loginCreate);

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                users.add( new User(user.getText().toString(),pass.getText().toString()));//create new user
                notificate("New user created");
            }
        });
    }

    private void notificate(String notification){
        Toast.makeText(getApplicationContext(), notification, Toast.LENGTH_LONG).show();
    }
}
