package com.example.afinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class mody extends AppCompatActivity {
    TextView moist;
    TextView tot;
    TextView hyl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mody);
        moist =findViewById(R.id.moistText);
        hyl =findViewById(R.id.hText);

        tot =findViewById(R.id.tot);
        Intent i = getIntent();
        String text=i.getStringExtra("moiststr");
        String texth=i.getStringExtra("hulstr");

        int total = i.getIntExtra("tot",0);
       String totaltxt =Integer.toString(total);
        moist.setText(text);
        hyl.setText(texth);
        tot.setText(totaltxt);
    }
}