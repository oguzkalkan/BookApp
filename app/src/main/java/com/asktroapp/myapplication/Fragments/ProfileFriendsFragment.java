package com.asktroapp.myapplication.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.asktroapp.myapplication.CustomItemClickListener;
import com.asktroapp.myapplication.Friends;
import com.asktroapp.myapplication.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mobiltek26 on 9/9/16.
 */
public class ProfileFriendsFragment extends Fragment {

    private RecyclerView recyclerView;
    private ProfileFriendsAdapter adapter;
    private List<Friends> friendsList;


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.profile_friends_fragment, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.Friends_Recycler_view);

        friendsList = new ArrayList<>();

        adapter = new ProfileFriendsAdapter(getActivity(), friendsList ,new CustomItemClickListener() {

            @Override
            public void onItemClick(View view, int position) {

            }
        });

        LinearLayoutManager llm = new LinearLayoutManager(getActivity().getBaseContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(llm);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        prepareFriends();

        return view;
    }


    private void prepareFriends() {

        int[] ProfileImages = new int[]
                {
                        R.drawable.jl,
                        R.drawable.rdj
                };


        Friends friend = new Friends("Jennifer","Lopez",10,ProfileImages[0]);

        friendsList.add(friend);

        friend = new Friends("Robert","Downey JR",5,ProfileImages[1]);

        friendsList.add(friend);

        adapter.notifyDataSetChanged();



    }


}
