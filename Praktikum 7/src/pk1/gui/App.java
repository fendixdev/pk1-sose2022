package pk1.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        Label nachricht = new Label("Hauptfenster");
        nachricht.setFont(new Font(50));

        Scene szene = new Scene(nachricht);
        primaryStage.setScene(szene);

        BildErfassungView bev = new BildErfassungView(null, primaryStage);
        bev.showView();

        primaryStage.show();

    }
}
