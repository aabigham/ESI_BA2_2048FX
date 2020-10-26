package java2048.model;

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
     * Starts the game.
     */
    @Override
    public void initGame() {
        this.board = new Board();
        this.board.initialize();
        this.status = GameStatus.IN_PROGRESS;
    }

    /**
     * Moves the tiles in the direction entered in parameter.
     *
     * @param direction the direction.
     */
    @Override
    public void move(int direction) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Getter of board.
     *
     * @return the board of the game.
     */
    public Board getBoard() {
        return board;
    }

    /**
     * Getter of status.
     *
     * @return the status of the game.
     */
    public GameStatus getStatus() {
        return status;
    }

}
