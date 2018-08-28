package dev.ian.breakoutescape;

import com.badlogic.gdx.Gdx;

/**
 * Created by: Ian Parcon
 * Date created: Aug 28, 2018
 * Time created: 2:07 PM
 */
public class Timer {

    private static final int INITIAL_GAME_TIME = 120;
    private long levelTime = INITIAL_GAME_TIME;
    private float timeState;

    public int startGameTime() {
        if (isTimeElapsed(1)) {
            levelTime = levelTime - 1;
        }
        return (int) levelTime;
    }

    public boolean isTimeElapsed(int timeCount) {
        timeState += Gdx.graphics.getDeltaTime();
        if (timeState >= timeCount) {
            timeState = 0f;
            return true;
        }
        return false;
    }

}
