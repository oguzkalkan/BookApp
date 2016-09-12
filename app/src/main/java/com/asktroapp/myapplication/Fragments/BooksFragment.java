package com.asktroapp.myapplication.Fragments;

import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.asktroapp.myapplication.Books;
import com.asktroapp.myapplication.BooksAdapter;
import com.asktroapp.myapplication.BooksFragmentAdapter;
import com.asktroapp.myapplication.CustomItemClickListener;
import com.asktroapp.myapplication.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mobiltek26 on 9/1/16.
 */
public class BooksFragment extends Fragment {

    private RecyclerView recyclerView;
    private BooksFragmentAdapter adapter;
    private List<Books> booksList;
<<<<<<< HEAD
=======

>>>>>>> origin/master

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.books_fragment, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.books_recycler_view);

        booksList = new ArrayList<>();

<<<<<<< HEAD

=======
>>>>>>> origin/master
        adapter = new BooksFragmentAdapter(getActivity(), booksList);

        RecyclerView.LayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);


        prepareBooks();


        return view;

    }


    private void prepareBooks() {

        int[] bookCovers = new int[]
                {
                        R.drawable.elif,
                        R.drawable.simyaci,
                        R.drawable.mockingbird,
                        R.drawable.saniye
                };

        Books b = new Books("Elif","Paulo Coelho","Roman","1. Baskı",bookCovers[0]);

<<<<<<< HEAD

        booksList.add(b);


        b = new Books("Simyacı","Paulo Coelho","Dünya-Roman","2. Baskı",bookCovers[1]);


        booksList.add(b);


=======
        booksList.add(b);

        b = new Books("Simyacı","Paulo Coelho","Dünya-Roman","2. Baskı",bookCovers[1]);

        booksList.add(b);

>>>>>>> origin/master
        b = new Books("To Kill a Mockingbird","Harper Lee","Polisiye","2. Baskı",bookCovers[2]);

        booksList.add(b);

        b = new Books("15 Saniye","Andrew Gross","Polisiye","2. Baskı",bookCovers[3]);

        booksList.add(b);

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





