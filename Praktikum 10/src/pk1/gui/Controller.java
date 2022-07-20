package pk1.gui;

import java.util.Iterator;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import pk1.medienverwaltung.*;
import pk1.datenhaltung.*;

public class Controller {

    private Medienverwaltung verwaltung;
    private Stage stage;
    private ObservableList<Medium> medien;

    public Controller(Stage stage, Medienverwaltung verwaltung){
        this.stage = stage;
        this.verwaltung = verwaltung;
    }


    public void addExamples(){
        verwaltung.init();
    }


    public void addAudio(){
        Audio audio = new Audio();
        AudioErfassungView aev = new AudioErfassungView(audio, stage);
        aev.showView();
        verwaltung.aufnehmen(audio);

        updateList();
    }

    public void addPicture(){
        Bild bild = new Bild();
        BildErfassungView bev = new BildErfassungView(bild, stage);
        bev.showView();
        verwaltung.aufnehmen(bild);

        updateList();
    }

    public String showAll(){
        return verwaltung.zeigeMedien();
    }

    public int berechneErscheinungsjahr(){
        return (int)verwaltung.berechneErscheinungsjahr();
    }

    public Medium sucheNeuesMedium(){
        return verwaltung.sucheNeuesMediumObj();
    }

    public void save() throws PersistenzException{
        verwaltung.save();
    }

    public void load() throws PersistenzException{
        verwaltung.load();

        updateList();
    }

    public ObservableList<Medium> getList(){
        medien = FXCollections.observableArrayList(verwaltung.getListe());
        return medien;
    }

    public void updateList(){
        medien.clear();
        Iterator<Medium> it = verwaltung.iterator();
        while(it.hasNext()){
            medien.add(it.next());
        }
    }
}