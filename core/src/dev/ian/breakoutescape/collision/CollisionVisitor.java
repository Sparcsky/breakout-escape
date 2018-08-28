package dev.ian.breakoutescape.collision;

/**
 * Created by: Ian Parcon
 * Date created: Aug 28, 2018
 * Time created: 12:07 PM
 */
public interface CollisionVisitor {

    void accept(Collidable collidable);

}
