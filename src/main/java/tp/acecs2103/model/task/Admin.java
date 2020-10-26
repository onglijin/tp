package tp.acecs2103.model.task;

import java.time.LocalDate;

public class Admin extends Task {

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
