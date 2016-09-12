package com.asktroapp.myapplication.Fragments;

import android.os.Bundle;
<<<<<<< HEAD
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
=======
import android.support.v4.app.Fragment;
>>>>>>> origin/master
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.asktroapp.myapplication.BookTabsPagerAdapter;
import com.asktroapp.myapplication.CircleTransform;
import com.asktroapp.myapplication.ProfileTabsPagerAdapter;
import com.asktroapp.myapplication.R;
import com.squareup.picasso.Picasso;

/**
 * Created by mobiltek26 on 9/1/16.
 */
public class ProfileFragment extends Fragment implements TabLayout.OnTabSelectedListener {

    ImageView imageView;
    private ViewPager viewPager;
    private Toolbar toolbar;
    private TabLayout tabLayout;
    ProfileTabsPagerAdapter adapter;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.profile_fragment, container, false);

        imageView = (ImageView) view.findViewById(R.id.ProfilePic);

        Picasso.with(getActivity()).load(R.drawable.baykus).transform(new CircleTransform()).into(imageView);


        tabLayout = (TabLayout) view.findViewById(R.id.ProfiletabLayout);

        tabLayout.addTab(tabLayout.newTab().setText(""));
        tabLayout.addTab(tabLayout.newTab().setText(""));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);


        viewPager = (ViewPager) view.findViewById(R.id.ProfileViewPager);

        adapter = new ProfileTabsPagerAdapter(getChildFragmentManager(), tabLayout.getTabCount());

        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(2);

        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setOnTabSelectedListener(this);

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




