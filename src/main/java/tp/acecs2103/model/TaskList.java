package tp.acecs2103.model;

import tp.acecs2103.model.task.Task;

import java.time.LocalDate;
import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> taskList = new ArrayList<>();
    private String keyWord; // This is to store condition for searching and displaying.
    private int timeRange;

    public TaskList(ArrayList<Task> taskList, int timeRange) {
        this.taskList = taskList;
        this.keyWord = "";
        this.timeRange = timeRange;
    }

    /**
     * Finds tasks based on existing keyWord and timeRange.
     *
     * @return a ArrayList consisting of all satisfied tasks.
     */
    public ArrayList<Task> find() {
        ArrayList<Task> newList = new ArrayList<>();
        for (Task task: taskList) {
            if (task.contains(keyWord) && task.isWeekX(timeRange)) {
                newList.add(task);
            }
        }
        return newList;
    }

    /**
     * Finds tasks based on new keyWord and timeRange.
     * @param newKeyWord is new keyword given by user.
     *
     * @return a new ArrayList to display.
     */
    public ArrayList<Task> find(String newKeyWord) {
        keyWord = newKeyWord;
        ArrayList<Task> newList = new ArrayList<>();
        for (Task task: taskList) {
            if (task.contains(keyWord)) {
                newList.add(task);
            }
        }
        return newList;
    }

    public ArrayList<Task> list(int weekNumber) {
        timeRange = weekNumber;
        ArrayList<Task> newList = new ArrayList<Task>();
        for (Task task: taskList) {
            if (task.isWeekX(weekNumber) && task.isWeekX(timeRange)) {
                newList.add(task);
            }
        }
        return newList;
    }

    public ArrayList<Task> delete(String taskIndex) {
        int i = 0;
        for (Task task: taskList) {
            i++;
            if (task.hasIndex(taskIndex)) {
                break;
            }
        }
        taskList.remove(i);
        return find();
    }

    public ArrayList<Task> deadline(String taskIndex, LocalDate deadline) {
        for (Task task: taskList) {
            if (task.hasIndex(taskIndex)) {
                task.setDeadline(deadline);
            }
        }
        return find();
    }
}
