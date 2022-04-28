package com.example.afinal;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.afinal.R;

import java.util.ArrayList;

public class haircare extends AppCompatActivity {
    ArrayList<ClassesModel> classesModels = new ArrayList<>();
    int[] classesImages={R.drawable.asd,R.drawable.img1,R.drawable.secich, R.drawable.img2,R.drawable.aveeno,R.drawable.giovanni};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hair_care);

        RecyclerView recyclerView=findViewById(R.id.mRecyclerView);

        steUpClassesModels();

        programAdapter adapter=new programAdapter(this,classesModels);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }
    private void steUpClassesModels(){
        String[] classesNames=getResources().getStringArray(R.array.classes_names);
        for(int i =0;i<classesNames.length;i++){
            classesModels.add(new ClassesModel(classesNames[i],classesImages[i]));

        }
    }

}