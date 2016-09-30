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
import com.firstproject.thethirdwill.thethirdwillfirstproject.questionClass;

import java.util.ArrayList;
import java.util.List;

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
    int size;
    int num=0;
    List<questionClass> list;
    questionClass quest;
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
        Cursor cursor=mSqLiteDatabase.rawQuery("select question,answer,year,_ID,finish,theme from card where year="+year,null);
        list=new ArrayList<questionClass>();
        while(cursor.moveToNext())
        {
            list.add(new questionClass(cursor));

        }
        cursor.close();
        size=list.size();
        for(int i=0;i<size;i++)
        {
            if(list.get(i).getIsAnswered()==0) {
                num = i;
                break;
            }

        }
        size=list.size();
        quest=list.get(num);
        question.setText(quest.getQuestoin());


    }
    public void next_move(View v)
    {

        String edit_answ=answer_fied.getText().toString();

        if(quest.isAnswerRight(edit_answ)) {

            ContentValues values = new ContentValues();
            values.put(DatabaseHelper.FINISH_COLUMN, 1);
            mSqLiteDatabase.update(mDatabaseHelper.DATABASE_TABLE,
                    values,
                    mDatabaseHelper._ID+ "= ?", new String[]{Integer.toString(1)});
            num++;




            quest=list.get(num);
            question.setText(quest.getQuestoin());
            Toast toast3 = Toast.makeText(getApplicationContext(),quest.getTheme(), Toast.LENGTH_LONG);
            toast3.show();
            answer_fied.setText("");
        }
        else
        { Toast toast3 = Toast.makeText(getApplicationContext(),"Wrong Answer", Toast.LENGTH_LONG);
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
