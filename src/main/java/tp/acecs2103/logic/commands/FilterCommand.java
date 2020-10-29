package tp.acecs2103.logic.commands;

import static java.util.Objects.requireNonNull;

import java.time.LocalDate;

import tp.acecs2103.commons.core.Messages;
import tp.acecs2103.commons.core.index.Index;
import tp.acecs2103.logic.commands.exceptions.CommandException;
import tp.acecs2103.model.Model;
import tp.acecs2103.model.task.Task;
import tp.acecs2103.model.task.WeekNumber;


public class FilterCommand extends Command {
    public static final String COMMAND_WORD = "filter";

    public static final String MESSAGE_USAGE = COMMAND_WORD;

    public static final String MESSAGE_SUCCESS = "Filtered task list displayed according to given criteria.";

    private final String keyword;
    private final String ddlType; // optional, only for pending tasks
    private final WeekNumber weekNumber; //optional

    /**
     * Creates an FilterCommand to display tasks that fulfill given criteria.
     * Only for display of completed tasks
     */
    public FilterCommand(String keyword) throws CommandException{
        requireNonNull(keyword);

        if (!keyword.equals("done")) {
            throw new CommandException(Messages.MESSAGE_INVALID_COMMAND_FORMAT);
        }
        this.keyword = keyword;
        this.ddlType = null;
        this.weekNumber = null;
    }

    /**
     * Creates an FilterCommand to display tasks that fulfill given criteria.
     * For display of completed tasks when week number is given
     */
    public FilterCommand(String keyword, WeekNumber weekNumber) throws CommandException{
        requireNonNull(keyword);
        if (!keyword.equals("done")) {
            throw new CommandException(Messages.MESSAGE_INVALID_COMMAND_FORMAT);
        }
        this.keyword = keyword;
        this.ddlType = null;
        this.weekNumber = weekNumber;
    }

    /**
     * Creates an FilterCommand to display tasks that fulfill given criteria.
     * For pending tasks with ddl type specified.
     */
    public FilterCommand(String keyword, String ddlType) throws CommandException{
        requireNonNull(keyword);

        if (!keyword.equals("pending") || (!ddlType.equals("official") && !ddlType.equals("customised"))) {
            throw new CommandException(Messages.MESSAGE_INVALID_COMMAND_FORMAT);
        }
        this.keyword = keyword;
        this.ddlType = ddlType;
        this.weekNumber = null;
    }

    /**
     * Creates an FilterCommand to display tasks that fulfill given criteria.
     * For pending tasks with ddl type specified and week number given.
     */
    public FilterCommand(String keyword, String ddlType, WeekNumber weekNumber) throws CommandException{
        requireNonNull(keyword);

        if (!keyword.equals("pending") || (!ddlType.equals("official") && !ddlType.equals("customised"))) {
            throw new CommandException(Messages.MESSAGE_INVALID_COMMAND_FORMAT);
        }
        this.keyword = keyword;
        this.ddlType = ddlType;
        this.weekNumber = weekNumber;
    }

    @Override
    public CommandResult execute(Model model)  {
        requireNonNull(model);
        boolean isDone = (keyword.equals("done"));
        boolean byOfficialDdl = false ? (ddlType == null)  : ddlType.equals("official");

        model.filterTasks(isDone, byOfficialDdl, weekNumber);
        model.getUiTaskList();
        return new CommandResult(String.format(MESSAGE_SUCCESS));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof AddCommand // instanceof handles nulls
                && keyword.equals(((FilterCommand) other).keyword)
                && ddlType.equals(((FilterCommand) other).ddlType)
                && weekNumber == ((FilterCommand) other).weekNumber);
    }
}
