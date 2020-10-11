package tp.acecs2103.ui;

//import java.time.LocalDate;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import tp.acecs2103.model.task.TaskCategory;

public class CategoryBox extends UiPart<Region> {
    private static final String FXML = "CategoryBox.fxml";

    @FXML
    private HBox cardPane;
    @FXML
    private Label category;

    /**
     * Creates a CategoryBox object.
     * @param description is a category.
     */
    public CategoryBox(TaskCategory description) {
        super(FXML);
        category.setText(description.categoryToString(description));
    }
}
