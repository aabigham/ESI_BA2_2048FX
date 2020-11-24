package com.java2048.main;

import com.java2048.model.Game;
import com.java2048.view.fx.VBoxForScene;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Main class for the fx launch.
 *
 * @author Amine-Ayoub Bigham {@literal <g54985@etu.he2b.be>}
 */
public class MainFx extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * The main entry point for all JavaFX applications.
     *
     * @param primaryStage the primary stage for this application, onto which
     * the application scene can be set
     */
    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(new VBoxForScene(new Game()));

        primaryStage.setHeight(325);
        primaryStage.setWidth(420);
        primaryStage.setResizable(false);
        primaryStage.setTitle("2048 FX");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
