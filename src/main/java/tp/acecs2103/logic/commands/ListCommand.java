package tp.acecs2103.logic.commands;

import static java.util.Objects.requireNonNull;

import tp.acecs2103.model.Model;
import tp.acecs2103.model.task.WeekNumber;

/**
 * Lists all persons in the address book to the user.
 */
public class ListCommand extends Command {

    public static final String COMMAND_WORD = "list";

    public static final String MESSAGE_SUCCESS = "Listed all tasks for week";

    private final WeekNumber weekNumber;

    /**
     * Creates a {@code ListCommand} with given Week number.
     */
    public ListCommand(WeekNumber weekNumber) {
        requireNonNull(weekNumber);
        this.weekNumber = weekNumber;
    }


    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.listTasks(weekNumber);
        return new CommandResult(MESSAGE_SUCCESS + this.weekNumber.value);
    }
}
