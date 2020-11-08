package tp.acecs2103.logic.parser;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import tp.acecs2103.logic.commands.DeleteCommand;
import tp.acecs2103.logic.parser.exceptions.ParseException;
import tp.acecs2103.model.task.Index;

public class DeleteCommandParserTest {
    @Test
    public void parse_validDeleteCommand_success() {
        DeleteCommandParser deleteCommandParser = new DeleteCommandParser();
        String parametersStub = "0101";
        DeleteCommand expected = new DeleteCommand(new Index("0101"));
        try {
            assertEquals(expected, deleteCommandParser.parse(parametersStub));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void parse_invalidDeleteCommandEmptyArguments_fail() {
        DeleteCommandParser deleteCommandParser = new DeleteCommandParser();
        String parametersStub = "";
        try {
            deleteCommandParser.parse(parametersStub);
        } catch (ParseException e) {
            assert true;
        }
    }

    @Test
    public void parse_invalidDeleteCommandInvalidIndex_fail() {
        DeleteCommandParser deleteCommandParser = new DeleteCommandParser();
        String parametersStub = "010101";
        try {
            deleteCommandParser.parse(parametersStub);
        } catch (ParseException e) {
            assert true;
        }
    }
}
