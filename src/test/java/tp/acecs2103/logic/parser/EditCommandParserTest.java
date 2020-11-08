package tp.acecs2103.logic.parser;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import tp.acecs2103.logic.commands.EditCommand;
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

public class EditCommandParserTest {
    @Test
    public void parse_validEditCommandWithRemark_success() {
        EditCommandParser editCommandParser = new EditCommandParser();
        String parametersStub = "edit i/0101 w/1 d/CyberPunk2077 c/2020-12-10 r/release";
        Index index = new Index("0101");
        EditCommand.EditTaskDescriptor editTaskDescriptor = new EditCommand.EditTaskDescriptor();
        editTaskDescriptor.setWeekNumber(new WeekNumber("1"));
        try {
            LocalDate customizedDeadlineParsed = ParserUtil.parseCustomizedDeadline("2020-12-10");
            editTaskDescriptor.setCustomizedDeadline(
                    new CustomizedDeadline(customizedDeadlineParsed.toString(), customizedDeadlineParsed));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        editTaskDescriptor.setDescription(new Description("CyberPunk2077"));
        editTaskDescriptor.setRemark(new Remark("release"));
        EditCommand expected = new EditCommand(index, editTaskDescriptor);
        try {
            assert editCommandParser.parse(parametersStub).equals(expected);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
