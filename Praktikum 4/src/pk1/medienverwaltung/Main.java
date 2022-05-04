package pk1.medienverwaltung;

public class Main {

    public static void main(String[] args) {

        Medienverwaltung mv = new Medienverwaltung();

        Audio a1 = new Audio("Everybody wants to rule the world", 2020, 239, "Tears of Fears");
        Bild b1 = new Bild("Fachbereich Informatik", 1999, "Dortmund");

        mv.aufnehmen(a1);
        mv.aufnehmen(b1);
        mv.zeigeMedien();
        mv.sucheNeuesMedium();
        mv.berechneErscheinungsjahr();

    }
}
