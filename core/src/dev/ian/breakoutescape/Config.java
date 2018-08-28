package dev.ian.breakoutescape;

import com.badlogic.gdx.Gdx;

/**
 * Created by: Ian Parcon
 * Date created: Aug 23, 2018
 * Time created: 4:56 PM
 */
public class Config {

    public static final int LIFE_COUNT = 5;
    public static int WIDTH = Gdx.graphics.getWidth();
    public static int HEIGHT = Gdx.graphics.getHeight();

    public static int ROW_COUNT = 5;
    public static int COL_COUNT = WIDTH / 32;

    public static int GAME_WIDTH = WIDTH - 190;
    public static int GAME_HEIGHT= HEIGHT - 90;

}
