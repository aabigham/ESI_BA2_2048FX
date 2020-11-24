package com.java2048.view.fx;

import com.java2048.model.Direction;
import com.java2048.model.Game;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 *
 * @author Amine-Ayoub Bigham {@literal <g54985@etu.he2b.be>}
 */
public class ArrowHandler implements EventHandler<KeyEvent> {

    private Game game;

    public ArrowHandler(Game game) {
        this.game = game;
    }

    @Override
    public void handle(KeyEvent event) {
        if (event.getCode() == KeyCode.UP) {
            game.play(Direction.UP);
        }
        if (event.getCode() == KeyCode.DOWN) {
            game.play(Direction.DOWN);
        }
        if (event.getCode() == KeyCode.RIGHT) {
            game.play(Direction.RIGHT);
        }
        if (event.getCode() == KeyCode.LEFT) {
            game.play(Direction.LEFT);
        }
        event.consume();
    }

}
