package com.example.jose5.lenguajes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class Logged_in_activity extends AppCompatActivity  {
    String user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logged_in);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        this.getMenuInflater().inflate(R.menu.change_pass, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.Overwrite:
                Intent next = new Intent(Logged_in_activity.this, Overwrite_activity.class);
                //next.putExtra("user",user);
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
