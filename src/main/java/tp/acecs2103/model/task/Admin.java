package tp.acecs2103.model.task;

import java.time.LocalDate;

public class Admin extends Task {

    public Admin(String index, int weekNumber, String description,
                 LocalDate officialDeadline, LocalDate customizedDeadline, String remark) {
        super(index, weekNumber, description, officialDeadline, customizedDeadline, remark);
    }

    @Override
    public TaskCategory getCategory() {
        return TaskCategory.ADMIN;
    }
}
