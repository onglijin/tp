package tp.acecs2103.model.task;

import static java.util.Objects.requireNonNull;

/**
 * Represents a Task's description in the task manager.
 * Guarantees: immutable; is valid as declared in {@link #isValidRemark(String)}
 */
public class Remark {

    // TODO: Message Constraints?

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
    
    // TODO: check if hashCode needed
}
