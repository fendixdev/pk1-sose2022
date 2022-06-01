package pk1.medienverwaltung;

import javax.swing.*;

public class Menu {

    public static void main(String[] args) {

        Medienverwaltung mv = new Medienverwaltung();
        boolean beendet = false;

        while (!beendet) {
            System.out.println("------------------------");
            System.out.println("Medienverwaltung");
            System.out.println("------------------------");
            System.out.print("1. Audio aufnehmen\n2. Bild aufnehmen\n3. Zeige alle Medien\n4. Medienliste in Datei schreiben\n5. Zeige neues Medium\n6. Berechne durchschnittliches Erscheinungsjahr\n7. Beenden\n");

            String menuAuswahl = JOptionPane.showInputDialog(null, "Bitte wählen Sie einen Menüpunkt aus.");

            try {
                switch (Integer.parseInt(menuAuswahl)) {
                    case 1 -> {
                        boolean isSuccessful = false;
                        String titel = JOptionPane.showInputDialog(null, "Bitte geben Sie einen Titel ein");
                        String interpret = JOptionPane.showInputDialog(null, "Bitte geben Sie den Interpreten ein");
                        int jahr = 0;
                        int dauer = 0;
                        while (!isSuccessful) {
                            try {
                                jahr = Integer.parseInt(JOptionPane.showInputDialog(null, "Bitte geben Sie das Erscheinungsjahr ein"));
                                isSuccessful = true;
                            } catch (NumberFormatException e) {
                                JOptionPane.showMessageDialog(null, "Bitte geben Sie ein gültiges Erscheinungsjahr ein!");
                            }
                        }
                        isSuccessful = false;
                        while (!isSuccessful) {
                            try {
                                dauer = Integer.parseInt(JOptionPane.showInputDialog(null, "Bitte geben Sie die Dauer ein"));
                                isSuccessful = true;
                            } catch (NumberFormatException e) {
                                JOptionPane.showMessageDialog(null, "Bitte geben Sie eine gültige Dauer ein!");
                            }
                        }
                        mv.aufnehmen(titel, jahr, dauer, interpret);
                    }
                    case 2 -> {
                        boolean isSuccessful = false;
                        int jahr = 0;
                        String titel = JOptionPane.showInputDialog(null, "Bitte geben Sie einen Titel ein");
                        while (!isSuccessful) {
                            try {
                                jahr = Integer.parseInt(JOptionPane.showInputDialog(null, "Bitte geben Sie das Erscheinungsjahr ein"));
                                isSuccessful = true;
                            } catch (NumberFormatException e) {
                                JOptionPane.showMessageDialog(null, "Bitte geben Sie ein gültiges Erscheinungsjahr ein!");
                            }
                        }
                        String ort = JOptionPane.showInputDialog(null, "Bitte geben Sie einen Ort ein");
                        mv.aufnehmen(titel, jahr, ort);

                    }
                    case 3 -> mv.zeigeMedien();
                    case 4 -> {

                        String filename = null;

                        try {
                            filename = dateinamenAbfragen();
                            mv.medienlisteSpeichern(filename);
                        } catch (EmptyFilenameException e) {
                            int auswahl = JOptionPane.showConfirmDialog(null, "Möchten Sie einen neuen Titel festlegen?", "Titel festlegen", JOptionPane.YES_NO_OPTION);
                            if (auswahl == 0) filename = dateinamenAbfragen();
                            mv.medienlisteSpeichern(filename);
                        }
                    }
                    case 5 -> mv.sucheNeuesMedium();
                    case 6 -> mv.berechneErscheinungsjahr();
                    case 7 -> beendet = true;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Bitte korrigieren Sie Ihre Eingabe!");
                //e.printStackTrace();
            }
        }
    }

    public static String dateinamenAbfragen() throws EmptyFilenameException {
        String input = JOptionPane.showInputDialog(null, "Bitte geben Sie einen Dateinamen ein.");

        if (input.isEmpty()) {
            throw new EmptyFilenameException();
        } else {
            return input;
        }
    }
}
