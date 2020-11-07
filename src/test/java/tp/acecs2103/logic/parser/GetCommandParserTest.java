package tp.acecs2103.logic.parser;

import org.junit.jupiter.api.Test;
import tp.acecs2103.logic.commands.GetCommand;
import tp.acecs2103.logic.parser.exceptions.ParseException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetCommandParserTest {
    @Test
    public void parse_validGetCommand_test_success() {
        GetCommandParser parser = new GetCommandParser();
        String argumentStab = " t/Admin";
        GetCommand expected = new GetCommand("Admin");
        try {
            assertEquals(expected, parser.parse(argumentStab));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
