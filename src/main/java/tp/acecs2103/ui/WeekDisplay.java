package tp.acecs2103.ui;


import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;

/**
 * A ui for the week display that is displayed at the top of the application.
 */
public class WeekDisplay extends UiPart<Region> {
    private static final String FXML = "WeekDisplay.fxml";

    @FXML
    private Label weekNumberAndDate;

    /**
     * Creates a {@code WeekDisplay} with the given {@code Path}.
     */
    // TODO: Connect method to weekToDisplay
    public WeekDisplay(String weekToDisplay) {
        super(FXML);
        weekNumberAndDate.setText(weekToDisplay);
    }
}
