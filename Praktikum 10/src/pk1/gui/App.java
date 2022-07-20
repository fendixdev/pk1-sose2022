package pk1.gui;

import java.io.FileOutputStream;
import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import pk1.datenhaltung.*;
import pk1.medienverwaltung.*;


public class App extends Application {

    private Audio audio;
    static Medienverwaltung verwaltung;
    Controller controller;

    public static void main(String[] args) throws Exception{
        launch(args);
    }

    public void start(Stage stage) throws Exception {


        Medienverwaltung verwaltung = new Medienverwaltung(new Serialisierung());
        Controller controller = new Controller(stage, verwaltung);
        controller.addExamples();

        BorderPane bp = new BorderPane();


        ListView<Medium> liste = new ListView<Medium>();
        liste.setItems(controller.getList());

        MenuBar mb = new MenuBar();
        ///////////////
        Menu datei = new Menu("Datei");
        MenuItem laden = new MenuItem("Laden");
        laden.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent arg0){
                try{
                    controller.load();
                } catch (PersistenzException e){
                    e.printStackTrace();
                }
            }
        });
        MenuItem speichern = new MenuItem("Speichern");
        speichern.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent arg0){
                try{
                    controller.save();
                } catch (PersistenzException e){
                    e.printStackTrace();
                }
            }
        });
        MenuItem mid = new MenuItem("Medienliste in Datei");
        mid.setOnAction(new saveToFileHandler());
        MenuItem beenden = new MenuItem("Beenden");
        datei.getItems().addAll(laden, speichern, new SeparatorMenuItem(), mid, new SeparatorMenuItem(), beenden);
        ///////////////
        Menu medium = new Menu("Medium");
        MenuItem ah = new MenuItem("Audio hinzufügen");
        ah.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent arg0) {
                controller.addAudio();
            }
        });
        MenuItem bh = new MenuItem("Bild hinzufügen");
        bh.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent arg0){
                controller.addPicture();
            }
        });
        medium.getItems().addAll(ah, bh);
        ///////////////
        Menu anzeige = new Menu("Anzeige");
        MenuItem alleAnzeigen = new MenuItem("Alle Einträge anzeigen");
        alleAnzeigen.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent arg0){
                MessageView.create(stage, "Alle Einträge", controller.showAll()).showView();
                controller.showAll();
            }
        });
        MenuItem avgErscheinungsjahr = new MenuItem("Durchschnittliches Erscheinungsjahr");
        avgErscheinungsjahr.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent arg0){
                MessageView.create(stage, "Durchschnittliches Erscheinungsjahr", "Das durchschnittliche Erscheinungsjahr ist: " + controller.berechneErscheinungsjahr()).showView();
            }
        });
        MenuItem neustesMedium = new MenuItem("Neustes Medium");
        neustesMedium.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent arg0){
                MessageView.create(stage, "Neuste Medium", "Das neuste Medium ist:\n\n" + controller.sucheNeuesMedium()).showView();
            }
        });
        anzeige.getItems().addAll(alleAnzeigen, avgErscheinungsjahr, neustesMedium);
        ///////////////
        mb.getMenus().addAll(datei, medium, anzeige);


        bp.setTop(mb);
        bp.setCenter(liste);
        Scene scene = new Scene(bp, 500, 300);
        stage.setTitle("Medienverwaltung");
        stage.setScene(scene);
        stage.show();
    }

    class saveToFileHandler implements EventHandler<ActionEvent>{
        public void handle(ActionEvent e){
            try(FileOutputStream fos = new FileOutputStream("v1.txt")){
                audio.druckeDatenOs(fos);
            } catch (IOException ex){
                ex.printStackTrace();
            }
        }
    }
}