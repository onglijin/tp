package tp.acecs2103.logic.parser;

import tp.acecs2103.logic.commands.HelpCommand;
import tp.acecs2103.logic.parser.exceptions.ParseException;

public class HelpCommandParser implements Parser<HelpCommand> {
    @Override
    public HelpCommand parse(String userInput) throws ParseException {
        return new HelpCommand();
    }
}
