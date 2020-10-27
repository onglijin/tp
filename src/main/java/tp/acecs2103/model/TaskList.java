package tp.acecs2103.model;

import static java.util.Objects.requireNonNull;

import java.time.LocalDate;
import java.util.ArrayList;

import tp.acecs2103.commons.util.AppUtil;
import tp.acecs2103.model.task.CustomizedDeadline;
import tp.acecs2103.model.task.Index;
import tp.acecs2103.model.task.OfficialDeadline;
import tp.acecs2103.model.task.Task;
import tp.acecs2103.model.task.WeekNumber;


public class TaskList {
    private ArrayList<Task> taskList;
    private WeekNumber timeRange;

    /**
     * Initializes a {@code TaskList} with given task list and time range.
     *
     * @param taskList is given task list.
     * @param timeRange is given time range.
     */
    public TaskList(ArrayList<Task> taskList, WeekNumber timeRange) {
        this.taskList = taskList;
        this.timeRange = timeRange;
    }

    /**
     * Initializes a {@code TaskList}.
     */
    public TaskList() {
        this.taskList = new ArrayList<>();
        this.timeRange = AppUtil.getCurrentWeekNumber();
    }

    /**
     * Initializes a {@code TaskList} with a given task list.
     */
    public TaskList(TaskList taskList) {
        resetData(taskList);
    }

    /**
     * Resets the task list with given new data.
     *
     * @param newData is a {@code TaskList}.
     */
    public void resetData(TaskList newData) {
        requireNonNull(newData);
        taskList = newData.getTaskList();
        timeRange = newData.getTimeRange();
    }


    /**
     * Gets a array list consisting of all tasks.
     *
     * @return an ArrayList.
     */
    public ArrayList<Task> getTaskList() {
        return taskList;
    }


    /**
     * Gets time range.
     *
     * @return a int of time range.
     */
    public WeekNumber getTimeRange() {
        return timeRange;
    }

    /**
     * Sets a time range for task list.
     *
     * @param weekNumber is new time range.
     */
    public void setTimeRange(WeekNumber weekNumber) {
        timeRange = weekNumber;
    }

    /**
     * Checks whether the task is already inside list.
     *
     * @param task is what we want we check.
     * @return true if it is already inside task and false if not.
     */
    public boolean hasTask(Task task) {
        return taskList.contains(task);
    }

    /**
     * Finds a certain task based on index.
     *
     * @return a task with the required index.
     */
    public Task getTask(Index index) {
        for (Task task: taskList) {
            //index is stored as String in task object,// so a conversion from string to int is needed
            if (task.getIndex().equals(index)) {
                return task;
            }
        }
        return null;
    }

    /**
     * Finds tasks based on existing keyWord and timeRange.
     *
     * @return a ArrayList consisting of all satisfied tasks.
     */
    public ArrayList<Task> find() {
        ArrayList<Task> newList = new ArrayList<>();
        for (Task task: taskList) {
            if (task.isWeekX(timeRange)) {
                newList.add(task);
            }
        }
        return newList;
    }

    /**
     * Finds tasks based on new keyWord and timeRange.
     *
     * @param keyWord is new keyword given by user.
     * @return a new ArrayList to display.
     */
    public ArrayList<Task> find(String keyWord) {
        ArrayList<Task> newList = new ArrayList<>();
        for (Task task: taskList) {
            if (task.contains(keyWord)) {
                newList.add(task);
            }
        }
        return newList;
    }

    /**
     * Finds all of tasks in certain week.
     *
     * @param weekNumber A valid week number.
     * @return a array list consisting of all satisfied tasks.
     */
    public ArrayList<Task> list(WeekNumber weekNumber) {
        // TODO: include assertion?
//        assert weekNumber.value <= 13;
        timeRange = weekNumber;
        ArrayList<Task> newList = new ArrayList<Task>();
        for (Task task: taskList) {
            if (task.isWeekX(weekNumber)) {
                newList.add(task);
            }
        }
        return find();
    }

    /**
     * Adds a task.
     *
     * @param task A valid task.
     * @return a new array list after find().
     */
    public ArrayList<Task> add(Task task) {
        taskList.add(task);
        return find();
    }

    /**
     * Deletes a certain task.
     * @param taskIndex A valid task index.
     * @return a new array list after find().
     */
    public ArrayList<Task> delete(Index taskIndex) {
        int i = 0;
        for (Task task: taskList) {
            if (task.hasIndex(taskIndex)) {
                break;
            }
            i++;
        }
        taskList.remove(i);
        return find();
    }

    /**
     * Sets a deadline to a certain task.
     *
     * @param taskIndex A valid task index.
     * @param deadline A valid deadline.
     * @return a new array list after find().
     */
    public ArrayList<Task> deadline(Index taskIndex, CustomizedDeadline deadline) {
        for (Task task: taskList) {
            if (task.hasIndex(taskIndex)) {
                task.setDeadline(deadline);
            }
        }
        return find();
    }

    /**
     * Edits a certain task.
     *
     * @param target Target task.
     * @param newTask New task.
     * @return a new array list after find().
     */
    public ArrayList<Task> resetTask(Task target, Task newTask) {
        requireNonNull(target);
        requireNonNull(newTask);

        int index = taskList.indexOf(target);
        taskList.set(index, newTask);
        return find();
    }

    /**
     * Fetches a task list with current key word and time range.
     *
     * @return a new array list.
     */
    public ArrayList<Task> getUiTaskList() {
        return find();
    }

    /**
     * Gets the size of task list.
     */
    public int size() {
        return taskList.size();
    }
}

