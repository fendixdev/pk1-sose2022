/*
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
            System.out.print("1. Audio aufnehmen\n2. Bild aufnehmen\n3. Zeige alle Medien\n4. Medienliste in Datei schreiben\n5. Medienliste laden\n6. Zeige neues Medium\n7. Berechne durchschnittliches Erscheinungsjahr\n8. Beenden\n");

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
                                JOptionPane.showMessageDialog(null, "Bitte geben Sie " + "ein gültiges Erscheinungsjahr ein!");
                            }
                        }
                        String ort = JOptionPane.showInputDialog(null, "Bitte geben Sie einen Ort ein");
                        mv.aufnehmen(titel, jahr, ort);

                    }
                    case 3 -> mv.zeigeMedien();
                    case 4 -> {
                        String filename;
                        int err = 1;

                        while (err == 1) {
                            err = 0;
                            try {
                                filename = dateinamenAbfragen();
                                mv.medienlisteSpeichern(filename);
                            } catch (EmptyFilenameException e) {
                                JOptionPane.showMessageDialog(null, "Legen Sie bitte einen gültigen Titel fest!");
                                err = 1;
                            }
                        }
                    }
                    case 5 -> {
                        String filename;
                        int err = 1;

                        while (err == 1) {
                            err = 0;
                            try {
                                filename = dateinamenAbfragen();
                                mv.medienlisteLaden(filename);
                            } catch (EmptyFilenameException e) {
                                JOptionPane.showMessageDialog(null, "Geben Sie bitte einen gültigen Dateinamen ein!");
                                err = 1;
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    case 6 -> mv.sucheNeuesMedium();
                    case 7 -> mv.berechneErscheinungsjahr();
                    case 8 -> beendet = true;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Bitte korrigieren Sie Ihre Eingabe!");
                //e.printStackTrace();
            }
        }
    }

    public static String dateinamenAbfragen() throws EmptyFilenameException {
        String input = JOptionPane.showInputDialog(null, "Bitte geben Sie einen Dateinamen ein: ");

        if (input.isEmpty()) {
            throw new EmptyFilenameException();
        } else {
            return input;
        }
    }
}

*/
