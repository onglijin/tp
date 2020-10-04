package tp.acecs2103.model;

import tp.acecs2103.model.task.Task;
import tp.acecs2103.storage.TaskStorage;
import tp.acecs2103.ui.UiTaskList;

import java.util.ArrayList;

public class TaskList {
    private static ArrayList<Task> taskList = new ArrayList<>();
    private static String keyWord; // This is to store condition for searching and displaying.
    private static int timeRange;

    public static void initialize() {
        taskList.addAll(TaskStorage.readTaskList());
        UiTaskList.addAll(find(keyWord));
    }

    /**
     * Finds tasks based on existing keyWord and timeRange.
     *
     * @return a ArrayList consisting of all satisfied tasks.
     */
    public static ArrayList<Task> find() {
        return taskList;
    }

    /**
     * Finds tasks based on new keyWord and timeRange.
     * @param keyWord is new keyword given by user.
     *
     * @return a new ArrayList to display.
     */
    public static ArrayList<Task> find(String keyWord) {
        return taskList;
    }

    public static ArrayList<Task> list(int weekNumber) {
        return find();
    }

    public static ArrayList<Task> delete(String taskIndex) {
        return find();
    }

    public static ArrayList<Task> deadline() {
        return find();
    }
}
