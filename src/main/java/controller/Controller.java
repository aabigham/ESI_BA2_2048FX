/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Game;
import view.InterfaceView;

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
}
