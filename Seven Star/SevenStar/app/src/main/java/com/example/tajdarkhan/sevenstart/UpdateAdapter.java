package com.example.tajdarkhan.sevenstart;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import database.ContactModel;
import database.SQLiteHelper;

/**
 * Created by Tajdar khan on 2/22/2016.
 */
public class UpdateAdapter extends ArrayAdapter {
    private List list = new ArrayList();
    private Context context;

    public UpdateAdapter(Context context, int resource) {
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
        Button updateBtn;
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
            row = inflater.inflate(R.layout.single_customer_update, parent, false);
            holder = new ImgHolder();
            holder.ID = (TextView) row.findViewById(R.id.customer_update_id);
            holder.NAME = (TextView) row.findViewById(R.id.customer_update_name);
            holder.CITY = (TextView) row.findViewById(R.id.customer_update_city);
            holder.updateBtn = (Button) row.findViewById(R.id.customer_update_sub);
            row.setTag(holder);
        } else {
            holder = (ImgHolder) row.getTag();

        }

        ContactModel FR = (ContactModel) getItem(position);
        holder.ID.setText(FR.getID());
        holder.NAME.setText(FR.getFirstName());
        holder.CITY.setText(FR.getCityName());

        holder.updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirecting to Delete activity when a record is deleted.
                Intent intent = new Intent(context, CustomerUpdate.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("customer-id", holder.ID.getText().toString());
                intent.putExtra("customer-name", holder.NAME.getText().toString());
                intent.putExtra("customer-city", holder.CITY.getText().toString());
                context.startActivity(intent);


            }
        });
        return row;
    }


}
