package java2048.model;

/**
 * The game board. It is filled with tiles.
 *
 * @author Amine-Ayoub Bigham {@literal <g54985@etu.he2b.be>}
 */
public class Board {

    private Tile[][] tiles;
    private final int SIDE = 4;

    /**
     * Constructor of the board.
     */
    public Board() {
    }

    /**
     * Initializes the board with the two first tiles.
     */
    public void initialize() {
        this.tiles = new Tile[SIDE][SIDE];
        addRandomTile();
        addRandomTile();
    }

    /**
     * This method adds a random tile on the board. Can be a 2 or a 4, 4 has one
     * out ouf ten chances to be picked.
     */
    public void addRandomTile() {
        int nbFreeTiles = getNbFreeTiles();
        if (nbFreeTiles != 0) {
            int cpt = 1;
            int random_tile = (int) (Math.random() * (nbFreeTiles - 1 + 1) + 1);
            int value = (int) (Math.random() * (10 - 0 + 1) + 0) == 0 ? 4 : 2;
            for (int i = 0; i < SIDE; i++) {
                for (int j = 0; j < SIDE; j++) {
                    if (cpt == random_tile) {
                        this.tiles[i][j] = new Tile(value);
                    }
                    cpt++;
                }
            }
        }
    }

    /**
     * Gets the number of free tiles.
     *
     * @return the number of free tiles.
     */
    public int getNbFreeTiles() {
        int cpt = 0;
        for (int i = 0; i < SIDE; i++) {
            for (int j = 0; j < SIDE; j++) {
                if (tiles[i][j] == null) {
                    cpt++;
                }
            }
        }
        return cpt;
    }

    /**
     * Gets the tile at the position in parameter.
     *
     * @param row the row of the board.
     * @param col te column of the board.
     * @return the tile in the specified position.
     */
    public Tile getTileAt(int row, int col) {
        return tiles[row][col];

    }

    /**
     * Getter of the max side value.
     *
     * @return the side value.
     */
    public int getSIDE() {
        return SIDE;
    }

}
