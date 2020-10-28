package tp.acecs2103.logic.parser;

import static tp.acecs2103.logic.parser.CliSyntax.PREFIX_CUSTOMIZED_DEADLINE;
import static tp.acecs2103.logic.parser.CliSyntax.PREFIX_INDEX;

import java.time.LocalDate;

import tp.acecs2103.logic.commands.DeadlineCommand;
import tp.acecs2103.logic.parser.exceptions.ParseException;
import tp.acecs2103.model.task.Index;

public class DeadlineCommandParser implements Parser<DeadlineCommand> {
    @Override
    public DeadlineCommand parse(String args) throws ParseException {
        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args, PREFIX_INDEX, PREFIX_CUSTOMIZED_DEADLINE);
        String indexParsed = ParserUtil.parseIndex(argMultimap.getValue(PREFIX_INDEX).get());
        Index index = new Index(indexParsed);
        LocalDate customizedDeadline =
                ParserUtil.parseCustomizedDeadline(argMultimap.getValue(PREFIX_CUSTOMIZED_DEADLINE).get());
        return new DeadlineCommand(index, customizedDeadline);
    }
}
