package dev.ian.breakoutescape.sound;

import com.badlogic.gdx.audio.Sound;

import java.util.HashMap;

import dev.ian.breakoutescape.asset.Asset;

/**
 * Created by: Ian Parcon
 * Date created: Aug 27, 2018
 * Time created: 9:32 PM
 */
public class SoundPlayer {

    private static HashMap<String, Sound> sounds = new HashMap<String, Sound>();

    public SoundPlayer() {
    }

    public static void init() {
        sounds.put(Asset.BG_SOUND, (Sound) Asset.instance().get(Asset.BG_SOUND));
        sounds.put(Asset.DEATH_SOUND, (Sound) Asset.instance().get(Asset.DEATH_SOUND));
        sounds.put(Asset.BALL_HIT_SOUND, (Sound) Asset.instance().get(Asset.BALL_HIT_SOUND));
        sounds.put(Asset.BRICK_HIT_SOUND, (Sound) Asset.instance().get(Asset.BRICK_HIT_SOUND));
        sounds.put(Asset.GAME_OVER_SOUND, (Sound) Asset.instance().get(Asset.GAME_OVER_SOUND));
    }

    public static void play(String name, boolean looping) {
        Sound sound = sounds.get(name);
        sound.setLooping(sound.play(), looping);
    }

    public static void stopCurrentSound() {
        sounds.get(Asset.BG_SOUND).stop();
    }
}
