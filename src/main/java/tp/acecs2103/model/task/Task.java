package tp.acecs2103.model.task;

import java.time.LocalDate;
import java.util.logging.Logger;

import tp.acecs2103.commons.core.LogsCenter;
import tp.acecs2103.commons.util.CollectionUtil;

/**
 * Represents a general task in Ace CS2103/T.
 */
public class Task {
    private static final Logger logger = LogsCenter.getLogger(Task.class);

    private Index index;
    private WeekNumber weekNumber;
    private Description description;
    private OfficialDeadline officialDeadline;
    private CustomizedDeadline customizedDeadline;
    private Remark remark;
    private TaskCategory category;

    /**
     * Creates a {@code Task} with given details.
     */
    public Task(Index index, WeekNumber weekNumber,
                Description description, OfficialDeadline officialDeadline,
                CustomizedDeadline customizedDeadline, Remark remark) {
        CollectionUtil.requireAllNonNull(index, weekNumber, description, officialDeadline);
        this.index = index;
        this.weekNumber = weekNumber;
        this.description = description;
        this.officialDeadline = officialDeadline;
        this.customizedDeadline = customizedDeadline;
        this.remark = remark;
        this.category = TaskCategory.TASK;
    }

    /**
     * Creates a {@code Task} with given details.
     */
    public Task(Index index, WeekNumber weekNumber, Description description,
                OfficialDeadline officialDeadline, CustomizedDeadline customizedDeadline,
                Remark remark, TaskCategory taskCategory) {
        CollectionUtil.requireAllNonNull(index, weekNumber, description, officialDeadline);
        this.index = index;
        this.weekNumber = weekNumber;
        this.description = description;
        this.officialDeadline = officialDeadline;
        this.customizedDeadline = customizedDeadline;
        this.remark = remark;
        this.category = taskCategory;
    }

    /**
     * Gets the task index.
     */
    public Index getIndex() {
        return index;
    }

    /**
     * Gets the week number.
     */
    public WeekNumber getWeekNumber() {
        return weekNumber;
    }

    /**
     * Gets the task description.
     */
    public Description getDescription() {
        return description;
    }

    /**
     * Gets the official deadline of task.
     */
    public OfficialDeadline getOfficialDeadline() {
        return officialDeadline;
    }

    /**
     * Gets the customized deadline of task.
     */
    public CustomizedDeadline getCustomizedDeadline() {
        return customizedDeadline;
    }

    /**
     * Gets the remark of the task.
     */
    public Remark getRemark() {
        return remark;
    }

    /**
     * Gets the category of the task.
     */
    public TaskCategory getCategory() {
        return this.category;
    }

    /**
     * Checks whether the task has index {@code taskIndex}
     */
    public boolean hasIndex(Index taskIndex) {
        return this.index.equals(taskIndex);
    }

    /**
     * Checks whether the task has customized deadline.
     */
    public boolean hasDeadline() {
        return customizedDeadline != null;
    }

    /**
     * Sets a deadline to the task.
     * @param deadline A valid LocalDate.
     */
    public void setDeadline(CustomizedDeadline deadline) {
        assert deadline != null;
        customizedDeadline = deadline;
    }

    /**
     * Check whether the task is in week {@code weekIndex}.
     */
    public boolean isWeekX(WeekNumber weekIndex) {
        return weekIndex == weekNumber;
    }

    /**
     * Checks whether the description and remark of task contains certain key word.
     */
    public boolean contains(String keyword) {
        return description.contains(keyword) || remark.contains(keyword);
    }

    /**
     * Checks whether the task is same task as {@code task}.
     */
    public boolean isSameTask(Task task) {
        return index.equals(task.getIndex());
    }
}
