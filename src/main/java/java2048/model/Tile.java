package java2048.model;

/**
 * A tile is represented in the game board, it has a integer value and a
 * position.
 *
 * @author Amine-Ayoub Bigham {@literal <g54985@etu.he2b.be>}
 */
public class Tile {

    private int value;
    private boolean blocked;

    /**
     * Constructor of tile.
     *
     * @param value the value of the tile.
     */
    public Tile(int value) {
        this.value = value;
        this.blocked = false;
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

    /**
     * Getter of blocked.
     *
     * @return true if the tile is blocked, false otherwise.
     */
    public boolean isBlocked() {
        return blocked;
    }

    /**
     * Setter of blocked.
     *
     * @param blocked the new status of the tile.
     */
    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

}
