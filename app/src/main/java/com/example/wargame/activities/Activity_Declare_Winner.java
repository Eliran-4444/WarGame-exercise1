package com.example.wargame.activities;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.wargame.R;
import com.example.wargame.objects.MediaPlayerGame;
import com.example.wargame.objects.Player;
import com.google.gson.Gson;

public class Activity_Declare_Winner extends AppCompatActivity {

    private ImageView winnerIMG;
    private TextView winnerLBL;
    private ImageButton backBTN;
    private String drawIMG = "@drawable/img_draw";
    private MediaPlayerGame mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity__declare__winner);
        Gson gson = new Gson();
        String strWinner = getIntent().getStringExtra("winner");
        Player winner = gson.fromJson(strWinner, Player.class);
        backBTN = findViewById(R.id.winner_BTN_back);
        winnerIMG = findViewById(R.id.winner_IMG_winnerImg);
        winnerLBL = findViewById(R.id.winner_LBK_winnerName);
        showWinner(winner);
        setBackAction();
    }

    /**
     * show winner img or draw img .
     *
     * @param winner
     */
    private void showWinner(Player winner) {
        if (!(winner.getImgPlayer() == 0)) {
            mp = new MediaPlayerGame(this, R.raw.snd_winner);
            winnerIMG.setImageResource(winner.getImgPlayer());
            winnerLBL.setText(winner.getName());
        } else {
            mp = new MediaPlayerGame(this, R.raw.snd_draw);
            winnerLBL = findViewById(R.id.winner_LBL_winnerTitle);
            winnerLBL.setText("Draw");
            winnerIMG.setImageResource(R.drawable.img_draw);
        }
        mp.playSound();
    }

    /**
     * set a button to close this activity and so returns to the main menu activity
     */
    private void setBackAction() {
        backBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}