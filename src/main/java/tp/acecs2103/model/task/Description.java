package tp.acecs2103.model.task;

import static java.util.Objects.requireNonNull;

/**
 * Represents a Task's description in the task manager.
 */
public class Description {
    
    // TODO: Message Constraints?
    
    public final String value;

    /**
     * Constructs a {@code Description}.
     * 
     * @param description A valid description.
     */
    public Description(String description) {
        requireNonNull(description);
        value = description;   
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
