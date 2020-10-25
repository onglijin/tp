package tp.acecs2103.storage;

import java.time.LocalDate;
import java.util.logging.Logger;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import tp.acecs2103.commons.core.LogsCenter;
import tp.acecs2103.commons.exceptions.IllegalValueException;
import tp.acecs2103.model.task.Admin;
import tp.acecs2103.model.task.IP;
import tp.acecs2103.model.task.TP;
import tp.acecs2103.model.task.Task;
import tp.acecs2103.model.task.TaskCategory;
import tp.acecs2103.model.task.Topic;



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

    /**
     * Constructs a {@code JsonAdaptedPerson} with the given person details.
     */
    @JsonCreator
    public JsonAdaptedTask(@JsonProperty("index") String index,
                           @JsonProperty("weekNumber") String weekNumber,
                           @JsonProperty("description") String description,
                           @JsonProperty("officialDeadline") String officialDeadline,
                           @JsonProperty("customizedDeadline") String customizedDeadline,
                           @JsonProperty("remark") String remark,
                           @JsonProperty("category") String category,
                           @JsonProperty("customized") String customized) {
        this.index = index;
        this.weekNumber = weekNumber;
        this.description = description;
        this.officialDeadline = officialDeadline;
        this.customizedDeadline = customizedDeadline;
        this.remark = remark;
        this.category = category;
        this.customized = customized;
    }

    /**
     * Converts a given {@code Task} into this class for Jackson use.
     */
    public JsonAdaptedTask(Task task) {
        index = task.getIndex();
        weekNumber = Integer.toString(task.getWeekNumber());
        description = task.getDescription();
        if (task.getOfficialDeadline() != null) {
            officialDeadline = task.getOfficialDeadline().toString();
        } else {
            officialDeadline = null;
        }
        if (task.getCustomizedDeadline() != null) {
            customizedDeadline = task.getCustomizedDeadline().toString();
        } else {
            customizedDeadline = null;
        }
        if (task.getRemark() != null) {
            remark = task.getRemark();
        } else {
            remark = null;
        }
        category = TaskCategory.categoryToString(task.getCategory());
        if (task.isCustomized()) {
            customized = "true";
        } else {
            customized = "false";
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

        if (TaskCategory.isStringAdmin(category)) {
            return new Admin(index, Integer.parseInt(weekNumber), description,
                    parseDeadline(officialDeadline), parseDeadline(customizedDeadline),
                    remark, isCustomized);
        }

        if (TaskCategory.isStringTopic(category)) {
            return new Topic(index, Integer.parseInt(weekNumber), description,
                    parseDeadline(officialDeadline), parseDeadline(customizedDeadline),
                    remark, isCustomized);
        }

        if (TaskCategory.isStringIP(category)) {
            return new IP(index, Integer.parseInt(weekNumber), description,
                    parseDeadline(officialDeadline), parseDeadline(customizedDeadline),
                    remark, isCustomized);
        }

        if (TaskCategory.isStringTP(category)) {
            return new TP(index, Integer.parseInt(weekNumber), description,
                    parseDeadline(officialDeadline), parseDeadline(customizedDeadline),
                    remark, isCustomized);
        }

        return new Task(index, Integer.parseInt(weekNumber), description,
                parseDeadline(officialDeadline), parseDeadline(customizedDeadline),
                remark, isCustomized);
    }

    public LocalDate parseDeadline(String deadline) {
        if (deadline == null) {
            return null;
        } else {
            return LocalDate.parse(deadline);
        }
    }

}

