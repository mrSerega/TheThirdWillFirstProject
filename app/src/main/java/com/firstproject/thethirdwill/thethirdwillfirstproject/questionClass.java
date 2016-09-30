package com.firstproject.thethirdwill.thethirdwillfirstproject;

import android.database.Cursor;

/**
 * Created by akella on 30.09.2016.
 */
public class questionClass {
    public String getQuestoin() {
        return questoin;
    }

    public void setQuestoin(String questoin) {
        this.questoin = questoin;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIsAnswered() {
        return isAnswered;
    }

    public void setIsAnswered(int isAnswered) {
        this.isAnswered = isAnswered;
    }

    private String questoin;
    private String answer;
    private int year;
    private String theme;
    private int id;
    private int isAnswered;
    private String[] answers;
    public questionClass(int id,String q,String a,int y,int ia)
    {
        setQuestoin(q);
        setAnswer(a);
        setId(id);
        setIsAnswered(ia);
        setYear(y);
        answers=answer.split(",");

    }
    public questionClass(Cursor cursor)
    {
        setQuestoin(cursor.getString(0));
        setAnswer(cursor.getString(1));
        setId(cursor.getInt(3));
        setYear(cursor.getInt(2));
        setIsAnswered(cursor.getInt(4));
        setTheme(cursor.getString(5));
        answers=answer.split(",");


    }
    public boolean isAnswerRight(String str)
    {
        boolean flag=false;
        for(int i=0;i<answers.length;i++)
        {
            str=str.toLowerCase();

            if(answers[i].toLowerCase().equals(str))
            {
                flag=true;
                break;
            }
        }
        return flag;
    }





}
