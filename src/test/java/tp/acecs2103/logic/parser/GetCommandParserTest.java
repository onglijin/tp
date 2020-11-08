package tp.acecs2103.logic.parser;

import org.junit.jupiter.api.Test;
import tp.acecs2103.logic.commands.GetCommand;
import tp.acecs2103.logic.parser.exceptions.ParseException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetCommandParserTest {
    @Test
    public void parse_validGetCommand_success() {
        GetCommandParser parser = new GetCommandParser();
        String argumentStab = " t/Admin";
        GetCommand expected = new GetCommand("Admin");
        try {
            assertEquals(expected, parser.parse(argumentStab));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void parse_invalidGetCommand_emptyArgument_fail() {
        GetCommandParser parser = new GetCommandParser();
        String argumentStab = " ";
        try {
            parser.parse(argumentStab);
            assert false;
        } catch (ParseException e) {
            assert true;
        }
    }
}
