package com.asktroapp.myapplication;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.asktroapp.myapplication.Fragments.PopularBooksFragment;
import com.asktroapp.myapplication.Fragments.RecAddedBooksFragment;

import java.util.Arrays;
import java.util.List;

/**
 * Created by mobiltek26 on 9/5/16.
 */
public class BookTabsPagerAdapter extends FragmentPagerAdapter{

    int tabCount;
    List<String> mFragmentTitleList = Arrays.asList("Yeni eklenenler","En çok arananlar");

    public BookTabsPagerAdapter(FragmentManager fm, int tabCount) {
        super(fm);
        this.tabCount= tabCount;
    }

    @Override
    public Fragment getItem(int index) {

        switch (index) {
            case 0:
                RecAddedBooksFragment tab1 = new RecAddedBooksFragment();
                return tab1;
            case 1:
                PopularBooksFragment tab2 = new PopularBooksFragment();
                return tab2;
        }

        return null;
    }

    @Override
    public int getCount() {
        // get item count - equal to number of tabs
        return tabCount;
    }


    @Override
    public CharSequence getPageTitle(int position) {
       String Title = mFragmentTitleList.get(position);
        return Title;
    }

}
