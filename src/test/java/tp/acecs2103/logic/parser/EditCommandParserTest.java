package tp.acecs2103.logic.parser;

import static tp.acecs2103.logic.parser.CommandParserTestUtil.assertParseFailure;
import static tp.acecs2103.logic.parser.CommandParserTestUtil.assertParseSuccess;

import org.junit.jupiter.api.Test;

import tp.acecs2103.commons.core.index.Index;
import tp.acecs2103.logic.commands.EditCommand;
import tp.acecs2103.model.task.Address;
import tp.acecs2103.model.task.Email;
import tp.acecs2103.model.task.Name;
import tp.acecs2103.model.task.Phone;
import tp.acecs2103.model.tag.Tag;
import tp.acecs2103.testutil.EditPersonDescriptorBuilder;
import tp.acecs2103.commons.core.Messages;
import tp.acecs2103.logic.commands.CommandTestUtil;
import tp.acecs2103.testutil.TypicalIndexes;

public class EditCommandParserTest {

    private static final String TAG_EMPTY = " " + CliSyntax.PREFIX_TAG;

    private static final String MESSAGE_INVALID_FORMAT =
            String.format(Messages.MESSAGE_INVALID_COMMAND_FORMAT, EditCommand.MESSAGE_USAGE);

    private EditCommandParser parser = new EditCommandParser();

    @Test
    public void parse_missingParts_failure() {
        // no index specified
        assertParseFailure(parser, CommandTestUtil.VALID_NAME_AMY, MESSAGE_INVALID_FORMAT);

        // no field specified
        assertParseFailure(parser, "1", EditCommand.MESSAGE_NOT_EDITED);

        // no index and no field specified
        assertParseFailure(parser, "", MESSAGE_INVALID_FORMAT);
    }

    @Test
    public void parse_invalidPreamble_failure() {
        // negative index
        assertParseFailure(parser, "-5" + CommandTestUtil.NAME_DESC_AMY, MESSAGE_INVALID_FORMAT);

        // zero index
        assertParseFailure(parser, "0" + CommandTestUtil.NAME_DESC_AMY, MESSAGE_INVALID_FORMAT);

        // invalid arguments being parsed as preamble
        assertParseFailure(parser, "1 some random string", MESSAGE_INVALID_FORMAT);

        // invalid prefix being parsed as preamble
        assertParseFailure(parser, "1 i/ string", MESSAGE_INVALID_FORMAT);
    }

    @Test
    public void parse_invalidValue_failure() {
        assertParseFailure(parser, "1" + CommandTestUtil.INVALID_NAME_DESC, Name.MESSAGE_CONSTRAINTS); // invalid name
        assertParseFailure(parser, "1" + CommandTestUtil.INVALID_PHONE_DESC, Phone.MESSAGE_CONSTRAINTS); // invalid phone
        assertParseFailure(parser, "1" + CommandTestUtil.INVALID_EMAIL_DESC, Email.MESSAGE_CONSTRAINTS); // invalid email
        assertParseFailure(parser, "1" + CommandTestUtil.INVALID_ADDRESS_DESC, Address.MESSAGE_CONSTRAINTS); // invalid address
        assertParseFailure(parser, "1" + CommandTestUtil.INVALID_TAG_DESC, Tag.MESSAGE_CONSTRAINTS); // invalid tag

        // invalid phone followed by valid email
        assertParseFailure(parser, "1" + CommandTestUtil.INVALID_PHONE_DESC + CommandTestUtil.EMAIL_DESC_AMY, Phone.MESSAGE_CONSTRAINTS);

        // valid phone followed by invalid phone. The test case for invalid phone followed by valid phone
        // is tested at {@code parse_invalidValueFollowedByValidValue_success()}
        assertParseFailure(parser, "1" + CommandTestUtil.PHONE_DESC_BOB + CommandTestUtil.INVALID_PHONE_DESC, Phone.MESSAGE_CONSTRAINTS);

        // while parsing {@code PREFIX_TAG} alone will reset the tags of the {@code Person} being edited,
        // parsing it together with a valid tag results in error
        assertParseFailure(parser, "1" + CommandTestUtil.TAG_DESC_FRIEND + CommandTestUtil.TAG_DESC_HUSBAND + TAG_EMPTY, Tag.MESSAGE_CONSTRAINTS);
        assertParseFailure(parser, "1" + CommandTestUtil.TAG_DESC_FRIEND + TAG_EMPTY + CommandTestUtil.TAG_DESC_HUSBAND, Tag.MESSAGE_CONSTRAINTS);
        assertParseFailure(parser, "1" + TAG_EMPTY + CommandTestUtil.TAG_DESC_FRIEND + CommandTestUtil.TAG_DESC_HUSBAND, Tag.MESSAGE_CONSTRAINTS);

        // multiple invalid values, but only the first invalid value is captured
        assertParseFailure(parser, "1" + CommandTestUtil.INVALID_NAME_DESC + CommandTestUtil.INVALID_EMAIL_DESC + CommandTestUtil.VALID_ADDRESS_AMY + CommandTestUtil.VALID_PHONE_AMY,
                Name.MESSAGE_CONSTRAINTS);
    }

