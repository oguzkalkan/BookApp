package com.asktroapp.myapplication;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class DashBoard extends AppCompatActivity implements View.OnClickListener {
    Button BtnAdd;
    ListView kullanicilar;
    ArrayList<String> kullaniciIsimleri;
    MyListViewAdapter myListViewAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
        BtnAdd = (Button) findViewById(R.id.btnAdd);
        BtnAdd.setOnClickListener(this);
        kullanicilar = (ListView) findViewById(R.id.listView);
        kullaniciIsimleri = new ArrayList<>();
        myListViewAdapter = new MyListViewAdapter(kullaniciIsimleri, this);

        kullanicilar.setAdapter(myListViewAdapter);
        kullanicilar.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.v("hello",kullaniciIsimleri.get(position) + "isimli item tıklandı");
                showAlertDialog();
            }
        });
    }

    void showAlertDialog()
    {
        final AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("Alarm");
        alertDialog.setMessage("Bu bir alarm diyaloğudur");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "Tamam", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                alertDialog.dismiss();
            }
        });
        alertDialog.show();



    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnAdd:
                addUser();


                break;
        }


    }
    int x = 0;
    private void addUser() {

        String username = "name" + x;
        kullaniciIsimleri.add(username);
        myListViewAdapter.notifyDataSetChanged();
        x++;
    }




    public void AddUser(View view)
    {

    }
}
