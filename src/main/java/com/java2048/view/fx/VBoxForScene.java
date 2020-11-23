package com.java2048.view.fx;

import com.java2048.model.Game;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
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
        this.setPadding(new Insets(0, 0, 0, 10));
        VBox vBoxMain = new VBox();
        HBox hBoxMain = new HBox();
        hBoxMain.setPadding(new Insets(0, 0, 20, 0));

        boardFx = new BoardFx(game);
        game.reset();

        //Arrow key event
        this.addEventFilter(KeyEvent.KEY_PRESSED, new ArrowHandler(game));
        //Arrow key end

        //Restart button
        Button btnRestart = new Button("Recommencer");
        btnRestart.setOnAction((ActionEvent t) -> {
            game.reset();
        });
        //Restart button end

        hBoxMain.getChildren().add(boardFx);
        vBoxMain.getChildren().addAll(hBoxMain, btnRestart);
        this.getChildren().add(vBoxMain);
    }

}
