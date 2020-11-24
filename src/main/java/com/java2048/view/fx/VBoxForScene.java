package com.java2048.view.fx;

import com.java2048.model.Game;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * This class creates the main VBox (root) containing every below him in the
 * hierachy.
 *
 * @author Amine-Ayoub Bigham {@literal <g54985@etu.he2b.be>}
 */
public class VBoxForScene extends HBox {

    /**
     * Constructor of the VBox.
     *
     * @param game the model (game).
     */
    public VBoxForScene(Game game) {
        this.setPadding(new Insets(10));
        this.setStyle("-fx-background-color: #AD9D8F");
        VBox vBoxMain = new VBox();
        HBox hBoxMain = new HBox();
        hBoxMain.setPadding(new Insets(0, 0, 20, 0));

        //Board
        BoardFx boardFx = new BoardFx(game);
        //Separator
        Separator separator = new Separator(Orientation.VERTICAL);
        //TextArea
        TextAreaFx textAreaFx = new TextAreaFx(game);
        textAreaFx.appendText("Bienvenue au 2048\n");

        //Buttons
        VBox vBoxButtons = new VBox();
        vBoxButtons.setSpacing(10);

        Button btnRestart = new Button("Recommencer");
        btnRestart.setStyle("-fx-background-color: #8F7A66; -fx-font-size: 2em; -fx-text-fill: #FFFFFF");

        Button btnStart = new Button("Commencer une partie");
        btnStart.setStyle("-fx-background-color: #8F7A66; -fx-font-size: 2em; -fx-text-fill: #FFFFFF");

        vBoxButtons.getChildren().addAll(btnStart);

        //Restart button action
        btnRestart.setOnAction((ActionEvent t) -> {
            game.reset();
            textAreaFx.clearField();
        });

        //Start button action
        btnStart.setOnAction((ActionEvent t) -> {
            //Init game + add arrow key handler
            game.reset();
            this.addEventFilter(KeyEvent.KEY_PRESSED, new ArrowHandler(game));

            //TextArea setup
            textAreaFx.clearField();
            textAreaFx.appendText("À vous de jouer !\n");

            //Remove start button & add restart button
            vBoxButtons.getChildren().remove(btnStart);
            vBoxButtons.getChildren().add(btnRestart);
        });

        hBoxMain.getChildren().addAll(boardFx, separator, textAreaFx);
        vBoxMain.getChildren().addAll(hBoxMain, vBoxButtons);
        this.getChildren().add(vBoxMain);
    }

}
