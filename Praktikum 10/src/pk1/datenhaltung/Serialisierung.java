package pk1.datenhaltung;

import pk1.medienverwaltung.Medium;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class Serialisierung implements IDao {

    public void medienlisteSpeichern(List<Medium> liste) throws PersistenzException {

        File file = new File("/Users/maximiliandrude/Documents/GitHub/pk1-sose2022/Praktikum 10/medienliste.ser");

        try (FileOutputStream fos = new FileOutputStream(file);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            oos.writeObject(liste);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public LinkedList<Medium> medienlisteLaden() {
        File file = new File("/Users/maximiliandrude/Documents/GitHub/pk1-sose2022/Praktikum 10/medienliste.ser");
        LinkedList<Medium> geladeneListe = null;

        try (FileInputStream fis = new FileInputStream(file);
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            geladeneListe = (LinkedList<Medium>) ois.readObject();

        } catch (FileNotFoundException e) {
            System.out.println("Datei nicht gefunden");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return geladeneListe;
    }

}
