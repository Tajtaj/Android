package com.example.tajdarkhan.sevenstart;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);


        Button btn = (Button) findViewById(R.id.loginButton);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText a1;
                a1 = (EditText) findViewById(R.id.loginPassword);
                String password = a1.getText().toString();
                if (a1.getText().length() == 0) {
                    a1.setError("Password is empty");
                } else if (password.equals("admin")) {
                    Toast.makeText(getApplicationContext(), "Welcome, " + password, Toast.LENGTH_LONG).show();
                    Intent i = new Intent(getApplicationContext(), Home.class);
                    startActivity(i);
                    // Setting password field empty after going to home activity.
                    a1.setText("");

                } else {
                    a1.setError("Wrong password.");
                }
            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
