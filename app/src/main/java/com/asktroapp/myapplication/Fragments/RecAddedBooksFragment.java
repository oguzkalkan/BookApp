package com.asktroapp.myapplication.Fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.asktroapp.myapplication.R;

/**
 * Created by mobiltek26 on 9/5/16.
 */
public class RecAddedBooksFragment extends Fragment {

    public String [] RecAddedBooks = {"İstanbul Hatırası","Kitap Hırsızı","Olasılıksız","Bir Ermeni Subayın Çanakkale ve Doğu Cephesi Günlüğü 1914-1918"};
    ListView listView;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view = inflater.inflate(R.layout.recaddedbooks_fragment, container, false);

        listView = (ListView) view.findViewById(R.id.RecAddedBooksLV);

        ArrayAdapter<String> dataAdapter=new ArrayAdapter<String>
                (getActivity(), android.R.layout.simple_list_item_1, android.R.id.text1, RecAddedBooks);


        listView.setAdapter(dataAdapter);

        return view;
    }
}
