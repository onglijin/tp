package tp.acecs2103.logic.parser;

import tp.acecs2103.logic.parser.exceptions.ParseException;

import static tp.acecs2103.logic.parser.CliSyntax.PREFIX_TYPE;
import static tp.acecs2103.logic.parser.CliSyntax.PREFIX_WEEKNO;

public class GetCommandParser implements Parser<GetCommand> {
    @Override
    public GetCommand parse(String args) throws ParseException {
        ArgumentMultimap argMultimap = ArgumentTokenizer.tokenize(args, PREFIX_TYPE);

        String type = ParserUtil.parseType(argMultimap.getValue(PREFIX_TYPE).get());
        return new GetCommand(type);
    }
}
