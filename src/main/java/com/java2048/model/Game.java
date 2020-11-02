package com.java2048.model;

/**
 * The Game class gathers the necessary elements for the game to present a
 * facade to the view. The view only interacts with this class to access the
 * model
 *
 * @author Amine-Ayoub Bigham {@literal <g54985@etu.he2b.be>}
 */
public class Game implements Model {

    Board board;
    GameStatus status;

    /**
     * Constructor of Game.
     *
     * @param board the board of the game
     */
    public Game(Board board) {
        this.board = board;
        this.status = GameStatus.IN_PROGRESS;
    }

    /**
     * Default constructor of Game.
     */
    public Game() {
    }

    /**
     * Initializes the game.
     */
    @Override
    public void initGame() {
        this.board = new Board();
        this.board.initialize();
        this.status = GameStatus.IN_PROGRESS;
    }

    /**
     * Moves all the tiles in the desired direction.
     *
     * @param direction the direction in which to move the tiles
     * @return true if at least one tile moved, false otherwise.
     */
    @Override
    public boolean move(Direction direction) {
        return board.moveTiles(direction);
    }

    /**
     * This method adds a random tile on the board, can be a 2 or a 4. The 4 has
     * one chance out of ten to be chosen.
     */
    @Override
    public void addRandomTile() {
        board.addRandomTile();
    }

    /**
     * Updates the status of the game, WIN or FAIL.
     */
    @Override
    public void updateStatus() {
        if (board.getNbFreeTiles() == 0) {
            this.status = GameStatus.FAIL;
        } else if (board.check2048()) {
            this.status = GameStatus.WIN;
        }
    }

    /**
     * Checks if the game is still in progress.
     *
     * @return true is if the game is still in progress, false otherwise.
     */
    public boolean isInProgress() {
        return status.equals(GameStatus.IN_PROGRESS);
    }

    /**
     * Getter of the game board.
     *
     * @return the game board.
     */
    public Board getBoard() {
        return board;
    }

    /**
     * Getter of the game status.
     *
     * @return the game status.
     */
    public GameStatus getStatus() {
        return status;
    }

}
