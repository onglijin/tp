package tp.acecs2103.logic.parser;

import org.junit.jupiter.api.Test;
import tp.acecs2103.logic.commands.DeadlineCommand;
import tp.acecs2103.logic.parser.exceptions.ParseException;
import tp.acecs2103.model.task.*;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeadlineCommandParserTest {
    @Test
    public void parse_validDeadlineCommand_success() {
        DeadlineCommandParser deadlineCommandParser = new DeadlineCommandParser();
        String parametersStub = " i/0101 c/2020-08-17";
        DeadlineCommand expected =
                new DeadlineCommand(new Index("0101"),
                        new CustomizedDeadline("2020-08-17", LocalDate.parse("2020-08-17")));
        try {
            assertEquals(expected, deadlineCommandParser.parse(parametersStub));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void parse_invalidDeadlineCommand_invalidIndex_fail() {
        DeadlineCommandParser deadlineCommandParser = new DeadlineCommandParser();
        String parametersStub = " i/01401 c/2020-08-17";
        try {
            deadlineCommandParser.parse(parametersStub);
        } catch (ParseException e) {
            assert true;
        }
    }

    @Test
    public void parse_invalidDeadlineCommand_invalidDate_fail() {
        DeadlineCommandParser deadlineCommandParser = new DeadlineCommandParser();
        String parametersStub = " i/01401 c/2019-02-29";
        try {
            deadlineCommandParser.parse(parametersStub);
        } catch (ParseException e) {
            assert true;
        }
    }

    @Test
    public void parse_invalidDeadlineCommand_missingParameter1_fail() {
        DeadlineCommandParser deadlineCommandParser = new DeadlineCommandParser();
        String parametersStub = " i/01401";
        try {
            deadlineCommandParser.parse(parametersStub);
        } catch (ParseException e) {
            assert true;
        }
    }

    @Test
    public void parse_invalidDeadlineCommand_missingParameter2_fail() {
        DeadlineCommandParser deadlineCommandParser = new DeadlineCommandParser();
        String parametersStub = " c/2019-02-29";
        try {
            deadlineCommandParser.parse(parametersStub);
        } catch (ParseException e) {
            assert true;
        }
    }

    @Test
    public void parse_invalidDeadlineCommand_missingParameter3_fail() {
        DeadlineCommandParser deadlineCommandParser = new DeadlineCommandParser();
        String parametersStub = "                ";
        try {
            deadlineCommandParser.parse(parametersStub);
        } catch (ParseException e) {
            assert true;
        }
    }
}
