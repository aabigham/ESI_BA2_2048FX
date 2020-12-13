package com.java2048.view.fx;

import com.java2048.model.Observer;
import com.java2048.model.Game;
import com.java2048.model.GameStatus;
import java.time.format.DateTimeFormatter;
import javafx.scene.control.TextArea;

/**
 * This class represents the text area to display messages to the player.
 *
 * @author Amine-Ayoub Bigham {@literal <g54985@etu.he2b.be>}
 */
public class TextAreaFx extends TextArea implements Observer {

    private final Game observable;

    /**
     * Constructor of the text area used to diplay messages to the player.
     *
     * @param observable the observable game.
     */
    public TextAreaFx(Game observable) {
        if (observable == null) {
            throw new IllegalArgumentException("Nothing to observe");
        }
        this.observable = (Game) observable;

        this.setPrefWidth(220);
        this.setPrefHeight(278);
        this.setEditable(false);

        observable.registerObserver(this);
    }

    /**
     * Updates the text area when the players makes an unauthorized move or when
     * the game is over.
     */
    @Override
    public void update() {
        //Current hour
        String now = java.time.LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        //Avoid the "mouvement impossible" message at start
        boolean flagMove = observable.couldMove();
        if (observable.getScore() == 0) {
            flagMove = true;
        }
        //Displays the messages
        if (!flagMove) {
            this.appendText(now + " - Mouvement impossible !\n");
        } else if (observable.getStatus().equals(GameStatus.WIN)) {
            this.appendText(now + " - Partie gagnée !\n");
        } else if (observable.getStatus().equals(GameStatus.FAIL)) {
            this.appendText(now + " - Vous avez perdu !\n");
        }
    }

    /**
     * Clears the text aread and resets the line count.
     */
    public void clearField() {
        this.clear();
    }

}
