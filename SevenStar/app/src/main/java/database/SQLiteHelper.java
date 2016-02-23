package database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Tajdar khan on 2/11/2016.
 */
public class SQLiteHelper extends SQLiteOpenHelper {
    public static final String TABLE_NAME = "CUSTOMER";
    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_FIRST_NAME = "FIRST_NAME";
    public static final String COLUMN_CITY_NAME = "CITY_NAME";
    private static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "SQLiteDatabase.db";

    public SQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " ( " + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_FIRST_NAME + " VARCHAR, " + COLUMN_CITY_NAME + " VARCHAR);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    // Insert method
    private SQLiteDatabase database;

    public void insertRecord(ContactModel contact) {
        database = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_FIRST_NAME, contact.getFirstName());
        contentValues.put(COLUMN_CITY_NAME, contact.getCityName());
        database.insert(TABLE_NAME, null, contentValues);
        database.close();
    }

    // Update record
    public void updateRecord(ContactModel contact) {
        database = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_FIRST_NAME, contact.getFirstName());
        contentValues.put(COLUMN_CITY_NAME, contact.getCityName());
        database.update(TABLE_NAME, contentValues, COLUMN_ID + " = ?", new String[]{contact.getID()});
        database.close();
    }

    // Getting records
    public ArrayList<ContactModel> getAllRecords() {
        database = this.getReadableDatabase();
        Cursor cursor = database.query(TABLE_NAME, null, null, null, null, null, null);

        ArrayList<ContactModel> contacts = new ArrayList<ContactModel>();
        ContactModel contactModel;
        if (cursor.getCount() > 0) {
            for (int i = 0; i < cursor.getCount(); i++) {
                cursor.moveToNext();

                contactModel = new ContactModel();
                contactModel.setID(cursor.getString(0));
                contactModel.setFirstName(cursor.getString(1));
                contactModel.setCityName(cursor.getString(2));

                contacts.add(contactModel);
            }
        }
        cursor.close();
        database.close();

        return contacts;
    }

    // Deletion
    public void deleteRecord(ContactModel contact) {
        database = this.getReadableDatabase();
        database.delete(TABLE_NAME, COLUMN_ID + " = ?", new String[]{contact.getID()});
        database.close();
    }
}
