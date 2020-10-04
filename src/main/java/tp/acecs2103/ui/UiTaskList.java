package tp.acecs2103.ui;

import tp.acecs2103.model.task.*;

import java.util.ArrayList;

public class UiTaskList {
    private static ArrayList<Admin> adminList;
    private static ArrayList<Topic> topicList;
    private static ArrayList<IP> ipList;
    private static ArrayList<TP> tpList;

    public static void addAll(ArrayList<Task> taskList) {
        adminList.clear();
        topicList.clear();
        ipList.clear();
        tpList.clear();
        for (Task task: taskList) {
            if (task instanceof Admin) {
                adminList.add((Admin )task);
            } else if (task instanceof Topic) {
                topicList.add((Topic) task);
            } else if (task instanceof IP) {
                ipList.add((IP) task);
            } else if (task instanceof TP) {
                tpList.add((TP) task);
            }
        }
    }
}
