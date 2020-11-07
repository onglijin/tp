package tp.acecs2103.model.task;

/**
 * Represents a Task's description in the task manager.
 * Guarantees: immutable;}
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

    public boolean contains(String keyword) {
        return value.contains(keyword);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this
                || (other instanceof Remark
                && value.equals(((Remark) other).value));
    }
}
