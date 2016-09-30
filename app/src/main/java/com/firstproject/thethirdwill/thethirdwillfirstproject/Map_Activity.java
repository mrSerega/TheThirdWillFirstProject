package com.firstproject.thethirdwill.thethirdwillfirstproject;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Map;

public class Map_Activity extends AppCompatActivity{
    private DatabaseHelper mDatabaseHelper;
    public static SQLiteDatabase mSqLiteDatabase;
    //Button butt60;
    //Button butt70;
    //Button butt80;
    //Button butt90;
    //Button butt00;
    public static Integer first60;
    public static Integer first70;
    public static Integer first80;
    public static Integer first90;
    public static Integer first00;




    public static void getnumbers(SQLiteDatabase db,int year)
    {


        Cursor cursor=mSqLiteDatabase.rawQuery("select year,_ID from card where year="+year+" and finish=0",null);
        Integer numb=cursor.getCount();
        cursor.moveToFirst();
        if (year==1960)
            first60=cursor.getInt(1);
        if (year==1970)
            first70=cursor.getInt(1);
        if (year==1980)
            first80=cursor.getInt(1);
        if (year==1990)
            first90=cursor.getInt(1);
        if (year==2000)
            first00=cursor.getInt(1);

    }

    public static Integer getfinished(SQLiteDatabase db,Integer year)
    {
        Cursor cursor=mSqLiteDatabase.rawQuery("select year,_ID,finish from card where year="+year+" and finish=1",null);
        Integer numb=cursor.getCount();
        return numb;


    }
    public static Integer getall(SQLiteDatabase db,Integer year)
    {
        Cursor cursor=mSqLiteDatabase.rawQuery("select year,_ID,finish from card where year="+year,null);
        Integer numb=cursor.getCount();
        return numb;


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_);

        mDatabaseHelper = new DatabaseHelper(this, "cards.db", null, 1);
        mSqLiteDatabase = mDatabaseHelper.getWritableDatabase();
        //butt60=(Button) findViewById(R.id.button2);
        //butt70=(Button) findViewById(R.id.button3);
        //butt80=(Button) findViewById(R.id.button4);
        //butt90=(Button) findViewById(R.id.button5);
        //butt00=(Button) findViewById(R.id.button6);
        //butt60.setText("60s \n"+getfinished(mSqLiteDatabase,1960)+"/"+getall(mSqLiteDatabase,1960));
        //butt70.setText("70s \n"+getfinished(mSqLiteDatabase,1970)+"/"+getall(mSqLiteDatabase,1970));
        //butt80.setText("80s \n"+getfinished(mSqLiteDatabase,1980)+"/"+getall(mSqLiteDatabase,1980));
        //butt90.setText("90s \n"+getfinished(mSqLiteDatabase,1990)+"/"+getall(mSqLiteDatabase,1990));
        //butt00.setText("00s \n"+getfinished(mSqLiteDatabase,2000)+"/"+getall(mSqLiteDatabase,2000));

        ViewPager pager=(ViewPager)findViewById(R.id.pager);//----------------------
        pager.setAdapter(new MyAdapter(getSupportFragmentManager()));//-------------



    }
    public void go_to_60s(View v)
    {
        getnumbers(mSqLiteDatabase,1960);
        Intent intent=new Intent(Map_Activity.this,question.class);
        intent.putExtra("year",1960);
        intent.putExtra("first",first60);
        startActivity(intent);
        finish();
    }
    public void go_to_70s(View v)
    {
        getnumbers(mSqLiteDatabase,1970);
        Intent intent=new Intent(Map_Activity.this,question.class);
        intent.putExtra("year",1970);
        intent.putExtra("first",first70);
        startActivity(intent);
        finish();



    }
    public void go_to_80s(View v)
    {
        getnumbers(mSqLiteDatabase,1980);
        Intent intent=new Intent(Map_Activity.this,question.class);
        intent.putExtra("year",1980);
        intent.putExtra("first",first80);
        startActivity(intent);
        finish();



    }
    public void go_to_90s(View v)
    {
        getnumbers(mSqLiteDatabase,1990);
        Intent intent=new Intent(Map_Activity.this,question.class);
        intent.putExtra("year",1990);
        intent.putExtra("first",first90);
        startActivity(intent);
        finish();



    }
    public void go_to_00s(View v)
    {
        getnumbers(mSqLiteDatabase,2000);
        Intent intent=new Intent(Map_Activity.this,question.class);
        intent.putExtra("year",2000);
        intent.putExtra("first",first00);
        startActivity(intent);
        finish();



    }





}
