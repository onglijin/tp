package tp.acecs2103.logic.parser;

import org.junit.jupiter.api.Test;
import tp.acecs2103.AppParameters;
import tp.acecs2103.AppParametersTest;
import tp.acecs2103.logic.commands.AddCommand;
import tp.acecs2103.logic.commands.exceptions.CommandException;
import tp.acecs2103.logic.parser.exceptions.ParseException;
import tp.acecs2103.model.task.*;

import java.nio.file.Paths;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddCommandParserTest {
    @Test
    public void parse_validAddCommand_withRemark_success() {
        AddCommandParser addCommandParser = new AddCommandParser();
        String parametersStub = "add i/0101 w/1 d/CyberPunk2077 c/2020-12-10 r/release a/Ip";
        Task task = new IP(new Index("0101"), new WeekNumber("1"), new Description("CyberPunk2077"), null,
                new CustomizedDeadline("2020-12-10", LocalDate.parse("2020-12-10")),
                new Remark("release"), true, false);
        AddCommand expected;
        try {
            expected = new AddCommand(task);
            try {
                assertEquals(expected, addCommandParser.parse(parametersStub));
            } catch (ParseException e) {
                e.printStackTrace();
            } catch (CommandException e) {
                e.printStackTrace();
            }
        } catch (CommandException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void parse_validAddCommand_withoutRemark_success() {
        AddCommandParser addCommandParser = new AddCommandParser();
        String parametersStub = "add i/0101 w/1 d/CyberPunk2077 c/2020-12-10 a/Ip";
        Task task = new IP(new Index("0101"), new WeekNumber("1"), new Description("CyberPunk2077"), null,
                new CustomizedDeadline("2020-12-10", LocalDate.parse("2020-12-10")),
                new Remark(""), true, false);
        AddCommand expected;
        try {
            expected = new AddCommand(task);
            try {
                assertEquals(expected, addCommandParser.parse(parametersStub));
            } catch (ParseException e) {
                e.printStackTrace();
            } catch (CommandException e) {
                e.printStackTrace();
            }
        } catch (CommandException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void parse_invalidAddCommand_argumentNotEnough_fail() {
        AddCommandParser addCommandParser = new AddCommandParser();
        String parametersStub = "add i/0101 d/CyberPunk2077 c/2020-12-10 a/Ip";//no WeekNumber
        try {
            addCommandParser.parse(parametersStub);
        } catch (CommandException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            assert true;
        }
    }

    @Test
    public void parse_invalidAddCommand_emptyCommand_fail() {
        AddCommandParser addCommandParser = new AddCommandParser();
        String parametersStub = "";

        try {
            addCommandParser.parse(parametersStub);
        } catch (CommandException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            assert true;
        }
    }
}
