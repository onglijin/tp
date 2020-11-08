package tp.acecs2103.logic.commands;

import org.junit.jupiter.api.Test;
import tp.acecs2103.logic.commands.exceptions.CommandException;
import tp.acecs2103.model.Model;
import tp.acecs2103.model.ModelManager;
import tp.acecs2103.model.UserPrefs;
import tp.acecs2103.model.task.*;
import tp.acecs2103.testutil.TypicalTasks;


import static org.junit.jupiter.api.Assertions.*;
import static tp.acecs2103.testutil.Assert.assertThrows;

class DoneCommandTest {
    @Test
    public void execute_validIndex_success() {
        Model model = new ModelManager(TypicalTasks.getTypicalTaskList(), new UserPrefs());

        Index index = new Index("0301");
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

    public void equal_null_returnTrue() {
        Index index = new Index("0101");

        DoneCommand doneCommand = new DoneCommand(index);
        DoneCommand doneCommand1 = new DoneCommand(index);

        assertTrue(doneCommand.equals(doneCommand1));
    }

    @Test
    public void equal_null_returnFalse() {
        Index index = new Index("0101");
        Index index1 = new Index("0102");

        DoneCommand doneCommand = new DoneCommand(index);
        DoneCommand doneCommand1 = new DoneCommand(index1);

        assertFalse(doneCommand.equals(doneCommand1));
        assertFalse(doneCommand.equals(null));
        assertFalse(doneCommand.equals("0101"));
    }

}