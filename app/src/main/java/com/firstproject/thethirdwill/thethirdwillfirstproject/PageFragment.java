package com.firstproject.thethirdwill.thethirdwillfirstproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

/**
 * Created by Serega on 24.09.2016.
 */
public class PageFragment extends Fragment{
    private int pageNumber;

    public static PageFragment newInstance(int page) {
        PageFragment fragment = new PageFragment();
        Bundle args=new Bundle();
        args.putInt("num", page);
        fragment.setArguments(args);
        return fragment;
    }

    public PageFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageNumber = getArguments() != null ? getArguments().getInt("num") : 1;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View result=inflater.inflate(R.layout.fragment_page, container, false);
        TextView pageHeader=(TextView)result.findViewById(R.id.displayText);
        ImageView pic = (ImageView)result.findViewById(R.id.pic);
        switch(pageNumber){
            case 0:
                pic.setImageResource(R.drawable.pic60s);
                pic.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Map_Activity.getnumbers(Map_Activity.mSqLiteDatabase, 1960);
                        Intent intent = new Intent(getActivity(), question.class);
                        intent.putExtra("year", 1960);
                        intent.putExtra("first", Map_Activity.first60);
                        startActivity(intent);
                        //finish();
                    }
                });
                pageHeader.setText(Map_Activity.getfinished(Map_Activity.mSqLiteDatabase, 1960)+"/"+Map_Activity.getall(Map_Activity.mSqLiteDatabase, 1960));
                break;
            case 1:
                pic.setImageResource(R.drawable.pic70s);
                pic.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Map_Activity.getnumbers(Map_Activity.mSqLiteDatabase, 1970);
                        Intent intent = new Intent(getActivity(), question.class);
                        intent.putExtra("year", 1970);
                        intent.putExtra("first", Map_Activity.first70);
                        startActivity(intent);
                        //finish();
                    }
                });
                pageHeader.setText(Map_Activity.getfinished(Map_Activity.mSqLiteDatabase, 1970) + "/" + Map_Activity.getall(Map_Activity.mSqLiteDatabase, 1970));
                break;
            case 2:
                pic.setImageResource(R.drawable.pic80s);
                pic.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Map_Activity.getnumbers(Map_Activity.mSqLiteDatabase, 1980);
                        Intent intent = new Intent(getActivity(), question.class);
                        intent.putExtra("year", 1980);
                        intent.putExtra("first", Map_Activity.first80);
                        startActivity(intent);
                        //finish();
                    }
                });
                pageHeader.setText(Map_Activity.getfinished(Map_Activity.mSqLiteDatabase, 1980) + "/" + Map_Activity.getall(Map_Activity.mSqLiteDatabase, 1980));
                break;
            case 3:
                pic.setImageResource(R.drawable.pic90s);
                pic.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Map_Activity.getnumbers(Map_Activity.mSqLiteDatabase, 1990);
                        Intent intent = new Intent(getActivity(), question.class);
                        intent.putExtra("year", 1990);
                        intent.putExtra("first", Map_Activity.first90);
                        startActivity(intent);
                        //finish();
                    }
                });
                pageHeader.setText(Map_Activity.getfinished(Map_Activity.mSqLiteDatabase, 1990) + "/" + Map_Activity.getall(Map_Activity.mSqLiteDatabase, 1990));
                break;
            case 4:
                pic.setImageResource(R.drawable.pic00s);
                pic.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Map_Activity.getnumbers(Map_Activity.mSqLiteDatabase, 2000);
                        Intent intent = new Intent(getActivity(), question.class);
                        intent.putExtra("year", 2000);
                        intent.putExtra("first", Map_Activity.first00);
                        startActivity(intent);
                        //finish();
                    }
                });
                pageHeader.setText(Map_Activity.getfinished(Map_Activity.mSqLiteDatabase, 2000) + "/" + Map_Activity.getall(Map_Activity.mSqLiteDatabase, 2000));
                break;
        }
        //pageHeader.setText("Фрагмент " + String.valueOf(pageNumber+1));
        return result;
    }
}
