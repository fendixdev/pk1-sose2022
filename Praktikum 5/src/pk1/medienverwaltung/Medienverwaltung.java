package pk1.medienverwaltung;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

public class Medienverwaltung {

    LinkedList<Medium> medienliste = new LinkedList<>();

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

    public void zeigeMedien() {
        System.out.print("\n\n");
        for (Medium m : medienliste) {
            //m.druckeDaten();
            m.druckeDatenOs(System.out);
        }
        System.out.println("");
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

    public void berechneErscheinungsjahr() {
        if (medienliste.getFirst() != null) {
            int counter = 0;
            int sum = 0;

            Iterator<Medium> it = medienliste.iterator();

            while (it.hasNext()) {
                Medium m = (Medium) it.next();
                sum += m.getJahr();
                counter++;
            }
            System.out.printf("Das durchschnittliche Erscheinungsjahr ist %d\n", sum / counter);
        }
    }

    public void medienlisteSpeichern(String dateiname) throws EmptyFilenameException {

        File file = new File("/Users/maximiliandrude/Documents/GitHub/pk1-sose2022/Praktikum 5/" + dateiname + ".ser");

        try(FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos)){

            oos.writeObject(medienliste);

        } catch (Exception e){
            e.printStackTrace();
        }
    }


}
