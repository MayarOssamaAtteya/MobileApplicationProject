package com.example.afinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class login extends AppCompatActivity {
    private EditText user, email;
    Button button;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        user = findViewById(R.id.textViewu);
        email = findViewById(R.id.textViewp);




        button = findViewById(R.id.login_login);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("My Notification", "My Notification", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);

        }


        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                /////////notification code//////
                NotificationCompat.Builder builder = new NotificationCompat.Builder(login.this, "My Notification");
                builder.setContentTitle("Natural care");
                builder.setContentText(" login is complete , Welcome to natural care");
                builder.setSmallIcon(R.drawable.ic_baseline_home_24);
                builder.setAutoCancel(true);

                NotificationManagerCompat managerCompat = NotificationManagerCompat.from(login.this);
                managerCompat.notify(1, builder.build());
                Intent intent = new Intent(getApplicationContext(),home.class);
                String text="Welcome "+user.getText().toString();
                intent.putExtra("string",text);
                startActivity(intent);





            }
        });





        };



    protected void onResume() {
        super.onResume();
        //fetching the stored data from the sharedPreference
        SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        //the value will be default as empty string
        //bydwar 3ala el keys fl file b asamehom
        String uname = sh.getString("username", "");
        String uemail = sh.getString("email", "");

        int numP = sh.getInt("mobile", 0);
        //setting the fetched data in the EditTexts
        user.setText(uname);
        email.setText(uemail);



    }


    protected void onPause() {
        super.onPause();
        //basame esm el file ely hahot feh l data
        //preferred to have the same name as the package
        //lw 3amalt mode public ay app tany momken y-access 3aleh
        SharedPreferences sp = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        //Creating an editor object to edit in the file
        //permit the system to edit that file and write data in it
        //ya3ne bafa3al el editor
        SharedPreferences.Editor myEdit = sp.edit();
        //store data as key value pair
        myEdit.putString("username", user.getText().toString());
        myEdit.putString("email", email.getText().toString());
        myEdit.apply();
        //keda ana 3malt store w h3ml retrieve mn el onresume
    }


    public void opensignup(){
        Intent intent=new Intent(this,  home.class );
        startActivity(intent);}
}

