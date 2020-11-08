package tp.acecs2103.logic.commands;

import org.junit.jupiter.api.Test;
import tp.acecs2103.model.Model;
import tp.acecs2103.model.ModelManager;
import tp.acecs2103.model.UserPrefs;
import tp.acecs2103.testutil.TypicalTasks;

import static org.junit.jupiter.api.Assertions.*;

class CommandResultTest {
    @Test
    public void getFeedback_null_String() {
        Model model = new ModelManager(TypicalTasks.getTypicalTaskList(), new UserPrefs());
        CommandResult commandResult = new ClearCommand().execute(model);
        String MESSAGE_SUCCESS = "Address book has been cleared!";
        assertTrue(MESSAGE_SUCCESS.equals(commandResult.getFeedbackToUser()));
        assertFalse("random".equals(commandResult.getFeedbackToUser()));
    }
}
