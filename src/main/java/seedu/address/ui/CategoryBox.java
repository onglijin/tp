package seedu.address.ui;

import java.time.LocalDate;
import java.util.Comparator;  //not sure will need it

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import seedu.address.model.TaskCategory;

public class CategoryBox extends UiPart<Region> {
    private static final String FXML = "CategoryBox.fxml";

    @FXML
    private HBox cardPane;
    @FXML
    private Label category;

    public CategoryBox(TaskCategory description) {
        super(FXML);
        category.setText(description.categoryToString(description));
    }
}
