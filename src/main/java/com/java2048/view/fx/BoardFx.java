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
        this.setPadding(new Insets(10, 10, 10, 10));

        /*Button button1 = new Button("    ");
        Button button2 = new Button("    ");
        Button button3 = new Button("    ");
        Button button4 = new Button("    ");
        Button button5 = new Button("    ");
        Button button6 = new Button("    ");
        Button button7 = new Button("    ");
        Button button8 = new Button("    ");
        Button button9 = new Button("    ");
        Button button10 = new Button("    ");
        Button button11 = new Button("    ");
        Button button12 = new Button("    ");
        Button button13 = new Button("    ");
        Button button14 = new Button("    ");
        Button button15 = new Button("    ");
        Button button16 = new Button("    ");

        this.add(button1, 0, 0);
        this.add(button2, 1, 0);
        this.add(button3, 2, 0);
        this.add(button4, 3, 0);

        this.add(button5, 0, 1);
        this.add(button6, 1, 1);
        this.add(button7, 2, 1);
        this.add(button8, 3, 1);

        this.add(button9, 0, 2);
        this.add(button10, 1, 2);
        this.add(button11, 2, 2);
        this.add(button12, 3, 2);

        this.add(button13, 0, 3);
        this.add(button14, 1, 3);
        this.add(button15, 2, 3);
        this.add(button16, 3, 3);*/
        for (int i = 0; i < SIDE; i++) {
            for (int j = 0; j < SIDE; j++) {
                Button button = new Button("  24");
                this.add(button, j, i);
            }
        }

        observable.registerObserver(this);
    }

    /**
     * Updates the board.
     */
    @Override
    public void update() {
        for (int i = 0; i < SIDE; i++) {
            for (int j = 0; j < SIDE; j++) {
                Button button = new Button("   ");
                Tile tile = observable.getBoard().getTileAt(j, j);
                if (tile == null) {
                    button.setText("    ");
                } else if (tile.getValue() < 10) {
                    button.setText("   " + String.valueOf(observable.getBoard().getTileAt(j, j).getValue()));
                } else if (tile.getValue() >= 10 && tile.getValue() <= 99) {
                    button.setText("  " + String.valueOf(observable.getBoard().getTileAt(j, j).getValue()));
                } else if (tile.getValue() >= 99 && tile.getValue() <= 999) {
                    button.setText(" " + String.valueOf(observable.getBoard().getTileAt(j, j).getValue()));
                } else {
                    button.setText(String.valueOf(observable.getBoard().getTileAt(j, j).getValue()));
                }
                this.add(button, j, i);
            }
        }
    }

}
