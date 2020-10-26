package model;

/**
 * The position on the board which has x and y axis.
 *
 * @author Amine-Ayoub Bigham {@literal <g54985@etu.he2b.be>}
 */
public class Position {

    private int x, y;

    /**
     * Constructor of Position.
     *
     * @param x the x axis.
     * @param y the y axis.
     */
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Getter of the x axis.
     *
     * @return the x axis.
     */
    public int getX() {
        return x;
    }

    /**
     * Setrer of the x axis.
     *
     * @param x the new x axis.
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Getter of the y axis.
     *
     * @return the y axis.
     */
    public int getY() {
        return y;
    }

    /**
     * Setrer of the y axis.
     *
     * @param y the new y axis.
     */
    public void setY(int y) {
        this.y = y;
    }

}
