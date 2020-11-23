package com.java2048.view.fx;

import com.java2048.model.Game;
import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author Amine-Ayoub Bigham {@literal <g54985@etu.he2b.be>}
 */
public class VBoxForScene extends VBox {

    private BoardFx boardFx;

    public VBoxForScene(Game game) {
        HBox hBoxMain = new HBox();
        hBoxMain.setPadding(new Insets(10, 10, 10, 10));

        this.boardFx = new BoardFx(game);

        hBoxMain.getChildren().add(boardFx);
        this.getChildren().addAll(hBoxMain);
    }

}
