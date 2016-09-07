package com.asktroapp.myapplication.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.asktroapp.myapplication.R;

/**
 * Created by mobiltek26 on 9/5/16.
 */
public class PopularBooksFragment extends Fragment {

    public String [] PopularBooks = {"Alif The Unseen","Bab-ı Esrar"};
    ListView listView;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.popularbooks_fragment, container, false);

        listView = (ListView) view.findViewById(R.id.PopularBooksLV);

        ArrayAdapter<String> dataAdapter=new ArrayAdapter<String>
                (getActivity(), android.R.layout.simple_list_item_1, android.R.id.text1, PopularBooks);


        listView.setAdapter(dataAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String value = PopularBooks[position];


            }
        });

        return view;


    }
}
