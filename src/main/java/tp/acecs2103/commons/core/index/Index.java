package tp.acecs2103.commons.core.index;

/**
 * Represents a zero-based or one-based index.
 *
 * {@code Index} should be used right from the start (when parsing in a new user input), so that if the current
 * component wants to communicate with another component, it can send an {@code Index} to avoid having to know what
 * base the other component is using for its index. However, after receiving the {@code Index}, that component can
 * convert it back to an int if the index will not be passed to a different component again.
 */
public class Index {
    private String strIndex; // to keep the correct format for index like "0601"
    private int intIndex;


    public Index(String strIndex) {
        int intIndex = Integer.parseInt(strIndex);
        if (intIndex < 0) {
            throw new IndexOutOfBoundsException();
        }
        this.strIndex = strIndex;
        this.intIndex = intIndex;
    }

    public int getIntIndex() {
        return intIndex;
    }

    public String getStrIndex() {
        return strIndex;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Index // instanceof handles nulls
                && strIndex == ((Index) other).strIndex); // state check
    }
}
