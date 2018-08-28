package dev.ian.breakoutescape.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import dev.ian.breakoutescape.BreakoutEscape;
import dev.ian.breakoutescape.Config;
import dev.ian.breakoutescape.Game;
import dev.ian.breakoutescape.GameScorer;
import dev.ian.breakoutescape.Timer;
import dev.ian.breakoutescape.asset.Asset;
import dev.ian.breakoutescape.entity.Ball;
import dev.ian.breakoutescape.entity.Brick;
import dev.ian.breakoutescape.entity.Paddle;
import dev.ian.breakoutescape.entity.Player;

/**
 * Created by: Ian Parcon
 * Date created: Aug 23, 2018
 * Time created: 1:23 PM
 */
public class PlayScreen extends BaseScreen {

    private BitmapFont font;
    private TextureAtlas atlas = Asset.instance().get(Asset.BREAKOUT_ATLAS);
    private Texture bg = Asset.instance().get(Asset.BACKGROUND_IMAGE);

    private Timer timer;
    private Game game;
    private Paddle paddle;
    private Player player;
    private List<Ball> balls;
    private List<Brick> entities;

    public PlayScreen(BreakoutEscape breakoutEscape) {
        super(breakoutEscape);
        timer = new Timer();
        game = new Game();
        game.start();
        font = Asset.instance().get(Asset.PIXEL_FONT);
        paddle = new Paddle(atlas.createSprite("paddle"), (Config.WIDTH / 2) - 32, 120);
        player = new Player();

        balls = new ArrayList<Ball>();
        balls.add(new Ball(atlas.createSprite("ball")));

        initBrick();
    }

    private void initBrick() {
        entities = new ArrayList<Brick>();
        for (int row = 0; row < Config.ROW_COUNT; row++) {
            for (int col = 0; col < (Config.WIDTH - 190) / 40; col++) {
                Brick block = new Brick(atlas.createSprite("block_blue"));
                block.setSize(40, block.getHeight());
                float xPos = 90 + (col * (block.getWidth() + 2));
                float yPos = (Config.HEIGHT - 95) - row * block.getHeight() - block.getHeight();
                block.setPosition(xPos, yPos);
                entities.add(block);
            }
        }
    }

    @Override
    public void update(float delta) {
        if (!game.isGameOver()) {
            paddle.update(delta);
            player.update(delta);
            game.gameCountDown();
            if (timer.isTimeElapsed(10)) {
                balls.add(new Ball(atlas.createSprite("ball")));
            }
            for (Ball ball : balls) {
                ball.update(delta);
                ball.collide(paddle);
                if (ball.isOutOfBounds()) {
                    if (player.hasLifeLeft()) {
                        player.popHeart();
                        ball.reset();
                    } else {
                        game.gameOver();
                    }
                }
            }
        }
    }

    @Override
    public void render(float delta) {
        batch.draw(bg, 0, 0, Config.WIDTH, Config.HEIGHT);
        drawFont();
        drawEntity();
        drawBricks();
    }

    private void drawFont() {
        font.draw(batch, "Player: " + "Ian", 10, Config.HEIGHT - 10);
        font.draw(batch, "Score: " + GameScorer.score, 100, Config.HEIGHT - 10);
        font.draw(batch, "Time: " + game.getCountdown(), 250, Config.HEIGHT - 10);

        if (game.isGameOver()) {
            font.draw(batch, "Game Over", Config.WIDTH / 2 - ((12 * 8) / 2), Config.HEIGHT / 2);
        }
    }

    private void drawEntity() {
        player.draw(batch);
        paddle.draw(batch);
        for (Ball ball : balls) {
            ball.draw(batch);
        }
    }

    private void drawBricks() {
        Iterator<Brick> item = entities.iterator();
        while (item.hasNext()) {
            Brick brick = item.next();
            brick.update(Gdx.graphics.getDeltaTime());
            brick.draw(batch);
            for (Ball ball : balls) {
                if (ball.isCollide(brick)) {
                    ball.collide(brick);
                    item.remove();
                }
            }
        }
    }

}
