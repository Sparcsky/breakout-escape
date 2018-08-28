package dev.ian.breakoutescape.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Sprite;

import dev.ian.breakoutescape.Config;
import dev.ian.breakoutescape.asset.Asset;
import dev.ian.breakoutescape.collision.Collidable;
import dev.ian.breakoutescape.sound.SoundPlayer;

/**
 * Created by: Ian Parcon
 * Date created: Aug 23, 2018
 * Time created: 1:22 PM
 */
public class Paddle extends GameObject {

    public Paddle(Sprite sprite, float x, float y) {
        super(sprite, x, y);
    }

    @Override
    public void accept(Collidable collidable) {
        collidable.collide(this);
    }

    public void reset() {
        x = (Config.WIDTH / 2) - getWidth() / 2;
        y = 90;
    }

    @Override
    public void update(float delta) {
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) x = x - 10;
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) x = x + 10;
        if (x > Config.WIDTH - 90 - getWidth()) x = Config.WIDTH - 90 - getWidth();
        if (x < 90) x = 90;

        sprite.setPosition(x, y);
    }

    @Override
    public void collide(Paddle paddle) {

    }

    @Override
    public void collide(Ball ball) {
        if (isCollide(ball)) {
            SoundPlayer.play(Asset.BALL_HIT_SOUND,false);
            if (isHitLeftSide(ball)) {
                ball.setDirection(-50, 300);
            } else if (isHitRightSide(ball)) {
                ball.setDirection(50, 300);
            } else {
                ball.setDy(300);
            }
        }
    }

    @Override
    public void collide(Brick brick) {

    }

    public boolean isHitRightSide(Ball ball) {
        return ball.getX() > x + (getWidth() / 2);
    }


    public boolean isHitLeftSide(Ball ball) {
        return ball.getX() < x + (getWidth() / 2);
    }
}
