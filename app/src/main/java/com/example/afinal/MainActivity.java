package com.example.afinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
    }
    public void broadcastIntent (View view){
        Intent intent = new Intent( );
        intent.setAction("com.example.afinal.AIRPLANE_MODE");
        sendBroadcast (intent);
    }
}