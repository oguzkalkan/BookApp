package com.asktroapp.myapplication;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.view.View;
import android.content.Intent;

public class ilkActivity extends AppCompatActivity {

    public final static String ONEMLI_MESAJ = "com.asktroapp.myapplication.MESAJ";
    EditText mesajEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ilk);

        mesajEditText = (EditText) findViewById(R.id.gidecekmesaj);
    }


   public void sendMessage(View v)
   {
       Intent msjIntent = new Intent(this, IkinciActivity.class);
       mesajEditText = (EditText) findViewById(R.id.gidecekmesaj);
       String s = mesajEditText.getText().toString();
       msjIntent.putExtra(ONEMLI_MESAJ,s);
       startActivity(msjIntent);
   }
}
