package com.example.afinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class skincare extends AppCompatActivity implements View.OnClickListener {
        Button button ,moist , hyl, water, sun ;
        TextView moist1 , hyl1, water1, sun1 ;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.skin_care);
            button = (Button) findViewById(R.id.checkout_button);
            moist = (Button) findViewById(R.id.moist_button);
            hyl = (Button) findViewById(R.id.hylau_button);
            water = (Button) findViewById(R.id.water_button);
            sun = (Button) findViewById(R.id.cleanser_button);
            moist1= findViewById(R.id.moistText);
            hyl1 =findViewById(R.id.hylauText);
            water1 =findViewById(R.id.waterText);
            sun1 = findViewById(R.id.cleanserText);

            button.setOnClickListener(this);
            moist.setOnClickListener(this);
            hyl.setOnClickListener(this);
            water.setOnClickListener(this);
            sun.setOnClickListener(this);





    }

    @Override
    public void onClick(View src) {
        int moistp=0;
        int hylp=0;
        int waterp=0;
        int sunp=0;
        int sum= moistp+hylp+waterp+sunp;
        if (src.getId() == R.id.checkout_button) {
            Intent intent = new Intent(this, mody.class);

            startActivity(intent);
        }
        if(src.getId()==R.id.moist_button){
            moistp=350;
            Intent intent = new Intent(this, mody.class);
            String moistTxt= moist1.getText().toString()+" 350 LE";
            intent.putExtra("moiststr",moistTxt);
             sum= moistp+hylp+waterp+sunp;
            intent.putExtra("tot",sum);
            startActivity(intent);

        }
        if(src.getId()==R.id.hylau_button){
            hylp=180;
            Intent intent = new Intent(this, mody.class);
            String hylTxt= hyl1.getText().toString()+" 180 LE";
            intent.putExtra("hulstr",hylTxt);
            sum= moistp+hylp+waterp+sunp;
            intent.putExtra("tot",sum);
            startActivity(intent);

        }
    }
}