package seedu.address.ui;

import java.time.LocalDate;
import java.util.Comparator;  //not sure will need it

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import seedu.address.model.Task;

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
