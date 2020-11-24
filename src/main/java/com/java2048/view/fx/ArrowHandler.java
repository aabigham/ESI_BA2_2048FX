package com.java2048.view.fx;

import com.java2048.model.Direction;
import com.java2048.model.Game;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 * This hanlder handles the arrow keys pressed by the player.
 *
 * @author Amine-Ayoub Bigham {@literal <g54985@etu.he2b.be>}
 */
public class ArrowHandler implements EventHandler<KeyEvent> {

    private Game game;

    /**
     * Constructor of the handler.
     *
     * @param game the game in which the handler moves the tiles.
     */
    public ArrowHandler(Game game) {
        this.game = game;
    }

    /**
     * Handles the arrow keys pressed by the player and moves the tiles in the
     * wanted direction. Consumes it if it's not an arrow key.
     *
     * @param event the keyboard key event.
     */
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
