package tp.acecs2103.logic.commands;

import org.junit.jupiter.api.Test;
import tp.acecs2103.logic.commands.EditCommand.EditTaskDescriptor;
import tp.acecs2103.logic.commands.exceptions.CommandException;
import tp.acecs2103.model.Model;
import tp.acecs2103.model.ModelManager;
import tp.acecs2103.model.UserPrefs;
import tp.acecs2103.model.task.*;
import tp.acecs2103.testutil.EditTaskDescriptorBuilder;
import tp.acecs2103.testutil.TaskBuilder;
import tp.acecs2103.testutil.TypicalTasks;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static tp.acecs2103.testutil.Assert.assertThrows;



import static tp.acecs2103.logic.commands.CommandTestUtil.*;

public class EditCommandTest {
    @Test
    public void execute_allFieldsSpecifiedCustomisedAdminTask_success() {
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
    public void execute_allFieldsSpecifiedCustomisedTopicTask_success() {
        Model model = new ModelManager(TypicalTasks.getTypicalTaskList(), new UserPrefs());
        ModelManager expectedModel = new ModelManager(TypicalTasks.getTypicalTaskList(), new UserPrefs());

        Topic reference = new TaskBuilder().buildTopic();
        EditTaskDescriptor descriptor = new EditTaskDescriptorBuilder(reference).build();

        EditCommand editCommand = new EditCommand(new Index("0202"), descriptor);

        try {
            editCommand.execute(model);
        } catch (CommandException e) {
            e.printStackTrace();
        }

        Task taskToEdit = expectedModel.getTaskList().getTask(new Index("0202"));
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
    public void execute_allFieldsSpecifiedCustomisedIPTask_success() {
        Model model = new ModelManager(TypicalTasks.getTypicalTaskList(), new UserPrefs());
        ModelManager expectedModel = new ModelManager(TypicalTasks.getTypicalTaskList(), new UserPrefs());

        IP reference = new TaskBuilder().buildIp();
        EditTaskDescriptor descriptor = new EditTaskDescriptorBuilder(reference).build();

        EditCommand editCommand = new EditCommand(new Index("0302"), descriptor);

        try {
            editCommand.execute(model);
        } catch (CommandException e) {
            e.printStackTrace();
        }

        Task taskToEdit = expectedModel.getTaskList().getTask(new Index("0302"));
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
    public void execute_allFieldsSpecifiedCustomisedTPTask_success() {
        Model model = new ModelManager(TypicalTasks.getTypicalTaskList(), new UserPrefs());
        ModelManager expectedModel = new ModelManager(TypicalTasks.getTypicalTaskList(), new UserPrefs());

        TP reference = new TaskBuilder().buildTp();
        EditTaskDescriptor descriptor = new EditTaskDescriptorBuilder(reference).build();

        EditCommand editCommand = new EditCommand(new Index("0402"), descriptor);

        try {
            editCommand.execute(model);
        } catch (CommandException e) {
            e.printStackTrace();
        }

        Task taskToEdit = expectedModel.getTaskList().getTask(new Index("0402"));
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

    @Test
    public void equal_null_returnTrue() {
        Admin reference = new TaskBuilder().buildAdmin();
        EditTaskDescriptor descriptor1 = new EditTaskDescriptorBuilder(reference).build();
        EditTaskDescriptor descriptor2 = new EditTaskDescriptorBuilder(reference).build();
        EditCommand editCommand1 = new EditCommand(new Index("0102"), descriptor1);
        EditCommand editCommand2 = new EditCommand(new Index("0102"), descriptor2);
        assertTrue(editCommand1.equals(editCommand2));
    }

    @Test
    public void equal_null_returnFalse() {
        Admin reference = new TaskBuilder().buildAdmin();
        EditTaskDescriptor descriptor1 = new EditTaskDescriptorBuilder(reference).build();
        EditTaskDescriptor descriptor2 = new EditTaskDescriptorBuilder(reference).build();
        EditCommand editCommand1 = new EditCommand(new Index("0101"), descriptor1);
        EditCommand editCommand2 = new EditCommand(new Index("0102"), descriptor2);
        assertFalse(editCommand1.equals(null));
        assertFalse(editCommand1.equals("1"));
        assertFalse(editCommand1.equals(editCommand2));
    }

    @Test
    public void equalDescriptor_null_returnTrue() {
        Admin reference = new TaskBuilder().buildAdmin();
        EditTaskDescriptor descriptor1 = new EditTaskDescriptorBuilder(reference).build();
        EditTaskDescriptor descriptor2 = new EditTaskDescriptorBuilder(reference).build();
        assertTrue(descriptor1.equals(descriptor2));
    }

    @Test
    public void equalDescriptor_null_returnFalse() {
        Admin reference = new TaskBuilder().buildAdmin();
        IP ref2 = new TaskBuilder().build();
        EditTaskDescriptor descriptor1 = new EditTaskDescriptorBuilder(reference).build();
        EditTaskDescriptor descriptor2 = new EditTaskDescriptorBuilder(ref2).build();
        assertFalse(descriptor1.equals(descriptor2));
        assertFalse(descriptor1.equals(null));
        assertFalse(descriptor1.equals("1"));
    }

    @Test
    public void isAnyFieldEdited_null_returnTrue() {
        Admin reference = new TaskBuilder().buildAdmin();
        EditTaskDescriptor descriptor = new EditTaskDescriptorBuilder(reference).build();
        assertTrue(descriptor.isAnyFieldEdited());
    }

    @Test
    public void isAnyFieldEdited_null_returnFalse() {
        EditTaskDescriptor descriptor = new EditTaskDescriptor();
        assertFalse(descriptor.isAnyFieldEdited());
    }







}