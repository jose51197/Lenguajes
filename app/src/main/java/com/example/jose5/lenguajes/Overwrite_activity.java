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
    User logged;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.overwrite);

        final EditText user =  (EditText) findViewById(R.id.owUser);
        final EditText pass =  (EditText) findViewById(R.id.owPass);

        logged = (User) getIntent().getSerializableExtra("User");
        user.setText(logged.getUser());

        Button buttonOver  = (Button) findViewById(R.id.overwriteOk);
        //When the user presses the new button
        buttonOver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent next = new Intent(Overwrite_activity.this, Logged_in_activity.class);
                logged.change(user.getText().toString(),pass.getText().toString());
                next.putExtra("User",logged);
                startActivity(next);
                finish();
            }
        });



    }

    private void notificate(String notification){
        Toast.makeText(getApplicationContext(), notification, Toast.LENGTH_LONG).show();
    }
}
