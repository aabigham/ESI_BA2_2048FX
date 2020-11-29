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
    private int scoreAdditioner;

    /**
     * Constructor of Board with tiles (USED FOR TESTS).
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
        this.scoreAdditioner = 0;
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

        //Applies the moveTile method to each tile in the correct path, according to its direction
        switch (direction) {
            case LEFT:
                //Read from left to right (col decrement), 2 2 4 8 --> 4 4 8 0 
                for (int row = 0; row < SIDE; row++) {
                    for (int col = 0; col < SIDE; col++) {
                        if (!couldMove) {
                            couldMove = moveTile(row, col, direction);
                        } else {
                            moveTile(row, col, direction);
                        }
                    }
                }
                break;
            case RIGHT:
                //Read columns from right to left (col increment), 2 2 4 8 --> 0 4 4 8 
                for (int row = 0; row < SIDE; row++) {
                    for (int col = SIDE - 1; col >= 0; col--) {
                        if (!couldMove) {
                            couldMove = moveTile(row, col, direction);
                        } else {
                            moveTile(row, col, direction);
                        }
                    }
                }
                break;
            case UP:
                //Read from top to bottom (row decrement)
                for (int row = 0; row < SIDE; row++) {
                    for (int col = 0; col < SIDE; col++) {
                        if (!couldMove) {
                            couldMove = moveTile(row, col, direction);
                        } else {
                            moveTile(row, col, direction);
                        }
                    }
                }
                break;
            case DOWN:
                //Read rows from bottom to top (row increment)
                for (int row = SIDE - 1; row >= 0; row--) {
                    for (int col = 0; col < SIDE; col++) {
                        if (!couldMove) {
                            couldMove = moveTile(row, col, direction);
                        } else {
                            moveTile(row, col, direction);
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
     * @return true if the tile was able to moveTile or merge, false otherwise.
     */
    private boolean moveTile(int row, int col, Direction direction) {
        //Get the current tile, if it's null returns false
        Tile currentTile = tiles[row][col];
        if (currentTile == null) {
            return false;
        }
        //This will be used to know if the tile was able to moveTile or not
        boolean couldMove = false;

        //Variables to calculate the next position
        int horizontalDelta = direction.getDeltaCol();
        int verticalDelta = direction.getDeltaRow();
        int nextRow = row;
        int nextCol = col;

        //While the tile is able to moveTile to an empty place or able to merge, or if it's simply not hitting a wall 
        while (true) {
            nextRow += verticalDelta;
            nextCol += horizontalDelta;
            //New position out of bounds ? if yes, break
            if (nextRow < 0 || nextRow > SIDE - 1 || nextCol < 0 || nextCol > SIDE - 1) {
                break;
            }

            if (tiles[nextRow][nextCol] == null) {
                //If there is nothing in the new position, moves the current tile there
                tiles[nextRow][nextCol] = currentTile;
                couldMove = true;
                tiles[nextRow - verticalDelta][nextCol - horizontalDelta] = null;//old pos = null
            } else if (tiles[nextRow][nextCol].getValue() == currentTile.getValue()
                    && !tiles[nextRow][nextCol].isBlocked()) {
                /**
                 * There is a tile in the future position and the if statement
                 * checks if this tile can merge with the current one, and also
                 * if it is blocked or not
                 */
                tiles[nextRow][nextCol].setBlocked(true);
                tiles[nextRow][nextCol].setValue(tiles[nextRow][nextCol].getValue() * 2);
                this.scoreAdditioner += tiles[nextRow][nextCol].getValue();
                couldMove = true;
                tiles[nextRow - verticalDelta][nextCol - horizontalDelta] = null;//old pos = null
            } else {
                //Probably never going to get there
                break;
            }
        }

        return couldMove;
    }

    /**
     * Checks if the board is able to moveTile or not.
     *
     * @return true if the board is able to moveTile, false otherwise.
     */
    boolean ableToMove() {
        //If there is at least one empty tile, return true
        if (oneTileFree()) {
            return true;
        }

        //Checks every neighbour of each tile and if the merge is available or not.
        for (int row = 0; row < SIDE; row++) {
            for (int col = 0; col < SIDE; col++) {
                if (tiles[row][col] != null) {
                    if (testMerge(row + 1, col, tiles[row][col].getValue())) {
                        return true;
                    }
                    if (testMerge(row - 1, col, tiles[row][col].getValue())) {
                        return true;
                    }
                    if (testMerge(row, col + 1, tiles[row][col].getValue())) {
                        return true;
                    }
                    if (testMerge(row, col - 1, tiles[row][col].getValue())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * This method tests if a tile will be able to merge with the tiles in the
     * position in parameter.
     *
     * @param row the row of the tile to test
     * @param col the column of the tile to test
     * @param value the value to test
     * @return true if the merge is possible, false otherwise.
     */
    private boolean testMerge(int row, int col, int value) {
        if (row < 0 || row > 3 || col < 0 || col > 3) {
            return false;
        }
        return tiles[row][col].getValue() == value;
    }

    /**
     * Recursive method that adds a random tile in the board only if there is no
     * tile already there. The number can be 2 or 4 but 4 has only one chance
     * out of ten to be chosen.
     */
    void addRandomTile() {
        if (!oneTileFree()) {
            throw new RuntimeException("The board is already full of tiles !");
        }
        int value = (int) (Math.random() * (10 - 0 + 1) + 0) == 0 ? 4 : 2;
        int random_row = (int) (Math.random() * ((SIDE - 1) - 0 + 1) + 0);
        int random_col = (int) (Math.random() * ((SIDE - 1) - 0 + 1) + 0);

        if (tiles[random_row][random_col] == null) {
            tiles[random_row][random_col] = new Tile(value);
        } else {
            addRandomTile();
        }
    }

    /**
     * This methods checks if there is at least one free tile on the board.
     *
     * @return true if there is one free tile, false otherwise.
     */
    private boolean oneTileFree() {
        for (int i = 0; i < SIDE; i++) {
            for (int j = 0; j < SIDE; j++) {
                if (tiles[i][j] == null) {
                    return true;
                }
            }
        }
        return false;
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
     * @param row the row of the board
     * @param col the column of the board
     * @return the tile in the specified position.
     */
    public Tile getTileAt(int row, int col) {
        return tiles[row][col];
    }

    /**
     * This method checks if a board has the same values of another board, at
     * the same exact position for each tile (used in tests).
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

    /**
     * Gets the score additioner.
     *
     * @return the score additioner;
     */
    int getScoreAdditioner() {
        return scoreAdditioner;
    }

}
