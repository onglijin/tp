package tp.acecs2103.model.task;

import java.time.LocalDate;

/**
 * Represents a Admin task.
 */
public class Admin extends Task {

     /**
     * Creates a {@code Admin} task.
     */
    public Admin(Index index, WeekNumber weekNumber, Description description,
                 OfficialDeadline officialDeadline,
                 CustomizedDeadline customizedDeadline, Remark remark) {
        super(index, weekNumber, description, officialDeadline, customizedDeadline, remark);
    }

    @Override
    public TaskCategory getCategory() {
        return TaskCategory.ADMIN;
    }
}
