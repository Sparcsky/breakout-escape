package dev.ian.breakoutescape.screen;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import dev.ian.breakoutescape.BreakoutEscape;

/**
 * Created by: Ian Parcon
 * Date created: Aug 23, 2018
 * Time created: 1:16 PM
 */
public abstract class BaseScreen implements Screen {

    protected BreakoutEscape game;
    protected SpriteBatch batch;

    public BaseScreen(BreakoutEscape game) {
        this.game = game;
        this.batch = game.batch;
    }

    public abstract void render(float delta);

    public abstract void update(float delta);

    @Override
    public void show() {

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
    }
}
