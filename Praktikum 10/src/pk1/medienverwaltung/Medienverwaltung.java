package pk1.medienverwaltung;

import pk1.datenhaltung.*;

import java.io.*;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

public class Medienverwaltung {

    LinkedList<Medium> medienliste = new LinkedList<>();
    private Serialisierung serialisierung;

    public Medienverwaltung(Serialisierung serialisierung){
        this.serialisierung = serialisierung;
    }


    public void init(){
        medienliste.add(new Audio("Wreckingball", 2015, 238, "Miley Cyrus"));
        medienliste.add(new Bild("Mona Lisa", 1503, "Leonardo da Vinci"));
    }

    public void aufnehmen(Medium m) {
        medienliste.add(m);
        Collections.sort(medienliste);
    }

    public void aufnehmen(String titel, int jahr, int dauer, String interpret) {
        medienliste.add(new Audio(titel, jahr, dauer, interpret));
        Collections.sort(medienliste);
    }

    public void aufnehmen(String titel, int jahr, String ort) {
        medienliste.add(new Bild(titel, jahr, ort));
        Collections.sort(medienliste);
    }

    /*public void zeigeMedien() {
        System.out.print("\n\n");
        for (Medium m : medienliste) {
            //m.druckeDaten();
            m.druckeDatenOs(System.out);
        }
        System.out.println("");
    }*/

    public LinkedList<Medium>  getListe(){
        return medienliste;
    }

    public String zeigeMedien() {
        String s = "";
        for (Medium medienName : medienliste) {
            s += medienName.toString();
        }
        return s;
    }

    public void sucheNeuesMedium() {
        if (medienliste.getFirst() != null) {
            Medium neustesMedium = medienliste.getFirst();
            for (Medium medium : medienliste) {
                if (medium != null) {
                    if (medium.getJahr() > neustesMedium.getJahr()) {
                        neustesMedium = medium;
                    }
                }
            }
            System.out.printf("Das neuste Medium ist \"%s\" aus dem Jahr %d.\n", neustesMedium.getTitel(), neustesMedium.getJahr());
        }
    }

    public Medium sucheNeuesMediumObj() {
        Medium neustesMedium = null;
        if (medienliste.getFirst() != null) {
            neustesMedium = medienliste.getFirst();
            for (Medium medium : medienliste) {
                if (medium != null) {
                    if (medium.getJahr() > neustesMedium.getJahr()) {
                        neustesMedium = medium;
                    }
                }
            }
        }
        return neustesMedium;
    }

    public Iterator<Medium> iterator() {
        return medienliste.iterator();
    }

    public int berechneErscheinungsjahr() {
        int counter = 0;
        int sum = 0;
        if (medienliste.getFirst() != null) {

            Iterator<Medium> it = medienliste.iterator();

            while (it.hasNext()) {
                Medium m = it.next();
                sum += m.getJahr();
                counter++;
            }
            System.out.printf("Das durchschnittliche Erscheinungsjahr ist %d\n", sum / counter);
        }
        return sum / counter;
    }

    public void save() throws PersistenzException {
        serialisierung.medienlisteSpeichern(medienliste);
    }

    public void load() throws PersistenzException {
        int counter = 0;
        medienliste = serialisierung.medienlisteLaden();

        counter = medienliste.size();
        Medium.setIdCounter(counter);
        System.out.println(counter);
    }

}
