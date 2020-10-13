package tp.acecs2103.model.task;

public enum TaskCategory {
    ADMIN, IP, TP, TOPIC, TASK;

    public static String categoryToString(TaskCategory category) {
        switch (category) {
            case ADMIN:
                return "admin";
            case TOPIC:
                return "topic";
            case IP:
                return "ip";
            case TP:
                return "tp";
            default:
                return "";
        }
    }

    public static boolean isAdmin(TaskCategory category) {
        return category == ADMIN;
    }

    public static boolean isAdmin(String category) {
        return category == "admin";
    }

    public static boolean isTopic(TaskCategory category) {
        return category == TOPIC;
    }

    public static boolean isTopic(String category) {
        return category == "topic";
    }

    public static boolean isIP(TaskCategory category) {
        return category == IP;
    }

    public static boolean isIP(String category) {
        return category == "ip";
    }

    public static boolean isTP(TaskCategory category) {
        return category == TP;
    }

    public static boolean isTP(String category) {
        return category == "tp";
    }
}
