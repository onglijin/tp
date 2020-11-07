package tp.acecs2103.logic.commands;

import org.junit.jupiter.api.Test;
import tp.acecs2103.logic.commands.EditCommand.EditTaskDescriptor;
import tp.acecs2103.logic.commands.exceptions.CommandException;
import tp.acecs2103.model.Model;
import tp.acecs2103.model.ModelManager;
import tp.acecs2103.model.TaskList;
import tp.acecs2103.model.UserPrefs;
import tp.acecs2103.model.task.Admin;
import tp.acecs2103.model.task.IP;
import tp.acecs2103.model.task.Index;
import tp.acecs2103.model.task.Task;
import tp.acecs2103.testutil.EditTaskDescriptorBuilder;
import tp.acecs2103.testutil.TaskBuilder;
import tp.acecs2103.testutil.TypicalTasks;

import static tp.acecs2103.testutil.Assert.assertThrows;


import static tp.acecs2103.logic.commands.CommandTestUtil.*;

public class EditCommandTest {
    @Test
    public void execute_allFieldsSpecifiedCustomisedTask_success() {
        Model model = new ModelManager(TypicalTasks.getTypicalTaskList(), new UserPrefs());
        ModelManager expectedModel = new ModelManager(TypicalTasks.getTypicalTaskList(), new UserPrefs());

        Admin reference = new TaskBuilder().buildAdmin();
        EditTaskDescriptor descriptor = new EditTaskDescriptorBuilder(reference).build();
        EditCommand editCommand = new EditCommand(new Index("0102"), descriptor);

        try {
            editCommand.execute(model);
        } catch (CommandException e) {
            e.printStackTrace();
        }

        Task taskToEdit = expectedModel.getTaskList().getTask(new Index("0102"));
        Task editedTask = null;
        try {
            editedTask = EditCommand.createEditedTask(taskToEdit,descriptor);
        } catch (CommandException e) {
            e.printStackTrace();
        }
        expectedModel.setTask(taskToEdit, editedTask);

        String expectedMessage = String.format(EditCommand.MESSAGE_EDIT_TASK_SUCCESS, editedTask);
        assertCommandSuccess(editCommand, model, expectedMessage, expectedModel);
    }

    @Test
    public void execute_allFieldsSpecifiedDefaultTask_success() {
        Model model = new ModelManager(TypicalTasks.getTypicalTaskList(), new UserPrefs());
        ModelManager expectedModel = new ModelManager(TypicalTasks.getTypicalTaskList(), new UserPrefs());

        IP reference = new TaskBuilder().build();
        EditTaskDescriptor descriptor = new EditTaskDescriptorBuilder(reference).build();
        EditCommand editCommand = new EditCommand(new Index("0101"), descriptor);

        try {
            editCommand.execute(model);
        } catch (CommandException e) {
            e.printStackTrace();
        }

        Task taskToEdit = expectedModel.getTaskList().getTask(new Index("0101"));
        Task editedTask = null;
        try {
            editedTask = EditCommand.createEditedTask(taskToEdit,descriptor);
        } catch (CommandException e) {
            e.printStackTrace();
        }
        expectedModel.setTask(taskToEdit, editedTask);

        String expectedMessage = String.format(EditCommand.MESSAGE_EDIT_TASK_SUCCESS, editedTask);
        assertCommandSuccess(editCommand, model, expectedMessage, expectedModel);
    }

    @Test
    public void execute_allFieldsSpecifiedDefaultTask_fail() {
        Model model = new ModelManager(TypicalTasks.getTypicalTaskList(), new UserPrefs());
        ModelManager expectedModel = new ModelManager(TypicalTasks.getTypicalTaskList(), new UserPrefs());

        Admin reference = new TaskBuilder().buildAdmin();
        EditTaskDescriptor descriptor = new EditTaskDescriptorBuilder(reference).build();
        EditCommand editCommand = new EditCommand(new Index("0101"), descriptor);

        assertThrows(CommandException.class, () -> editCommand.execute(model));
    }

    @Test
    public void execute_someFieldsSpecifiedDefault_success() {
        ModelManager model = new ModelManager(TypicalTasks.getTypicalTaskList(), new UserPrefs());
        ModelManager expectedModel = new ModelManager(TypicalTasks.getTypicalTaskList(), new UserPrefs());

        EditTaskDescriptor descriptor = new EditTaskDescriptorBuilder()
                .withRemark(VALID_REMARK_1).build();

        EditCommand editCommand = new EditCommand(new Index("0101"), descriptor);
        try {
            editCommand.execute(model);
        } catch (CommandException e) {
            e.printStackTrace();
        }

        Task taskToEdit = expectedModel.getTaskList().getTask(new Index("0101"));
        Task editedTask = null;
        try {
            editedTask = EditCommand.createEditedTask(taskToEdit,descriptor);
        } catch (CommandException e) {
            e.printStackTrace();
        }
        expectedModel.setTask(taskToEdit, editedTask);

        String expectedMessage = String.format(EditCommand.MESSAGE_EDIT_TASK_SUCCESS, editedTask);

        assertCommandSuccess(editCommand, model, expectedMessage, expectedModel);
    }

    @Test
    public void execute_noFieldSpecifiedUnfilteredList_success() {
        ModelManager model = new ModelManager(TypicalTasks.getTypicalTaskList(), new UserPrefs());
        ModelManager expectedModel = new ModelManager(TypicalTasks.getTypicalTaskList(), new UserPrefs());

        EditTaskDescriptor descriptor = new EditTaskDescriptor();
        EditCommand editCommand = new EditCommand(new Index("0101"), descriptor);
        Task taskToEdit = model.getTaskList().getTask(new Index("0101"));

        try {
            editCommand.execute(model);
        } catch (CommandException e) {
            e.printStackTrace();
        }

        String expectedMessage = String.format(EditCommand.MESSAGE_EDIT_TASK_SUCCESS, taskToEdit);
        assertCommandSuccess(editCommand, model, expectedMessage, expectedModel);
    }







}