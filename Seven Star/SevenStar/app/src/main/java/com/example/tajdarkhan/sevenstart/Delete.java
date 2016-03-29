package com.example.tajdarkhan.sevenstart;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import database.ContactModel;
import database.SQLiteHelper;

/**
 * Created by Tajdar khan on 2/11/2016.
 */
public class Delete extends AppCompatActivity {
    ListView listview;
    private Button mainBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delete);
        // Calling allRecords method
        allRecords();
    }

    public void allRecords() {
        listview = (ListView) findViewById(R.id.main_list_view);
        DeleteAdapter adapter = new DeleteAdapter(getApplicationContext(), R.layout.row_layout);
        listview.setAdapter(adapter);
        TextView noRecordFound = (TextView) findViewById(R.id.no_record_found);
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
