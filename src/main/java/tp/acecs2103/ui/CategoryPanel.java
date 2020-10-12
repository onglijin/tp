package tp.acecs2103.ui;

import java.util.logging.Logger;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.Region;
import tp.acecs2103.commons.core.LogsCenter;
import tp.acecs2103.model.task.Task;

/**
 * Panel containing the list of tasks for each category.
 */
public class CategoryPanel extends UiPart<Region> {
    private static final String FXML = "CategoryPanel.fxml";
    private final Logger logger = LogsCenter.getLogger(CategoryPanel.class);

    @FXML
    private ListView<Task> categoryView;

    /**
     * Creates a {@code CategoryPanel} with the given {@code ObservableList}.
     */
    public CategoryPanel(ObservableList<Task> taskList) {
        super(FXML);
        categoryView.setItems(taskList);
        categoryView.setCellFactory(listView -> new CategoryCell());
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
