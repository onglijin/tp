package seedu.address.ui;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Region;

/**
 * A ui for the week window.
 */
public class WeekWindow extends UiPart<Region> {

    private static final String FXML = "WeekWindow.fxml";

    @FXML
    private TextArea resultDisplay;

    public WeekWindow() {
        super(FXML);
    }
}
