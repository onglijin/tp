package tp.acecs2103.model;

import javafx.collections.ObservableList;
import tp.acecs2103.model.task.*;

import java.util.ArrayList;

public class UiTaskList {
    private static ObservableList<Admin> adminList;
    private static ObservableList<Topic>  topicList;
    private static ObservableList<IP>  ipList;
    private static ObservableList<TP>  tpList;


    public UiTaskList(ArrayList<Task> source) {
        addAll(source);
    }

    public static void addAll(ArrayList<Task> taskList) {
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

    public ObservableList<Admin>  getAdminList() {
        return adminList;
    }

    public static ObservableList<IP>  getIpList() {

        return ipList;
    }

    public static ObservableList<TP> getTpList() {
        return tpList;
    }

    public static ObservableList<Topic> getTopicList() {
        return topicList;
    }

    public int size() {
        return adminList.size() + ipList.size() + tpList.size() + topicList.size();
    }
}
