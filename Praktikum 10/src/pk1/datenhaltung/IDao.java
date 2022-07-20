package pk1.datenhaltung;

import java.util.List;
import pk1.medienverwaltung.*;

public interface IDao {
    void medienlisteSpeichern(List<Medium> liste) throws PersistenzException;
    List<Medium> medienlisteLaden() throws PersistenzException;
}
