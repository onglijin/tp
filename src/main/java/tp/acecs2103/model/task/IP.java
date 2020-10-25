package tp.acecs2103.model.task;

import java.time.LocalDate;

/**
 * Represents a IP task.
 */
public class IP extends Task {
    /**
     * Creates a {@code IP} task.
     */
    public IP(String index, int weekNumber,
              String description, LocalDate officialDeadline, LocalDate customizedDeadline,
              String remark, boolean customized) {
        super(index, weekNumber, description, officialDeadline, customizedDeadline,
                remark, customized);
    }

    @Override
    public TaskCategory getCategory() {
        return TaskCategory.IP;
    }
}
