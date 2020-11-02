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
     * Constructor of Board.
     *
     * @param tiles the tiles of the board
     */
    public Board(Tile[][] tiles) {
        this.tiles = tiles;
    }

    /**
     * Default constructor of board.
     */
    public Board() {
    }

    /**
     * Initializes the board with the two first random tiles.
     */
    void initialize() {
        this.tiles = new Tile[SIDE][SIDE];
        addRandomTile();
        addRandomTile();
    }

    /**
     * This method moves all the tiles into the direction in parameter.
     *
     * @param direction the desired direction
     * @return true if at least one tile moved, false otherwise.
     */
    boolean moveTiles(Direction direction) {
        /**
         * This variable be used to know if at least one tile was able to move
         * or not. Once this is set to true, it will never go back to false due
         * to the if statements inside the for loops.
         */
        boolean couldMove = false;

        //Applies the move method to each tile in the correct path, according to its direction
        switch (direction) {
            case LEFT:
                //Read from left to right (col decrement), 2 2 4 8 --> 4 4 8 0 
                for (int row = 0; row < SIDE; row++) {
                    for (int col = 0; col < SIDE; col++) {
                        if (!couldMove) {
                            couldMove = move(row, col, direction);
                        } else {
                            move(row, col, direction);
                        }
                    }
                }
                break;
            case RIGHT:
                //Read columns from right to left (col increment), 2 2 4 8 --> 0 4 4 8 
                for (int row = 0; row < SIDE; row++) {
                    for (int col = SIDE - 1; col >= 0; col--) {
                        if (!couldMove) {
                            couldMove = move(row, col, direction);
                        } else {
                            move(row, col, direction);
                        }
                    }
                }
                break;
            case UP:
                //Read from top to bottom (row decrement)
                for (int row = 0; row < SIDE; row++) {
                    for (int col = 0; col < SIDE; col++) {
                        if (!couldMove) {
                            couldMove = move(row, col, direction);
                        } else {
                            move(row, col, direction);
                        }
                    }
                }
                break;
            case DOWN:
                //Read rows from bottom to top (row increment)
                for (int row = SIDE - 1; row >= 0; row--) {
                    for (int col = 0; col < SIDE; col++) {
                        if (!couldMove) {
                            couldMove = move(row, col, direction);
                        } else {
                            move(row, col, direction);
                        }
                    }
                }
                break;
        }

        /**
         * Reset the blocked status for every tile at the end of each call
         * otherwise next time nothing will be able to move
         */
        for (int row = 0; row < SIDE; row++) {
            for (int col = 0; col < SIDE; col++) {
                if (tiles[row][col] != null) {
                    tiles[row][col].setBlocked(false);
                }
            }
        }

        return couldMove;
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
    private boolean move(int row, int col, Direction direction) {
        //Get the current tile, if it's null returns false
        Tile currentTile = tiles[row][col];
        if (currentTile == null) {
            return false;
        }
        //This will be used to know if the tile was able to move or not
        boolean couldMove = false;

        //Variables to calculate the next position
        int horizontalDelta = direction.getDeltaCol();
        int verticalDelta = direction.getDeltaRow();
        int nextRow = row;
        int nextCol = col;

        //While the tile is able to move to an empty place or able to merge, or if it's simply not hitting a wall 
        while (true) {
            nextRow += verticalDelta;
            nextCol += horizontalDelta;
            //New position out of bounds ? if yes, break
            if (nextRow < 0 || nextRow > SIDE - 1 || nextCol < 0 || nextCol > SIDE - 1) {
                break;
            }

            if (tiles[nextRow][nextCol] == null) {
                //If there is nothing in the new position, moves the current tile to the new position
                tiles[nextRow][nextCol] = currentTile;
                couldMove = true;
                tiles[nextRow - verticalDelta][nextCol - horizontalDelta] = null;
            } else if (tiles[nextRow][nextCol].canMergeWith(currentTile) && !tiles[nextRow][nextCol].isBlocked()) {
                //Checks if the tile in the new position can merge with the current one and if the new tile is blocked or not
                tiles[nextRow][nextCol].setBlocked(true);
                tiles[nextRow][nextCol].setValue(tiles[nextRow][nextCol].getValue() * 2);
                couldMove = true;
                tiles[nextRow - verticalDelta][nextCol - horizontalDelta] = null;
            } else {
                //Probably never going to get there
                break;
            }
        }

        return couldMove;
    }

    /**
     * Recursive method that adds a random tile in the board only if there is no
     * tile already there. The number can be 2 or 4 but 4 has only one chance
     * out of ten to be chosen.
     */
    void addRandomTile() {
        if (getNbFreeTiles() != 0) {
            int value = (int) (Math.random() * (10 - 0 + 1) + 0) == 0 ? 4 : 2;
            int random_row = (int) (Math.random() * ((SIDE - 1) - 0 + 1) + 0);
            int random_col = (int) (Math.random() * ((SIDE - 1) - 0 + 1) + 0);

            if (tiles[random_row][random_col] == null) {
                tiles[random_row][random_col] = new Tile(value);
            } else {
                addRandomTile();
            }
        }
    }

    /**
     * Gets the number of free tiles.
     *
     * @return the number of free tiles.
     */
    int getNbFreeTiles() {
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
     * Checks if the player has reach a 2048 tile.
     *
     * @return true if the player has reach a 2048 tile, false otherwise
     */
    boolean check2048() {
        for (int row = 0; row < SIDE; row++) {
            for (int col = 0; col < SIDE; col++) {
                if (tiles[row][col] != null && tiles[row][col].getValue() == 2048) {
                    return true;
                }
            }
        }
        return false;
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

    /**
     * This method checks if a board has the same values of another board, at
     * the same exact position for each tile.
     *
     * @param board the board we want to check
     * @return true if the board is similar, false otherwise.
     */
    boolean isSimilarTo(Board board) {
        for (int row = 0; row < SIDE; row++) {
            for (int col = 0; col < SIDE; col++) {
                Tile thisTile = this.getTileAt(row, col);
                Tile boardTile = board.getTileAt(row, col);
                //One tile is null but the other is not
                if (thisTile == null && boardTile != null
                        || thisTile != null && boardTile == null) {
                    return false;
                }
                //Both tiles are not null and have values
                if (thisTile != null && boardTile != null
                        && thisTile.getValue() != boardTile.getValue()) {
                    return false;
                }
            }
        }
        return true;
    }

}
