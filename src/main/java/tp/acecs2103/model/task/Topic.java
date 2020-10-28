package tp.acecs2103.model.task;

public class Topic extends Task {
    public Topic(Index index, WeekNumber weekNumber,
                 Description description, OfficialDeadline officialDeadline,
                 CustomizedDeadline customizedDeadline, Remark remark, boolean isCustomized) {
        super(index, weekNumber, description, officialDeadline, customizedDeadline, remark, isCustomized);
    }

    @Override
    public TaskCategory getCategory() {
        return TaskCategory.TOPIC;
    }
}
