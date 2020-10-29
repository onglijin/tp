package tp.acecs2103.model.task;

/**
 * Represents a Task's description in the task manager.
 * Guarantees: immutable; is valid as declared in {@link #isValidRemark(String)}
 */
public class Remark {

    public final String value;

    /**
     * Constructs a {@code Remark}.
     *
     * @param remark A valid description.
     */
    public Remark(String remark) {
        value = remark;
    }

    @Override
    public String toString() {
        return value;
    }

    public boolean contains(String keyword) {
        return value.contains(keyword);
    }
}
