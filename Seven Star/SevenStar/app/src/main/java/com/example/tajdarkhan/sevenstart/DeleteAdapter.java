package com.example.tajdarkhan.sevenstart;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import database.ContactModel;
import database.SQLiteHelper;

public class DeleteAdapter extends ArrayAdapter {
    private List list = new ArrayList();
    private Context context;

    public DeleteAdapter(Context context, int resource) {
        super(context, resource);
        this.context = context;
        // TODO Auto-generated constructor stub
    }

    public void add(ContactModel object) {
        // TODO Auto-generated method stub
        list.add(object);
        super.add(object);
    }

    static class ImgHolder {
        TextView ID;
        TextView NAME;
        TextView CITY;
        Button delBtn;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return this.list.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return this.list.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        View row;
        row = convertView;
        final ImgHolder holder;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.row_layout, parent, false);
            holder = new ImgHolder();
            holder.ID = (TextView) row.findViewById(R.id.customer_id);
            holder.NAME = (TextView) row.findViewById(R.id.customer_name);
            holder.CITY = (TextView) row.findViewById(R.id.customer_city);
            holder.delBtn = (Button) row.findViewById(R.id.customer_delete);
            row.setTag(holder);
        } else {
            holder = (ImgHolder) row.getTag();

        }

        ContactModel FR = (ContactModel) getItem(position);
        holder.ID.setText(FR.getID());
        holder.NAME.setText(FR.getFirstName());
        holder.CITY.setText(FR.getCityName());

        holder.delBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteHelper databasedel = new SQLiteHelper(getContext());
                ContactModel contact = new ContactModel();
                String cus_name = holder.ID.getText().toString();
                contact.setID(cus_name);
                databasedel.deleteRecord(contact);
                Toast.makeText(getContext(), "Record is deleted successfully.", Toast.LENGTH_LONG).show();
                // Redirecting to Delete activity when a record is deleted.
                Intent intent = new Intent(context, Delete.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);


            }
        });
        return row;
    }


}
