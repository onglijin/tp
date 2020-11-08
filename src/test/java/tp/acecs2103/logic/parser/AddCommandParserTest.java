package tp.acecs2103.logic.parser;

import org.junit.jupiter.api.Test;
import tp.acecs2103.logic.commands.AddCommand;
import tp.acecs2103.logic.commands.exceptions.CommandException;
import tp.acecs2103.logic.parser.exceptions.ParseException;
import tp.acecs2103.model.task.*;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddCommandParserTest {
    @Test
    public void parse_validAddCommand_withRemark_success() {
        AddCommandParser addCommandParser = new AddCommandParser();
        String parametersStub = " i/0101 w/1 d/CyberPunk2077 c/2020-12-10 r/release a/Ip";
        Task task = new IP(new Index("0101"), new WeekNumber("1"), new Description("CyberPunk2077"),
                null, new CustomizedDeadline("2020-12-10",
                LocalDate.parse("2020-12-10")), new Remark("release"), true, false);
        AddCommand expected;
        try {
            expected = new AddCommand(task);
            try {
                assertEquals(expected, addCommandParser.parse(parametersStub));
            } catch (ParseException | CommandException e) {
                e.printStackTrace();
            }
        } catch (CommandException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void parse_validAddCommand_withoutRemark_success() {
        AddCommandParser addCommandParser = new AddCommandParser();
        String parametersStub = " i/0101 w/1 d/CyberPunk2077 c/2020-12-10 a/Ip";
        Task task = new IP(new Index("0101"), new WeekNumber("1"), new Description("CyberPunk2077"),
                null, new CustomizedDeadline("2020-12-10",
                LocalDate.parse("2020-12-10")), new Remark(""), true, false);
        AddCommand expected;
        try {
            expected = new AddCommand(task);
            try {
                assertEquals(expected, addCommandParser.parse(parametersStub));
            } catch (ParseException | CommandException e) {
                e.printStackTrace();
            }
        } catch (CommandException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void parse_invalidAddCommand_argumentNotEnough_fail() {
        AddCommandParser addCommandParser = new AddCommandParser();
        String parametersStub = " i/0101 d/CyberPunk2077 c/2020-12-10 a/Ip";//no WeekNumber
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

    @Test
    public void parse_invalidAddCommand_ExtraArguments_fail() {
        AddCommandParser addCommandParser = new AddCommandParser();
        String parametersStub = " i/0101 w/1 d/CyberPunk2077 c/2020-12-10 a/Ip x/fail";
        try {
            addCommandParser.parse(parametersStub);
        } catch (CommandException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            assert true;
        }
    }

    @Test
    public void parse_invalidAddCommand_argumentNotEnough1_fail() {
        AddCommandParser addCommandParser = new AddCommandParser();
        String parametersStub = " w/1 d/CyberPunk2077 c/2020-12-10 a/Ip";
        try {
            addCommandParser.parse(parametersStub);
        } catch (CommandException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            assert true;
        }
    }

    @Test
    public void parse_invalidAddCommand_argumentNotEnough3_fail() {
        AddCommandParser addCommandParser = new AddCommandParser();
        String parametersStub = " i/0101 w/1 c/2020-12-10 a/Ip";
        try {
            addCommandParser.parse(parametersStub);
        } catch (CommandException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            assert true;
        }
    }

    @Test
    public void parse_invalidAddCommand_argumentNotEnough4_fail() {
        AddCommandParser addCommandParser = new AddCommandParser();
        String parametersStub = " i/0101 w/1 d/CyberPunk2077 a/Ip";
        try {
            addCommandParser.parse(parametersStub);
        } catch (CommandException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            assert true;
        }
    }

    @Test
    public void parse_invalidAddCommand_argumentNotEnough5_fail() {
        AddCommandParser addCommandParser = new AddCommandParser();
        String parametersStub = " i/0101 w/1 d/CyberPunk2077 c/2020-12-10";
        try {
            addCommandParser.parse(parametersStub);
        } catch (CommandException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            assert true;
        }
    }

    @Test
    public void parse_validAddCommand_unorderedArguments_success() {
        AddCommandParser addCommandParser = new AddCommandParser();
        String parametersStub = " a/Ip c/2020-12-10 w/1 i/0101 d/CyberPunk2077";
        Task task = new IP(new Index("0101"), new WeekNumber("1"), new Description("CyberPunk2077"),
                null, new CustomizedDeadline("2020-12-10",
                LocalDate.parse("2020-12-10")), new Remark(""), true, false);
        AddCommand expected;
        try {
            expected = new AddCommand(task);
            try {
                assertEquals(expected, addCommandParser.parse(parametersStub));
            } catch (ParseException | CommandException e) {
                e.printStackTrace();
            }
        } catch (CommandException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void parse_invalidAddCommand_invalidDate_fail() {
        AddCommandParser addCommandParser = new AddCommandParser();
        String parametersStub = " i/0101 w/1 d/CyberPunk2077 c/2020-12-99 a/Ip";
        try {
            addCommandParser.parse(parametersStub);
        } catch (CommandException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            assert true;
        }
    }

    @Test
    public void parse_invalidAddCommand_invalidWeek_fail() {
        AddCommandParser addCommandParser = new AddCommandParser();
        String parametersStub = " i/0101 w/16 d/CyberPunk2077 c/2020-12-10 a/Ip";
        try {
            addCommandParser.parse(parametersStub);
        } catch (CommandException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            assert true;
        }
    }

    @Test
    public void parse_invalidAddCommand_invalidIndex_fail() {
        AddCommandParser addCommandParser = new AddCommandParser();
        String parametersStub = " i/01401 w/1 d/CyberPunk2077 c/2020-12-10 a/Ip";
        try {
            addCommandParser.parse(parametersStub);
        } catch (CommandException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            assert true;
        }
    }

    @Test
    public void parse_invalidAddCommand_invalidCategory_fail() {
        AddCommandParser addCommandParser = new AddCommandParser();
        String parametersStub = " i/0101 w/1 d/CyberPunk2077 c/2020-12-10 a/Undefined";
        try {
            addCommandParser.parse(parametersStub);
        } catch (CommandException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            assert true;
        }
    }

    @Test
    public void parse_invalidAddCommand_invalidDescription_fail() {
        AddCommandParser addCommandParser = new AddCommandParser();
        String parametersStub = " i/0101 w/1 d/ c/2020-12-10 a/Ip";
        try {
            addCommandParser.parse(parametersStub);
        } catch (CommandException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            assert true;
        }
    }

}
