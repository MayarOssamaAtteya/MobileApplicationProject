package com.example.afinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class skincare extends AppCompatActivity {
        Button button;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.skin_care);


            button = (Button) findViewById(R.id.checkout_button);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v){
                    open();
                }

            });

        }
        public void open(){
            Intent intent=new Intent(this,  mody.class );
            startActivity(intent);
        }
    }