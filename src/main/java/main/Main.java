package main;

import controller.Controller;
import model.Game;
import view.ConsoleView;

/**
 * Main class of the game.
 *
 * @author Amine-Ayoub Bigham {@literal <g54985@etu.he2b.be>}
 */
public class Main {

    public static void main(String[] args) {
        Controller controller = new Controller(new Game(), new ConsoleView());
        controller.startGame();
    }

}
