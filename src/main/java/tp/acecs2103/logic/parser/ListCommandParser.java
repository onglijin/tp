package tp.acecs2103.logic.parser;

import tp.acecs2103.logic.commands.ListCommand;
import tp.acecs2103.logic.parser.exceptions.ParseException;
import tp.acecs2103.model.task.WeekNumber;

public class ListCommandParser implements Parser<ListCommand> {
    @Override
    public ListCommand parse(String args) throws ParseException {
        String trimmedArgs = args.trim();
        int weekNumber = ParserUtil.parseWeekNumber(trimmedArgs);

        return new ListCommand(new WeekNumber(Integer.toString(weekNumber)));
    }
}
