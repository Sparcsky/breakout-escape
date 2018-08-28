package dev.ian.breakoutescape.entity;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import java.util.Stack;

import dev.ian.breakoutescape.Config;
import dev.ian.breakoutescape.asset.Asset;

/**
 * Created by: Ian Parcon
 * Date created: Aug 26, 2018
 * Time created: 11:47 PM
 */
public class Player extends GameObject {

    private Stack<GameObject> lives;

    public Player() {
        setLives(5);
    }

    public void setLives(int count) {
        TextureAtlas atlas = Asset.instance().get(Asset.BREAKOUT_ATLAS);
        lives = new Stack<GameObject>();
        for (int i = 0; i < count; i++)
            lives.add(new GameObject(atlas.createSprite("heart")));
    }

    @Override
    public void draw(SpriteBatch batch) {
        renderHeart(batch);
    }

    private void renderHeart(SpriteBatch batch) {
        for (int i = 0; i < lives.size(); i++) {
            GameObject life = lives.get(i);
            life.setSize(20, 20);
            life.setPosition(Config.WIDTH - ((life.getWidth()) * i) - 25, (Config.HEIGHT - 15) - life.getHeight() / 2);
            life.draw(batch);
        }
    }

    public boolean hasLifeLeft() {
        return !lives.empty();
    }

    public void popHeart() {
        lives.pop();
    }

}
