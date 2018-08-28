package dev.ian.breakoutescape.entity;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by: Ian Parcon
 * Date created: Aug 23, 2018
 * Time created: 4:38 PM
 */
public interface Entity{

    void update(float delta);
    void draw(SpriteBatch batch);

}
