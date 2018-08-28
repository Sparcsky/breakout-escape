package dev.ian.breakoutescape.entity;

import com.badlogic.gdx.graphics.g2d.Sprite;

import dev.ian.breakoutescape.collision.Collidable;

/**
 * Created by: Ian Parcon
 * Date created: Aug 23, 2018
 * Time created: 1:22 PM
 */
public class Brick extends GameObject {

    public Brick(Sprite sprite) {
        super(sprite);
    }

    @Override
    public void collide(Paddle paddle) {

    }

    @Override
    public void collide(Ball ball) {

    }

    @Override
    public void collide(Brick brick) {

    }

    @Override
    public void accept(Collidable collidable) {
        collidable.collide(this);
    }
}
