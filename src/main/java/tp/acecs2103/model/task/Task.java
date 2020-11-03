package tp.acecs2103.model.task;

import java.time.LocalDate;
import java.util.logging.Logger;

import tp.acecs2103.commons.core.LogsCenter;
import tp.acecs2103.commons.util.CollectionUtil;
import tp.acecs2103.logic.commands.exceptions.CommandException;

/**
 * Represents a general task in Ace CS2103/T.
 */
public class Task implements Comparable<Task> {
    private static final Logger logger = LogsCenter.getLogger(Task.class);

    private Index index;
    private WeekNumber weekNumber;
    private Description description;
    private OfficialDeadline officialDeadline;
    private CustomizedDeadline customizedDeadline;
    private Remark remark;
    private TaskCategory category;
    private boolean customized;
    private boolean doneStatus;

    /**
     * Creates a {@code Task} with given details.
     */
    public Task(Index index, WeekNumber weekNumber,
                Description description, OfficialDeadline officialDeadline,
                CustomizedDeadline customizedDeadline, Remark remark, boolean customized,
                boolean doneStatus) {
        CollectionUtil.requireAllNonNull(index, weekNumber, description);
        this.index = index;
        this.weekNumber = weekNumber;
        this.description = description;
        this.officialDeadline = officialDeadline;
        this.customizedDeadline = customizedDeadline;
        this.remark = remark;
        this.category = TaskCategory.TASK;
        this.customized = customized;
        this.doneStatus = doneStatus;
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
        if (this instanceof IP) {
            return TaskCategory.IP;
        } else if (this instanceof TP) {
            return TaskCategory.TP;
        } else if (this instanceof Topic) {
            return TaskCategory.TOPIC;
        } else {
            return TaskCategory.ADMIN;
        }
    }

    /**
     * Checks whether the task is customized.
     */
    public boolean isCustomized() {
        return this.customized;
    }

    /**
     * Checks whether the task is done
     */
    public boolean isDone() {
        return this.doneStatus;
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
     * Mark the task as done.
     */
    public void markAsDone() {
        assert !doneStatus;
        doneStatus = true;
    }

    /**
     * Mark the task as pending (i.e. not done yet).
     */
    public void markAsPending() {
        assert doneStatus;
        doneStatus = false;
    }

    /**
     * Sets a deadline to the task.
     * @param deadline A valid LocalDate.
     */
    public void setDeadline(CustomizedDeadline deadline) throws CommandException {
        assert deadline != null;
        if (deadline.compareTo(this.officialDeadline) > 0) {
            throw new CommandException("Customised deadline should not be later than official deadline. " +
                    "Please set the customised deadline to a date before or on: " +
                    this.officialDeadline);
        }
        customizedDeadline = deadline;
    }

    /**
     * Check whether the task a valid task, aka if the official deadline is correctly set to null for a customised task.
     */
    public boolean isValid() {
        return isCustomized() == (officialDeadline == null);
    }

    /**
     * Check whether the task is in week {@code weekIndex}.
     */
    public boolean isWeekX(WeekNumber weekIndex) {
        return weekNumber.equals(weekIndex);
    }

    /**
     * Checks whether the description and remark of task contains certain key word.
     */
    public boolean contains(String keyword) {
        keyword = keyword.toLowerCase();

        if (description == null && remark != null) {
            return remark.value.toLowerCase().contains(keyword);
        } else if (description != null && remark == null) {
            return description.value.toLowerCase().contains(keyword);
        } else if (description == null && remark == null) {
            return false;
        }
        return description.value.toLowerCase().contains(keyword)
                || remark.value.toLowerCase().contains(keyword);

    }

    /**
     * Checks whether the task is same task as {@code task}.
     */
    public boolean isSameTask(Task task) {
        return index.equals(task.getIndex());
    }

    /**
     * Checks is a task if overdue (i.e. passed ddl but have not done yet )
     */
    public boolean isOverdue() {
        if (getOfficialDeadline() != null && getOfficialDeadline().getTimeInfo() != null) {
            return getOfficialDeadline().getTimeInfo().compareTo(LocalDate.now()) < 0;
        } else if (getCustomizedDeadline() != null && getCustomizedDeadline().getTimeInfo() != null) {
            return getCustomizedDeadline().getTimeInfo().compareTo(LocalDate.now()) < 0;
        } else {
            return false;
        }
    }

    @Override
    public int compareTo(Task o) {
        return getOfficialDeadline().compareTo(o.getOfficialDeadline());
    }

    public boolean equals(Task o) {
        return this.getIndex().equals(o.getIndex());
    }

    @Override
    public String toString() {
        String returnString = "[Week " + this.getWeekNumber().value + "] " + this.getCategory() + " Task "
                              + this.getIndex().value + " with description: " + this.getDescription().value;
        if (officialDeadline != null) {
            returnString += "\nOfficial deadline: " + officialDeadline.value;
        }
        if (customizedDeadline != null) {
            returnString += "\nCustomized deadline: " + customizedDeadline.value;
        }
        if (remark != null) {
            returnString += "\nRemark: " + remark.value;
        }
        return returnString;
    }
}
