package pk1.medienverwaltung;

import java.io.OutputStream;
import java.io.PrintStream;
import java.io.Serializable;
import java.util.Objects;

public class Bild extends Medium implements Serializable {

    private String ort;

    public Bild(String titel, int jahr, String ort) {
        super(titel, jahr);
        this.ort = ort;
    }

    public Bild(){}

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public void setTitel(String titel){
        super.setTitel(titel);
    }

    public void setJahr(int jahr){
        super.setJahr(jahr);
    }

    public String getOrt() {
        return this.ort;
    }

    @Override
    public void druckeDaten() {
        System.out.printf("ID: %d | Titel: %s | Jahr: %d | Ort: %s | Alter: %d Jahre\n", super.getId(), super.getTitel(), super.getJahr(), getOrt(), alter());
    }

    @Override
    public void druckeDatenOs(OutputStream os) {
        PrintStream ps = new PrintStream(os);
        ps.printf("ID: %d | Titel: %s | Jahr: %d | Ort: %s | Alter: %d Jahre\n", super.getId(), super.getTitel(), super.getJahr(), getOrt(), alter());
    }

    @Override
    public String toString() {
        return String.format("ID: %d | Titel: %s | Jahr: %d | Ort: %s | Alter: %d Jahre\n", super.getId(), super.getTitel(), super.getJahr(), getOrt(), alter());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof Bild bild)) return false;
        if (!super.equals(o)) return false;
        return getOrt().equals(bild.getOrt());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getOrt());
    }
}
