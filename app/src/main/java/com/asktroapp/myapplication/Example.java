package com.asktroapp.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Example extends AppCompatActivity {

    public final static String ONEMLI_MESAJ = "com.asktroapp.myapplication.MESAJ";
    EditText UserName;
    EditText Password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example);

        UserName = (EditText) findViewById(R.id.TxtName);
        Password = (EditText) findViewById(R.id.TxtPassword);
    }

    public void SendAccount(View view) {
        Intent msjIntent = new Intent(this, DashBoard.class);
        UserName = (EditText) findViewById(R.id.TxtName);
        String s = UserName.getText().toString();
        Password = (EditText) findViewById(R.id.TxtPassword);
        String s1 = Password.getText().toString();
        msjIntent.putExtra(ONEMLI_MESAJ,s);
        msjIntent.putExtra(ONEMLI_MESAJ,s1);
        startActivity(msjIntent);

    }
}
