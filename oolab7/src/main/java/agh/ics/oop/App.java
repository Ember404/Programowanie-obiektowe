package agh.ics.oop;
import javafx.geometry.Insets;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import java.util.List;



    public class App extends Application {
        @Override
        public void init (AbstractWorldMap m) throws Exception
        {
            super.init ();
            Parameters parameters = getParameters ();

            List<String> rawArguments = parameters.getRaw (m.toString());
            List<String> unnamedParameters = parameters.getUnnamed ();

            System.out.println ("\nrawArguments -");
            for (String raw : rawArguments)
                System.out.println (raw);

            System.out.println ("\nunnamedParameters -");
            for (String unnamed : unnamedParameters)
                System.out.println (unnamed);
        }

        @Override
        public void start(Stage stage) {
            GridPane gridPane = new GridPane();
            gridPane.setGridLinesVisible(true);

            Label label = new Label("Zwierzak");
            Scene scene = new Scene(label);

            stage.setScene(scene);
            stage.show();
        }

        public static void main(String[] args) {
            launch(args);
        }
    }

