package pk1.medienverwaltung;

import java.util.Iterator;
import java.util.LinkedList;

public class Medienverwaltung {

    LinkedList<Medium> medienliste = new LinkedList<>();

    public void aufnehmen(Medium m) {
        medienliste.add(m);
    }

    public void zeigeMedien() {
        for (Medium m : medienliste) {
            m.druckeDaten();
        }
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
}
