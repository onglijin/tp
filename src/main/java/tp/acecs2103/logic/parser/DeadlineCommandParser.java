package tp.acecs2103.logic.parser;

import tp.acecs2103.logic.parser.exceptions.ParseException;

public class DeadlineCommandParser implements Parser<DeadlineCommand> {
    @Override
    public DeadlineCommand parse(String userInput) throws ParseException {
        return DeadlineCommand();
    }
}
