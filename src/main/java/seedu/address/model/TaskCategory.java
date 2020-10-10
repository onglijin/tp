package seedu.address.model;

public enum TaskCategory {
    ADMIN, IP, TP, TOPIC, TASK;

    /**
     * Converts a taskCategory object to String representation.
     * @param category a TaskCategory object.
     * @return String representation of category.
     */
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
        default:
            return "";
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
