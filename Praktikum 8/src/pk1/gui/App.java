package pk1.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.Stage;
import pk1.medienverwaltung.Audio;
import pk1.medienverwaltung.Bild;

public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Bild test = new Bild("test",2000,"Dortmund");
        BildErfassungView test2 = new BildErfassungView(test,stage);
        test2.showView();

        Audio aud = new Audio("Testtitel", 2004, 2004, "Testinterpret");
        AudioErfassungView aev = new AudioErfassungView(aud, stage);
        aev.showView();

        BorderPane bp = new BorderPane();

        MenuBar mb = new MenuBar();
        ///////////////
        Menu datei = new Menu("Datei");
        MenuItem laden = new MenuItem("Laden");
        MenuItem speichern = new MenuItem("Speichern");
        MenuItem mid = new MenuItem("Medienliste in Datei");
        MenuItem beenden = new MenuItem("Beenden");
        datei.getItems().addAll(laden, speichern, new SeparatorMenuItem(), mid, new SeparatorMenuItem(), beenden);
        ///////////////
        Menu medium = new Menu("Medium");
        MenuItem ah = new MenuItem("Audio hinzufügen");
        MenuItem bh = new MenuItem("Bild hinzufügen");
        medium.getItems().addAll(ah, bh);
        ///////////////
        Menu anzeige = new Menu("Anzeige");
        MenuItem alleAnzeigen = new MenuItem("Alle Einträge anzeigen");
        anzeige.getItems().addAll(alleAnzeigen);
        ///////////////
        mb.getMenus().addAll(datei, medium, anzeige);


        bp.setTop(mb);
        Scene scene = new Scene(bp, 500, 300);
        stage.setTitle("Medienverwaltung");
        stage.setScene(scene);
        stage.show();

    }
}
