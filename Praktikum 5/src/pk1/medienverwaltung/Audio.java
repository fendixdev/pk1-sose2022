package pk1.medienverwaltung;

import java.io.OutputStream;
import java.io.PrintStream;
import java.io.Serializable;
import java.util.Objects;

public class Audio extends Medium implements Serializable {

    private String interpret;
    private int dauer;

    public Audio(String titel, int jahr, int dauer, String interpret) {
        super(titel, jahr);
        this.dauer = dauer;
        this.interpret = interpret;
    }

    public String getInterpret() {
        return interpret;
    }

    public int getDauer() {
        return dauer;
    }

    
    @Override
    public void druckeDaten() {
        System.out.printf("ID: %d | Titel: %s | Interpret: %s | Jahr: %d | Dauer: %d | Alter: %s Jahre\n", super.getId(), super.getTitel(), getInterpret(), super.getJahr(), getDauer(), alter());
    }
    
    @Override
    public void druckeDatenOs(OutputStream os){
        PrintStream ps = new PrintStream(os);
        ps.printf("ID: %d | Titel: %s | Interpret: %s | Jahr: %d | Dauer: %d | Alter: %s Jahre\n", super.getId(), super.getTitel(), getInterpret(), super.getJahr(), getDauer(), alter());
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof Audio)) return false;
        if (!super.equals(o)) return false;
        Audio audio = (Audio) o;
        return getDauer() == audio.getDauer() && getInterpret().equals(audio.getInterpret());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getInterpret(), getDauer());
    }
}
