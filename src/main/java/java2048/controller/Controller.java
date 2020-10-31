/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java2048.controller;

import java.util.Scanner;
import java2048.model.Direction;
import java2048.model.Game;
import java2048.view.InterfaceView;

/**
 *
 * @author Amine-Ayoub Bigham {@literal <g54985@etu.he2b.be>}
 */
public class Controller {

    Game game;
    InterfaceView consoleView;

    /**
     * Constructor of controller.
     *
     * @param game the game.
     * @param consoleView the console view.
     */
    public Controller(Game game, InterfaceView consoleView) {
        this.game = game;
        this.consoleView = consoleView;
    }

    public void startGame() {
        game.initGame();
        consoleView.displayBoard(game.getBoard());
    }

    /**
     * Asks a direction.
     *
     * @return the direction.
     */
    Direction askDirection() {
        Scanner scanner = new Scanner(System.in);
        consoleView.displayMessage("Enter your direction : Z (UP) | Q (LEFT) | S (DOWN) | D (RIGHT)");
        char c = scanner.nextLine().charAt(0);
        Character.toLowerCase(c);

        while (c != 'z' && c != 'q' && c != 's' && c != 'd') {
            consoleView.displayMessage("Enter your direction : Z (UP) | Q (LEFT) | S (DOWN) | D (RIGHT)");
            c = scanner.nextLine().charAt(0);
        }

        switch (c) {
            case 'z':
                return Direction.NORTH;
            case 'q':
                return Direction.WEST;
            case 's':
                return Direction.EAST;
            case 'd':
                return Direction.EAST;
            default:
                throw new AssertionError();
        }
    }
}
