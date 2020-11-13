package com.java2048.view;

import com.java2048.model.Board;

/**
 * Interface of view.
 *
 * @author Amine-Ayoub Bigham {@literal <g54985@etu.he2b.be>}
 */
public interface InterfaceView {

    /**
     * Displays the game board via console.
     *
     * @param board the board to display to the player
     */
    void displayBoard(Board board);

    /**
     * Display a message to the player's attention.
     *
     * @param message the message to display to the player
     */
    void displayMessage(String message);

    /**
     * Displays the score of the player.
     *
     * @param score the score of the player.
     */
    public void displayScore(int score);
}
