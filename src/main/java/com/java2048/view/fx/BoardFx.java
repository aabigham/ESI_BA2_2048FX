/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java2048.view.fx;

import com.java2048.model.Game;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Amine-Ayoub Bigham {@literal <g54985@etu.he2b.be>}
 */
public class BoardFx extends GridPane implements Observer {

    private final int SIDE = 4;
    private final Game observable;

    /**
     * Constructor the the game board using buttons.
     *
     * @param observable the observable game.
     */
    public BoardFx(Game observable) {
        if (observable == null) {
            throw new IllegalArgumentException("Nothing to observe");
        }
        this.observable = (Game) observable;

        this.setVgap(10);
        this.setHgap(10);
        this.setPadding(new Insets(10, 10, 10, 0));

        //Initializes empty tiles
        for (int i = 0; i < SIDE; i++) {
            for (int j = 0; j < SIDE; j++) {
                TileFx tileFx = new TileFx(null);
                this.add(tileFx, j, i);
            }
        }
        observable.registerObserver(this);
    }

    /**
     * Updates the board and displays all the tiles with all of the according
     * colors for each number.
     */
    @Override
    public void update() {
        this.getChildren().clear();
        for (int i = 0; i < SIDE; i++) {
            for (int j = 0; j < SIDE; j++) {
                TileFx tileFx = new TileFx(observable.getBoard().getTileAt(i, j));
                this.add(tileFx, j, i);
            }
        }

    }
}
