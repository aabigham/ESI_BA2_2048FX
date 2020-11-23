package com.java2048.controller;

import java.util.Scanner;
import com.java2048.model.Direction;
import com.java2048.model.Game;
import static com.java2048.model.GameStatus.*;
import com.java2048.view.console.ConsoleView;

/**
 * The controller responds to the user input and performs interactions on the
 * data model objects.
 *
 * @author Amine-Ayoub Bigham {@literal <g54985@etu.he2b.be>}
 */
public class Controller {

    Game game;
    ConsoleView view;

    /**
     * Constructor of controller.
     *
     * @param game the game
     * @param view the view
     */
    public Controller(Game game, ConsoleView view) {
        this.game = game;
        this.view = view;
    }

    /**
     * Starts the game.
     */
    public void startGame() {
        //While in progress
        while (game.getStatus().equals(IN_PROGRESS)) {
            view.displayScore(game.getScore()); //Display score
            view.displayBoard(game.getBoard()); //Display board

            //If a tile moved, updates score, adds a new tile & updates the status
            if (game.move(askDirection())) {
                game.updateScore();
                game.addRandomTile();
                game.updateStatus();
            }
        }

        //After the loop breaks, shows score, board and the end message.
        view.displayScore(game.getScore());
        view.displayBoard(game.getBoard());
        if (game.getStatus().equals(WIN)) {
            view.displayMessage("You won !");
        } else if (game.getStatus().equals(FAIL)) {
            view.displayMessage("You lose !");
        }
    }

    /**
     * Asks a direction to the player.
     *
     * @return the direction.
     */
    private Direction askDirection() {
        Scanner scanner = new Scanner(System.in);
        char dir;
        do {
            view.displayMessage("Enter your direction : Z (UP) | Q (LEFT) | S (DOWN) | D (RIGHT)");
            dir = Character.toLowerCase(scanner.next().charAt(0));
        } while (dir != 'z' && dir != 'q' && dir != 's' && dir != 'd');

        switch (dir) {
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
