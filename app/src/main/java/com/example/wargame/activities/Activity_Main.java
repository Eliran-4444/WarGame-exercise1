package com.example.wargame.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.wargame.R;
import com.example.wargame.objects.MediaPlayerGame;

public class Activity_Main extends AppCompatActivity {

    private Button menu_BTN_play;
    private Button menu_BTN_records;
    private MediaPlayerGame sndSuffelCards;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        sndSuffelCards = new MediaPlayerGame(this, R.raw.snd_laugh);
        menu_BTN_play = findViewById(R.id.main_BTN_play);
        menu_BTN_records = findViewById(R.id.main_BTN_records);
        setPlayButton();
        setRecordsButton();
    }



    private void setRecordsButton() {
        menu_BTN_records.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showRecords(Activity_Main.this);
            }
        });
    }

    private void setPlayButton() {
        menu_BTN_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sndSuffelCards.playSound();
                startGame(Activity_Main.this);
            }
        });
    }

    private void startGame(Activity activity) {
        Intent game = new Intent(activity, Activity_Game.class);
        startActivity(game);
    }

    private void showRecords(Activity activity) {
        Intent records = new Intent(activity, Activity_Score_Records.class);
        startActivity(records);
    }
}