package com.java2048.model;

import static com.java2048.model.Direction.*;

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
     * This method moves all the tiles into the direction in parameter.
     *
     * @param direction the desired direction
     */
    public void moveTiles(Direction direction) {
        switch (direction) {
            case LEFT:
                //Read from left to right, 2 2 4 8 --> 4 4 8 0 
                for (int row = 0; row < SIDE; row++) {
                    for (int col = 0; col < SIDE; col++) {
                        move(row, col, direction);
                    }
                }
                break;
            case RIGHT:
                //Read columns from right to left, 2 2 4 8 --> 0 4 4 8 
                for (int row = 0; row < SIDE; row++) {
                    for (int col = SIDE - 1; col >= 0; col--) {
                        move(row, col, direction);
                    }
                }
                break;
            case UP:
                //Read from top to bottom, same as left but reversed delta values
                for (int row = 0; row < SIDE; row++) {
                    for (int col = 0; col < SIDE; col++) {
                        move(row, col, direction);
                    }
                }
                break;
            case DOWN:
                //Read rows from bottom to top, same as right but reversed delta values
                for (int row = SIDE - 1; row >= 0; row--) {
                    for (int col = 0; col < SIDE; col++) {
                        move(row, col, direction);
                    }
                }
                break;
            default:
                throw new IllegalArgumentException("Direction is not valid.");
        }

        //Reset the blocked status for every tile at the end of each call otherwise next time nothing will be able to move
        for (int row = 0; row < SIDE; row++) {
            for (int col = 0; col < SIDE; col++) {
                if (tiles[row][col] != null) {
                    tiles[row][col].setBlocked(false);
                }
            }
        }

    }

    /**
     * This method moves a unique tile continuously until it hits a wall or
     * merges.
     *
     * @param row the row of the tile
     * @param col the column of the tile
     * @param direction the direction in which the tile should slide to
     * @return true if the tile was able to move or merge, false otherwise.
     */
    public boolean move(int row, int col, Direction direction) {
        int horizontalDelta = direction.getDeltaCol();
        int verticalDelta = direction.getDeltaRow();
        //This will be used to know if the tile was able to move or not
        boolean couldMove = false;

        //Get the current tile, if it's null returns false
        Tile currentTile = tiles[row][col];
        if (currentTile == null) {
            return false;
        }

        int newRow = row;
        int newCol = col;

        //While the tile is able to move to an empty place or able to merge, or if it's simply not hitting a wall 
        while (true) {
            newRow += verticalDelta;
            newCol += horizontalDelta;
            //New position out of bounds ? if yes, break
            if (newRow < 0 || newRow > SIDE - 1 || newCol < 0 || newCol > SIDE - 1) {
                break;
            }

            if (tiles[newRow][newCol] == null) {
                //If there is nothing in the new position, moves the current tile to the new position
                tiles[newRow][newCol] = currentTile;
                tiles[newRow - verticalDelta][newCol - horizontalDelta] = null;
            } else if (tiles[newRow][newCol].canMergeWith(currentTile) && !tiles[newRow][newCol].isBlocked()) {
                //Checks if the tile in the new position can merge with the current one and if the new tile is blocked or not
                tiles[newRow][newCol].setBlocked(true);
                tiles[newRow][newCol].setValue(tiles[newRow][newCol].getValue() * 2);
                couldMove = true;
                tiles[newRow - verticalDelta][newCol - horizontalDelta] = null;
            } else {
                //Probably never going to get there because out of bounds statement before
                break;
            }
        }

        return couldMove;
    }

    /**
     * This method adds a random tile on the board. Can be a 2 or a 4, 4 has one
     * out of ten chances to be picked.
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