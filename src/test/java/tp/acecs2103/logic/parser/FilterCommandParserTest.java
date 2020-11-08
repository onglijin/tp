package tp.acecs2103.logic.parser;

import org.junit.jupiter.api.Test;
import tp.acecs2103.logic.commands.EditCommand;
import tp.acecs2103.logic.commands.FilterCommand;
import tp.acecs2103.logic.commands.exceptions.CommandException;
import tp.acecs2103.logic.parser.exceptions.ParseException;
import tp.acecs2103.model.task.*;

import java.time.LocalDate;

public class FilterCommandParserTest {
    @Test
    public void parse_validFilterCommand_wkl_success() {
        FilterCommandParser filterCommandParser = new FilterCommandParser();
        String parametersStub = " w/4 k/pending l/official";
        FilterCommand expected = null;
        try {
            expected = new FilterCommand("pending", "official", new WeekNumber("4"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            assert filterCommandParser.parse(parametersStub).equals(expected);
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (CommandException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void parse_validFilterCommand_kl_success() {
        FilterCommandParser filterCommandParser = new FilterCommandParser();
        String parametersStub = " k/pending l/official";
        FilterCommand expected = null;
        try {
            expected = new FilterCommand("pending", "official");
            assert filterCommandParser.parse(parametersStub).equals(expected);
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (CommandException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void parse_validFilterCommand_wk_success() {
        FilterCommandParser filterCommandParser = new FilterCommandParser();
        String parametersStub = " w/4 k/done";
        FilterCommand expected = null;
        try {
            expected = new FilterCommand("done", new WeekNumber("4"));
            assert filterCommandParser.parse(parametersStub).equals(expected);
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (CommandException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void parse_validFilterCommand_k_success() {
        FilterCommandParser filterCommandParser = new FilterCommandParser();
        String parametersStub = " k/done";
        FilterCommand expected = null;
        try {
            expected = new FilterCommand("done");
            assert filterCommandParser.parse(parametersStub).equals(expected);
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (CommandException e) {
            e.printStackTrace();
        }
    }
}
