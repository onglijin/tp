package tp.acecs2103.logic.commands;

import org.junit.jupiter.api.Test;
import tp.acecs2103.logic.commands.exceptions.CommandException;
import tp.acecs2103.model.Model;
import tp.acecs2103.model.ModelManager;
import tp.acecs2103.model.UserPrefs;
import tp.acecs2103.model.task.*;
import tp.acecs2103.testutil.TypicalTasks;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static tp.acecs2103.testutil.Assert.assertThrows;

class DeleteCommandTest {
    @Test
    public void execute_validIndex_success() {
        Model model = new ModelManager(TypicalTasks.getTypicalTaskList(), new UserPrefs());
        ModelManager expectedModel = new ModelManager(TypicalTasks.getTypicalTaskList(), new UserPrefs());

        Task task = new IP(new Index("0203"), new WeekNumber("2"), new Description("Test Task One"),
                null, new CustomizedDeadline("2020-09-10", LocalDate.of(2020, 9, 10)),
                 new Remark("no remark"), true, false);

        AddCommand addCommand = null;
        try {
            addCommand = new AddCommand(task);
            addCommand.execute(model);
        } catch (CommandException e) {
            e.printStackTrace();
        }

        Index index = new Index("0203");
        DeleteCommand deleteCommand = new DeleteCommand(index);
        CommandResult commandResult = null;
        try {
            commandResult = deleteCommand.execute(model);
        } catch (CommandException e) {
            e.printStackTrace();
        }

        String expectedMessage = String.format(DeleteCommand.MESSAGE_DELETE_TASK_SUCCESS, task);
        assertEquals(expectedMessage, commandResult.getFeedbackToUser());
        assertEquals(expectedModel, model);
    }

    @Test
    public void execute_invalidIndex_NonExistent_fail() {
        Model model = new ModelManager(TypicalTasks.getTypicalTaskList(), new UserPrefs());

        Index index = new Index("0203");
        DeleteCommand deleteCommand = new DeleteCommand(index);

        assertThrows(CommandException.class, () -> deleteCommand.execute(model));
    }

    @Test
    public void execute_invalidIndex_DefaultTask_fail() {
        Model model = new ModelManager(TypicalTasks.getTypicalTaskList(), new UserPrefs());

        Index index = new Index("0101");
        DeleteCommand deleteCommand = new DeleteCommand(index);

        assertThrows(CommandException.class, () -> deleteCommand.execute(model));
    }
}