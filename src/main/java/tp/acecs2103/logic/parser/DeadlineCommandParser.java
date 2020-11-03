package tp.acecs2103.logic.parser;

import java.time.LocalDate;
import java.util.Optional;
import java.util.stream.Stream;

import tp.acecs2103.commons.core.Messages;
import tp.acecs2103.logic.commands.AddCommand;
import tp.acecs2103.logic.commands.DeadlineCommand;
import tp.acecs2103.logic.parser.exceptions.ParseException;
import tp.acecs2103.model.task.CustomizedDeadline;
import tp.acecs2103.model.task.Index;

import static tp.acecs2103.logic.parser.CliSyntax.*;

public class DeadlineCommandParser implements Parser<DeadlineCommand> {
    @Override
    public DeadlineCommand parse(String args) throws ParseException {
        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args, PREFIX_INDEX, PREFIX_CUSTOMIZED_DEADLINE);

        if (!arePrefixesPresent(argMultimap, PREFIX_INDEX, PREFIX_CUSTOMIZED_DEADLINE)
                || !argMultimap.getPreamble().isEmpty()) {
            throw new ParseException(String.format(Messages.MESSAGE_INVALID_COMMAND_FORMAT, DeadlineCommand.MESSAGE_USAGE));
        }

        String indexParsed = ParserUtil.parseIndex(argMultimap.getValue(PREFIX_INDEX).get());
        Index index = new Index(indexParsed);
        LocalDate customizedDeadline =
                ParserUtil.parseCustomizedDeadline(argMultimap.getValue(PREFIX_CUSTOMIZED_DEADLINE).get());
        return new DeadlineCommand(index, new CustomizedDeadline(customizedDeadline.toString(), customizedDeadline));
    }

    /**
     * Returns true if none of the prefixes contains empty {@code Optional} values in the given
     * {@code ArgumentMultimap}.
     */
    private static boolean arePrefixesPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        return Stream.of(prefixes).allMatch(prefix -> !argumentMultimap.getValue(prefix).get().equals(""));
    }
}