    @Test
    public void parse_allFieldsSpecified_success() {
        Index targetIndex = TypicalIndexes.INDEX_SECOND_PERSON;
        String userInput = targetIndex.getOneBased() + CommandTestUtil.PHONE_DESC_BOB + CommandTestUtil.TAG_DESC_HUSBAND
                + CommandTestUtil.EMAIL_DESC_AMY + CommandTestUtil.ADDRESS_DESC_AMY + CommandTestUtil.NAME_DESC_AMY + CommandTestUtil.TAG_DESC_FRIEND;

        EditCommand.EditPersonDescriptor descriptor = new EditPersonDescriptorBuilder().withName(CommandTestUtil.VALID_NAME_AMY)
                .withPhone(CommandTestUtil.VALID_PHONE_BOB).withEmail(CommandTestUtil.VALID_EMAIL_AMY).withAddress(CommandTestUtil.VALID_ADDRESS_AMY)
                .withTags(CommandTestUtil.VALID_TAG_HUSBAND, CommandTestUtil.VALID_TAG_FRIEND).build();
        EditCommand expectedCommand = new EditCommand(targetIndex, descriptor);

        assertParseSuccess(parser, userInput, expectedCommand);
    }

    @Test
    public void parse_someFieldsSpecified_success() {
        Index targetIndex = TypicalIndexes.INDEX_FIRST_PERSON;
        String userInput = targetIndex.getOneBased() + CommandTestUtil.PHONE_DESC_BOB + CommandTestUtil.EMAIL_DESC_AMY;

        EditCommand.EditPersonDescriptor descriptor = new EditPersonDescriptorBuilder().withPhone(CommandTestUtil.VALID_PHONE_BOB)
                .withEmail(CommandTestUtil.VALID_EMAIL_AMY).build();
        EditCommand expectedCommand = new EditCommand(targetIndex, descriptor);

        assertParseSuccess(parser, userInput, expectedCommand);
    }

    @Test
    public void parse_oneFieldSpecified_success() {
        // name
        Index targetIndex = TypicalIndexes.INDEX_THIRD_PERSON;
        String userInput = targetIndex.getOneBased() + CommandTestUtil.NAME_DESC_AMY;
        EditCommand.EditPersonDescriptor descriptor = new EditPersonDescriptorBuilder().withName(CommandTestUtil.VALID_NAME_AMY).build();
        EditCommand expectedCommand = new EditCommand(targetIndex, descriptor);
        assertParseSuccess(parser, userInput, expectedCommand);

        // phone
        userInput = targetIndex.getOneBased() + CommandTestUtil.PHONE_DESC_AMY;
        descriptor = new EditPersonDescriptorBuilder().withPhone(CommandTestUtil.VALID_PHONE_AMY).build();
        expectedCommand = new EditCommand(targetIndex, descriptor);
        assertParseSuccess(parser, userInput, expectedCommand);

        // email
        userInput = targetIndex.getOneBased() + CommandTestUtil.EMAIL_DESC_AMY;
        descriptor = new EditPersonDescriptorBuilder().withEmail(CommandTestUtil.VALID_EMAIL_AMY).build();
        expectedCommand = new EditCommand(targetIndex, descriptor);
        assertParseSuccess(parser, userInput, expectedCommand);

        // address
        userInput = targetIndex.getOneBased() + CommandTestUtil.ADDRESS_DESC_AMY;
        descriptor = new EditPersonDescriptorBuilder().withAddress(CommandTestUtil.VALID_ADDRESS_AMY).build();
        expectedCommand = new EditCommand(targetIndex, descriptor);
        assertParseSuccess(parser, userInput, expectedCommand);

        // tags
        userInput = targetIndex.getOneBased() + CommandTestUtil.TAG_DESC_FRIEND;
        descriptor = new EditPersonDescriptorBuilder().withTags(CommandTestUtil.VALID_TAG_FRIEND).build();
        expectedCommand = new EditCommand(targetIndex, descriptor);
        assertParseSuccess(parser, userInput, expectedCommand);
    }

