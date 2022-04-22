package com.example.afinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    ImageButton hair, skin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        hair = findViewById(R.id.haircareimg);
        skin = findViewById(R.id.skincareimg);

        hair.setOnClickListener(this);
        skin.setOnClickListener(this);
    }

    @Override
    public void onClick(View src) {
        if (src.getId() == R.id.skincareimg) {
            Intent intent = new Intent(this, skincare.class);
            startActivity(intent);
        }
//        else if(src.getId()==R.id.haircareimg){
//            Intent intent = new Intent(this, haircare.class);
//            startActivity(intent);
//        }
//        else{
//            Intent intent=new Intent(this,checkout.class);
//            startActivity(intent);
//        }


    }
    public void broadcastIntent (View view){
        Intent intent = new Intent( );
        intent.setAction("com.example.afinal.AIRPLANE_MODE");
        sendBroadcast (intent);
    }
}