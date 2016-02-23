package com.example.tajdarkhan.sevenstart;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import database.ContactModel;
import database.SQLiteHelper;

/**
 * Created by Tajdar khan on 2/11/2016.
 */
public class Update extends AppCompatActivity {
    ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update);
        // All records for update
        allRecords();
    }

    public void allRecords() {
        listview = (ListView) findViewById(R.id.main_list_view_update);
        UpdateAdapter adapter = new UpdateAdapter(getApplicationContext(), R.layout.single_customer_update);
        listview.setAdapter(adapter);
        TextView noRecordFound = (TextView) findViewById(R.id.no_record_found_update);
        noRecordFound.setVisibility(View.GONE);
        ArrayList<ContactModel> totalRecords = new ArrayList<ContactModel>();
        SQLiteHelper database = new SQLiteHelper(this);
        totalRecords = database.getAllRecords();
        if (totalRecords.size() == 0) {
            noRecordFound.setVisibility(View.VISIBLE);
        } else {
            for (int i = 0; i < totalRecords.size(); i++) {
                adapter.add(totalRecords.get(i));
                noRecordFound.setVisibility(View.GONE);

            }
        }

    }


}
