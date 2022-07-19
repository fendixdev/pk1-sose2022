package pk1.gui;

import javafx.stage.Modality;
import javafx.stage.Stage;
import pk1.medienverwaltung.*;

public class AudioErfassungView extends Stage {

    private Audio audio;

    public AudioErfassungView(Audio audio, Stage primaryStage) {
        this.audio = audio;
        this.initOwner(primaryStage);
        this.initModality(Modality.WINDOW_MODAL);
    }

    public void showView() {
        this.showAndWait();
    }
}
