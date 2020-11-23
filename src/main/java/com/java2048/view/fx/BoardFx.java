/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java2048.view.fx;

import com.java2048.model.Game;
import com.java2048.model.Tile;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Amine-Ayoub Bigham {@literal <g54985@etu.he2b.be>}
 */
public class BoardFx extends GridPane implements Observer {

    private final int SIDE = 4;
    private final Game observable;

    public BoardFx(Game observable) {
        if (observable == null) {
            throw new IllegalArgumentException("Nothing to observe");
        }
        this.observable = (Game) observable;

        this.setVgap(10);
        this.setHgap(10);
        this.setPadding(new Insets(10, 10, 10, 0));

        /*for (int i = 0; i < SIDE; i++) {
            for (int j = 0; j < SIDE; j++) {
                Button button = new Button("    ");
                this.add(button, j, i);
            }
        }*/
        observable.registerObserver(this);
    }

    /**
     * Updates the board.
     */
    @Override
    public void update() {
        this.getChildren().clear();
        for (int i = 0; i < SIDE; i++) {
            for (int j = 0; j < SIDE; j++) {
                Button button = new Button();
                Tile tile = observable.getBoard().getTileAt(i, j);
                if (tile == null) {
                    button.setText("    ");
                } else if (tile.getValue() < 10) {
                    button.setText("   " + String.valueOf(observable.getBoard().getTileAt(i, j).getValue()));
                } else if (tile.getValue() >= 10 && tile.getValue() <= 99) {
                    button.setText("  " + String.valueOf(observable.getBoard().getTileAt(i, j).getValue()));
                } else if (tile.getValue() >= 99 && tile.getValue() <= 999) {
                    button.setText(" " + String.valueOf(observable.getBoard().getTileAt(i, j).getValue()));
                } else {
                    button.setText(String.valueOf(observable.getBoard().getTileAt(i, j).getValue()));
                }
                this.add(button, j, i);
            }
        }
    }
}
