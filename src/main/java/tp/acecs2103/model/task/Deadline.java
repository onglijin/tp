package tp.acecs2103.model.task;

import static java.util.Objects.requireNonNull;
import static tp.acecs2103.commons.util.AppUtil.checkArgument;

import java.time.LocalDate;
import java.util.logging.Logger;

import tp.acecs2103.AppParameters;
import tp.acecs2103.commons.core.LogsCenter;

public class Deadline {
    private static final Logger logger = LogsCenter.getLogger(AppParameters.class);
    public static final String MESSAGE_CONSTRAINTS =
            "Deadlines should be of the format of 'YYYY-MM-DD' and be consists of only numbers and '-'s. " +
                    "Range of dates is allowed from '2000-01-01' to '2099-12-31'";

    public static final String VALIDATION_REGEX = "^19|20\\d\\d[- /.](0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])$";

    public final String value;
    public final LocalDate timeInfo;

    /**
     * Constructs an {@code OfficialDeadline}.
     *
     * @param Deadline A valid official deadline.
     */
    public Deadline(String Deadline, LocalDate timeInfo) {
        if (Deadline != null) {
            checkArgument(isValidDeadline(Deadline), MESSAGE_CONSTRAINTS);
        }
        this.value =Deadline;
        this.timeInfo = timeInfo;
    }

    /**
     * Returns true if a given string is a valid official deadline.
     */
    public static boolean isValidDeadline(String test){
        return test.matches(VALIDATION_REGEX);
    }
    public boolean contains(String keyword) {
        return value.contains(keyword);
    }

    public LocalDate getTimeInfo(){
        return timeInfo;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this
                || (other instanceof WeekNumber
                && timeInfo.equals(((Deadline) other).timeInfo));
    }

    public int compareTo(Deadline Deadline) {
        return this.timeInfo.compareTo(Deadline.getTimeInfo());
    }
}
