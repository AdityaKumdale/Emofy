package com.example.leylandgo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class EmosectionAct extends AppCompatActivity {

    CardView anger,sad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emosection);

        //getSupportActionBar().hide();
        anger = findViewById(R.id.AngerCard);
        sad = findViewById(R.id.SadCard);

        anger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EmosectionAct.this,SetsActivity.class);
                startActivity(intent);
            }
        });
    }
}