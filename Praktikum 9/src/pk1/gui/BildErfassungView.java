package pk1.gui;

import javafx.stage.Modality;
import javafx.stage.Stage;
import pk1.medienverwaltung.Bild;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

public class BildErfassungView extends Stage {

    private Bild bild;
    TextField tf1;
    TextField tf2;
    TextField tf3;
    TextField tf4;

    public BildErfassungView(Bild bild, Stage primaryStage) {
        this.bild = bild;
        this.initOwner(primaryStage);
        this.initModality(Modality.WINDOW_MODAL);
    }

    public void showView() {
        BorderPane bp = new BorderPane();

        //Buttons
        HBox hb = new HBox();
        hb.setPadding(new Insets(10.0));
        hb.setSpacing(10.0);
        hb.setAlignment(Pos.CENTER);
        Button neu = new Button("Neu");
        Button abbrechen = new Button("Abbrechen");
        hb.getChildren().addAll(neu, abbrechen);


        //Textfields
        GridPane grid = new GridPane();
        this.setTitle("Bilderfassung:");
        grid.setPadding(new Insets(10));
        grid.setHgap(10);
        grid.setVgap(10);

        Label titel = new Label("Titel:");
        Label ort = new Label ("Ort:");
        Label aufnahmejahr = new Label("Aufnahmejahr:");

        tf1 = new TextField(bild.getTitel());
        tf2 = new TextField(bild.getOrt());
        tf3 = new TextField(bild.getJahr() + "");
        GridPane.setHgrow(tf1, Priority.ALWAYS);

        grid.addRow(1, titel, tf1);
        grid.addRow(2, ort, tf2);
        grid.addRow(3, aufnahmejahr, tf3);
        GridPane.setHalignment(titel, HPos.RIGHT);
        GridPane.setHalignment(ort, HPos.RIGHT);
        GridPane.setHalignment(aufnahmejahr, HPos.RIGHT);

        //Adjustierung
        bp.setBottom(hb);
        bp.setCenter(grid);

        //Szene erstellen
        Scene szene = new Scene(bp, 500.0, 200.0);
        this.setScene(szene);
        this.show();
    }
}
