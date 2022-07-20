package pk1.medienverwaltung;

public class MedienverwaltungArray {

    Medium[] medienArray = new Medium[10];
    int medienArrayCounter = 0;

    public void aufnehmen(Medium m) {
        if (medienArrayCounter <= 10) {
            medienArray[medienArrayCounter] = m;
            medienArrayCounter++;
        } else {
            System.out.println("Es können keine Medien mehr aufgenommen werden!");
        }
    }

    public void zeigeMedien() {
        for (Medium m : medienArray) {
            if (m != null) {
                m.druckeDaten();
            }
        }
    }

    public void sucheNeuesMedium() {
        if (medienArray[0] != null) {
            Medium neustesMedium = medienArray[0];
            for (Medium medium : medienArray) {
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
        double sum = 0;
        if (medienArrayCounter != 0) {
            for (Medium m : medienArray) {
                if (m != null) {
                    sum += m.getJahr();
                }
            }
            System.out.printf("Das durchschnittliche Erscheinungsjahr ist %.0f.\n", sum / medienArrayCounter);
        }
    }
}


