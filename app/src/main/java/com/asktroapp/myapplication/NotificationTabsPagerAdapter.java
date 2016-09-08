package com.asktroapp.myapplication;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.asktroapp.myapplication.Fragments.PurposesInFragment;
import com.asktroapp.myapplication.Fragments.PurposesOutFragment;

import java.util.Arrays;
import java.util.List;

/**
 * Created by mobiltek26 on 9/6/16.
 */
public class NotificationTabsPagerAdapter extends FragmentPagerAdapter {

    int tabCount;
    List<String> tagList = Arrays.asList("İstek gönderdiklerim", "Gelen istekler");



    public NotificationTabsPagerAdapter(FragmentManager fm ,int tabCount) {
        super(fm);
        this.tabCount = tabCount;
    }

    @Override
    public Fragment getItem(int index) {
        switch (index) {
            case 0:
                // Gelen istekler
                PurposesInFragment tab1 = new PurposesInFragment();
                return tab1;
            case 1:
                // Gönderdiğim istekler
                PurposesOutFragment tab2 = new PurposesOutFragment();
                return tab2;
    }
        return  null;
}

    @Override
    public int getCount()
    {
        return tabCount;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String Title = tagList.get(position);
        return Title;
    }


}
