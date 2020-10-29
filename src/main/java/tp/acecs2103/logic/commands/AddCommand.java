package tp.acecs2103.logic.commands;

import static java.util.Objects.requireNonNull;

import tp.acecs2103.logic.commands.exceptions.CommandException;
import tp.acecs2103.model.Model;
import tp.acecs2103.model.task.Task;

/**
 * Adds a person to the address book.
 */
public class AddCommand extends Command {

    public static final String COMMAND_WORD = "add";

    public static final String MESSAGE_USAGE = COMMAND_WORD;

    public static final String MESSAGE_SUCCESS = "New task added: \n%1$s";
    public static final String MESSAGE_DUPLICATE_TASK = "This task already exists in the task list";
    public static final String MESSAGE_INVALID_TASK = "A customised task should not have an official deadline";

    private final Task toAdd;

    /**
     * Creates an AddCommand to add the specified {@code Task}
     */
    public AddCommand(Task task) throws CommandException{
        requireNonNull(task);
        if (!task.isValid()) {
            throw new CommandException(MESSAGE_INVALID_TASK);
        }
        toAdd = task;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        if (model.hasTask(toAdd)) {
            throw new CommandException(MESSAGE_DUPLICATE_TASK);
        }

        model.addTask(toAdd);
        model.getUiTaskList();
        return new CommandResult(String.format(MESSAGE_SUCCESS, toAdd));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof AddCommand // instanceof handles nulls
                && toAdd.equals(((AddCommand) other).toAdd));
    }
}
