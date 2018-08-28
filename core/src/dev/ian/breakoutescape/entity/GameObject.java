package dev.ian.breakoutescape.entity;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import dev.ian.breakoutescape.collision.Collidable;
import dev.ian.breakoutescape.collision.CollisionVisitor;

/**
 * Created by: Ian Parcon
 * Date created: Aug 23, 2018
 * Time created: 3:05 PM
 */
public  class GameObject implements Entity,CollisionVisitor,Collidable {

    protected Sprite sprite;
    protected float x;
    protected float y;

    public GameObject(Sprite sprite, float x, float y) {
        this.sprite = sprite;
        setPosition(x, y);
    }

    public GameObject(Sprite sprite) {
        this.sprite = sprite;
    }

    public GameObject() {

    }

    public void setPosition(float x, float y) {
        this.x = x;
        this.y = y;
        sprite.setPosition(x, y);
    }

    public void update(float delta) {
        if (sprite != null)
            sprite.setPosition(x, y);
    }

    public void draw(SpriteBatch batch) {
        sprite.draw(batch);
    }

    public void setSize(float width, float height) {
        sprite.setSize(width, height);
    }

    public boolean isCollide(GameObject object) {
        return sprite.getBoundingRectangle().overlaps(object.sprite.getBoundingRectangle());
    }

    public float getWidth() {
        return sprite.getWidth();
    }

    public float getHeight() {
        return sprite.getHeight();
    }

    public float getY() {
        return y;
    }

    public float getX() {
        return x;
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

    }
}
