package dev.ian.breakoutescape;

import dev.ian.breakoutescape.asset.Asset;
import dev.ian.breakoutescape.sound.SoundPlayer;

/**
 * Created by: Ian Parcon
 * Date created: Aug 28, 2018
 * Time created: 2:09 PM
 */
public class Game {

    private Timer timer;
    private int countdown;
    private boolean gameOver;

    public void start() {
        SoundPlayer.play(Asset.BG_SOUND, true);
        timer = new Timer();
    }

    public void gameOver() {
        SoundPlayer.stopCurrentSound();
        SoundPlayer.play(Asset.GAME_OVER_SOUND, false);
        gameOver = true;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void gameCountDown() {
        countdown = timer.startGameTime();
        if (countdown <= 0) {
            gameOver = true;
        }
    }

    public int getCountdown() {
        return countdown;
    }
}
