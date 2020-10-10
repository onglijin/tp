package seedu.address.model;

import java.time.LocalDate;

import seedu.address.commons.util.CollectionUtil;

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

    /**
     * Creates a task object.
     * @param index index of a task.
     * @param weekNumber weekNumber of a task.
     * @param description description of a task.
     * @param officialDeadline officialDeadline of a task.
     * @param customizedDeadline customizedDeadline officialDeadline of a task.
     * @param remark remark of a task.
     */
    public Task(String index, int weekNumber, String description, LocalDate officialDeadline,
                LocalDate customizedDeadline, String remark) {
        CollectionUtil.requireAllNonNull(index, weekNumber, description);
        this.index = index;
        this.weekNumber = weekNumber;
        this.description = description;
        this.officialDeadline = officialDeadline;
        this.customizedDeadline = customizedDeadline;
        this.remark = remark;
    }

    public String getIndex() {
        return index;
    }

    public int getWeekNumber() {
        return weekNumber;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getOfficialDeadline() {
        return officialDeadline;
    }

    public LocalDate getCustomizedDeadline() {
        return customizedDeadline;
    }

    public String getRemark() {
        return remark;
    }

    public TaskCategory getCategory() {
        return TaskCategory.TASK;
    }

    public boolean hasIndex(String taskIndex) {
        return this.index == taskIndex;
    }

    public boolean hasDeadline() {
        return customizedDeadline != null;
    }

    public void setDeadline(LocalDate deadline) {
        customizedDeadline = deadline;
    }

    public boolean isWeekX(int weekIndex) {
        return weekIndex == weekNumber;
    }

    public boolean contains(String keyword) {
        return description.contains(keyword) || remark.contains(keyword);
    }
}
