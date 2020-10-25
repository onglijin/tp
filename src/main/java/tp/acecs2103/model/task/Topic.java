package tp.acecs2103.model.task;

import java.time.LocalDate;

public class Topic extends Task {
    public Topic(String index, int weekNumber,
                 String description, LocalDate officialDeadline, LocalDate customizedDeadline,
                 String remark, boolean customized) {
        super(index, weekNumber, description, officialDeadline, customizedDeadline, remark, customized);
    }

    @Override
    public TaskCategory getCategory() {
        return TaskCategory.TOPIC;
    }
}
