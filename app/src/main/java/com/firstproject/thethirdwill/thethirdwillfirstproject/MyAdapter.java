package com.firstproject.thethirdwill.thethirdwillfirstproject;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Serega on 24.09.2016.
 */
public class MyAdapter extends FragmentPagerAdapter {
    public MyAdapter(FragmentManager mgr) {
        super(mgr);
    }
    @Override
    public int getCount() {
        return(5);
    }
    @Override
    public Fragment getItem(int position) {
        return(PageFragment.newInstance(position));
    }
}
