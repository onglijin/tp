package tp.acecs2103.model.task;

import static tp.acecs2103.commons.util.AppUtil.checkArgument;

/**
 * Represents a Task's official deadline in the task manager.
 * Guarantees: is valid as declared in {@link #isValidCustomizedDeadline(String)}
 */
public class CustomizedDeadline {

    public static final String MESSAGE_CONSTRAINTS =
            "Deadlines should be of the format of 'YYYY-MM-DD' and be consists of only numbers and '-'s. "
                    + "Range of dates is allowed from '2000-01-01' to '2099-12-31'";

    public static final String VALIDATION_REGEX = "^19|20\\d\\d[- /.](0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])$";

    public final String value;

    /**
     * Constructs an {@code CustomizedDeadline}.
     *
     * @param customizedDeadline A valid customized deadline.
     */
    public CustomizedDeadline(String customizedDeadline) {
        if (customizedDeadline != null) {
            checkArgument(isValidCustomizedDeadline(customizedDeadline), MESSAGE_CONSTRAINTS);
        }
        value = customizedDeadline;
    }

    /**
     * Returns true if a given string is a valid official deadline.
     */
    public static boolean isValidCustomizedDeadline(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    // TODO: Check whether need hashcode
}
