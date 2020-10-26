package view;

import model.Board;

/**
 * Interface of view.
 *
 * @author Amine-Ayoub Bigham {@literal <g54985@etu.he2b.be>}
 */
public interface InterfaceView {

    /**
     * Displays the game board.
     *
     * @param board the board to display.
     */
    void displayBoard(Board board);

    /**
     * Display a message to the player's attention.
     *
     * @param message a message for the player.
     */
    void displayMessage(String message);
}
