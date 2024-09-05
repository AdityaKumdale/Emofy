package com.example.leylandgo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;

import java.io.IOException;

public class Music extends AppCompatActivity {

    private Button play;
    private Button pause;
    private SeekBar seekBar;
    private MediaPlayer mediaPlayer;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        play = findViewById(R.id.play);
        pause = findViewById(R.id.pause);
        seekBar = findViewById(R.id.seekBar);
        //Mediaplayer using local source
        mediaPlayer = MediaPlayer.create(this,R.raw.medit);

        //Prepare the media player asynchronously and set a listener for when it's ready
        mediaPlayer.prepareAsync();
        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                //Start the playback when the media player is prepared
                mediaPlayer.start();
            }
        });

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.start();
            }
        });
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.pause();
            }
        });
    }
}