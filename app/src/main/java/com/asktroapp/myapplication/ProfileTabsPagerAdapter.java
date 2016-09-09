package com.asktroapp.myapplication;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.asktroapp.myapplication.Fragments.ProfileBooksFragment;
import com.asktroapp.myapplication.Fragments.ProfileFriendsFragment;

import java.util.Arrays;
import java.util.List;

/**
 * Created by mobiltek26 on 9/9/16.
 */
public class ProfileTabsPagerAdapter extends FragmentPagerAdapter {

    int tabCount;
    List<String> mFragmentTitleList = Arrays.asList("Kitaplar", "Arkadaşlar");

    public ProfileTabsPagerAdapter(FragmentManager fm, int tabCount) {
        super(fm);
        this.tabCount= tabCount;
    }



    @Override
    public Fragment getItem(int index) {

        switch (index) {
            case 0:
                ProfileBooksFragment tab1 = new ProfileBooksFragment();
                return tab1;
            case 1:
                ProfileFriendsFragment tab2 = new ProfileFriendsFragment();
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
