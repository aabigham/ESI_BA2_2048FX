package com.java2048.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Amine-Ayoub Bigham {@literal <g54985@etu.he2b.be>}
 */
public class BoardTest {

    private Board board;

    public BoardTest() {
    }

    @BeforeEach
    public void setUp() {
        board = new Board(new Tile[][]{
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null}
        });
    }

    /**
     * Test of moveTiles method, of class Board.
     */
    @Test
    public void testMoveTiles() {
    }

    /**
     * Test of move method, of class Board.
     */
    @Test
    public void testMove() {
    }

    /**
     * Test of addRandomTile method, of class Board.
     */
    @Test
    public void testAddRandomTile() {
    }

    /**
     * Test of getNbFreeTiles method, of class Board.
     */
    @Test
    public void testGetNbFreeTiles() {
    }

    /**
     * Test of getTileAt method, of class Board.
     */
    @Test
    public void testGetTileAt() {
    }

    /**
     * Test of getSIDE method, of class Board.
     */
    @Test
    public void testGetSIDE() {
    }

}
