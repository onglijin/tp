package tp.acecs2103.logic.parser;

import static tp.acecs2103.logic.parser.CliSyntax.PREFIX_CATEGORY;
import static tp.acecs2103.logic.parser.CliSyntax.PREFIX_CUSTOMIZEDDDL;
import static tp.acecs2103.logic.parser.CliSyntax.PREFIX_DESCRIPTION;
import static tp.acecs2103.logic.parser.CliSyntax.PREFIX_INDEX;
import static tp.acecs2103.logic.parser.CliSyntax.PREFIX_REMARK;
import static tp.acecs2103.logic.parser.CliSyntax.PREFIX_WEEKNO;

import java.time.LocalDate;
import java.util.stream.Stream;

import tp.acecs2103.commons.core.Messages;
import tp.acecs2103.logic.commands.AddCommand;
import tp.acecs2103.logic.parser.exceptions.ParseException;
import tp.acecs2103.model.task.Admin;
import tp.acecs2103.model.task.IP;
import tp.acecs2103.model.task.TP;
import tp.acecs2103.model.task.Task;
import tp.acecs2103.model.task.TaskCategory;
import tp.acecs2103.model.task.Topic;



/**
 * Parses input arguments and creates a new AddCommand object
 */
public class AddCommandParser implements Parser<AddCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the AddCommand
     * and returns an AddCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public AddCommand parse(String args) throws ParseException {
        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args, PREFIX_INDEX, PREFIX_WEEKNO, PREFIX_DESCRIPTION,
                        PREFIX_CUSTOMIZEDDDL, PREFIX_REMARK, PREFIX_CATEGORY);

        if (!arePrefixesPresent(argMultimap, PREFIX_INDEX, PREFIX_WEEKNO, PREFIX_DESCRIPTION)
                || !argMultimap.getPreamble().isEmpty()) {
            throw new ParseException(String.format(Messages.MESSAGE_INVALID_COMMAND_FORMAT, AddCommand.MESSAGE_USAGE));
        }

        String index =
                ParserUtil.parseIndex(argMultimap.getValue(PREFIX_INDEX).get());
        int weekNumber =
                ParserUtil.parseWeekNumber(argMultimap.getValue(PREFIX_WEEKNO).get());
        String description =
                ParserUtil.parseDescription(argMultimap.getValue(PREFIX_DESCRIPTION).get());
        LocalDate customizedDeadline =
                ParserUtil.parseCustomizedDeadline(argMultimap.getValue(PREFIX_CUSTOMIZEDDDL).get());
        String remark =
                ParserUtil.parseRemark(argMultimap.getValue(PREFIX_REMARK).get());
        TaskCategory category = ParserUtil.parseCategory(argMultimap.getValue(PREFIX_CATEGORY).get());

        if (category.equals(TaskCategory.ADMIN)) {
            Admin admin = new Admin(index, weekNumber, description, null, customizedDeadline, remark);
            return new AddCommand(admin);
        } else if (category.equals(TaskCategory.TOPIC)) {
            Topic topic = new Topic(index, weekNumber, description, null, customizedDeadline, remark);
            return new AddCommand(topic);
        } else if (category.equals(TaskCategory.IP)) {
            IP ip = new IP(index, weekNumber, description, null, customizedDeadline, remark);
            return new AddCommand(ip);
        } else if (category.equals(TaskCategory.TP)) {
            TP tp = new TP(index, weekNumber, description, null, customizedDeadline, remark);
            return new AddCommand(tp);
        }

        Task task = new Task(index, weekNumber, description, null, customizedDeadline, remark, category);
        return new AddCommand(task);
    }

    /**
     * Returns true if none of the prefixes contains empty {@code Optional} values in the given
     * {@code ArgumentMultimap}.
     */
    private static boolean arePrefixesPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        return Stream.of(prefixes).allMatch(prefix -> argumentMultimap.getValue(prefix).isPresent());
    }

}
