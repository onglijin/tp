package tp.acecs2103.ui;

import java.util.logging.Logger;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.Region;
import tp.acecs2103.commons.core.LogsCenter;
import tp.acecs2103.model.task.Task;

/**
 * Encapsulates a panel containing the list of tasks for a specific category.
 */
public class CategoryPanel extends UiPart<Region> {
    private static final String FXML = "CategoryPanel.fxml";
    private final Logger logger = LogsCenter.getLogger(CategoryPanel.class);

    @FXML
    private ListView<Task> categoryView;
    @FXML
    private Label categoryLabel;

    /**
     * Creates a {@code CategoryPanel} with the given {@code ObservableList} and {@code categoryString}.
     */
    public CategoryPanel(ObservableList<Task> taskList, String categoryString) {
        super(FXML);
        categoryLabel.setText(categoryString);
        categoryView.setItems(taskList);
        logger.info("1");
        categoryView.setCellFactory(listView -> new CategoryCell());
        logger.info("2");
    }

    /**
     * Custom {@code CategoryCell} that displays the graphics of a {@code Task} using a {@code TaskBox}.
     */
    class CategoryCell extends ListCell<Task> {
        @Override
        protected void updateItem(Task task, boolean empty) {
            super.updateItem(task, empty);

            if (empty || task == null) {
                setGraphic(null);
                setText(null);
            } else {
                setGraphic(new TaskBox(task).getRoot());

            }
        }
    }

}
