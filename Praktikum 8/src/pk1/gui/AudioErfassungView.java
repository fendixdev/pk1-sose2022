package pk1.gui;

import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import pk1.medienverwaltung.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;


public class AudioErfassungView extends Stage {

    private Audio audio;
    private TextField tf1;
    private TextField tf2;
    private TextField tf3;
    private TextField tf4;

    public AudioErfassungView(Audio audio, Stage primaryStage) {
        this.audio = audio;
        this.initOwner(primaryStage);
        this.initModality(Modality.WINDOW_MODAL);
    }

    public void showView() {

        BorderPane bp = new BorderPane();

        //Settings
        HBox hb = new HBox();
        hb.setPadding(new Insets(10.0));
        hb.setSpacing(10.0);
        hb.setAlignment(Pos.CENTER);

        //Textfields
        GridPane grid = new GridPane();
        this.setTitle("Audioerfassung:");
        grid.setPadding(new Insets(10));
        grid.setHgap(10);
        grid.setVgap(10);

        Label titel = new Label("Titel:");
        Label interpret = new Label("Interpret:");
        Label jahr = new Label ("Jahr:");
        Label dauer = new Label("Dauer in Sekunden:");

        tf1 = new TextField("audio.getTitel()");
        tf2 = new TextField("audio.getInterpret()");
        tf3 = new TextField("audio.getJahr()");
        tf4 = new TextField("audio.getDauer()");
        GridPane.setHgrow(tf1, Priority.ALWAYS);

        grid.addRow(1, titel, tf1);
        grid.addRow(2, interpret, tf2);
        grid.addRow(3, jahr, tf3);
        grid.addRow(4, dauer, tf4);
        GridPane.setHalignment(titel, HPos.RIGHT);
        GridPane.setHalignment(interpret, HPos.RIGHT);
        GridPane.setHalignment(jahr, HPos.RIGHT);
        GridPane.setHalignment(dauer, HPos.RIGHT);

        //Adjustierung
        bp.setBottom(hb);
        bp.setCenter(grid);

        //Buttons
        Button neu = new Button("Neu");
        Button abbrechen = new Button("Abbrechen");
        hb.getChildren().addAll(neu, abbrechen);

        //Szene erstellen
        Scene szene = new Scene(bp, 500.0, 250.00);
        this.setScene(szene);
        //this.show();
        this.showAndWait();
    }
}
