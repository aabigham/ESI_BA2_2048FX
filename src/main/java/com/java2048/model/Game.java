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
    int score;

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
     * Adds a random tile on the board, can be a 2 or a 4. The 4 has one chance
     * out of ten to be chosen.
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
     * Updates the score of the game.
     */
    @Override
    public void updateScore() {
        this.score += board.getScoreAdditioner() - this.score;
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

    /**
     * Getter of the score.
     *
     * @return the score of the current game.
     */
    public int getScore() {
        return score;
    }

}
