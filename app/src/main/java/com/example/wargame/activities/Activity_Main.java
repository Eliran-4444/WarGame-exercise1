package com.example.wargame.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.example.wargame.R;

public class Activity_Main extends AppCompatActivity {

    private Button menu_BTN_play;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        menu_BTN_play = findViewById(R.id.main_BTN_play);
        setPlayButton();
    }




    private void setPlayButton() {
        menu_BTN_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startGame(Activity_Main.this);
            }
        });
    }

    private void startGame(Activity activity) {
        Intent game = new Intent(activity, Activity_Game.class);
        startActivity(game);
    }

}