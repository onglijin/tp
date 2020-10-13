package tp.acecs2103.logic.parser;

import tp.acecs2103.logic.commands.ListCommand;
import tp.acecs2103.logic.parser.exceptions.ParseException;

import static tp.acecs2103.logic.parser.CliSyntax.*;
public class ListCommandParser implements Parser<ListCommand> {
    @Override
    public ListCommand parse(String args) throws ParseException {
        ArgumentMultimap argMultimap = ArgumentTokenizer.tokenize(args, PREFIX_WEEKNO);

        int weekNumber = ParserUtil.parseWeekNumber(argMultimap.getValue(PREFIX_WEEKNO).get());

        return new ListCommand(weekNumber);
    }
}
