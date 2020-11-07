package tp.acecs2103.logic.parser;

import tp.acecs2103.commons.core.Messages;
import tp.acecs2103.logic.commands.DoneCommand;
import tp.acecs2103.logic.parser.exceptions.ParseException;
import tp.acecs2103.model.task.Index;

public class DoneCommandParser implements Parser<DoneCommand> {

    /**
     * Parses args to the input of {@code DoneCommand}.
     */
    public DoneCommand parse(String args) throws ParseException {
        try {
            String indexParsed = ParserUtil.parseIndex(args);
            Index index = new Index(indexParsed);
            return new DoneCommand(index);
        } catch (ParseException pe) {
            throw new ParseException(
                    String.format(Messages.MESSAGE_INVALID_COMMAND_FORMAT, DoneCommand.MESSAGE_USAGE), pe);
        }
    }
}
