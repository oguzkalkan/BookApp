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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.asktroapp.myapplication.Books;
import com.asktroapp.myapplication.CustomItemClickListener;
import com.asktroapp.myapplication.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mobiltek26 on 9/5/16.
 */
public class PopularBooksFragment extends Fragment {


    private RecyclerView recyclerView;
    private PopularBooksAdapter adapter;
    private List<Books> booksList;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.popular_books_fragment, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.PopRecycler_view);

        booksList = new ArrayList<>();

        adapter = new PopularBooksAdapter(getActivity(), booksList ,new CustomItemClickListener() {

            @Override
            public void onItemClick(View view, int position) {

                Log.d("Click", "clicked position:" + position);
                String value = booksList.get(position).getBookName();

                String author = booksList.get(position).getAuthor();

                int ImageId = booksList.get(position).getBookImage();
                FragmentManager fm = getFragmentManager();
                PopularBooksDialogFragment dialogFragment = new PopularBooksDialogFragment();
                Bundle args1 = new Bundle();
                args1.putString("key1", "Kitap Adı : " + value);
                args1.putString("key2", "Yazar Adı : " + author);
                args1.putInt("key3",ImageId);
                dialogFragment.setArguments(args1);

                dialogFragment.show(fm, "Books");
                long postId = booksList.get(position).getBookImage();
            }
        });

        LinearLayoutManager LLM = new LinearLayoutManager(getActivity().getBaseContext());
        LLM.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(LLM);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        prepareBooks();

        return view;


    }

    private void prepareBooks() {

        int[] bookCovers = new int[]
                {
                        R.drawable.aliftheunseen,
                        R.drawable.mockingbird,
                        R.drawable.saniye
                };

        Books book = new Books("Elif","Willow Wilson","Fantastik","1. Baskı",bookCovers[0]);

        booksList.add(book);

        book = new Books("To Kil A Mockingbird","Harper Lee","Roman","2. Baskı",bookCovers[1]);

        booksList.add(book);

        book = new Books("15 Saniye","Andrew Gross","Roman","1. Baskı",bookCovers[2]);

        booksList.add(book);



        adapter.notifyDataSetChanged();



    }
}
