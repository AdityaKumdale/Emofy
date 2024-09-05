package com.example.leylandgo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.leylandgo.databinding.ActivityScoreBinding;

public class ScoreActivity extends AppCompatActivity {

    ActivityScoreBinding binding;
    Button fixit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityScoreBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //getSupportActionBar().hide();
        fixit  = findViewById(R.id.fixhealth);
        int totalScore = getIntent().getIntExtra("total",0);
        int correctAnsw = getIntent().getIntExtra("score",0);

        int wrong = totalScore - correctAnsw;

        binding.totalQuestionn.setText(String.valueOf(totalScore));
        binding.rightAns.setText(String.valueOf(correctAnsw));

        binding.wrongAns.setText(String.valueOf(wrong));

        binding.btnRetry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ScoreActivity.this,SetsActivity.class);
                startActivity(intent);
                finish();
            }
        });

        binding.btnQuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        fixit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ScoreActivity.this,healthFixes.class);
                startActivity(intent);
            }
        });
    }
}