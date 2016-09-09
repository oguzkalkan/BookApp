package com.asktroapp.myapplication.Fragments;

import android.support.v4.app.Fragment;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.asktroapp.myapplication.Books;
import com.asktroapp.myapplication.BooksAdapter;
import com.asktroapp.myapplication.CustomItemClickListener;
import com.asktroapp.myapplication.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mobiltek26 on 9/5/16.
 */
public class SearchFragment extends Fragment {

    private RecyclerView recyclerView;
    private BooksAdapter adapter;
    private List<Books> booksList;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.search_fragment, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);

        booksList = new ArrayList<>();

        adapter = new BooksAdapter(getActivity(), booksList, new CustomItemClickListener() {

            @Override
            public void onItemClick(View v, int position) {
                Log.d("", "clicked position:" + position);
                //    long postId = booksList.get(position).getBookImage();
                // do what ever you want to do with it
            }
        });

        LinearLayoutManager llm = new LinearLayoutManager(getActivity().getBaseContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(llm);
      //  RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
       // recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        prepareBooks();

        return view;

    }

    private void prepareBooks() {

        int[] bookCovers = new int[]
                {
                    R.drawable.babiesrar,
                    R.drawable.aliftheunseen
                };

        Books b = new Books("Elif","Willow Wilson","Fantastik","1. Baskı",bookCovers[1]);

        booksList.add(b);

        b = new Books("Bab-ı Esrar","Ahmet Ümit","Polisiye","2. Baskı",bookCovers[0]);

        booksList.add(b);

        adapter.notifyDataSetChanged();



    }


}
