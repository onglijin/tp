package tp.acecs2103.ui;

//import java.time.LocalDate;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import tp.acecs2103.model.task.Task;

public class TaskBox extends UiPart<Region> {
    private static final String FXML = "TaskBox.fxml";
    public final Task task;

    @FXML
    private HBox cardPane;
    @FXML
    private Label index;
    @FXML
    private Label weekNumber;
    @FXML
    private Label description;
    @FXML
    private Label officialDeadline;
    @FXML
    private Label customizedDeadline;
    @FXML
    private Label remark;

    /**
     * Creates a TaskBox object.
     * @param task is a task object.
     */
    public TaskBox(Task task) {
        super(FXML);
        this.task = task;
        index.setText(task.getIndex());
        weekNumber.setText(Integer.toString(task.getWeekNumber()));
        description.setText(task.getDescription());
        officialDeadline.setText(task.getOfficialDeadline().toString());
        customizedDeadline.setText(task.getCustomizedDeadline().toString());
        remark.setText(task.getRemark());
    }
}
