package com.java2048.view.fx;

import com.java2048.model.Observer;
import com.java2048.model.Game;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;

/**
 * This class represents the board on which are placed all the tiles of the
 * game.
 *
 * @author Amine-Ayoub Bigham {@literal <g54985@etu.he2b.be>}
 */
public class BoardFx extends GridPane implements Observer {

    private final int SIDE;
    private Game observable;

    /**
     * Constructor the the game board using buttons.
     *
     * @param observable the observable game.
     */
    public BoardFx(Game observable) {
        if (observable == null) {
            throw new IllegalArgumentException("Nothing to observe");
        }
        this.observable = (Game) observable;

        this.SIDE = 4;

        this.setVgap(10);
        this.setHgap(10);
        this.setPadding(new Insets(10, 10, 10, 0));

        //Initializes empty tiles
        for (int i = 0; i < SIDE; i++) {
            for (int j = 0; j < SIDE; j++) {
                TileFx tileFx = new TileFx(null);
                this.add(tileFx, j, i);
            }
        }
        observable.registerObserver(this);
    }

    /**
     * Updates the board and displays all the tiles with all of the according
     * colors for each number.
     */
    @Override
    public void update() {
        this.getChildren().clear();
        for (int i = 0; i < SIDE; i++) {
            for (int j = 0; j < SIDE; j++) {
                TileFx tileFx = new TileFx(observable.getBoard().getTileAt(i, j));
                this.add(tileFx, j, i);
            }
        }

    }
}
