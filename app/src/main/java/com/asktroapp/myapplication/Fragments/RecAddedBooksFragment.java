package com.asktroapp.myapplication.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.asktroapp.myapplication.Books;
import com.asktroapp.myapplication.CircleTransform;
import com.asktroapp.myapplication.CustomItemClickListener;
import com.asktroapp.myapplication.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mobiltek26 on 9/5/16.
 */
public class RecAddedBooksFragment extends Fragment {


    private RecyclerView recyclerView;
    private RecAddedBooksAdapter adapter;
    private List<Books> booksList;


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.rec_added_books_fragment, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.Recycler_view);

        booksList = new ArrayList<>();

        adapter = new RecAddedBooksAdapter(getActivity(), booksList ,new CustomItemClickListener() {

            @Override
            public void onItemClick(View view, int position) {

                Log.d("Click", "clicked position:" + position);
                String value = booksList.get(position).getBookName();

                String author = booksList.get(position).getAuthor();

                int ImageId = booksList.get(position).getBookImage();
                FragmentManager fm = getFragmentManager();
                RecAddedBooksDialogFragment dialogFragment = new RecAddedBooksDialogFragment();
                Bundle args1 = new Bundle();
                args1.putString("key1", "Kitap Adı : " + value);
                args1.putString("key2", "Yazar Adı : " + author);
                args1.putInt("key3",ImageId);
                dialogFragment.setArguments(args1);

                dialogFragment.show(fm, "Books");
              long postId = booksList.get(position).getBookImage();
            }
        });

        LinearLayoutManager llm = new LinearLayoutManager(getActivity().getBaseContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(llm);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        prepareBooks();

        return view;
    }


    private void prepareBooks() {

        int[] bookCovers = new int[]
                {
                        R.drawable.istanbul,
                        R.drawable.sofie
                };


        Books book = new Books("İstanbul Hatırası","Ahmet Ümit","Polisiye","1. Baskı",bookCovers[0]);

        booksList.add(book);

        book = new Books("Sofie'nin Dünyası","Jostein Gaarder ","Felsefe","2. Baskı",bookCovers[1]);

        booksList.add(book);

        adapter.notifyDataSetChanged();



    }

}
