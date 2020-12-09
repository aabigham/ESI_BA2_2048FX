package com.java2048.main;

import com.java2048.controller.Controller;
import com.java2048.model.Game;
import com.java2048.view.console.ConsoleView;

/**
 * Main class of the game.
 *
 * @author Amine-Ayoub Bigham {@literal <g54985@etu.he2b.be>}
 */
public class Main {

    /**
     * The application's entry point.
     *
     * @param args an array of command-line arguments for the application
     */
    public static void main(String[] args) {
        Game game = new Game();
        game.initialize();

        Controller controller = new Controller(game, new ConsoleView());
        controller.startGame();
    }

}
