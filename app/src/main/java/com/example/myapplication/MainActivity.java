package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button22);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                openlogin();
            }

        });
        button2 = (Button) findViewById(R.id.button33);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View n){
                opensignup();
            }

        });
    }
    public void openlogin(){
        Intent intent=new Intent(this, login.class );
        startActivity(intent);
    }
    public void opensignup(){
        Intent intent=new Intent(this, skincare.class );
        startActivity(intent);
    }
}