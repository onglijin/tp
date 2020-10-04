package tp.acecs2103.model.task;

import java.time.LocalDate;

public class Topic extends Task{
    public Topic(String index, int weekNumber, String description, LocalDate officialDeadline, LocalDate customizedDeadline, String remark) {
        super(index, weekNumber, description, officialDeadline, customizedDeadline, remark);
    }
}
