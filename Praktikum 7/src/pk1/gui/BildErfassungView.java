package pk1.gui;

import javafx.stage.Modality;
import javafx.stage.Stage;
import pk1.medienverwaltung.Bild;

public class BildErfassungView extends Stage {

    private Bild bild;

    public BildErfassungView(Bild bild, Stage primaryStage) {
        this.bild = bild;
        this.initOwner(primaryStage);
        this.initModality(Modality.WINDOW_MODAL);
    }

    public void showView() {
        this.showAndWait();
    }
}
