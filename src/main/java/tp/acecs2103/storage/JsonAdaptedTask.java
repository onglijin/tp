package tp.acecs2103.storage;

import java.time.LocalDate;
import java.util.logging.Logger;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import tp.acecs2103.commons.core.LogsCenter;
import tp.acecs2103.commons.exceptions.IllegalValueException;
import tp.acecs2103.model.task.Admin;
import tp.acecs2103.model.task.CustomizedDeadline;
import tp.acecs2103.model.task.Description;
import tp.acecs2103.model.task.IP;
import tp.acecs2103.model.task.Index;
import tp.acecs2103.model.task.OfficialDeadline;
import tp.acecs2103.model.task.Remark;
import tp.acecs2103.model.task.TP;
import tp.acecs2103.model.task.Task;
import tp.acecs2103.model.task.TaskCategory;
import tp.acecs2103.model.task.Topic;
import tp.acecs2103.model.task.WeekNumber;


/**
 * Jackson-friendly version of {@link Task}.
 */
class JsonAdaptedTask {

    public static final String MISSING_FIELD_MESSAGE_FORMAT = "Task's %s field is missing!";
    private static final Logger logger = LogsCenter.getLogger(JsonAdaptedTask.class);

    private String index;
    private String weekNumber;
    private String description;
    private String officialDeadline;
    private String customizedDeadline;
    private String remark;
    private String category;
    private String customized;
    private String doneStatus;

    /**
     * Constructs a {@code JsonAdaptedTask} with the given person details.
     */
    @JsonCreator
    public JsonAdaptedTask(@JsonProperty("index") String index,
                           @JsonProperty("weekNumber") String weekNumber,
                           @JsonProperty("description") String description,
                           @JsonProperty("officialDeadline") String officialDeadline,
                           @JsonProperty("customizedDeadline") String customizedDeadline,
                           @JsonProperty("remark") String remark,
                           @JsonProperty("category") String category,
                           @JsonProperty("customized") String customized,
                           @JsonProperty("doneStatus") String doneStatus) {
        this.index = index;
        this.weekNumber = weekNumber;
        this.description = description;
        this.officialDeadline = officialDeadline;
        this.customizedDeadline = customizedDeadline;
        this.remark = remark;
        this.category = category;
        this.customized = customized;
        this.doneStatus = doneStatus;
    }

    /**
     * Converts a given {@code Task} into this class for Jackson use.
     */
    public JsonAdaptedTask(Task task) {
        index = task.getIndex().value;
        weekNumber = task.getWeekNumber().value;
        description = task.getDescription().value;
        if (task.getOfficialDeadline() != null) {
            officialDeadline = task.getOfficialDeadline().value;
        } else {
            officialDeadline = null;
        }
        if (task.getCustomizedDeadline() != null) {
            customizedDeadline = task.getCustomizedDeadline().value;
            customizedDeadline = null;
        }
        if (task.getRemark() != null) {
            remark = task.getRemark().value;
        } else {
            remark = null;
        }
        category = TaskCategory.categoryToString(task.getCategory());
        if (task.isCustomized()) {
            customized = "true";
        } else {
            customized = "false";
        }
        if (task.isDone()) {
            doneStatus = "true";
        } else {
            doneStatus = "false";
        }
    }

    /**
     * Converts this Jackson-friendly adapted person object into the model's {@code Task} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted task.
     */
    public Task toModelType() throws IllegalValueException {

        if (index == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, "index"));
        }
        if (weekNumber == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, "weekNumber"));
        }
        if (description == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, "description"));
        }

        boolean isCustomized;
        if (customized.equals("true")) {
            isCustomized = true;
        } else {
            isCustomized = false;
        }

        boolean isDone;
        if (doneStatus.equals("true")) {
            isDone = true;
        } else {
            isDone = false;
        }

        OfficialDeadline officialddl;
        if (officialDeadline == null) {
            officialddl = null;
        } else {
            officialddl = new OfficialDeadline(officialDeadline, LocalDate.parse(officialDeadline));
        }

        CustomizedDeadline customizedddl;
        if (customizedDeadline == null) {
            customizedddl = null;
        } else {
            customizedddl = new CustomizedDeadline(customizedDeadline, LocalDate.parse(customizedDeadline));
        }

        if (TaskCategory.isStringAdmin(category)) {
            return new Admin(new Index(index), new WeekNumber(weekNumber), new Description(description),
                    officialddl, customizedddl,
                    new Remark(remark), isCustomized, isDone);
        }

        if (TaskCategory.isStringTopic(category)) {
            return new Topic(new Index(index), new WeekNumber(weekNumber), new Description(description),
                    officialddl, customizedddl,
                    new Remark(remark), isCustomized, isDone);
        }

        if (TaskCategory.isStringIP(category)) {
            return new IP(new Index(index), new WeekNumber(weekNumber), new Description(description),
                    officialddl, customizedddl,
                    new Remark(remark), isCustomized, isDone);
        }

        if (TaskCategory.isStringTP(category)) {
            return new TP(new Index(index), new WeekNumber(weekNumber), new Description(description),
                    officialddl, customizedddl,
                    new Remark(remark), isCustomized, isDone);
        }

        return new Task(new Index(index), new WeekNumber(weekNumber), new Description(description),
                officialddl, customizedddl,
                new Remark(remark), true, isDone);
    }

    public LocalDate parseDeadline(String deadline) {
        if (deadline == null) {
            return null;
        } else {
            return LocalDate.parse(deadline);
        }
    }

}

