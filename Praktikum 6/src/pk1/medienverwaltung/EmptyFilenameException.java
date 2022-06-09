package pk1.medienverwaltung;

public class EmptyFilenameException extends Exception {
    public EmptyFilenameException(){
        super();
    }

    public EmptyFilenameException(String message){
        super(message);
    }
}
