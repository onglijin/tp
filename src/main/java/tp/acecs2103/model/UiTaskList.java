package tp.acecs2103.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import tp.acecs2103.model.task.*;

import java.util.ArrayList;

public class UiTaskList {
    private ObservableList<Task> adminList = FXCollections.observableArrayList();
    private ObservableList<Task>  topicList = FXCollections.observableArrayList();
    private ObservableList<Task>  ipList = FXCollections.observableArrayList();
    private ObservableList<Task>  tpList = FXCollections.observableArrayList();


    public UiTaskList(ArrayList<Task> source) {
        addAll(source);
    }

    public void addAll(ArrayList<Task> taskList) {
        adminList.clear();
        topicList.clear();
        ipList.clear();
        tpList.clear();
        for (Task task: taskList) {
            if (TaskCategory.isAdmin(task.getCategory())) {
                adminList.add((Admin) task);
            } else if (TaskCategory.isTopic(task.getCategory())) {
                topicList.add((Topic) task);
            } else if (TaskCategory.isIP(task.getCategory())) {
                ipList.add((IP) task);
            } else if (TaskCategory.isTP(task.getCategory())) {
                tpList.add((TP) task);
            }
        }
    }

    public ObservableList<Task>  getAdminList() {
        return adminList;
    }

    public ObservableList<Task>  getIpList() {

        return ipList;
    }

    public ObservableList<Task> getTpList() {
        return tpList;
    }

    public ObservableList<Task> getTopicList() {
        return topicList;
    }

    public int size() {
        return adminList.size() + ipList.size() + tpList.size() + topicList.size();
    }
}
