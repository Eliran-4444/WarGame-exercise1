package com.example.wargame.activities;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.wargame.R;
import com.example.wargame.objects.GameManger;
import com.example.wargame.objects.Player;
import com.google.gson.Gson;

public class Activity_Game extends AppCompatActivity {

    private ImageButton btn_play;
    private Button btn_addNames;
    private TextView lbl_playerOneScore;
    private TextView lbl_playerTwoScore;
    private ImageView img_playerOneCard;
    private ImageView img_playerTwoCard;
    private ImageView img_playerOne;
    private ImageView img_playerTwo;
    private GameManger gameManger;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_game);
        gameManger = new GameManger();
        connectObjects();
    }





    /**
     * play the game.
     */
    private void play() {
        if (gameManger.play()) {
            showCards();
            gameManger.showDown();
            updateScore();
        } else {
            openWinnerActivity(gameManger.getWinner());
        }
    }

    /**
     * connects objects to objects at activity_game.xml
     */
    private void connectObjects() {
        img_playerOne = findViewById(R.id.game_IMG_playerOne);
        img_playerTwo = findViewById(R.id.game_IMG_playerTwo);
        btn_play = findViewById(R.id.game_IMG_BTN_play);
        btn_addNames = findViewById(R.id.game_btn_addPlayersName);
        lbl_playerOneScore = findViewById(R.id.game_LBL_playerOneScore);
        lbl_playerTwoScore = findViewById(R.id.game_LBL_playerTwoScore);
        img_playerOneCard = findViewById(R.id.game_IMG_playerOneCard);
        img_playerTwoCard = findViewById(R.id.game_IMG_playerTwoCard);
        img_playerOne.setImageResource(gameManger.getPlayerOne().getImgPlayer());
        img_playerTwo.setImageResource(gameManger.getPlayerTwo().getImgPlayer());
        set_BTN_addNames();
        setBtn_play();
    }

    /**
     * configure add names button.
     */
    private void set_BTN_addNames() {
        btn_addNames.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText edt_playerOneName = findViewById(R.id.game_EDT_playerOneName);
                EditText edt_playerTwoName = findViewById(R.id.game_EDT_playerTwoName);
                String playerOneName = edt_playerOneName.getText().toString();
                String playerTwoName = edt_playerTwoName.getText().toString();
                if (gameManger.setPlayerName(true, playerOneName) && gameManger.setPlayerName(false, playerTwoName)) {
                    hideLayoutGetName();
                    showLayoutGame();
                } else {
                    showPopUp("Players names are not valid");
                }
            }
        });
    }

    /**
     * set action for button play.
     */
    private void setBtn_play() {
        btn_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play();
            }
        });
    }

    /**
     * turn game layout to visible.
     */
    private void showLayoutGame() {
        RelativeLayout layoutPlayerRight = findViewById(R.id.game_layout_rightPlayer);
        RelativeLayout layoutPlayerLeft = findViewById(R.id.game_layout_leftPlayer);
        LinearLayout layoutCards = findViewById(R.id.game_layout_cards);
        layoutCards.setVisibility(View.VISIBLE);
        layoutPlayerRight.setVisibility(View.VISIBLE);
        layoutPlayerLeft.setVisibility(View.VISIBLE);
        btn_play.setVisibility(View.VISIBLE);
    }

    /**
     * turn names layout to GONE.
     */
    private void hideLayoutGetName() {
        RelativeLayout layoutNames = findViewById(R.id.game_layout_playersNames);
        layoutNames.setVisibility(View.GONE);

    }

    /**
     * show message
     *
     * @param msg
     */
    private void showPopUp(String msg) {
        new AlertDialog.Builder(this).setTitle("Oops").setMessage(msg).setPositiveButton("Close", null).show();
    }




    /**
     * start and send player to activity_declare_winner.
     * finish this activity.
     *
     * @param winner
     */
    private void openWinnerActivity(Player winner) {
        Gson gson = new Gson();
        Intent winnerActivity = new Intent(Activity_Game.this, Activity_Declare_Winner.class);
        String strWinner = gson.toJson(winner);
        winnerActivity.putExtra("winner", strWinner);
        startActivity(winnerActivity);
        finish();
    }


    /**
     * set cards image at activity_game.xml
     */
    private void showCards() {
        img_playerOneCard.setImageResource(getResources().getIdentifier(gameManger.getCard_playerOne().getCardImageResource(), null, getPackageName()));
        img_playerTwoCard.setImageResource(getResources().getIdentifier(gameManger.getCard_playerTwo().getCardImageResource(), null, getPackageName()));
    }


    /**
     * update players scores
     */
    private void updateScore() {
        lbl_playerOneScore.setText("" + gameManger.getPlayerOne().getScore());
        lbl_playerTwoScore.setText("" + gameManger.getPlayerTwo().getScore());

    }


}