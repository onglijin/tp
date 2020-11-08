package tp.acecs2103.logic.parser;

import org.junit.jupiter.api.Test;

import tp.acecs2103.logic.commands.FilterCommand;
import tp.acecs2103.logic.commands.exceptions.CommandException;
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

public class FilterCommandParserTest {
    @Test
    public void parse_validFilterCommandWkl_success() {
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
    public void parse_validFilterCommandKl_success() {
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
    public void parse_validFilterCommandWk_success() {
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
    public void parse_validFilterCommandK_success() {
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
