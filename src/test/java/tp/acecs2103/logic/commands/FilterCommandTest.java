package tp.acecs2103.logic.commands;

import org.junit.jupiter.api.Test;
import tp.acecs2103.commons.core.Messages;
import tp.acecs2103.logic.commands.EditCommand.EditTaskDescriptor;
import tp.acecs2103.logic.commands.exceptions.CommandException;
import tp.acecs2103.logic.parser.exceptions.ParseException;
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

class FilterCommandTest {
    @Test
    public void execute_done_success() {
        Model model = new ModelManager(TypicalTasks.getTypicalTaskList(), new UserPrefs());
        ModelManager expectedModel = new ModelManager(TypicalTasks.getTypicalTaskList(), new UserPrefs());
        FilterCommand filterCommand = null;
        try {
            filterCommand = new FilterCommand("done");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        filterCommand.execute(model);
        expectedModel.filterTasks(true,false,null);
        String expectedMessage = FilterCommand.MESSAGE_SUCCESS + "\nStatus: done"
        + "\n-->" + String.format(Messages.MESSAGE_TASKS_LISTED_OVERVIEW, model.getUiTaskList().size());;
        assertCommandSuccess(filterCommand, model, expectedMessage, expectedModel);
    }

    @Test
    public void execute_pending_byOfficial_success() {
        Model model = new ModelManager(TypicalTasks.getExtraTaskList(), new UserPrefs());
        ModelManager expectedModel = new ModelManager(TypicalTasks.getExtraTaskList(), new UserPrefs());
        FilterCommand filterCommand = null;
        try {
            filterCommand = new FilterCommand("pending", "official");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        filterCommand.execute(model);
        expectedModel.filterTasks(false,true,null);
        String expectedMessage = FilterCommand.MESSAGE_SUCCESS + "\nStatus: pending"
                + ("\nBy: official deadline")
                + "\n-->" + String.format(Messages.MESSAGE_TASKS_LISTED_OVERVIEW, model.getUiTaskList().size());;
        assertCommandSuccess(filterCommand, model, expectedMessage, expectedModel);
    }

    @Test
    public void execute_pending_byCustomized_success() {
        Model model = new ModelManager(TypicalTasks.getExtraTaskList(), new UserPrefs());
        ModelManager expectedModel = new ModelManager(TypicalTasks.getExtraTaskList(), new UserPrefs());
        FilterCommand filterCommand = null;
        try {
            filterCommand = new FilterCommand("pending", "customised");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        filterCommand.execute(model);
        expectedModel.filterTasks(false,false,null);
        String expectedMessage = FilterCommand.MESSAGE_SUCCESS + "\nStatus: pending"
                + ("\nBy: customised deadline")
                + "\n-->" + String.format(Messages.MESSAGE_TASKS_LISTED_OVERVIEW, model.getUiTaskList().size());;
        assertCommandSuccess(filterCommand, model, expectedMessage, expectedModel);
    }

    @Test
    public void execute_pending_byCustomized_Week1_success() {
        Model model = new ModelManager(TypicalTasks.getExtraTaskList(), new UserPrefs());
        ModelManager expectedModel = new ModelManager(TypicalTasks.getExtraTaskList(), new UserPrefs());
        FilterCommand filterCommand = null;
        WeekNumber weekNumber = new WeekNumber("1");

        try {
            filterCommand = new FilterCommand("pending", "customised", weekNumber);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        filterCommand.execute(model);
        expectedModel.filterTasks(false,false,weekNumber);
        String expectedMessage = FilterCommand.MESSAGE_SUCCESS + "\nStatus: pending"
                + ("\nBy: customised deadline")
                + "\nDuration: week 1"
                + "\n-->" + String.format(Messages.MESSAGE_TASKS_LISTED_OVERVIEW, model.getUiTaskList().size());;
        assertCommandSuccess(filterCommand, model, expectedMessage, expectedModel);
    }

    @Test
    public void execute_pending_byCustomized_Week5_success() {
        Model model = new ModelManager(TypicalTasks.getExtraTaskList(), new UserPrefs());
        ModelManager expectedModel = new ModelManager(TypicalTasks.getExtraTaskList(), new UserPrefs());
        FilterCommand filterCommand = null;
        WeekNumber weekNumber = new WeekNumber("5");

        try {
            filterCommand = new FilterCommand("pending", "customised", weekNumber);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        filterCommand.execute(model);
        expectedModel.filterTasks(false,false,weekNumber);
        String expectedMessage = FilterCommand.MESSAGE_SUCCESS + "\nStatus: pending"
                + ("\nBy: customised deadline")
                + "\nDuration: week 5"
                + "\n-->" + String.format(Messages.MESSAGE_TASKS_LISTED_OVERVIEW, model.getUiTaskList().size());;
        assertCommandSuccess(filterCommand, model, expectedMessage, expectedModel);
    }

    @Test
    public void execute_pending_byCustomized_Week13_success() {
        Model model = new ModelManager(TypicalTasks.getExtraTaskList(), new UserPrefs());
        ModelManager expectedModel = new ModelManager(TypicalTasks.getExtraTaskList(), new UserPrefs());
        FilterCommand filterCommand = null;
        WeekNumber weekNumber = new WeekNumber("13");

        try {
            filterCommand = new FilterCommand("pending", "customised", weekNumber);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        filterCommand.execute(model);
        expectedModel.filterTasks(false,false,weekNumber);
        String expectedMessage = FilterCommand.MESSAGE_SUCCESS + "\nStatus: pending"
                + ("\nBy: customised deadline")
                + "\nDuration: week 13"
                + "\n-->" + String.format(Messages.MESSAGE_TASKS_LISTED_OVERVIEW, model.getUiTaskList().size());;
        assertCommandSuccess(filterCommand, model, expectedMessage, expectedModel);
    }

    @Test
    public void equal_null_returnFalse() {
        WeekNumber weekNumber = new WeekNumber("13");
        WeekNumber weekNumber1 = new WeekNumber("1");
        FilterCommand filterCommand = null;
        FilterCommand filterCommand1 = null;
        try {
            filterCommand = new FilterCommand("pending", "customised", weekNumber);
            filterCommand1 = new FilterCommand("pending", "customised", weekNumber1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        assertFalse(filterCommand1.equals(null));
        assertFalse(filterCommand1.equals("1"));
        assertFalse(filterCommand1.equals(filterCommand));
    }

    @Test
    public void equal_null_returnTrue() {
        WeekNumber weekNumber = new WeekNumber("13");
        FilterCommand filterCommand = null;
        FilterCommand filterCommand1 = null;
        try {
            filterCommand = new FilterCommand("pending", "customised", weekNumber);
            filterCommand1 = new FilterCommand("pending", "customised", weekNumber);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        assertTrue(filterCommand1.equals(filterCommand));
    }




}