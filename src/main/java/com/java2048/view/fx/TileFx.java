package com.java2048.view.fx;

import com.java2048.model.Tile;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 * This class represents a tile on the board.
 *
 * @author Amine-Ayoub Bigham {@literal <g54985@etu.he2b.be>}
 */
public class TileFx extends StackPane {

    private Rectangle rectangle;
    private Text text;

    /**
     * Construcor of TileFx. Changes the color of the tile according to its
     * number.
     *
     * @param tile the tile from the model.
     */
    public TileFx(Tile tile) {
        rectangle = new Rectangle(70, 70);
        text = new Text();

        if (tile == null) {
            rectangle.setFill(Color.valueOf("#CDC1B4"));
        } else {
            int value = tile.getValue();
            switch (tile.getValue()) {
                case 2:
                    text.setText(String.valueOf(value));
                    rectangle.setFill(Color.valueOf("#EEE4DA"));
                    break;
                case 4:
                    text.setText(String.valueOf(value));
                    rectangle.setFill(Color.valueOf("#EEE1C9"));
                    break;
                case 8:
                    text.setText(String.valueOf(value));
                    rectangle.setFill(Color.valueOf("#F3B27A"));
                    break;
                case 16:
                    text.setText(String.valueOf(value));
                    rectangle.setFill(Color.valueOf("#F69664"));
                    break;
                case 32:
                    text.setText(String.valueOf(value));
                    rectangle.setFill(Color.valueOf("#F77C5F"));
                    break;
                case 64:
                    text.setText(String.valueOf(value));
                    rectangle.setFill(Color.valueOf("#F75F3B"));
                    break;
                case 128:
                    text.setText(String.valueOf(value));
                    rectangle.setFill(Color.valueOf("#EDD073"));
                    break;
                case 256:
                    text.setText(String.valueOf(value));
                    rectangle.setFill(Color.valueOf("#EDCC61"));
                    break;
                case 512:
                    text.setText(String.valueOf(value));
                    rectangle.setFill(Color.valueOf("#EDC850"));
                    break;
                case 1024:
                    text.setText(String.valueOf(value));
                    rectangle.setFill(Color.valueOf("#EDC53F"));
                    break;
                case 2048:
                    text.setText(String.valueOf(value));
                    rectangle.setFill(Color.valueOf("#EDC22E"));
                    break;
                default:
                    throw new IllegalArgumentException("Not a valid argument !");
            }
        }
        text.setFont(new Font(30));
        this.getChildren().addAll(rectangle, text);
    }

}
