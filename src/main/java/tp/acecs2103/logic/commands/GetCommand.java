package tp.acecs2103.logic.commands;

import static java.util.Objects.requireNonNull;

import java.time.LocalDate;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import tp.acecs2103.commons.core.Messages;
import tp.acecs2103.commons.core.index.Index;
import tp.acecs2103.commons.util.CollectionUtil;
import tp.acecs2103.logic.commands.exceptions.CommandException;
import tp.acecs2103.model.Model;
import tp.acecs2103.model.TaskList;
import tp.acecs2103.model.task.*;

public class GetCommand extends Command {
    public static final String COMMAND_WORD = "get";

    public static final String MESSAGE_SUCCESS = "Gotten required administrative information.";

    private final String infoType;

    public GetCommand(String infoType) {
        requireNonNull(infoType);
        this.infoType = infoType;
    }

    public CommandResult execute(Model model) throws CommandException {
            return new CommandResult(MESSAGE_SUCCESS, true, false); // dummy code for now

    }

}
