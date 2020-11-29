package com.java2048.view.fx;

import com.java2048.model.Game;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 *
 * @author Amine-Ayoub Bigham {@literal <g54985@etu.he2b.be>}
 */
public class ScoreTile extends StackPane implements Observer {

    private final Text text;
    private Game observable;

    public ScoreTile(Game observable) {
        if (observable == null) {
            throw new IllegalArgumentException("Nothing to observe");
        }
        this.observable = (Game) observable;

        this.text = new Text();
        text.setText("Score : " + String.valueOf(observable.getScore()));
        text.setFont(new Font(25));

        this.getChildren().addAll(text);
        observable.registerObserver(this);
    }

    @Override
    public void update() {
        text.setText("Score : " + String.valueOf(observable.getScore()));
    }

}
