package com.example.tajdarkhan.sevenstart;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import database.ContactModel;
import database.SQLiteHelper;

/**
 * Created by Tajdar khan on 2/22/2016.
 */
public class CustomerUpdate extends AppCompatActivity {
    EditText customerName, customerCity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer_update);
        // Calling allRecords method
        Intent in = getIntent();
        customerName = (EditText) findViewById(R.id.updateName);
        customerCity = (EditText) findViewById(R.id.updateCity);
        // Getting value from UpdateAdapter class and setting that value into CustomerUpdate class.
        customerName.setText(in.getStringExtra("customer-name"));
        customerCity.setText(in.getStringExtra("customer-city"));
    }

    // Update method
    public void onCustomerUpdate(View v) {
        ContactModel contact = new ContactModel();
        EditText customerName = (EditText) findViewById(R.id.updateName);
        EditText customerCity = (EditText) findViewById(R.id.updateCity);
        String cus_name = customerName.getText().toString();
        String cus_city = customerCity.getText().toString();
        if (cus_name.length() == 0 || cus_city.length() == 0) {
            Toast.makeText(getApplicationContext(), "Please provide fields value", Toast.LENGTH_LONG).show();
        } else {
            Intent in = getIntent();
            Toast.makeText(getApplicationContext(), "Customer is updated successfully.", Toast.LENGTH_LONG).show();
            SQLiteHelper sqlhelper = new SQLiteHelper(this);
            contact.setID(in.getStringExtra("customer-id"));
            contact.setFirstName(cus_name);
            contact.setCityName(cus_city);
            sqlhelper.updateRecord(contact);
            Intent i = new Intent(getApplicationContext(), Update.class);
            startActivity(i);
        }
    }
}
