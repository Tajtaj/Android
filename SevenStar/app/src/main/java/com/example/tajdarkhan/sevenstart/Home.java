package com.example.tajdarkhan.sevenstart;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.RequiresPermission;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import database.ContactModel;
import database.SQLiteHelper;

public class Home extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_home);

    }

    // Create button click method
    public void onCreateBtnClick(View v) {
        Intent i = new Intent(getApplicationContext(), Create.class);
        startActivity(i);
    }

    // Delete button click method
    public void onDeleteBtnClick(View v) {
        Intent i = new Intent(getApplicationContext(), Delete.class);
        startActivity(i);
    }

    // Update button click method
    public void onUpdateBtnClick(View v) {
        Intent i = new Intent(getApplicationContext(), Update.class);
        startActivity(i);
    }

    // Read button click method
    public void onReadBtnClick(View v) {
        Intent i = new Intent(getApplicationContext(), Read.class);
        startActivity(i);
    }

}
