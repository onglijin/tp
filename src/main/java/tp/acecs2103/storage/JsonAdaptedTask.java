package tp.acecs2103.storage;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import tp.acecs2103.commons.exceptions.IllegalValueException;
import tp.acecs2103.model.task.*;

import java.time.LocalDate;

/**
 * Jackson-friendly version of {@link Task}.
 */
class JsonAdaptedTask {

    public static final String MISSING_FIELD_MESSAGE_FORMAT = "Task's %s field is missing!";

    private String index;
    private String weekNumber;
    private String description;
    private String officialDeadline;
    private String customizedDeadline;
    private String remark;
    private String category;

    /**
     * Constructs a {@code JsonAdaptedPerson} with the given person details.
     */
    @JsonCreator
    public JsonAdaptedTask(@JsonProperty("index") String index, @JsonProperty("weekNumber") String weekNumber,
                           @JsonProperty("description") String description, @JsonProperty("officialDeadline") String officialDeadline,
                           @JsonProperty("customizedDeadline") String customizedDeadline, @JsonProperty("remark") String remark,
                           @JsonProperty("category") String category) {
        this.index = index;
        this.weekNumber = weekNumber;
        this.description = description;
        this.officialDeadline = officialDeadline;
        this.customizedDeadline = customizedDeadline;
        this.remark = remark;
        this.category = category;
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

        if (TaskCategory.isAdmin(category)) {
            return new Admin(index, Integer.parseInt(weekNumber), description, parseDeadline(officialDeadline), parseDeadline(customizedDeadline), remark);
        }

        if (TaskCategory.isTopic(category)) {
            return new Topic(index, Integer.parseInt(weekNumber), description, parseDeadline(officialDeadline), parseDeadline(customizedDeadline), remark);
        }

        if (TaskCategory.isIP(category)) {
            return new IP(index, Integer.parseInt(weekNumber), description, parseDeadline(officialDeadline), parseDeadline(customizedDeadline), remark);
        }

        if (TaskCategory.isTP(category)) {
            return new TP(index, Integer.parseInt(weekNumber), description, parseDeadline(officialDeadline), parseDeadline(customizedDeadline), remark);
        }
    }

    public LocalDate parseDeadline(String deadline) {
        if (deadline == null) {
            return null;
        } else {
            return LocalDate.parse(deadline);
        }
    }

}

