package com.example.leylandgo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.icu.text.CaseMap;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Homeactivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homeactivity);

        SharedPreferences sharedpreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
        String username = sharedpreferences.getString("username","").toString();
        Toast.makeText(getApplicationContext(), "Welcome "+username, Toast.LENGTH_SHORT).show();

        CardView exit = findViewById(R.id.cardExit);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.clear();
                editor.apply();
                startActivity(new Intent(Homeactivity.this,LoginActivity.class));
            }
        });

        CardView findDoctor = findViewById(R.id.cardFindMechanic);
        findDoctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity((new Intent(Homeactivity.this,FindMechanicActivity.class)));
            }
        });

        CardView labTest = findViewById(R.id.cardLabTest);
        labTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Homeactivity.this,LabTestActivity.class));
            }
        });

        CardView emo = findViewById(R.id.emosection);
        emo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Homeactivity.this,EmosectionAct.class));
            }
        });

        CardView jor = findViewById(R.id.cardOrderDetails);
        jor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Homeactivity.this,Journal.class));
            }
        });

        CardView music = findViewById(R.id.cardSchedule);
        music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(Homeactivity.this,Music.class);
//                startActivity(intent);

//                Intent intent = new Intent(Intent.ACTION_MAIN);
//                intent.setComponent(ComponentName.unflattenFromString("com.example.mediaplayerapp"));
//                intent.addCategory(Intent.CATEGORY_LAUNCHER);
//                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                startActivity(intent);

                Intent i = getPackageManager().getLaunchIntentForPackage("com.example.mediaplayerapp");
                startActivity(i);
            }
        });
    }
}