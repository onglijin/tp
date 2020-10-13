package tp.acecs2103.model.task;

public enum TaskCategory {
    ADMIN, IP, TP, TOPIC, TASK;

    /**
     * Gets string based on {@code category}
     */
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

    /**
     * Checks whether a category belongs to Admin.
     * @param category A valid {@code TaskCategory}.
     */
    public static boolean isAdmin(TaskCategory category) {
        return category == ADMIN;
    }

    /**
     * Checks whether a category belongs to Admin.
     * @param category A valid {@code String}.
     */
    public static boolean isAdmin(String category) {
        return category == "admin";
    }

    /**
     * Checks whether a category belongs to Topic.
     * @param category A valid {@code TaskCategory}.
     */
    public static boolean isTopic(TaskCategory category) {
        return category == TOPIC;
    }

    /**
     * Checks whether a category belongs to Topic.
     * @param category A valid {@code String}.
     */
    public static boolean isTopic(String category) {
        return category == "topic";
    }

    /**
     * Checks whether a category belongs to IP.
     * @param category A valid {@code TaskCategory}.
     */
    public static boolean isIP(TaskCategory category) {
        return category == IP;
    }

    /**
     * Checks whether a category belongs to IP.
     * @param category A valid {@code String}.
     */
    public static boolean isIP(String category) {
        return category == "ip";
    }

    /**
     * Checks whether a category belongs to TP.
     * @param category A valid {@code TaskCategory}.
     */
    public static boolean isTP(TaskCategory category) {
        return category == TP;
    }

    /**
     * Checks whether a category belongs to TP.
     * @param category A valid {@code String}.
     */
    public static boolean isTP(String category) {
        return category == "tp";
    }
}
