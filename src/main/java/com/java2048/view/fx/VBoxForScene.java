package com.java2048.view.fx;

import com.java2048.model.Game;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author Amine-Ayoub Bigham {@literal <g54985@etu.he2b.be>}
 */
public class VBoxForScene extends HBox {
    
    private BoardFx boardFx;
    
    public VBoxForScene(Game game) {
        this.setPadding(new Insets(10));
        this.setStyle("-fx-background-color: #AD9D8F");
        VBox vBoxMain = new VBox();
        HBox hBoxMain = new HBox();
        hBoxMain.setPadding(new Insets(0, 0, 20, 0));

        //Board
        //VBox vBoxBoard = new VBox();
        boardFx = new BoardFx(game);
        //game.reset();
        //vBoxBoard.getChildren().add(boardFx);
        //Board

        Separator separator = new Separator(Orientation.VERTICAL);

        //TextArea
        //VBox vBoxTextArea = new VBox();
        TextArea textArea = new TextArea();
        //vBoxTextArea.getChildren().add(textArea);
        //TextArea

        //Arrow key event
        this.addEventFilter(KeyEvent.KEY_PRESSED, new ArrowHandler(game));
        //Arrow key end

        //Buttons
        VBox vBoxButtons = new VBox();
        vBoxButtons.setSpacing(10);
        Button btnRestart = new Button("Recommencer");
        Button btnStart = new Button("Commencer une partie");
        vBoxButtons.getChildren().addAll(btnStart, btnRestart);
        
        btnRestart.setOnAction((ActionEvent t) -> {
            game.reset();
        });
        btnRestart.setDisable(true);
        
        btnStart.setOnAction((ActionEvent t) -> {
            game.reset();
            btnStart.setDisable(true);
            btnRestart.setDisable(false);
            vBoxButtons.getChildren().remove(btnStart);
        });
        //Buttons end

        hBoxMain.getChildren().addAll(boardFx, separator, textArea);
        vBoxMain.getChildren().addAll(hBoxMain, vBoxButtons);
        this.getChildren().add(vBoxMain);
    }
    
}
