package com.example.tajdarkhan.sevenstart;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import database.ContactModel;
import database.SQLiteHelper;

/**
 * Created by Tajdar khan on 2/11/2016.
 */
public class Read extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.read);
        // Calling populateListView method
        populateListView();

    }

    // Declaring populateListView method
    private void populateListView() {
        ArrayList<ContactModel> totalRecords = new ArrayList<ContactModel>();
        SQLiteHelper database = new SQLiteHelper(this);
        totalRecords = database.getAllRecords();
        TextView noRecordFound = (TextView) findViewById(R.id.no_record_found_read);
        noRecordFound.setVisibility(View.GONE);
        if (totalRecords.size() == 0) {
            noRecordFound.setVisibility(View.VISIBLE);
        } else {
            noRecordFound.setVisibility(View.GONE);
            ArrayList<String> records = new ArrayList<String>();
            for (int i = 0; i < totalRecords.size(); i++) {
                Log.i("Total", totalRecords.get(i).toString());
                String temp = " Name \t\t\t\t " + totalRecords.get(i).getFirstName() + "\n\n City \t\t\t\t\t " + totalRecords.get(i).getCityName();

                records.add(temp);
            }
            // Build Adapter
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                    this,   // Context for the activity
                    R.layout.single_customer,  // Layout to use
                    records);  // Items to be displayed
            // Configure the list view
            ListView list = (ListView) findViewById(R.id.listViewMain);
            list.setAdapter(adapter);
            // Getting information on click
            list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position,
                                        long id) {

                    String item = ((TextView) view).getText().toString();

                    Toast.makeText(getBaseContext(), item, Toast.LENGTH_LONG).show();

                }
            });
        }
    }

}