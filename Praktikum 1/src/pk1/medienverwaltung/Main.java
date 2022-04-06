package pk1.medienverwaltung;

public class Main {

    public static void main(String[] args) {
        Audio a1 = new Audio("Everybody wants to rule the world", 2020, 239, "Tears of Fears");
        Bild b1 = new Bild("Fachbereich Informatik", 2016, "Dortmund");

        a1.druckeDaten();
        b1.druckeDaten();
        System.out.println(a1.hashCode());
        System.out.println(a1.equals(a2));
    }
}
