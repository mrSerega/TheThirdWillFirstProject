package com.firstproject.thethirdwill.thethirdwillfirstproject;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class question extends AppCompatActivity {
    private DatabaseHelper mDatabaseHelper;
    private SQLiteDatabase mSqLiteDatabase;
    EditText answer_fied;
    TextView question;
    TextView answer;
    String answ;
    int value=2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        mDatabaseHelper = new DatabaseHelper(this, "cards.db", null, 1);
        mSqLiteDatabase = mDatabaseHelper.getWritableDatabase();
        question=(TextView) findViewById(R.id.qViev);
        answer_fied=(EditText) findViewById(R.id.answer_field);
        Cursor cursor=mSqLiteDatabase.rawQuery("select question,answer from card where _ID like '1'",null);
        cursor.moveToFirst();
        answ=cursor.getString(1);
        String quest=cursor.getString(0);
        question.setText(quest);


    }
    public void next_move(View v)
    {

        String edit_answ=answer_fied.getText().toString();
        edit_answ.toLowerCase();
        answ.toLowerCase();
        String[] answers=answ.split(",");
        Boolean flag=false;
        for(int i=0;i<answers.length;i++)
        {
            if(answers[i].equals(edit_answ))
            {
                flag=true;
                break;
            }
        }
        if(flag==true) {


            Cursor cursor = mSqLiteDatabase.rawQuery("select question,answer from card where _ID like '" + value + "'", null);
            cursor.moveToFirst();
            answ = cursor.getString(1);
            String quest = cursor.getString(0);
            question.setText(quest);
            value++;
        }
        else
        { Toast toast3 = Toast.makeText(getApplicationContext(),"Wrong answer", Toast.LENGTH_LONG);
        toast3.show();}





    }}
