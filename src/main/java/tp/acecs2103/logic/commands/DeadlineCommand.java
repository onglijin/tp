package tp.acecs2103.logic.commands;

import static java.util.Objects.requireNonNull;

import tp.acecs2103.model.Model;
import tp.acecs2103.model.task.CustomizedDeadline;
import tp.acecs2103.model.task.Index;


public class DeadlineCommand extends Command {
    public static final String COMMAND_WORD = "deadline";

    public static final String MESSAGE_SUCCESS = "Modified deadline for the required task.\nCustomized deadline :";

    private final Index targetIndex;
    private final CustomizedDeadline newDeadline;

    /**
     * Creates a {@code DeadlineCommand} with given index and newDeadline
     */
    public DeadlineCommand(Index targetIndex, CustomizedDeadline newDeadline) {
        requireNonNull(targetIndex);
        requireNonNull(newDeadline);
        this.targetIndex = targetIndex;
        this.newDeadline = newDeadline;
    }

    public Index getTargetIndex() {
        return targetIndex;
    }

    public CustomizedDeadline getNewDeadline() {
        return newDeadline;
    }

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.deadlineTask(targetIndex, newDeadline);
        return new CommandResult(MESSAGE_SUCCESS + newDeadline.value);
    }
}
