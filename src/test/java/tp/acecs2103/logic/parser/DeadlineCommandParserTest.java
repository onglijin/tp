package tp.acecs2103.logic.parser;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import tp.acecs2103.logic.commands.DeadlineCommand;
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
import tp.acecs2103.model.task.WeekNumber;;

public class DeadlineCommandParserTest {
    @Test
    public void parse_validDeadlineCommand_success() {
        DeadlineCommandParser deadlineCommandParser = new DeadlineCommandParser();
        String parametersStub = " i/0101 c/2020-08-17";
        DeadlineCommand expected = new DeadlineCommand(
                new Index("0101"), new CustomizedDeadline("2020-08-17", LocalDate.parse("2020-08-17")));
        try {
            assertEquals(expected, deadlineCommandParser.parse(parametersStub));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
