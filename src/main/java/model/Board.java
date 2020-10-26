package model;

/**
 * The game board. It is filled with tiles.
 *
 * @author Amine-Ayoub Bigham {@literal <g54985@etu.he2b.be>}
 */
public class Board {

    private Tile[][] tiles;
    private final int SIDE = 4;

    /**
     * Contructor of the board.
     *
     */
    public Board() {
        this.tiles = new Tile[SIDE][SIDE];
    }

    /**
     * Gets the tile at the position in parameter.
     *
     * @param position the position in which the tile is placed.
     * @return the tile in the position in parameter.
     */
    public Tile getTileAt(Position position) {
        return tiles[position.getRow()][position.getCol()];
    }

    /**
     * Getter of the max sie value.
     *
     * @return the side value.
     */
    public int getSIDE() {
        return SIDE;
    }

}
