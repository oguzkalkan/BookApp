package com.asktroapp.myapplication.Fragments;

<<<<<<< HEAD
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
=======
import android.os.Bundle;
import android.support.v4.app.Fragment;
>>>>>>> origin/master
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.asktroapp.myapplication.CustomItemClickListener;
import com.asktroapp.myapplication.Friends;
import com.asktroapp.myapplication.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mobiltek26 on 9/1/16.
 */
public class FriendsFragment extends Fragment {

    private RecyclerView recyclerView;
    private FriendsAdapter adapter;
    private List<Friends> friendsList;


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.friends_fragment, container, false);


        recyclerView = (RecyclerView) view.findViewById(R.id.friends_recycler_view);

        friendsList = new ArrayList<>();


        adapter = new FriendsAdapter(getActivity(), friendsList, new CustomItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {

            }
        });

        RecyclerView.LayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.addItemDecoration(new FriendsFragment.GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);


        prepareFriends();



        return view;


    }

    private void prepareFriends() {

        int[] ProfileImages = new int[]
                {
                        R.drawable.jl,
                        R.drawable.rdj,
                        R.drawable.sj,
                        R.drawable.mf
                };


        Friends friend = new Friends("Jennifer","Lopez",10,ProfileImages[0]);

        friendsList.add(friend);

        friend = new Friends("Robert","Downey JR",5,ProfileImages[1]);

        friendsList.add(friend);

        friend = new Friends("Scarlett","Johansson",3,ProfileImages[2]);

        friendsList.add(friend);

        friend = new Friends("Morgan","Freeman",12,ProfileImages[3]);

        friendsList.add(friend);

        adapter.notifyDataSetChanged();



    }


    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }


        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view);
            int column = position % spanCount;

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount;
                outRect.right = (column + 1) * spacing / spanCount;

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount;
                outRect.right = spacing - (column + 1) * spacing / spanCount;
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }

    }

    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }

}
