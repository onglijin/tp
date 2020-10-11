package tp.acecs2103.logic.parser;

import tp.acecs2103.commons.core.index.Index;
import tp.acecs2103.logic.parser.exceptions.ParseException;

import java.time.LocalDate;

import static tp.acecs2103.logic.parser.CliSyntax.*;

public class DeadlineCommandParser implements Parser<DeadlineCommand> {
    @Override
    public DeadlineCommand parse(String args) throws ParseException {
        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args, PREFIX_INDEX, PREFIX_CUSTOMIZEDDDL);
        Index index = ParserUtil.parseIndexObj(argMultimap.getValue(PREFIX_INDEX).get());
        LocalDate customizedDeadline = ParserUtil.parseCustomizedDeadline(argMultimap.getValue(PREFIX_CUSTOMIZEDDDL).get());
        return new DeadlineCommand(index, customizedDeadline);
    }
}
