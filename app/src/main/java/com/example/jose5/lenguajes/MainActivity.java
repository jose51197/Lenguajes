package com.example.jose5.lenguajes;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ArrayList<User> users= new ArrayList<>();//Here we are gonna load every user we have

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try{

            read();
            if(users==null){
                users=new ArrayList<>();
            }
        }
        catch(Exception e){
            notificate("No users found");
        }


        final EditText user =  (EditText) findViewById(R.id.loginUserText);
        final EditText pass =  (EditText) findViewById(R.id.loginPassText);
        Button buttonLogin = (Button) findViewById(R.id.loginOk);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(User u : users){
                    if(u.getUser().equals(user.getText().toString()) && u.login(pass.getText().toString())){//if the user exists open the new window with the user
                        Intent next = new Intent(MainActivity.this, Logged_in_activity.class);
                        next.putExtra("User",u);
                        next.putExtra("Users",users);
                        startActivity(next);
                        notificate("Logged in");
                        finish();
                        break;
                    }
                }




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

    public static Object readObjectFromCache(Context context, String key) {
        try {
            FileInputStream fis = context.openFileInput(key);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object object = ois.readObject();
            return object;
        } catch (Exception ex) {
            return null;
        }
    }
    public void read() {

        ObjectInputStream input = null;
        users = null;
        File f = new File(this.getFilesDir(),"/users.jur");
        try {
            input = new ObjectInputStream(new FileInputStream(f));
            users= (ArrayList<User>) input.readObject();
            input.close();

        } catch (StreamCorruptedException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }



}
