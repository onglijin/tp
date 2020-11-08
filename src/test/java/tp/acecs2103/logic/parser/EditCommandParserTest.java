package tp.acecs2103.logic.parser;

import org.junit.jupiter.api.Test;
import tp.acecs2103.logic.commands.EditCommand;
import tp.acecs2103.logic.parser.exceptions.ParseException;
import tp.acecs2103.model.task.*;

import java.time.LocalDate;

public class EditCommandParserTest {
    @Test
    public void parse_validEditCommand_withRemark_success() {
        EditCommandParser editCommandParser = new EditCommandParser();
        String parametersStub = " i/0101 w/1 d/CyberPunk2077 c/2020-12-10 r/release";
        Index index = new Index("0101");
        EditCommand.EditTaskDescriptor editTaskDescriptor = new EditCommand.EditTaskDescriptor();
        editTaskDescriptor.setWeekNumber(new WeekNumber("1"));
        try {
            LocalDate customizedDeadlineParsed = ParserUtil.parseCustomizedDeadline("2020-12-10");
            editTaskDescriptor.setCustomizedDeadline(new CustomizedDeadline(customizedDeadlineParsed.toString(), customizedDeadlineParsed));
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

    @Test
    public void parse_validEditCommand_withoutRemark_success() {
        EditCommandParser editCommandParser = new EditCommandParser();
        String parametersStub = " i/0101 w/1 d/CyberPunk2077 c/2020-12-10";
        Index index = new Index("0101");
        EditCommand.EditTaskDescriptor editTaskDescriptor = new EditCommand.EditTaskDescriptor();
        editTaskDescriptor.setWeekNumber(new WeekNumber("1"));
        try {
            LocalDate customizedDeadlineParsed = ParserUtil.parseCustomizedDeadline("2020-12-10");
            editTaskDescriptor.setCustomizedDeadline(new CustomizedDeadline(customizedDeadlineParsed.toString(), customizedDeadlineParsed));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        editTaskDescriptor.setDescription(new Description("CyberPunk2077"));
        EditCommand expected = new EditCommand(index, editTaskDescriptor);
        try {
            assert editCommandParser.parse(parametersStub).equals(expected);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void parse_validEditCommand_withoutDescription_success() {
        EditCommandParser editCommandParser = new EditCommandParser();
        String parametersStub = " i/0101 w/1 c/2020-12-10";
        Index index = new Index("0101");
        EditCommand.EditTaskDescriptor editTaskDescriptor = new EditCommand.EditTaskDescriptor();
        editTaskDescriptor.setWeekNumber(new WeekNumber("1"));
        try {
            LocalDate customizedDeadlineParsed = ParserUtil.parseCustomizedDeadline("2020-12-10");
            editTaskDescriptor.setCustomizedDeadline(new CustomizedDeadline(customizedDeadlineParsed.toString(), customizedDeadlineParsed));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        EditCommand expected = new EditCommand(index, editTaskDescriptor);
        try {
            assert editCommandParser.parse(parametersStub).equals(expected);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void parse_invalidEditCommand_missingArgument1_fail() {
        EditCommandParser editCommandParser = new EditCommandParser();
        String parametersStub = " ";
        try {
            editCommandParser.parse(parametersStub);
        } catch (ParseException e) {
            assert true;
        }
    }

    @Test
    public void parse_invalidEditCommand_missingArgument2_fail() {
        EditCommandParser editCommandParser = new EditCommandParser();
        String parametersStub = " w/1 d/CyberPunk2077 c/2020-12-10 r/release";
        try {
            editCommandParser.parse(parametersStub);
        } catch (ParseException e) {
            assert true;
        }
    }

    @Test
    public void parse_invalidEditCommand_dummyParameter_fail() {
        EditCommandParser editCommandParser = new EditCommandParser();
        String parametersStub = " w/1 d/CyberPunk2077 c/2020-12-10 r/release x/dummy";
        try {
            editCommandParser.parse(parametersStub);
        } catch (ParseException e) {
            assert true;
        }
    }
}
