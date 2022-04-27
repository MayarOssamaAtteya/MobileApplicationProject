package com.example.afinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class home extends AppCompatActivity implements View.OnClickListener{
    ImageButton hair, skin,check;
    TextView hell;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        hair = findViewById(R.id.haircareimg);
        skin = findViewById(R.id.skincareimg);
        check=findViewById(R.id.cartbtn);
        hell=findViewById(R.id.welcome);

        hair.setOnClickListener(this);
        skin.setOnClickListener(this);
        check.setOnClickListener(this);

        Intent i =getIntent();
       String welc= i.getStringExtra("string");
       hell.setText(welc);
    }

    @Override
    public void onClick(View src) {
        if (src.getId() == R.id.skincareimg) {
            Intent intent = new Intent(this, skincare.class);
            startActivity(intent);
        }
        if(src.getId()==R.id.haircareimg){
            Intent intent = new Intent(this, haircare.class);
            startActivity(intent);
        }
        if(src.getId()==R.id.cartbtn){
            Intent intent = new Intent(this, mody.class);
            startActivity(intent);
        }



    }
    public void broadcastIntent (View view){
        Intent intent = new Intent( );
        intent.setAction("com.example.afinal.AIRPLANE_MODE");
        sendBroadcast (intent);
    }
}