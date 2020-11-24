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
                    button.setText("     ");
                    button.setStyle("-fx-background-color: #CDC1B4");
                } else {
                    switch (tile.getValue()) {
                        case 2:
                            button.setText("   " + String.valueOf(observable.getBoard().getTileAt(i, j).getValue()));
                            button.setStyle("-fx-background-color: #EEE4DA");
                            break;
                        case 4:
                            button.setText("   " + String.valueOf(observable.getBoard().getTileAt(i, j).getValue()));
                            button.setStyle("-fx-background-color: #EEE1C9");
                            break;
                        case 8:
                            button.setText("   " + String.valueOf(observable.getBoard().getTileAt(i, j).getValue()));
                            button.setStyle("-fx-background-color: #F3B27A");
                            break;
                        case 16:
                            button.setText(" " + String.valueOf(observable.getBoard().getTileAt(i, j).getValue()));
                            button.setStyle("-fx-background-color: #F69664");
                            break;
                        case 32:
                            button.setText(" " + String.valueOf(observable.getBoard().getTileAt(i, j).getValue()));
                            button.setStyle("-fx-background-color: #F77C5F");
                            break;
                        case 64:
                            button.setText(" " + String.valueOf(observable.getBoard().getTileAt(i, j).getValue()));
                            button.setStyle("-fx-background-color: #F75F3B");
                            break;
                        case 128:
                            button.setText(String.valueOf(observable.getBoard().getTileAt(i, j).getValue()));
                            button.setStyle("-fx-background-color: #EDD073");
                            break;
                        case 256:
                            button.setText(String.valueOf(observable.getBoard().getTileAt(i, j).getValue()));
                            button.setStyle("-fx-background-color: #EDCC61");
                            break;
                        case 512:
                            button.setText(String.valueOf(observable.getBoard().getTileAt(i, j).getValue()));
                            button.setStyle("-fx-background-color: #EDC850");
                            break;
                        case 1024:
                            button.setText(String.valueOf(observable.getBoard().getTileAt(i, j).getValue()));
                            button.setStyle("-fx-background-color: #EDC53F");
                            break;
                        case 2048:
                            button.setText(String.valueOf(observable.getBoard().getTileAt(i, j).getValue()));
                            button.setStyle("-fx-background-color: #EDC22E");
                            break;
                        default:
                            throw new AssertionError();
                    }
                }
                this.add(button, j, i);
            }
        }
    }
}
