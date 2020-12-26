package com.example.wargame.objects;

import android.app.Activity;
import android.media.MediaPlayer;

public class MediaPlayerGame {
    private MediaPlayer mp;
    private int rawSound;
    private Activity context;

    public MediaPlayerGame() {
    }

    public MediaPlayerGame(Activity context, int rawSound) {
        this.rawSound = rawSound;
        this.context = context;
    }

    public void playSound() {
        if (mp != null) {
            try {
                mp.reset();
                mp.release();
            } catch (Exception ex) {
            }
        }

        mp = MediaPlayer.create(context, rawSound);
        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.reset();
                mp.release();
                mp = null;
            }
        });
        mp.start();
    }

    public void setRawSound(int rawSound) {
        this.rawSound = rawSound;
    }
}
