package dev.ian.breakoutescape.asset;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGeneratorLoader;
import com.badlogic.gdx.graphics.g2d.freetype.FreetypeFontLoader;

/**
 * Created by: Ian Parcon
 * Date created: Aug 23, 2018
 * Time created: 2:57 PM
 */
public class Asset {

    private static Asset instance = new Asset();
    private AssetManager assetManager = new AssetManager();

    public static final String BREAKOUT_ATLAS = "sprites/breakout.pack";
    public static final String BACKGROUND_IMAGE = "sprites/background.png";

    public static final String DEATH_SOUND = "sounds/death.wav";
    public static final String BALL_HIT_SOUND = "sounds/ball_hit.wav";
    public static final String BRICK_HIT_SOUND = "sounds/brick_hit.wav";
    public static final String GAME_OVER_SOUND = "sounds/game_over.ogg";

    public static final String BG_SOUND = "sounds/tetris.mp3";
    public static final String PIXEL_FONT = "fonts/pixel.ttf";

    private Asset() {

    }

    public static Asset instance() {
        return instance;
    }

    private void initHandler() {
        FileHandleResolver resolver = new InternalFileHandleResolver();
        assetManager.setLoader(FreeTypeFontGenerator.class, new FreeTypeFontGeneratorLoader(resolver));
        assetManager.setLoader(BitmapFont.class, ".ttf", new FreetypeFontLoader(resolver));
    }

    public void loadAsset() {
        initHandler();
        loadFont();
        loadSound();
        loadSprites();
        assetManager.finishLoading();
    }

    private void loadFont() {
        FreetypeFontLoader.FreeTypeFontLoaderParameter mySmallFont = new FreetypeFontLoader.FreeTypeFontLoaderParameter();
        mySmallFont.fontFileName = PIXEL_FONT;
        mySmallFont.fontParameters.size = 12;
        mySmallFont.fontParameters.color = Color.WHITE;
        assetManager.load(PIXEL_FONT, BitmapFont.class, mySmallFont);
    }

    private void loadSound() {
        assetManager.load(DEATH_SOUND, Sound.class);
        assetManager.load(BALL_HIT_SOUND, Sound.class);
        assetManager.load(BRICK_HIT_SOUND, Sound.class);
        assetManager.load(GAME_OVER_SOUND, Sound.class);
        assetManager.load(BG_SOUND, Sound.class);
    }

    private void loadSprites() {
        assetManager.load(BREAKOUT_ATLAS, TextureAtlas.class);
        assetManager.load(BACKGROUND_IMAGE, Texture.class);
    }

    public <T> T get(String filename) {
        return assetManager.get(filename);
    }

    public void dispose() {
        assetManager.dispose();
    }

}
