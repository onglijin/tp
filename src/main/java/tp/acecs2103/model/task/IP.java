package tp.acecs2103.model.task;

import java.time.LocalDate;

/**
 * Represents a IP task.
 */
public class IP extends Task {
  
     /**
     * Creates a {@code IP} task.
     */
    public IP(Index index, WeekNumber weekNumber,
              Description description, OfficialDeadline officialDeadline,
              CustomizedDeadline customizedDeadline, Remark remark) {
        super(index, weekNumber, description, officialDeadline, customizedDeadline, remark);
    }

    @Override
    public TaskCategory getCategory() {
        return TaskCategory.IP;
    }
}
