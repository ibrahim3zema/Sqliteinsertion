package com.ibrahim.sqliteinsertion;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by ibra on 3/16/16.
 */
public class DBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Data";
    private static final String TABLE_NAME = "LoginTable";
    private static final int DATABASE_VERSION = 1;
    private static final String UID = "_id";
    private static final String NAME = "Name";
    private static final String PASSWORD = "Password";
    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME +
            "(" + UID + " INTEGER PRIMARY KEY AUTOINCREMENT , " + NAME + " VARCHAR(255), " + PASSWORD + " VARCHAR(255));";
    private static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
    Context context;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
        Toast.makeText(context, "constructor is called", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL(CREATE_TABLE);
            Toast.makeText(context, "onCreate is called", Toast.LENGTH_LONG).show();

        } catch (SQLException e) {
            Toast.makeText(context, "" + e, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        try {
            db.execSQL(DROP_TABLE);
            onCreate(db);
            Toast.makeText(context, "onUpgrade is called", Toast.LENGTH_LONG).show();

        } catch (SQLException e) {
            Toast.makeText(context, "" + e, Toast.LENGTH_LONG).show();

        }
    }
    public long insert(String name , String password){
        ContentValues values =new ContentValues();
        values.put(NAME,name);
        values.put(PASSWORD,password);
        SQLiteDatabase db=this.getWritableDatabase();
        long done=db.insert(TABLE_NAME,null,values);
        return done;
    }

}
