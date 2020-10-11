package tp.acecs2103.logic.parser;

import tp.acecs2103.logic.parser.exceptions.ParseException;

public class GetCommandParser implements Parser<GetCommand> {
    @Override
    public GetCommand parse(String userInput) throws ParseException {
        return new GetCommand();
    }
}
