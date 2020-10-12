package tp.acecs2103.model.task;

public enum TaskCategory {
    ADMIN, IP, TP, TOPIC, TASK;

    public String categoryToString(TaskCategory category) {
        switch (category) {
            case ADMIN:
                return "admin";
            case TOPIC:
                return "topic";
            case IP:
                return "ip";
            case TP:
                return "tp";
        }
    }

    public static boolean isAdmin(TaskCategory category) {
        return category == ADMIN;
    }

    public static boolean isTopic(TaskCategory category) {
        return category == TOPIC;
    }

    public static boolean isIP(TaskCategory category) {
        return category == IP;
    }

    public static boolean isTP(TaskCategory category) {
        return category == TP;
    }
}
