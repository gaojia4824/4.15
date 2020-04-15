package com.example.myapplication.uri.adapter;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class setAAdapter extends FragmentStatePagerAdapter {
   private ArrayList<String> mitem;
   private ArrayList<Fragment> mFragments;

    public setAAdapter(@NonNull FragmentManager fm, ArrayList<String> mitem, ArrayList<Fragment> fragments) {
        super(fm);
        this.mitem = mitem;
        mFragments = fragments;
    }

    public setAAdapter(@NonNull FragmentManager fm, int behavior, ArrayList<String> mitem, ArrayList<Fragment> fragments) {
        super(fm, behavior);
        this.mitem = mitem;
        mFragments = fragments;
    }

    public setAAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position)
    {
        return mFragments.get(position);
    }

    @Override
    public int getCount()
    {
        return mFragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mitem.get(position);
    }
}
