package tp.acecs2103.logic.parser;

import static java.util.Objects.requireNonNull;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import tp.acecs2103.commons.core.index.Index;
import tp.acecs2103.commons.util.StringUtil;
import tp.acecs2103.logic.parser.exceptions.ParseException;
import tp.acecs2103.model.task.TaskCategory;


/**
 * Contains utility methods used for parsing strings in the various *Parser classes.
 */
public class ParserUtil {

    public static final String MESSAGE_INVALID_INDEX = "Index is not a non-zero unsigned integer.";

    /**
     * Parses {@code oneBasedIndex} into an {@code Index} and returns it. Leading and trailing whitespaces will be
     * trimmed.
     * @throws ParseException if the specified index is invalid (not non-zero unsigned integer).
     */
    public static String parseIndex(String oneBasedIndex) throws ParseException {
        requireNonNull(oneBasedIndex);
        String trimmedIndex = oneBasedIndex.trim();
        if (!StringUtil.isNonZeroUnsignedInteger(trimmedIndex)) {
            throw new ParseException(MESSAGE_INVALID_INDEX);
        }
        return trimmedIndex;
    }

    /**
     * Parses {@code onBasedIndex} into an {@Code Index} and returns it. Leading and trailing whitespaces will be
     * trimmed.
     * @throws ParseException if the specified index is invalid (not non-zero unsigned integer).
     */
    public static Index parseIndexObj(String oneBasedIndex) throws ParseException {
        requireNonNull(oneBasedIndex);
        String trimmedIndex = oneBasedIndex.trim();
        try {
            Index test = new Index(trimmedIndex);
        } catch (IndexOutOfBoundsException i) {
            throw new ParseException(MESSAGE_INVALID_INDEX);
        }
        return new Index(trimmedIndex);
    }
    /**
     * Parses a week number.
     * @param weekNumber
     * @throws ParseException
     */
    public static int parseWeekNumber(String weekNumber) throws ParseException {
        requireNonNull(weekNumber);
        String trimmedWN = weekNumber.trim();
        if (!StringUtil.isNonZeroUnsignedInteger(trimmedWN)) {
            throw new ParseException(MESSAGE_INVALID_INDEX);
        }
        return Integer.parseInt(trimmedWN);
    }

    /**
     * Parses a description.
     * @param description
     * @throws ParseException
     */
    public static String parseDescription(String description) throws ParseException {
        requireNonNull(description);
        String trimmedDes = description.trim();
        return trimmedDes;
    }

    /**
     * Parses official deadline.
     * @param officialDeadline
     * @throws ParseException
     */
    public static LocalDate parseOfficialDeadline(String officialDeadline) throws ParseException {
        requireNonNull(officialDeadline);
        String trimmedDeadline = officialDeadline.trim();
        LocalDate result;
        try {
            result = LocalDate.parse(trimmedDeadline);
        } catch (Exception e) {
            throw new ParseException(MESSAGE_INVALID_INDEX);
        }
        return result;
    }

    /**
     * Parses a customized deadline.
     * @param customizedDeadline
     * @throws ParseException
     */
    public static LocalDate parseCustomizedDeadline(String customizedDeadline) throws ParseException {
        requireNonNull(customizedDeadline);
        String trimmedDeadline = customizedDeadline.trim();
        LocalDate result;
        try {
            result = LocalDate.parse(trimmedDeadline);
        } catch (Exception e) {
            throw new ParseException(MESSAGE_INVALID_INDEX);
        }
        return result;
    }

    /**
     * Parses remark.
     * @param remark
     * @throws ParseException
     */
    public static String parseRemark(String remark) throws ParseException {
        requireNonNull(remark);
        String trimmedDes = remark.trim();
        return trimmedDes;
    }

    /**
     * Parses a type.
     * @param type
     * @throws ParseException
     */
    public static String parseType(String type) throws ParseException {
        requireNonNull(type);
        String trimmedType = type.trim();
        if (trimmedType.isEmpty()) {
            throw new ParseException(MESSAGE_INVALID_INDEX);
        }
        return trimmedType;
    }

    /**
     * Parses a category.
     */
    public static TaskCategory parseCategory(String category) throws ParseException {
        switch (category) {
        case "Admin":
            return TaskCategory.ADMIN;
        case "Topic":
            return TaskCategory.TOPIC;
        case "Ip":
            return TaskCategory.IP;
        case "Tp":
            return TaskCategory.TP;
        default:
            throw new ParseException(MESSAGE_INVALID_INDEX);
        }
    }
}
