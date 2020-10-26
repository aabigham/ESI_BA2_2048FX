package model;

/**
 * A tile is represented in the game board, it has a integer value and a
 * position.
 *
 * @author Amine-Ayoub Bigham {@literal <g54985@etu.he2b.be>}
 */
public class Tile {

    private Position position;
    private int value;

    /**
     * Constructor of tile.
     *
     * @param position the position of the tile.
     * @param value the value of the tile.
     */
    public Tile(Position position, int value) {
        this.position = position;
        this.value = value;
    }

    /**
     * Getter of position
     *
     * @return the position of the tile on the board;
     */
    public Position getPosition() {
        return position;
    }

    /**
     * Setter of position.
     *
     * @param position the new position of the tile.
     */
    public void setPosition(Position position) {
        this.position = position;
    }

    /**
     * Getter of value.
     *
     * @return the value of the tile.
     */
    public int getValue() {
        return value;
    }

    /**
     * Setter of value.
     *
     * @param value the new value of the tile.
     */
    public void setValue(int value) {
        this.value = value;
    }

}
