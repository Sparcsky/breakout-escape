package dev.ian.breakoutescape.collision;

import dev.ian.breakoutescape.entity.Ball;
import dev.ian.breakoutescape.entity.Brick;
import dev.ian.breakoutescape.entity.Paddle;

/**
 * Created by: Ian Parcon
 * Date created: Aug 28, 2018
 * Time created: 10:09 AM
 */
public interface Collidable {

    void collide(Paddle paddle);

    void collide(Ball ball);

    void collide(Brick brick);
}
