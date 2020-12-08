package com.java2048.model;

/**
 * Interface of model.
 *
 * @author Amine-Ayoub Bigham {@literal <g54985@etu.he2b.be>}
 */
public interface Model {

    /**
     * Resets or intializes the game.
     */
    public void initialize();

    /**
     * Plays the game and moves the tiles in the desired direction. Also updates
     * the status, the score and adds a random tile if the tiles were able to
     * move.
     *
     * @param direction the directions in which to move the tiles.
     * @return true if at least one tile moved, false otherwise.
     */
    public boolean play(Direction direction);

    /**
     * This method adds a random tile on the board, can be a 2 or a 4. The 4 has
     * one chance out of ten to be chosen.
     */
    void addRandomTile();

    /**
     * Updates the status of the game, WIN or FAIL.
     */
    public void updateStatus();

    /**
     * Updates the score of the game.
     */
    public void updateScore();
}
