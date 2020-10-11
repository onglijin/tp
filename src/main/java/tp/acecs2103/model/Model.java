package tp.acecs2103.model;

import java.nio.file.Path;
import java.time.LocalDate;
import java.util.function.Predicate;

import javafx.collections.ObservableList;
import tp.acecs2103.commons.core.GuiSettings;
import tp.acecs2103.model.task.*;

/**
 * The API of the Model component.
 */
public interface Model {
    /** {@code Predicate} that always evaluate to true */
    Predicate<Person> PREDICATE_SHOW_ALL_PERSONS = unused -> true;

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
     * Adds task into task list.
     */
    void addTask(Task task);

    /**
     * Deletes one task out of task list with given index.
     */
    void deleteTask(String index);

    /**
     * Finds tasks based on given keyword.
     */
    void findTasks(String keyword);

    /**
     * Lists tasks in certain week.
     */
    void listTasks(int weekNumber);

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

    ObservableList<Admin> getAdminList();

    ObservableList<Topic> getTopicList();

    ObservableList<IP> getIpList();

    ObservableList<TP> getTpList();




}
