package model;

/**
 * The position on the board which has row and col axis.
 *
 * @author Amine-Ayoub Bigham {@literal <g54985@etu.he2b.be>}
 */
public class Position {

    private int row, col;

    /**
     * Constructor of Position.
     *
     * @param x the row axis.
     * @param y the col axis.
     */
    public Position(int x, int y) {
        this.row = x;
        this.col = y;
    }

    /**
     * Getter of the row axis.
     *
     * @return the row axis.
     */
    public int getRow() {
        return row;
    }

    /**
     * Setrer of the row axis.
     *
     * @param row the new row axis.
     */
    public void setRow(int row) {
        this.row = row;
    }

    /**
     * Getter of the col axis.
     *
     * @return the col axis.
     */
    public int getCol() {
        return col;
    }

    /**
     * Setrer of the col axis.
     *
     * @param col the new col axis.
     */
    public void setCol(int col) {
        this.col = col;
    }

}