    @Test
    public void parse_multipleRepeatedFields_acceptsLast() {
        Index targetIndex = TypicalIndexes.INDEX_FIRST_PERSON;
        String userInput = targetIndex.getOneBased() + CommandTestUtil.PHONE_DESC_AMY + CommandTestUtil.ADDRESS_DESC_AMY + CommandTestUtil.EMAIL_DESC_AMY
                + CommandTestUtil.TAG_DESC_FRIEND + CommandTestUtil.PHONE_DESC_AMY + CommandTestUtil.ADDRESS_DESC_AMY + CommandTestUtil.EMAIL_DESC_AMY + CommandTestUtil.TAG_DESC_FRIEND
                + CommandTestUtil.PHONE_DESC_BOB + CommandTestUtil.ADDRESS_DESC_BOB + CommandTestUtil.EMAIL_DESC_BOB + CommandTestUtil.TAG_DESC_HUSBAND;

        EditCommand.EditPersonDescriptor descriptor = new EditPersonDescriptorBuilder().withPhone(CommandTestUtil.VALID_PHONE_BOB)
                .withEmail(CommandTestUtil.VALID_EMAIL_BOB).withAddress(CommandTestUtil.VALID_ADDRESS_BOB).withTags(CommandTestUtil.VALID_TAG_FRIEND, CommandTestUtil.VALID_TAG_HUSBAND)
                .build();
        EditCommand expectedCommand = new EditCommand(targetIndex, descriptor);

        assertParseSuccess(parser, userInput, expectedCommand);
    }

    @Test
    public void parse_invalidValueFollowedByValidValue_success() {
        // no other valid values specified
        Index targetIndex = TypicalIndexes.INDEX_FIRST_PERSON;
        String userInput = targetIndex.getOneBased() + CommandTestUtil.INVALID_PHONE_DESC + CommandTestUtil.PHONE_DESC_BOB;
        EditCommand.EditPersonDescriptor descriptor = new EditPersonDescriptorBuilder().withPhone(CommandTestUtil.VALID_PHONE_BOB).build();
        EditCommand expectedCommand = new EditCommand(targetIndex, descriptor);
        assertParseSuccess(parser, userInput, expectedCommand);

        // other valid values specified
        userInput = targetIndex.getOneBased() + CommandTestUtil.EMAIL_DESC_BOB + CommandTestUtil.INVALID_PHONE_DESC + CommandTestUtil.ADDRESS_DESC_BOB
                + CommandTestUtil.PHONE_DESC_BOB;
        descriptor = new EditPersonDescriptorBuilder().withPhone(CommandTestUtil.VALID_PHONE_BOB).withEmail(CommandTestUtil.VALID_EMAIL_BOB)
                .withAddress(CommandTestUtil.VALID_ADDRESS_BOB).build();
        expectedCommand = new EditCommand(targetIndex, descriptor);
        assertParseSuccess(parser, userInput, expectedCommand);
    }

    @Test
    public void parse_resetTags_success() {
        Index targetIndex = TypicalIndexes.INDEX_THIRD_PERSON;
        String userInput = targetIndex.getOneBased() + TAG_EMPTY;

        EditCommand.EditPersonDescriptor descriptor = new EditPersonDescriptorBuilder().withTags().build();
        EditCommand expectedCommand = new EditCommand(targetIndex, descriptor);

        assertParseSuccess(parser, userInput, expectedCommand);
    }
}
