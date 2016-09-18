package com.firstproject.thethirdwill.thethirdwillfirstproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper implements BaseColumns {

    // названия столбцов
    Context context1;
    private int i=0;
    public static final String QUESTION_COLUMN = "question";
    public static final String ANSWER_COLUMN = "answer";// имя базы данных
    private static final String DATABASE_NAME = "cards.db";
    // версия базы данных
    private static final int DATABASE_VERSION = 1;
    // имя таблицы
    private static final String DATABASE_TABLE = "card";
    private static final String DATABASE_CREATE_SCRIPT = "create table "
            + DATABASE_TABLE + " (" + BaseColumns._ID
            + " integer primary key autoincrement, " + QUESTION_COLUMN
            + " text, " + ANSWER_COLUMN + " text, "+ " integer);";

    DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        context1=context;
    }

    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory,
                          int version) {
        super(context, name, factory, version);
        context1=context;

    }

    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory,
                          int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
        context1=context;

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE_SCRIPT);
        ContentValues values = new ContentValues();

        BufferedReader reader = null;


        ArrayList list=new ArrayList();


        try {
            reader = new BufferedReader(
                    new InputStreamReader(context1.getAssets().open("questions.txt")));

            // do reading, usually loop until end of file reading
            String mLine;
            while ((mLine = reader.readLine()) != null) {
                //mLine.toLowerCase();
    //            mLine= mLine.toLowerCase();

//                mLine=mLine.substring(mLine.indexOf(" ")+1,mLine.length()-1);
                list.add(mLine);

//                    values.put(DatabaseHelper.QUESTION_COLUMN, mLine);
//                else values.put(DatabaseHelper.ANSWER_COLUMN, mLine);
//                db.insert("card", null, values);


            }
        } catch (IOException e) {
            //log the exception
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    //log the exception
                }
            }
        }

        for(int i=0;i<list.size()-1;i=i+2)
        {

            values.put(DatabaseHelper.QUESTION_COLUMN,list.get(i).toString());
            values.put(DatabaseHelper.ANSWER_COLUMN,list.get(i+1).toString());
            db.insert("card",null,values);


        }







    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Запишем в журнал
        Log.w("SQLite", "Обновляемся с версии " + oldVersion + " на версию " + newVersion);

        // Удаляем старую таблицу и создаём новую
        db.execSQL("DROP TABLE IF IT EXISTS " + DATABASE_TABLE);
        // Создаём новую таблицу
        onCreate(db);
    }



}

