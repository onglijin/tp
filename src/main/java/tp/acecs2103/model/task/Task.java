package tp.acecs2103.model.task;

import java.time.LocalDate;

import tp.acecs2103.commons.util.CollectionUtil;

/**
 * Represents a general task in Ace CS2103/T.
 */
public class Task {
    private String index;
    private int weekNumber;
    private String description;
    private LocalDate officialDeadline;
    private LocalDate customizedDeadline;
    private String remark;
    private TaskCategory category;

    /**
     * Creates a {@code Task} with given details.
     */
    public Task(String index, int weekNumber,
                String description, LocalDate officialDeadline, LocalDate customizedDeadline, String remark) {
        CollectionUtil.requireAllNonNull(index, weekNumber, description);
        this.index = index;
        this.weekNumber = weekNumber;
        this.description = description;
        this.officialDeadline = officialDeadline;
        this.customizedDeadline = customizedDeadline;
        this.remark = remark;
        this.category = TaskCategory.TASK;
    }

    /**
     * Gets the task index.
     */
    public String getIndex() {
        return index;
    }

    /**
     * Gets the week number.
     */
    public int getWeekNumber() {
        return weekNumber;
    }

    /**
     * Gets the task description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets the official deadline of task.
     */
    public LocalDate getOfficialDeadline() {
        return officialDeadline;
    }

    /**
     * Gets the customized deadline of task.
     */
    public LocalDate getCustomizedDeadline() {
        return customizedDeadline;
    }

    /**
     * Gets the remark of the task.
     */
    public String getRemark() {
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
    public boolean hasIndex(String taskIndex) {
        return this.index == taskIndex;
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
    public void setDeadline(LocalDate deadline) {
        customizedDeadline = deadline;
    }

    /**
     * Check whether the task is in week {@code weekIndex}.
     */
    public boolean isWeekX(int weekIndex) {
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
