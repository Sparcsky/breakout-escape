package dev.ian.breakoutescape;

/**
 * Created by: Ian Parcon
 * Date created: Aug 28, 2018
 * Time created: 1:35 PM
 */
public class GameScorer {

    public static int score = 0;

    public static void addScore(int score) {
        GameScorer.score += score;
    }
}
