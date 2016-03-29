package com.example.tajdarkhan.sevenstart;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import database.ContactModel;
import database.SQLiteHelper;

/**
 * Created by Tajdar khan on 2/10/2016.
 */
public class Create extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create);
    }

    // Search button click method
    public void onCustomerAdd(View v) {
        ContactModel contact = new ContactModel();
        EditText customerName = (EditText) findViewById(R.id.createName);
        EditText customerCity = (EditText) findViewById(R.id.createCity);
        String cus_name = customerName.getText().toString();
        String cus_city = customerCity.getText().toString();
        if (cus_name.length() == 0 || cus_city.length() == 0) {
            Toast.makeText(getApplicationContext(), "Please provide fields value", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getApplicationContext(), "Customer is inserted successfully.", Toast.LENGTH_LONG).show();
            SQLiteHelper sqlhelper = new SQLiteHelper(this);
            contact.setFirstName(cus_name);
            contact.setCityName(cus_city);
            sqlhelper.insertRecord(contact);
            Intent i = new Intent(getApplicationContext(), Create.class);
            startActivity(i);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
