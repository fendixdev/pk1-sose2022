package pk1.medienverwaltung;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Medium {
    private int id;
    private static int idCounter;
    private String titel;
    private int jahr;

    public Medium(String titel, int jahr) {
        this.id = idCounter++;
        this.titel = titel;
        this.jahr = jahr;
    }

    public int getId() {
        return id;
    }

    public int getJahr() {
        return this.jahr;
    }

    public String getTitel() {
        return this.titel;
    }

    public int alter() {
        return LocalDate.now().getYear() - getJahr();
    }

    public abstract void druckeDaten();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof Medium)) return false;
        Medium medium = (Medium) o;
        return jahr == medium.jahr && Objects.equals(titel, medium.titel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titel, jahr);
    }
}
