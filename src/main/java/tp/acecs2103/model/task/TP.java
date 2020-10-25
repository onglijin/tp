package tp.acecs2103.model.task;

import java.time.LocalDate;

/**
 * Represents a TP task.
 */
public class TP extends Task {

    /**
     * Creates a {@code TP} task.
     */
    public TP(String index, int weekNumber,
              String description, LocalDate officialDeadline, LocalDate customizedDeadline,
              String remark, boolean customized) {
        super(index, weekNumber, description, officialDeadline, customizedDeadline,
                remark, customized);
    }

    @Override
    public TaskCategory getCategory() {
        return TaskCategory.TP;
    }
}
