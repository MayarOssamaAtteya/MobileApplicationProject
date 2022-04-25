package com.example.afinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


import com.example.myapplication.R;

public class signup extends AppCompatActivity {
    private EditText user,email,num,pass,repass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        user=findViewById(R.id.UserInp);
        email=findViewById(R.id.emailInp);
        num=findViewById(R.id.NumberInp);
        pass=findViewById(R.id.passInp);
        repass=findViewById(R.id.repassinp);
    }

    protected void onResume()
    {
        super.onResume();
        //fetching the stored data from the sharedPreference
        SharedPreferences sh= getSharedPreferences("MySharedPref",MODE_PRIVATE);
        //the value will be default as empty string
        //bydwar 3ala el keys fl file b asamehom
        String uname=sh.getString("username","");
        String uemail=sh.getString("email","");
        String upass=sh.getString("password","");
        String urepass=sh.getString("reenter","");
        int numP =sh.getInt("mobile",0);
        //setting the fetched data in the EditTexts
        user.setText(uname);
        email.setText(uemail);
        pass.setText(upass);
        repass.setText(urepass);
        //hyhawelha le string 3shan ye3redha fl edittext 3shan bte2bal string bs
        num.setText(String.valueOf(numP));
    }


    protected void onPause()
    {
        super.onPause();
        //basame esm el file ely hahot feh l data
        //preferred to have the same name as the package
        //lw 3amalt mode public ay app tany momken y-access 3aleh
        SharedPreferences sp = getSharedPreferences("MySharedPref",MODE_PRIVATE);
        //Creating an editor object to edit in the file
        //permit the system to edit that file and write data in it
        //ya3ne bafa3al el editor
        SharedPreferences.Editor myEdit =sp.edit();
        //store data as key value pair
        myEdit.putString("username",user.getText().toString());
        myEdit.putString("email",email.getText().toString());
        myEdit.putString("password",pass.getText().toString());
        myEdit.putString("reenter",repass.getText().toString());
        myEdit.putInt("mobile",Integer.parseInt(num.getText().toString()));
        //apply 3shan yekteb fl file
        myEdit.apply();
        //keda ana 3malt store w h3ml retrieve mn el onresume
    }



}