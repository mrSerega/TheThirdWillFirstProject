package com.firstproject.thethirdwill.thethirdwillfirstproject;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
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
    int first;
    int id;
    Integer year;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        Bundle bundle=getIntent().getExtras();
        year =bundle.getInt("year");
        first=bundle.getInt("first");
        value=first+1;

        mDatabaseHelper = new DatabaseHelper(this, "cards.db", null, 1);
        mSqLiteDatabase = mDatabaseHelper.getWritableDatabase();
        question=(TextView) findViewById(R.id.qViev);
        answer_fied=(EditText) findViewById(R.id.answer_field);
        Cursor cursor=mSqLiteDatabase.rawQuery("select question,answer,year,_ID from card where _ID like '"+first+"' and year="+year,null);
        cursor.moveToFirst();
        answ=cursor.getString(1);
        id=cursor.getInt(3);
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

            ContentValues values = new ContentValues();
            values.put(DatabaseHelper.FINISH_COLUMN, 1);
            mSqLiteDatabase.update(mDatabaseHelper.DATABASE_TABLE,
                    values,
                    mDatabaseHelper._ID+ "= ?", new String[]{Integer.toString(id)});



            Cursor cursor = mSqLiteDatabase.rawQuery("select question,answer,year,_ID from card where _ID like '" + value + "' and year="+year, null);
            cursor.moveToFirst();
            answ = cursor.getString(1);
            id=cursor.getInt(3);
            String quest = cursor.getString(0);
            question.setText(quest);
            value++;
            answer_fied.setText("");
        }
        else
        { Toast toast3 = Toast.makeText(getApplicationContext(),"Wrong answer", Toast.LENGTH_LONG);
        toast3.show();}





    }




    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)  {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            Intent newIntent = new Intent(question.this, Map_Activity.class);
            finish();
            startActivity(newIntent);




            return true;
        }

        return super.onKeyDown(keyCode, event);
    }
}
