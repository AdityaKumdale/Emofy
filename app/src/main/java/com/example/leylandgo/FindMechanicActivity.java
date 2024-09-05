package com.example.leylandgo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FindMechanicActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_mechanic);

        CardView Leylandmech = findViewById(R.id.cardFDLeyLandMechs);
        Leylandmech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(FindMechanicActivity.this,MechanicDetailsActivity.class);
                it.putExtra("title","Leyland Mechanics");
                startActivity(it);
            }
        });
        CardView nonLeylandmech = findViewById(R.id.cardFDNonMechs);
        nonLeylandmech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(FindMechanicActivity.this,MechanicDetailsActivity.class);
                it.putExtra("title","Non-Leyland Mechanics");
                startActivity(it);
            }
        });

    }
}