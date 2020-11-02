package com.java2048.controller;

import java.util.Scanner;
import com.java2048.model.Direction;
import com.java2048.model.Game;
import static com.java2048.model.GameStatus.*;
import com.java2048.view.InterfaceView;

/**
 * The controller responds to the user input and performs interactions on the
 * data model objects.
 *
 * @author Amine-Ayoub Bigham {@literal <g54985@etu.he2b.be>}
 */
public class Controller {

    Game game;
    InterfaceView consoleView;

    /**
     * Constructor of controller.
     *
     * @param game the game
     * @param consoleView the console view
     */
    public Controller(Game game, InterfaceView consoleView) {
        this.game = game;
        this.consoleView = consoleView;
    }

    /**
     * Starts the game.
     */
    public void startGame() {
        game.initGame();

        while (game.isInProgress()) {
            consoleView.displayBoard(game.getBoard());
            if (game.move(askDirection())) {
                game.addRandomTile();
            }
            game.updateStatus();
        }

        //After the loop breaks, shows the board and the end message.
        consoleView.displayBoard(game.getBoard());
        if (game.getStatus().equals(WIN)) {
            consoleView.displayMessage("You won !");
        } else if (game.getStatus().equals(FAIL)) {
            consoleView.displayMessage("You lose !");
        }
    }

    /**
     * Asks a direction to the player.
     *
     * @return the direction.
     */
    private Direction askDirection() {
        Scanner scanner = new Scanner(System.in);
        consoleView.displayMessage("Enter your direction : Z (UP) | Q (LEFT) | S (DOWN) | D (RIGHT)");
        char c = Character.toLowerCase(scanner.nextLine().charAt(0));

        //Safe console input
        while (c != 'z' && c != 'q' && c != 's' && c != 'd') {
            consoleView.displayMessage("Enter your direction : Z (UP) | Q (LEFT) | S (DOWN) | D (RIGHT)");
            c = Character.toLowerCase(scanner.nextLine().charAt(0));
        }

        switch (c) {
            case 'z':
                return Direction.UP;
            case 'q':
                return Direction.LEFT;
            case 's':
                return Direction.DOWN;
            case 'd':
                return Direction.RIGHT;
            default:
                throw new IllegalArgumentException();
        }
    }
}
