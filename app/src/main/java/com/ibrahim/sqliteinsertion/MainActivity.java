package com.ibrahim.sqliteinsertion;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText passwordValue , usernameValue;
    DBHelper dbHelper ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        passwordValue=(EditText)findViewById(R.id.passwordValue);
        usernameValue=(EditText)findViewById(R.id.usernameValue);
        dbHelper=new DBHelper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
    }

    public void addUser(View view) {
        String pass=passwordValue.getText().toString();
        String user=usernameValue.getText().toString();
        long id =dbHelper.insert(user,pass);
        if(id<0){
            Toast.makeText(this,"unsuccessful",Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(this,"user added successfully",Toast.LENGTH_LONG).show();

        }
    }
}
