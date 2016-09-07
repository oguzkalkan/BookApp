package com.asktroapp.myapplication.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.asktroapp.myapplication.MainActivity;
import com.asktroapp.myapplication.R;
import com.asktroapp.myapplication.TabsPagerAdapter;

/**
 * Created by mobiltek26 on 9/1/16.

    */
    public class HomepageFragment extends Fragment implements TabLayout.OnTabSelectedListener {

    private ViewPager viewPager;
    private Toolbar toolbar;
    private TabLayout tabLayout;

        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View view =inflater.inflate(R.layout.homepage_fragment, container, false);

            toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
            ((MainActivity)getActivity()).setSupportActionBar(toolbar);


            tabLayout = (TabLayout) view.findViewById(R.id.tabLayout);

            tabLayout.addTab(tabLayout.newTab().setText(""));
            tabLayout.addTab(tabLayout.newTab().setText(""));
            tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);


            viewPager = (ViewPager) view.findViewById(R.id.HomeViewPager);

            TabsPagerAdapter adapter = new TabsPagerAdapter(((MainActivity)getActivity()).getSupportFragmentManager(), tabLayout.getTabCount());

            viewPager.setAdapter(adapter);

            tabLayout.setupWithViewPager(viewPager);
            tabLayout.setOnTabSelectedListener(this);

         //   tabLayout.viewPagerOnTabSelectedListener(viewPager);


            return view;


        }


    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        viewPager.setCurrentItem(tab.getPosition());

    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}

