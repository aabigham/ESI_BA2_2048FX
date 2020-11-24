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

        //Buttons
        VBox vBoxButtons = new VBox();
        vBoxButtons.setSpacing(10);
        Button btnRestart = new Button("Recommencer");
        btnRestart.setDisable(true);
        Button btnStart = new Button("Commencer une partie");
        vBoxButtons.getChildren().addAll(btnStart, btnRestart);

        //Restart
        btnRestart.setOnAction((ActionEvent t) -> {
            game.reset();
            textAreaFx.clearField();
        });

        //On start
        btnStart.setOnAction((ActionEvent t) -> {
            textAreaFx.appendText("À vous de jouer !\n");
            this.addEventFilter(KeyEvent.KEY_PRESSED, new ArrowHandler(game));
            game.reset();
            btnStart.setDisable(true);
            btnRestart.setDisable(false);
            vBoxButtons.getChildren().remove(btnStart);
        });
        //Buttons end

        hBoxMain.getChildren().addAll(boardFx, separator, textAreaFx);
        vBoxMain.getChildren().addAll(hBoxMain, vBoxButtons);
        this.getChildren().add(vBoxMain);
    }

}
