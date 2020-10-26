package model;

/**
 * Model interface.
 *
 * @author Amine-Ayoub Bigham {@literal <g54985@etu.he2b.be>}
 */
public interface Model {

    /**
     * Starts the game.
     */
    void initGame();

    /**
     * Moves the tiles in the direction entered in parameter.
     *
     * @param direction the direction.
     */
    void move(int direction);
}
