package dev.ian.breakoutescape;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import dev.ian.breakoutescape.asset.Asset;
import dev.ian.breakoutescape.manager.ScreenManager;
import dev.ian.breakoutescape.screen.PlayScreen;
import dev.ian.breakoutescape.sound.SoundPlayer;

public class BreakoutEscape extends Game {

    public SpriteBatch batch;
    private ScreenManager screenManager;

    @Override
    public void create() {
        Asset.instance().loadAsset();
        SoundPlayer.init();
        batch = new SpriteBatch();
        screenManager = new ScreenManager();
        screenManager.addScreen(new PlayScreen(this));
    }

    @Override
    public void render() {
        clearScreen();
        batch.begin();
        screenManager.update(Gdx.graphics.getDeltaTime());
        screenManager.render(Gdx.graphics.getDeltaTime());
        batch.end();
    }

    private void clearScreen() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    @Override
    public void dispose() {
        batch.dispose();
        screenManager.dispose();
        Asset.instance().dispose();
    }
}
