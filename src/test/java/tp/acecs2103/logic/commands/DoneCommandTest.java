package tp.acecs2103.logic.commands;

import org.junit.jupiter.api.Test;
import tp.acecs2103.logic.commands.exceptions.CommandException;
import tp.acecs2103.model.Model;
import tp.acecs2103.model.ModelManager;
import tp.acecs2103.model.UserPrefs;
import tp.acecs2103.model.task.*;
import tp.acecs2103.testutil.TypicalTasks;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static tp.acecs2103.testutil.Assert.assertThrows;

class DoneCommandTest {
    @Test
    public void execute_validIndex_success() {
        Model model = new ModelManager(TypicalTasks.getTypicalTaskList(), new UserPrefs());

        Index index = new Index("0101");
        DoneCommand doneCommand = new DoneCommand(index);
        Task task = model.getTaskList().getTask(index);

        CommandResult commandResult = null;
        try {
            commandResult= doneCommand.execute(model);
        } catch (CommandException e) {
            e.printStackTrace();
        }

        String expectedMessage = String.format(DoneCommand.MESSAGE_DONE_TASK_SUCCESS, task);
        assertEquals(expectedMessage, commandResult.getFeedbackToUser());
        assertTrue(task.isDone());
    }

    @Test
    public void execute_invalidIndex_NonExistent_fail() {
        Model model = new ModelManager(TypicalTasks.getTypicalTaskList(), new UserPrefs());

        Index index = new Index("0203");
        DoneCommand doneCommand = new DoneCommand(index);

        assertThrows(CommandException.class, () -> doneCommand.execute(model));
    }

    @Test
    public void execute_invalidIndex_DoneTask_fail() {
        Model model = new ModelManager(TypicalTasks.getTypicalTaskList(), new UserPrefs());

        Index index = new Index("0101");
        Task task = model.getTaskList().getTask(index);
        task.markAsDone();
        DoneCommand doneCommand = new DoneCommand(index);

        assertThrows(CommandException.class, () -> doneCommand.execute(model));
    }

}