package tp.acecs2103.model;

import static java.util.Objects.requireNonNull;
import static tp.acecs2103.commons.util.CollectionUtil.requireAllNonNull;

import java.nio.file.Path;
import java.time.LocalDate;
import java.util.function.Predicate;
import java.util.logging.Logger;

import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import tp.acecs2103.commons.core.GuiSettings;
import tp.acecs2103.commons.core.LogsCenter;
import tp.acecs2103.model.task.*;
import tp.acecs2103.commons.util.CollectionUtil;

/**
 * Represents the in-memory model of the address book data.
 */
public class ModelManager implements Model {
    private static final Logger logger = LogsCenter.getLogger(ModelManager.class);

    private final TaskList taskList;
    private final UiTaskList uiTaskList;
    private final UserPrefs userPrefs;

    /**
     * Initializes a ModelManager with the given addressBook and userPrefs.
     */
    public ModelManager(TaskList taskList, ReadOnlyUserPrefs userPrefs) {
        super();
        CollectionUtil.requireAllNonNull(taskList, userPrefs);

        logger.fine("Initializing with task list: " + taskList + " and user prefs " + userPrefs);

        this.taskList = new TaskList(taskList);
        this.userPrefs = new UserPrefs(userPrefs);
        this.uiTaskList = new UiTaskList(this.taskList.getUiTaskList());
    }

    public ModelManager() {
        this.taskList = new TaskList();
        this.userPrefs = new UserPrefs();
        this.uiTaskList = new UiTaskList(taskList.getUiTaskList());
    }

    //=========== UserPrefs ==================================================================================

    @Override
    public void setUserPrefs(ReadOnlyUserPrefs userPrefs) {
        requireNonNull(userPrefs);
        this.userPrefs.resetData(userPrefs);
    }

    @Override
    public ReadOnlyUserPrefs getUserPrefs() {
        return userPrefs;
    }

    @Override
    public GuiSettings getGuiSettings() {
        return userPrefs.getGuiSettings();
    }

    @Override
    public void setGuiSettings(GuiSettings guiSettings) {
        requireNonNull(guiSettings);
        userPrefs.setGuiSettings(guiSettings);
    }

    @Override
    public Path getTaskListFilePath() {
        return userPrefs.getTaskListFilePath();
    }

    @Override
    public void setTaskListFilePath(Path taskListFilePath) {
        requireNonNull(taskListFilePath);
        userPrefs.setTaskListFilePath(taskListFilePath);
    }

    //=========== TaskList ================================================================================

    @Override
    public void setTaskList(TaskList taskList) {
        this.taskList.resetData(taskList);
    }

    @Override
    public TaskList getTaskList() {
        return taskList;
    }

    @Override
    public boolean hasTask(Task task) {
        requireNonNull(task);
        return taskList.hasTask(task);
        }

    @Override
    public void addTask(Task task) {
        UiTaskList.addAll(taskList.add(task));
    }

    @Override
    public void deleteTask(String index) {
        uiTaskList.addAll(taskList.delete(index));
    }

    @Override
    public void findTasks(String keyword) {
        uiTaskList.addAll(taskList.find(keyword));
    };

    @Override
    public void listTasks(int weekNumber) {
        uiTaskList.addAll(taskList.list(weekNumber));
    };

    @Override
    public void deadlineTask(String index, LocalDate deadline) {
        uiTaskList.addAll(taskList.deadline(index, deadline));
    }

    @Override
    public void setTask(Task target, Task editedTask) {
        uiTaskList.addAll(taskList.resetTask(target, editedTask));
    };

    //=========== UiTaskList ================================================================================

    @Override
    public UiTaskList getUiTaskList() {
        return uiTaskList;
    }


    @Override
    public ObservableList<Admin> getAdminList() {
        return uiTaskList.getAdminList();
    }

    @Override
    public ObservableList<Topic> getTopicList() {
        return uiTaskList.getTopicList();
    }

    @Override
    public ObservableList<IP> getIpList() {
        return uiTaskList.getIpList();
    }

    @Override
    public ObservableList<TP> getTpList() {
        return uiTaskList.getTpList();
    }

}

