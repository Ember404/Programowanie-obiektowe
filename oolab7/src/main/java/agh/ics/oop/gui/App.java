package agh.ics.oop.gui;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage stage) {
        GridPane gridPane = new GridPane();
        gridPane.setGridLinesVisible(true);

        Label label = new Label("Zwierzak");
        Scene scene = new Scene(label);

        stage.setScene(scene);
        stage.show();
        Platform.exit();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

