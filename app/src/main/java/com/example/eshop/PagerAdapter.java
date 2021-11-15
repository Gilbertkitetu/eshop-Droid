package com.example.eshop;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class PagerAdapter extends FragmentStateAdapter {
    public int numOfTabs;

    public PagerAdapter(FragmentManager fm, Lifecycle lifecycle, int tabCount){

        super(fm, lifecycle);
        this.numOfTabs = tabCount;
    }


    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new register();

            case 1:
                return new purchase();

            case 2:
                return new checkout();
            default:
                return new register();
        }
    }

    @Override
    public int getItemCount() {
        return numOfTabs;
    }
}