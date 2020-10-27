package tp.acecs2103.model.task;

import static java.util.Objects.requireNonNull;
import static tp.acecs2103.commons.util.AppUtil.checkArgument;

import javax.xml.validation.Validator;

import tp.acecs2103.ui.WeekDisplay;

/**
 * Represents which week a Task falls under in the task manager.
 * Guarantees: immutable; is valid as declaredi n {@link #isValidWeekNumber(String)}
 * TODO: Check parser and all for parsing of string and integers
 */
public class WeekNumber {

    public static final String MESSAGE_CONSTRAINTS =
            "Week numbers should only contain numbers, and be between 1 to 13.";

    public final String value;

    /**
     * Constructs a {@code WeekNumber}.
     *
     * @param weekNumber A valid week number.
     */
    public WeekNumber(String weekNumber) {
        requireNonNull(weekNumber);
        checkArgument(isValidWeekNumber(weekNumber), MESSAGE_CONSTRAINTS);
        value = weekNumber;
    }

    public static boolean isValidWeekNumber(String test) {
        int weekNumberInteger = Integer.parseInt(test);
        return weekNumberInteger >= 1 && weekNumberInteger <= 13;
    }

    public int getWeekValueInt() {
        return Integer.parseInt(value);
    }
    
//    public boolean weekNumberEqual(WeekNumber weekNumber) {
//        return this.value.equals(weekNumber.getWeekValueInt());
//    }
    
    
    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this
                || (other instanceof WeekNumber
                && value.equals(((WeekNumber) other).value));
    }

    // TODO: check if hashCode needed
}
