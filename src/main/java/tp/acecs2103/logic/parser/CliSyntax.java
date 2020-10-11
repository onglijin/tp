package tp.acecs2103.logic.parser;

/**
 * Contains Command Line Interface (CLI) syntax definitions common to multiple commands
 */
public class CliSyntax {
    public static final Prefix PREFIX_NAME = new Prefix("n/");
    public static final Prefix PREFIX_PHONE = new Prefix("p/");
    public static final Prefix PREFIX_EMAIL = new Prefix("e/");
    public static final Prefix PREFIX_ADDRESS = new Prefix("a/");
    public static final Prefix PREFIX_TAG = new Prefix("t/");

    /* Prefix definitions */
    public static final Prefix PREFIX_INDEX = new Prefix("i/");
    public static final Prefix PREFIX_WEEKNO = new Prefix("w/");
    public static final Prefix PREFIX_DESCRIPTION = new Prefix("d/");
    public static final Prefix PREFIX_OFFICIALDDL = new Prefix("o/");
    public static final Prefix PREFIX_CUSTOMIZEDDDL = new Prefix("c/");
    public static final Prefix PREFIX_REMARK = new Prefix("r/");
    public static final Prefix PREFIX_TYPE = new Prefix("t/");
}
