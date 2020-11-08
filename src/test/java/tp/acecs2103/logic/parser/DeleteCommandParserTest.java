package tp.acecs2103.logic.parser;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import tp.acecs2103.logic.commands.DeleteCommand;
import tp.acecs2103.logic.parser.exceptions.ParseException;
import tp.acecs2103.model.task.Admin;
import tp.acecs2103.model.task.CustomizedDeadline;
import tp.acecs2103.model.task.Deadline;
import tp.acecs2103.model.task.Description;
import tp.acecs2103.model.task.Index;
import tp.acecs2103.model.task.IP;
import tp.acecs2103.model.task.OfficialDeadline;
import tp.acecs2103.model.task.Remark;
import tp.acecs2103.model.task.Task;
import tp.acecs2103.model.task.TaskCategory;
import tp.acecs2103.model.task.Topic;
import tp.acecs2103.model.task.TP;
import tp.acecs2103.model.task.WeekNumber;

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
