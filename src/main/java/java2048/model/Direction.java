package java2048.model;

/**
 * Directions in which the board is going to slide the tiles to.
 *
 * @author Amine-Ayoub Bigham {@literal <g54985@etu.he2b.be>}
 */
public enum Direction {
    NORTH(-1, 0),
    SOUTH(1, 0),
    EAST(0, 1),
    WEST(0, -1);

    private final int deltaRow;
    private final int deltaCol;

    /**
     * Constructor of Direction.
     *
     * @param deltaRow the delta row.
     * @param deltaCol the delta column.
     */
    private Direction(int deltaRow, int deltaCol) {
        this.deltaRow = deltaRow;
        this.deltaCol = deltaCol;
    }

    /**
     * Get the value of deltaRow
     *
     * @return the value of deltaRow
     */
    public int getDeltaRow() {
        return deltaRow;
    }

    /**
     * Get the value of deltaCol
     *
     * @return the value of deltaCol
     */
    public int getDeltaCol() {
        return deltaCol;
    }

}
