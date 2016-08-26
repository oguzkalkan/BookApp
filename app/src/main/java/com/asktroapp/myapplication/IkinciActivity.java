package com.asktroapp.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class IkinciActivity extends AppCompatActivity {

        TextView mesajtext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ikinci);

        Intent intent = getIntent();
        String message = intent.getStringExtra(ilkActivity.ONEMLI_MESAJ);
        mesajtext = (TextView) findViewById(R.id.gosterilecekmesaj);
        mesajtext.setText(message);
    }
}
