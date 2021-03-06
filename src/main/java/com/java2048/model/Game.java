package com.java2048.model;

import java.util.ArrayList;
import java.util.List;

/**
 * The Game class gathers the necessary elements for the game to present a
 * facade to the view. The view only interacts with this class to access the
 * model
 *
 * @author Amine-Ayoub Bigham {@literal <g54985@etu.he2b.be>}
 */
public class Game implements Model, Observable {

    private Board board;
    private GameStatus status;
    private int score;
    private boolean couldMove;
    private final List<Observer> observers;

    /**
     * Constructor of Game with a board (USED FOR TESTS ATM).
     *
     * @param board the board of the game
     */
    public Game(Board board) {
        observers = new ArrayList<>();
        this.board = board;
        this.status = GameStatus.IN_PROGRESS;
        this.score = 0;
    }

    /**
     * Default constructor of Game.
     */
    public Game() {
        observers = new ArrayList<>();
    }

    /**
     * Resets or intializes the game.
     */
    @Override
    public void initialize() {
        this.board = new Board();
        this.board.initialize();
        this.status = GameStatus.IN_PROGRESS;
        this.score = 0;
        notifyObservers();
    }

    /**
     * Plays the game and moves the tiles in the desired direction. Also updates
     * the status, the score and adds a random tile if the tiles were able to
     * move.
     *
     * @param direction the directions in which to move the tiles.
     * @return true if at least one tile moved, false otherwise.
     */
    @Override
    public boolean play(Direction direction) {
        boolean flagMove = board.moveTiles(direction);
        if (flagMove) {
            updateScore();
            addRandomTile();
            updateStatus();
        }
        setCouldMove(flagMove);
        notifyObservers();
        return flagMove;
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
        if (board.check2048()) {
            this.status = GameStatus.WIN;
        } else if (!board.ableToMove()) {
            this.status = GameStatus.FAIL;
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

    /**
     * Getter of couldMove.
     *
     * @return true if the tiles could move, false otherwise.
     */
    public boolean couldMove() {
        return couldMove;
    }

    /**
     * Setter of couldMove.
     *
     * @param couldMove the new boolean value.
     */
    public void setCouldMove(boolean couldMove) {
        this.couldMove = couldMove;
    }

    /**
     * Adds an observer to the set of observers for this object, provided that
     * it is not the same as some observer already in the set.
     *
     * @param obs an observer to be added.
     */
    @Override
    public void registerObserver(Observer obs) {
        if (!observers.contains(obs)) {
            observers.add(obs);
        }
    }

    /**
     * Removes an observer from the set of observers of this object.
     *
     * @param obs an observer to be deleted.
     */
    @Override
    public void removeObserver(Observer obs) {
        if (observers.contains(obs)) {
            observers.remove(obs);
        }
    }

    /**
     * If this object has changed, then notify all of its observers.
     */
    @Override
    public void notifyObservers() {
        for (Observer obs : observers) {
            obs.update();
        }
    }
}
