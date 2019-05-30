package com.example.a6868.june_day1_work.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

public class VpAdpater extends FragmentStatePagerAdapter{
    private ArrayList<Fragment> fs;

    public VpAdpater(FragmentManager fm, ArrayList<Fragment> fs) {
        super(fm);
        this.fs = fs;
    }

    @Override
    public Fragment getItem(int i) {
        return fs.get(i);
    }

    @Override
    public int getCount() {
        return fs.size();
    }
}
