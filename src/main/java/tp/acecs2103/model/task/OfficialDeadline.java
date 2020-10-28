package tp.acecs2103.model.task;

<<<<<<< HEAD
import java.time.LocalDate;
=======
import static tp.acecs2103.commons.util.AppUtil.checkArgument;

import java.util.logging.Logger;

import tp.acecs2103.AppParameters;
import tp.acecs2103.commons.core.LogsCenter;


/**
 * Represents a Task's official deadline in the task manager.
 * Guarantees: is valid as declared in {@link #isValidDeadline(String)}
 */

public class OfficialDeadline extends Deadline {


    /**
     * Constructs an {@code OfficialDeadline}.
     *
     * @param officialDeadline A valid official deadline in String form.
     * @param timeInfo A valid official deadline in LocalTime form.
     */
    public OfficialDeadline(String officialDeadline, LocalDate timeInfo) {
        super(officialDeadline, timeInfo);

    }

}
