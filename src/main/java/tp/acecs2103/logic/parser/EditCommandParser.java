package tp.acecs2103.logic.parser;

import static java.util.Objects.requireNonNull;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
import java.util.Set;

import tp.acecs2103.commons.core.index.Index;
import tp.acecs2103.logic.commands.EditCommand;
import tp.acecs2103.logic.parser.exceptions.ParseException;
import tp.acecs2103.model.tag.Tag;
import tp.acecs2103.commons.core.Messages;

/**
 * Parses input arguments and creates a new EditCommand object
 */
public class EditCommandParser implements Parser<EditCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the EditCommand
     * and returns an EditCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public EditCommand parse(String args) throws ParseException {
        requireNonNull(args);
        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args, CliSyntax.PREFIX_WEEKNO, CliSyntax.PREFIX_INDEX, CliSyntax.PREFIX_DESCRIPTION, CliSyntax.PREFIX_OFFICIALDDL, CliSyntax.PREFIX_CUSTOMIZEDDDL, CliSyntax.PREFIX_REMARK);

        Index index;

        try {
            index = ParserUtil.parseIndex(argMultimap.getPreamble());
        } catch (ParseException pe) {
            throw new ParseException(String.format(Messages.MESSAGE_INVALID_COMMAND_FORMAT, EditCommand.MESSAGE_USAGE), pe);
        }

        EditCommand.EditTaskDescriptor editTaskDescriptor = new EditCommand.EditTaskDescriptor();
        if (argMultimap.getValue(CliSyntax.PREFIX_INDEX).isPresent()) {
            editTaskDescriptor.setIndex(ParserUtil.parseIndex(argMultimap.getValue(CliSyntax.PREFIX_INDEX).get()));
        }
        if (argMultimap.getValue(CliSyntax.PREFIX_WEEKNO).isPresent()) {
            editTaskDescriptor.setWeekNumber(ParserUtil.parseWeekNumber(argMultimap.getValue(CliSyntax.PREFIX_WEEKNO).get()));
        }
        if (argMultimap.getValue(CliSyntax.PREFIX_DESCRIPTION).isPresent()) {
            editTaskDescriptor.setDescription(ParserUtil.parseDescription(argMultimap.getValue(CliSyntax.PREFIX_DESCRIPTION).get()));
        }
        if (argMultimap.getValue(CliSyntax.PREFIX_OFFICIALDDL).isPresent()) {
            editTaskDescriptor.setOfficialDeadline(ParserUtil.parseOfficialDeadline(argMultimap.getValue(CliSyntax.PREFIX_OFFICIALDDL).get()));
        }
        if (argMultimap.getValue(CliSyntax.PREFIX_CUSTOMIZEDDDL).isPresent()) {
            editTaskDescriptor.setCustomizedDeadline(ParserUtil.parseCustomizedDeadline(argMultimap.getValue(CliSyntax.PREFIX_CUSTOMIZEDDDL).get()));
        }
        if (argMultimap.getValue(CliSyntax.PREFIX_REMARK).isPresent()) {
            editTaskDescriptor.setRemark(ParserUtil.parseRemark(argMultimap.getValue(CliSyntax.PREFIX_REMARK).get()));
        }

        if (!editTaskDescriptor.isAnyFieldEdited()) {
            throw new ParseException(EditCommand.MESSAGE_NOT_EDITED);
        }

        return new EditCommand(index, editTaskDescriptor);
    }

    /**
     * Parses {@code Collection<String> tags} into a {@code Set<Tag>} if {@code tags} is non-empty.
     * If {@code tags} contain only one element which is an empty string, it will be parsed into a
     * {@code Set<Tag>} containing zero tags.
     */
    private Optional<Set<Tag>> parseTagsForEdit(Collection<String> tags) throws ParseException {
        assert tags != null;

        if (tags.isEmpty()) {
            return Optional.empty();
        }
        Collection<String> tagSet = tags.size() == 1 && tags.contains("") ? Collections.emptySet() : tags;
        return Optional.of(ParserUtil.parseTags(tagSet));
    }

}
