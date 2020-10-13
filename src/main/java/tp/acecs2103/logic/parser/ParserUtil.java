package tp.acecs2103.logic.parser;

import static java.util.Objects.requireNonNull;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import tp.acecs2103.commons.core.index.Index;
import tp.acecs2103.commons.util.StringUtil;
import tp.acecs2103.logic.parser.exceptions.ParseException;
import tp.acecs2103.model.tag.Tag;
import tp.acecs2103.model.task.*;


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
     * @param weekno
     * @throws ParseException
     */
    public static int parseWeekNumber(String weekno) throws ParseException {
        requireNonNull(weekno);
        String trimmedWN = weekno.trim();
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
     * @param officialddl
     * @throws ParseException
     */
    public static LocalDate parseOfficialDeadline(String officialddl) throws ParseException {
        requireNonNull(officialddl);
        String trimmedddl = officialddl.trim();
        LocalDate result;
        try {
            result = LocalDate.parse(trimmedddl);
        } catch (Exception e) {
            throw new ParseException(MESSAGE_INVALID_INDEX);
        }
        return result;
    }

    /**
     * Parses a customized deadline.
     * @param customizedddl
     * @throws ParseException
     */
    public static LocalDate parseCustomizedDeadline(String customizedddl) throws ParseException {
        requireNonNull(customizedddl);
        String trimmedddl = customizedddl.trim();
        LocalDate result;
        try {
            result = LocalDate.parse(trimmedddl);
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

    /**
     * Parses a {@code String name} into a {@code Name}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code name} is invalid.
     */
    public static Name parseName(String name) throws ParseException {
        requireNonNull(name);
        String trimmedName = name.trim();
        if (!Name.isValidName(trimmedName)) {
            throw new ParseException(Name.MESSAGE_CONSTRAINTS);
        }
        return new Name(trimmedName);
    }

    /**
     * Parses a {@code String phone} into a {@code Phone}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code phone} is invalid.
     */
    public static Phone parsePhone(String phone) throws ParseException {
        requireNonNull(phone);
        String trimmedPhone = phone.trim();
        if (!Phone.isValidPhone(trimmedPhone)) {
            throw new ParseException(Phone.MESSAGE_CONSTRAINTS);
        }
        return new Phone(trimmedPhone);
    }

    /**
     * Parses a {@code String address} into an {@code Address}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code address} is invalid.
     */
    public static Address parseAddress(String address) throws ParseException {
        requireNonNull(address);
        String trimmedAddress = address.trim();
        if (!Address.isValidAddress(trimmedAddress)) {
            throw new ParseException(Address.MESSAGE_CONSTRAINTS);
        }
        return new Address(trimmedAddress);
    }

    /**
     * Parses a {@code String email} into an {@code Email}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code email} is invalid.
     */
    public static Email parseEmail(String email) throws ParseException {
        requireNonNull(email);
        String trimmedEmail = email.trim();
        if (!Email.isValidEmail(trimmedEmail)) {
            throw new ParseException(Email.MESSAGE_CONSTRAINTS);
        }
        return new Email(trimmedEmail);
    }

    /**
     * Parses a {@code String tag} into a {@code Tag}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code tag} is invalid.
     */
    public static Tag parseTag(String tag) throws ParseException {
        requireNonNull(tag);
        String trimmedTag = tag.trim();
        if (!Tag.isValidTagName(trimmedTag)) {
            throw new ParseException(Tag.MESSAGE_CONSTRAINTS);
        }
        return new Tag(trimmedTag);
    }

    /**
     * Parses {@code Collection<String> tags} into a {@code Set<Tag>}.
     */
    public static Set<Tag> parseTags(Collection<String> tags) throws ParseException {
        requireNonNull(tags);
        final Set<Tag> tagSet = new HashSet<>();
        for (String tagName : tags) {
            tagSet.add(parseTag(tagName));
        }
        return tagSet;
    }
}
