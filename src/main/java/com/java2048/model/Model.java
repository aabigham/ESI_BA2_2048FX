package com.java2048.model;

/**
 * Interface of model.
 *
 * @author Amine-Ayoub Bigham {@literal <g54985@etu.he2b.be>}
 */
public interface Model {

    /**
     * This method starts the game.
     */
    void initGame();

    /**
     * Moves the all the tiles in the desired direction.
     *
     * @param direction the direction in which to move the tiles
     * @return true if at least one tile moved, false otherwise.
     */
    boolean move(Direction direction);

    /**
     * This method adds a random tile on the board. Can be a 2 or a 4, 4 has one
     * out of ten chances to be picked.
     */
    void addRandomTile();

    /**
     * Updates the status of the game.
     */
    public void updateStatus();
}
