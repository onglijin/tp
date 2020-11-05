package tp.acecs2103.logic.parser;

import org.junit.jupiter.api.Test;
import tp.acecs2103.logic.commands.DoneCommand;
import tp.acecs2103.logic.parser.exceptions.ParseException;
import tp.acecs2103.model.task.Index;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DoneCommandParserTest {
    @Test
    public void parse_validDoneCommand_success() {
        DoneCommandParser doneCommandParser = new DoneCommandParser();
        String parametersStub = "0101";
        DoneCommand expected = new DoneCommand(new Index("0101"));
        try {
            assertEquals(expected.getTargetIndex(), doneCommandParser.parse(parametersStub).getTargetIndex());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void parse_invalidDoneCommand_emptyArgus_fail() {
        DoneCommandParser doneCommandParser = new DoneCommandParser();
        String parametersStub = "";
        try {
            doneCommandParser.parse(parametersStub);
        } catch (ParseException e) {
            assert true;
        }
    }
}
