package tp.acecs2103.model;

import tp.acecs2103.model.task.*;

import java.util.ArrayList;

public class UiTaskList {
    private static ArrayList<Admin> adminList;
    private static ArrayList<Topic> topicList;
    private static ArrayList<IP> ipList;
    private static ArrayList<TP> tpList;

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
    

    public ArrayList<Admin> getAdminList() {
        return adminList;
    }

    public static ArrayList<IP> getIpList() {
        return ipList;
    }

    public static ArrayList<TP> getTpList() {
        return tpList;
    }

    public static ArrayList<Topic> getTopicList() {
        return topicList;
    }
}
