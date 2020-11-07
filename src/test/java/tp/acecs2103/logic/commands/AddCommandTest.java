package tp.acecs2103.logic.commands;

import org.junit.jupiter.api.Test;
import tp.acecs2103.logic.commands.exceptions.CommandException;
import tp.acecs2103.model.task.*;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AddCommandTest {

    private Task defaultTaskOne = new Task(new Index("0101"), new WeekNumber("1"), new Description("Test Task One"),
            new OfficialDeadline("2020-09-10", LocalDate.of(2020, 9, 10)),
            null, new Remark("no remark"), false, false);

    private Task defaultTaskTwo = new Task(new Index("0101"), new WeekNumber("1"), new Description("Test Task One"),
            new OfficialDeadline("2021-01-01", LocalDate.of(2021, 1, 1)),
            null, new Remark("no remark"), false, false);

    private Task customizedTaskOne = new Task(new Index("0302"), new WeekNumber("3"),
            new Description("Test Task Three"), null,
            new CustomizedDeadline("2020-09-20", LocalDate.of(2020, 9, 20)),
            new Remark("no remark"), true, false);

    @Test
    public void constructor() throws CommandException {
        assertEquals(defaultTaskOne, new AddCommand(defaultTaskOne).getTaskToAdd());
    }

    @Test
    void execute() {
    }

    @Test
    void testEquals() {
    }
}