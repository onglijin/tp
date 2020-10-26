package tp.acecs2103.model;

import java.nio.file.Path;
import java.time.LocalDate;
import java.util.function.Predicate;

import javafx.collections.ObservableList;
import tp.acecs2103.commons.core.GuiSettings;
import tp.acecs2103.model.exceptions.ModelException;
import tp.acecs2103.model.task.Task;

/**
 * The API of the Model component.
 */
public interface Model {
    /** {@code Predicate} that always evaluate to true */
    Predicate<Task> PREDICATE_SHOW_ALL_TASKS = unused -> true;

    /**
     * Replaces user prefs data with the data in {@code userPrefs}.
     */
    void setUserPrefs(ReadOnlyUserPrefs userPrefs);

    /**
     * Returns the user prefs.
     */
    ReadOnlyUserPrefs getUserPrefs();

    /**
     * Returns the user prefs' GUI settings.
     */
    GuiSettings getGuiSettings();

    /**
     * Sets the user prefs' GUI settings.
     */
    void setGuiSettings(GuiSettings guiSettings);

    /**
     * Returns the user prefs' task list file path.
     */
    Path getTaskListFilePath();

    /**
     * Returns true if a task with the same identity as {@code task} exists in the task list.
     */
    boolean hasTask(Task task);

    /**
     * Sets the user prefs' task list file path.
     */
    void setTaskListFilePath(Path taskListFilePath);

    /**
     * Replaces task list data with the data in {@code taskList}.
     */
    void setTaskList(TaskList taskList);

    /** Returns the TaskList */
    TaskList getTaskList();

    /**
     * Replaces the given task {@code target} with {@code editedTask}.
     * {@code target} must exist in the task list.
     * The person identity of {@code editedPerson} must not be the same as another existing task in the task list
     */
    void setTask(Task target, Task editedTask);

    /**
     * Adds task into task list.
     */
    void addTask(Task task);

    /**
     * Checks whether the task is customized.
     */
    boolean isCustomizedTask(String index);

    /**
     * Deletes one task out of task list with given index.
     */
    void deleteTask(String index) throws ModelException;

    /**
     * Mark one task out of task list with given index as done.
     */
    void markTaskAsDone(String index) throws ModelException;

    /**
     * Finds tasks based on given keyword.
     */
    void findTasks(String keyword);

    /**
     * Lists tasks in certain week.
     */
    void listTasks(int weekNumber);

    /**
     * Lists tasks in certain week.
     */
    void filterTasks(boolean isDone, boolean byOfficialDeadline, int weekNumber);


    /**
     * Sets a customized deadline to a certain.
     * @param index is the index of task we want to set a deadline to.
     * @param deadline is a customized deadline.
     */
    void deadlineTask(String index, LocalDate deadline);

    /**
     * Gets  a ui task list for displaying.
     */
    UiTaskList getUiTaskList();

    ObservableList<Task> getAdminList();

    ObservableList<Task> getTopicList();

    ObservableList<Task> getIpList();

    ObservableList<Task> getTpList();




}
