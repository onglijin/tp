package tp.acecs2103.logic.commands;

import static java.util.Objects.requireNonNull;

import java.util.logging.Logger;

import tp.acecs2103.commons.core.LogsCenter;
import tp.acecs2103.commons.core.Messages;
import tp.acecs2103.commons.core.index.Index;
import tp.acecs2103.logic.commands.exceptions.CommandException;
import tp.acecs2103.model.Model;
import tp.acecs2103.model.TaskList;
import tp.acecs2103.model.exceptions.ModelException;
import tp.acecs2103.model.task.Task;

/**
 * Mark a task as done as identified by the index number.
 */
public class DoneCommand extends Command {
    public static final String COMMAND_WORD = "done";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Mark the task identified by the index number used in the displayed task list as done.\n"
            + "Parameters: INDEX (must be a positive integer)\n"
            + "Example: " + COMMAND_WORD + " 1";

    public static final String MESSAGE_DONE_TASK_SUCCESS = "Done Task: %1$s";

    private final Logger logger = LogsCenter.getLogger(getClass());

    private final Index targetIndex;

    public DoneCommand(Index targetIndex) {
        this.targetIndex = targetIndex;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        TaskList lastShownList = model.getTaskList();
        String strIndex = targetIndex.getStrIndex();
        Task taskToMarkAsDone = lastShownList.getTask(strIndex);
        try {
            model.markTaskAsDone(strIndex);
        } catch (Exception e) {
            throw new CommandException(e.getMessage());
        }
        return new CommandResult(String.format(MESSAGE_DONE_TASK_SUCCESS, taskToMarkAsDone));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof DeleteCommand // instanceof handles nulls
                && targetIndex.equals(((DoneCommand) other).targetIndex)); // state check
    }
}
