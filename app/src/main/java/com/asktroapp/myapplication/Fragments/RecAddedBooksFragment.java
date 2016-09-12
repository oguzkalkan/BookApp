package com.asktroapp.myapplication.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
<<<<<<< HEAD
import android.widget.ImageView;

import com.asktroapp.myapplication.Books;
import com.asktroapp.myapplication.CircleTransform;
import com.asktroapp.myapplication.CustomItemClickListener;
=======
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.asktroapp.myapplication.Books;
import com.asktroapp.myapplication.BooksAdapter;
import com.asktroapp.myapplication.CustomItemClickListener;
import com.asktroapp.myapplication.ItemClickSupport;
>>>>>>> origin/master
import com.asktroapp.myapplication.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by mobiltek26 on 9/5/16.
 */
public class RecAddedBooksFragment extends Fragment {


    private RecyclerView recyclerView;
<<<<<<< HEAD
    private RecAddedBooksAdapter adapter;
=======
    private BooksAdapter adapter;
>>>>>>> origin/master
    private List<Books> booksList;


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
<<<<<<< HEAD
        View view = inflater.inflate(R.layout.rec_added_books_fragment, container, false);
=======
        View view = inflater.inflate(R.layout.recaddedbooks_fragment, container, false);
>>>>>>> origin/master

        recyclerView = (RecyclerView) view.findViewById(R.id.Recycler_view);

        booksList = new ArrayList<>();

<<<<<<< HEAD
        adapter = new RecAddedBooksAdapter(getActivity(), booksList ,new CustomItemClickListener() {
=======
        adapter = new BooksAdapter(getActivity(), booksList ,new CustomItemClickListener() {
>>>>>>> origin/master

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

<<<<<<< HEAD

=======
>>>>>>> origin/master
        Books book = new Books("İstanbul Hatırası","Ahmet Ümit","Polisiye","1. Baskı",bookCovers[0]);

        booksList.add(book);

        book = new Books("Sofie'nin Dünyası","Jostein Gaarder ","Felsefe","2. Baskı",bookCovers[1]);

        booksList.add(book);

        adapter.notifyDataSetChanged();



    }

}
