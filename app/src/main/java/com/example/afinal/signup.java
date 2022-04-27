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

public class signup extends AppCompatActivity {

    private EditText user, email, num, pass, repass;
    Button not;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        user = findViewById(R.id.UserInp);
        email = findViewById(R.id.emailInp);
        num = findViewById(R.id.NumberInp);
        pass = findViewById(R.id.passInp);
        repass = findViewById(R.id.repassinp);


        not = findViewById(R.id.button);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("My Notification", "My Notification", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);

        }


        not.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                /////////notification code//////
                NotificationCompat.Builder builder = new NotificationCompat.Builder(signup.this, "My Notification");
                builder.setContentTitle("natural care"); //set title of notification
                builder.setContentText(" sign up is complete , Welcome to natural care");//this is notification message
                builder.setSmallIcon(R.drawable.ic_baseline_home_24); //set icon for notification
                builder.setAutoCancel(true);// makes auto cancel of notification
                builder.setPriority(NotificationCompat.PRIORITY_DEFAULT); //set priority of notification
                Intent intent = new Intent(getApplicationContext(),home.class);
                String text="Welcome "+user.getText().toString();
                intent.putExtra("string",text);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                //notification message will get at NotificationView
                intent.putExtra("message", " sign up is complete , Welcome to natural care ");

                PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0,intent,
                        PendingIntent.FLAG_UPDATE_CURRENT);
                builder.setContentIntent(pendingIntent);
                // Add as notification
                NotificationManager manager = (NotificationManager) getSystemService(getApplicationContext().NOTIFICATION_SERVICE);
                manager.notify(0, builder.build());
//                NotificationManagerCompat managerCompat = NotificationManagerCompat.from(login.this);
//                managerCompat.notify(1, builder.build());
//
//                opensignup();




            }
        });
    }

    protected void onResume() {
        super.onResume();
        //fetching the stored data from the sharedPreference
        SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        //the value will be default as empty string
        //bydwar 3ala el keys fl file b asamehom
        String uname = sh.getString("username", "");
        String uemail = sh.getString("email", "");
        String upass = sh.getString("password", "");
        String urepass = sh.getString("reenter", "");
        int numP = sh.getInt("mobile", 0);
        //setting the fetched data in the EditTexts
        user.setText(uname);
        email.setText(uemail);
        pass.setText(upass);
        repass.setText(urepass);
        //hyhawelha le string 3shan ye3redha fl edittext 3shan bte2bal string bs
        num.setText(String.valueOf(numP));
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
        myEdit.putString("password", pass.getText().toString());
        myEdit.putString("reenter", repass.getText().toString());
        myEdit.putInt("mobile", Integer.parseInt(num.getText().toString()));
        //apply 3shan yekteb fl file
        myEdit.apply();
        //keda ana 3malt store w h3ml retrieve mn el onresume
    }





    public void open() {
        Intent intent = new Intent(this, home.class);
        startActivity(intent);
    }


}
