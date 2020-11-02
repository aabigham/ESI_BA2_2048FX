package com.java2048.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

/**
 * Test class of the class game.
 *
 * @author Amine-Ayoub Bigham {@literal <g54985@etu.he2b.be>}
 */
public class GameTest {

    private Game game;

    public GameTest() {
    }

    /**
     * Test of updateStatus method, of class Game.
     */
    @Test
    public void testUpdateStatus_Win() {
        game = new Game(new Board(new Tile[][]{
            {new Tile(2048), null, null, null},
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null}
        }));
        game.updateStatus();
        assertTrue(game.getStatus().equals(GameStatus.WIN));
    }

    /**
     * Test of updateStatus method, of class Game.
     */
    @Test
    public void testUpdateStatus_Fail() {
        game = new Game(new Board(new Tile[][]{
            {new Tile(2), new Tile(2), new Tile(2), new Tile(2)},
            {new Tile(2), new Tile(2), new Tile(2), new Tile(2)},
            {new Tile(2), new Tile(2), new Tile(2), new Tile(2)},
            {new Tile(2), new Tile(2), new Tile(2), new Tile(2)}
        }));
        game.updateStatus();
        assertTrue(game.getStatus().equals(GameStatus.FAIL));
    }
}
