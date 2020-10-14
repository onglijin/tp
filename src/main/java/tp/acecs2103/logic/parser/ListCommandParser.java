package tp.acecs2103.logic.parser;

import tp.acecs2103.logic.commands.ListCommand;
import tp.acecs2103.logic.parser.exceptions.ParseException;

public class ListCommandParser implements Parser<ListCommand> {
    @Override
    public ListCommand parse(String args) throws ParseException {
        String trimmedArgs = args.trim();
        int weekNumber = ParserUtil.parseWeekNumber(trimmedArgs);

        return new ListCommand(weekNumber);
    }
}
