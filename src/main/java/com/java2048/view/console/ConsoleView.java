package com.java2048.view.console;

import com.java2048.model.Board;
import com.java2048.model.Tile;

/**
 * The view of the game via the console window.
 *
 * @author Amine-Ayoub Bigham {@literal <g54985@etu.he2b.be>}
 */
public class ConsoleView {

    /**
     * Displays the game board via console.
     *
     * @param board the board to display to the player
     */
    public void displayBoard(Board board) {
        for (int i = 0; i < 4; i++) {
            System.out.println("+------+------+------+------+");
            System.out.print("| ");
            for (int j = 0; j < 4; j++) {
                Tile tile = board.getTileAt(i, j);
                if (tile == null) {
                    System.out.print("    ");
                } else if (tile.getValue() < 10) {
                    System.out.print(tile.getValue() + "   ");
                } else if (tile.getValue() >= 10 && tile.getValue() <= 99) {
                    System.out.print(tile.getValue() + "  ");
                } else if (tile.getValue() >= 99 && tile.getValue() <= 999) {
                    System.out.print(tile.getValue() + " ");
                } else {
                    System.out.print(tile.getValue());
                }
                System.out.print(" | ");
            }
            System.out.println(" ");
        }
        System.out.println("+------+------+------+------+");
    }

    /**
     * Displays a message to the player.
     *
     * @param message the message to display to the player
     */
    public void displayMessage(String message) {
        System.out.println(message);
    }

    /**
     * Displays the score of the player.
     *
     * @param score the score of the player.
     */
    public void displayScore(int score) {
        System.out.println("Your score is : " + score);
    }
}
