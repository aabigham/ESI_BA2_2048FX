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
 * This class creates the main view (vbox root) containing every element below
 * him in the hierachy.
 *
 * @author Amine-Ayoub Bigham {@literal <g54985@etu.he2b.be>}
 */
public class VBoxForScene extends VBox {

    /**
     * Constructor of the HBox (scene).
     *
     * @param game the game model
     */
    public VBoxForScene(Game game) {
        this.setPadding(new Insets(10));
        this.setStyle("-fx-background-color: #AD9D8F");
        HBox hBoxMain = new HBox();
        hBoxMain.setPadding(new Insets(0, 0, 20, 0));

        //Board
        BoardFx boardFx = new BoardFx(game);

        //Separator
        Separator separator = new Separator(Orientation.VERTICAL);
        separator.setPadding(new Insets(0, 6, 0, 0));

        //Score
        ScoreTile scoreTile = new ScoreTile(game);

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

        vBoxButtons.getChildren().addAll(btnStart, scoreTile);

        //Restart button action
        btnRestart.setOnAction((ActionEvent t) -> {
            game.initialize();
            textAreaFx.clearField();
            textAreaFx.appendText("Bonne chance !\n");
        });

        //Start button action
        btnStart.setOnAction((ActionEvent t) -> {
            //Init game + add arrow key handler
            game.initialize();
            this.addEventFilter(KeyEvent.KEY_PRESSED, new ArrowHandler(game));

            //TextArea setup
            textAreaFx.clearField();
            textAreaFx.appendText("?? vous de jouer !\n");

            //Remove start button & add restart button
            vBoxButtons.getChildren().remove(btnStart);
            vBoxButtons.getChildren().add(btnRestart);
        });

        //Vbox score TextArea
        VBox scoreTextArea = new VBox();
        scoreTextArea.setSpacing(10);
        scoreTextArea.getChildren().addAll(scoreTile, textAreaFx);

        hBoxMain.getChildren().addAll(boardFx, separator, scoreTextArea);
        this.getChildren().addAll(hBoxMain, vBoxButtons);
    }

}
