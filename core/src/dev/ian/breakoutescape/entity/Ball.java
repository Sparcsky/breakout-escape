package dev.ian.breakoutescape.entity;

import com.badlogic.gdx.graphics.g2d.Sprite;

import dev.ian.breakoutescape.Config;
import dev.ian.breakoutescape.GameScorer;
import dev.ian.breakoutescape.asset.Asset;
import dev.ian.breakoutescape.collision.Collidable;
import dev.ian.breakoutescape.sound.SoundPlayer;

/**
 * Created by: Ian Parcon
 * Date created: Aug 23, 2018
 * Time created: 1:22 PM
 */
public class Ball extends GameObject {

    private float dx;
    private float dy;
    private float speed = 10;
    private final int INITIAL_POSX = Config.WIDTH / 2;
    private final int INITIAL_POSY = Config.HEIGHT / 2;

    public Ball(Sprite sprite) {
        super(sprite);
        reset();
    }

    public void reset() {
        x = INITIAL_POSX;
        y = INITIAL_POSY;
        dx = 0;
        dy = -300;
    }

    @Override
    public void update(float delta) {
        x = x + dx * delta;
        y = y + dy * delta;

        if (x + getWidth() > Config.GAME_WIDTH) dx = dx * -1;
        if (x + getWidth() < 90 + getWidth()) dx = dx + getWidth();
        if (y + getHeight() > Config.GAME_HEIGHT) dy = dy * -1;
        super.update(delta);
    }

    public void setDirection(float dx, float dy) {
        this.dy = dy;
        this.dx = dx;
    }

    public void setDx(float dx) {
        this.dx = dx;
    }

    public void setDy(float dy) {
        this.dy = dy;
    }

    @Override
    public float getX() {
        return x;
    }

    public float getDirX() {
        return dx;
    }

    public float getDirY() {
        return dy;
    }

    public boolean isOutOfBounds() {
        return y < 90;
    }

    @Override
    public void collide(Paddle paddle) {
        if (paddle.isCollide(this)) {
            SoundPlayer.play(Asset.BALL_HIT_SOUND, false);
            if (paddle.isHitLeftSide(this)) {
                setDirection(-50, 300);
            } else if (paddle.isHitRightSide(this)) {
                setDirection(50, 300);
            } else {
                setDy(300);
            }
        }
    }

    @Override
    public void collide(Ball ball) {

    }

    @Override
    public void collide(Brick brick) {
        setDy(getDirY() * -1);
        SoundPlayer.play(Asset.BRICK_HIT_SOUND, false);
        GameScorer.addScore(10);
    }

    @Override
    public void accept(Collidable collidable) {
        collidable.collide(this);
    }
}
