package com.firstproject.thethirdwill.thethirdwillfirstproject;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class question extends AppCompatActivity {
    private DatabaseHelper mDatabaseHelper;
    private SQLiteDatabase mSqLiteDatabase;
    TextView question;
    TextView answer;
    int value=2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        mDatabaseHelper = new DatabaseHelper(this, "cards.db", null, 1);
        mSqLiteDatabase = mDatabaseHelper.getWritableDatabase();
        question=(TextView) findViewById(R.id.qViev);
        answer=(TextView) findViewById(R.id.aView);
        Cursor cursor=mSqLiteDatabase.rawQuery("select question,answer from card where _ID like '1'",null);
        cursor.moveToFirst();
        String back=cursor.getString(1);
        answer.setText(back);
        String quest=cursor.getString(0);
        question.setText(quest);


    }
    public void next_move(View v)
    {

        Cursor cursor=mSqLiteDatabase.rawQuery("select question,answer from card where _ID like '"+value+"'",null);
        cursor.moveToFirst();
        String back=cursor.getString(1);
        answer.setText(back);
        String quest=cursor.getString(0);
        question.setText(quest);
        value++;

    }}
