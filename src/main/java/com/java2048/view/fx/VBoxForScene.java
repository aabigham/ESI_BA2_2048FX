package com.java2048.view.fx;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author Amine-Ayoub Bigham {@literal <g54985@etu.he2b.be>}
 */
public class VBoxForScene extends VBox {

    public VBoxForScene() {
        HBox hBoxMain = new HBox();

        this.getChildren().addAll(hBoxMain);
    }

}
