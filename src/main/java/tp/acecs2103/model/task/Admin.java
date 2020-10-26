package tp.acecs2103.model.task;

import java.time.LocalDate;

/**
 * Represents a Admin task.
 */
public class Admin extends Task {

    /**
     * Creates a {@code Admin} task.
     */
    public Admin(String index, int weekNumber, String description,
                 LocalDate officialDeadline, LocalDate customizedDeadline,
                 String remark, boolean customized) {
        super(index, weekNumber, description, officialDeadline, customizedDeadline,
                remark, customized);
    }

    @Override
    public TaskCategory getCategory() {
        return TaskCategory.ADMIN;
    }
}
