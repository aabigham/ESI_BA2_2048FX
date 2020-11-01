package com.java2048.view;

import com.java2048.model.Board;
import com.java2048.model.Tile;

/**
 * The view of the game via the console window.
 *
 * @author Amine-Ayoub Bigham {@literal <g54985@etu.he2b.be>}
 */
public class ConsoleView implements InterfaceView {

    /**
     * Displays the game board via console.
     *
     * @param board the board to display to the player
     */
    @Override
    public void displayBoard(Board board) {
        for (int i = 0; i < board.getSIDE(); i++) {
            System.out.println("+------+------+------+------+");
            System.out.print("| ");
            for (int j = 0; j < board.getSIDE(); j++) {
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
    @Override
    public void displayMessage(String message) {
        System.out.println(message);
    }
}
