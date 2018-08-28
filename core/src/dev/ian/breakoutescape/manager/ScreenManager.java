package dev.ian.breakoutescape.manager;

import com.badlogic.gdx.Screen;

import java.util.Stack;

import dev.ian.breakoutescape.screen.BaseScreen;

/**
 * Created by: Ian Parcon
 * Date created: Aug 23, 2018
 * Time created: 2:12 PM
 */
public class ScreenManager {

    private Stack<BaseScreen> screens = new Stack<BaseScreen>();

    public void addScreen(BaseScreen screen) {
        if (screens != null)
            screens.add(screen);
    }

    public void popScreen() {
        if (!screens.isEmpty())
            screens.pop();
    }

    public void render(float delta) {
        screens.peek().render(delta);
    }

    public void update(float delta) {
        screens.peek().update(delta);
    }

    public void dispose(){
        screens.peek().dispose();
    }
}
