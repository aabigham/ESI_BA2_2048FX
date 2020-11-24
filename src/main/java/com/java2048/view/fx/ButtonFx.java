package com.java2048.view.fx;

import com.java2048.model.Tile;
import javafx.scene.control.Button;

/**
 * This class represents a button (tile) on the fx board.
 *
 * @author Amine-Ayoub Bigham {@literal <g54985@etu.he2b.be>}
 */
public class ButtonFx extends Button {

    Tile tile;

    /**
     * Constuctor of the button (tile). Changes the color according to the value
     * of the tile in parameter.
     *
     * @param tile the tile we want to make a button out of
     */
    public ButtonFx(Tile tile) {
        if (tile == null) {
            this.setText("     ");
            this.setStyle("-fx-background-color: #CDC1B4");
        } else {
            int value = tile.getValue();
            switch (tile.getValue()) {
                case 2:
                    this.setText("   " + String.valueOf(value));
                    this.setStyle("-fx-background-color: #EEE4DA");
                    break;
                case 4:
                    this.setText("   " + String.valueOf(value));
                    this.setStyle("-fx-background-color: #EEE1C9");
                    break;
                case 8:
                    this.setText("   " + String.valueOf(value));
                    this.setStyle("-fx-background-color: #F3B27A");
                    break;
                case 16:
                    this.setText(" " + String.valueOf(value));
                    this.setStyle("-fx-background-color: #F69664");
                    break;
                case 32:
                    this.setText(" " + String.valueOf(value));
                    this.setStyle("-fx-background-color: #F77C5F");
                    break;
                case 64:
                    this.setText(" " + String.valueOf(value));
                    this.setStyle("-fx-background-color: #F75F3B");
                    break;
                case 128:
                    this.setText(String.valueOf(value));
                    this.setStyle("-fx-background-color: #EDD073");
                    break;
                case 256:
                    this.setText(String.valueOf(value));
                    this.setStyle("-fx-background-color: #EDCC61");
                    break;
                case 512:
                    this.setText(String.valueOf(value));
                    this.setStyle("-fx-background-color: #EDC850");
                    break;
                case 1024:
                    this.setText(String.valueOf(value));
                    this.setStyle("-fx-background-color: #EDC53F");
                    break;
                case 2048:
                    this.setText(String.valueOf(value));
                    this.setStyle("-fx-background-color: #EDC22E");
                    break;
                default:
                    throw new IllegalArgumentException("Not a valid argument !");
            }
        }
    }

}
