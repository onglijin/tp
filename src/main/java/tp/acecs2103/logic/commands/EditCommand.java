package tp.acecs2103.logic.commands;

import static java.util.Objects.requireNonNull;
import static tp.acecs2103.logic.parser.CliSyntax.PREFIX_ADDRESS;
import static tp.acecs2103.logic.parser.CliSyntax.PREFIX_EMAIL;
import static tp.acecs2103.logic.parser.CliSyntax.PREFIX_NAME;
import static tp.acecs2103.logic.parser.CliSyntax.PREFIX_PHONE;
import static tp.acecs2103.logic.parser.CliSyntax.PREFIX_TAG;

import java.time.LocalDate;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import tp.acecs2103.commons.core.Messages;
import tp.acecs2103.commons.core.index.Index;
import tp.acecs2103.commons.util.CollectionUtil;
import tp.acecs2103.logic.commands.exceptions.CommandException;
import tp.acecs2103.model.Model;
import tp.acecs2103.model.TaskList;
import tp.acecs2103.model.task.*;


/**
 * Edits the details of an existing person in the address book.
 */
public class EditCommand extends Command {

    public static final String COMMAND_WORD = "edit";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Edits the details of the person identified "
            + "by the index number used in the displayed person list. "
            + "Existing values will be overwritten by the input values.\n"
            + "Parameters: INDEX (must be a positive integer) "
            + "[" + PREFIX_NAME + "NAME] "
            + "[" + PREFIX_PHONE + "PHONE] "
            + "[" + PREFIX_EMAIL + "EMAIL] "
            + "[" + PREFIX_ADDRESS + "ADDRESS] "
            + "[" + PREFIX_TAG + "TAG]...\n"
            + "Example: " + COMMAND_WORD + " 1 "
            + PREFIX_PHONE + "91234567 "
            + PREFIX_EMAIL + "johndoe@example.com";

    public static final String MESSAGE_EDIT_TASK_SUCCESS = "Edited Task: %1$s";
    public static final String MESSAGE_NOT_EDITED = "At least one field to edit must be provided.";
    public static final String MESSAGE_DUPLICATE_TASK = "This task already exists in the task list.";

    private final Index index;
    private final EditTaskDescriptor editTaskDescriptor;

    /**
     * @param index of the person in the filtered person list to edit
     * @param editTaskDescriptor details to edit the person with
     */
    public EditCommand(Index index, EditTaskDescriptor editTaskDescriptor) {
        requireNonNull(index);
        requireNonNull(editTaskDescriptor);

        this.index = index;
        this.editTaskDescriptor = new EditTaskDescriptor(editTaskDescriptor);
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        TaskList lastShownList = model.getTaskList();

        if (index.getIntIndex() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_TASK_DISPLAYED_INDEX);
        }

        Task taskToEdit = lastShownList.getTask(index.getStrIndex());
        Task editedTask = createEditedTask(taskToEdit, editTaskDescriptor);

        if (!taskToEdit.isSameTask(editedTask) && model.hasTask(editedTask)) {
            throw new CommandException(MESSAGE_DUPLICATE_TASK);
        }

        model.setTask(taskToEdit, editedTask);
        return new CommandResult(String.format(MESSAGE_EDIT_TASK_SUCCESS, editedTask));
    }

    /**
     * Creates and returns a {@code Person} with the details of {@code personToEdit}
     * edited with {@code editPersonDescriptor}.
     */
    private static Task createEditedTask(Task taskToEdit, EditTaskDescriptor editTaskDescriptor) {
        assert taskToEdit != null;

        String updatedIndex = editTaskDescriptor.getIndex().orElse(taskToEdit.getIndex());
        int updatedWeekNumber = editTaskDescriptor.getWeekNumber().orElse(taskToEdit.getWeekNumber());
        String updatedDescription = editTaskDescriptor.getDescription().orElse(taskToEdit.getDescription());
        LocalDate updatedOfficialDeadline = editTaskDescriptor.getOfficialDeadline().orElse(taskToEdit.getOfficialDeadline());
        LocalDate updatedCustomizedDeadline = editTaskDescriptor.getCustomizedDeadline().orElse(taskToEdit.getOfficialDeadline());
        String remark = editTaskDescriptor.getRemark().orElse(taskToEdit.getRemark());

        return new Task(updatedIndex, updatedWeekNumber, updatedDescription, updatedOfficialDeadline, updatedCustomizedDeadline, remark);
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof EditCommand)) {
            return false;
        }

        // state check
        EditCommand e = (EditCommand) other;
        return index.equals(e.index)
                && editTaskDescriptor.equals(e.editTaskDescriptor);
    }

    /**
     * Stores the details to edit the person with. Each non-empty field value will replace the
     * corresponding field value of the person.
     */
    public static class EditTaskDescriptor {
        private String index;
        private int weekNumber;
        private String description;
        private LocalDate officialDeadline;
        private LocalDate customizedDeadline;
        private String remark;

        public EditTaskDescriptor() {}

        /**
         * Copy constructor.
         * A defensive copy of {@code tags} is used internally.
         */
        public EditTaskDescriptor(EditTaskDescriptor toCopy) {
            setIndex(toCopy.index);
            setWeekNumber(toCopy.weekNumber);
            setDescription(toCopy.description);
            setOfficialDeadline(toCopy.officialDeadline);
            setCustomizedDeadline(toCopy.customizedDeadline);
            setRemark(toCopy.remark);
        }

        /**
         * Returns true if at least one field is edited.
         */
        public boolean isAnyFieldEdited() {
            return CollectionUtil.isAnyNonNull(index, weekNumber, description, officialDeadline, customizedDeadline,remark);
        }

        public void setIndex(String index) {
            this.index = index;
        }

        public Optional<String> getIndex() {
            return Optional.ofNullable(index);
        }

        public void setWeekNumber(int weekNumber) {
            this.weekNumber = weekNumber;
        }

        public Optional<Integer> getWeekNumber() {
            return Optional.ofNullable(weekNumber);
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public Optional<String> getDescription() {
            return Optional.ofNullable(description);
        }

        public void setOfficialDeadline(LocalDate officialDeadline) {
            this.officialDeadline = officialDeadline;
        }

        public Optional<LocalDate> getOfficialDeadline() {
            return Optional.ofNullable(officialDeadline);
        }

        public void setCustomizedDeadline(LocalDate customizedDeadline) {
            this.customizedDeadline = customizedDeadline;
        }

        public Optional<LocalDate> getCustomizedDeadline() {
            return Optional.ofNullable(customizedDeadline);
        }

        /**
         * Sets {@code remark} to this object's {@code remark}.
         * A defensive copy of {@code remark} is used internally.
         */
        public void setRemark(String remark) {
            this.remark = remark;
        }

        /**
         * Returns an unmodifiable remark, which throws {@code UnsupportedOperationException}
         * if modification is attempted.
         * Returns {@code Optional#empty()} if {@code remark} is null.
         */
        public Optional<String> getRemark() {
            return Optional.ofNullable(remark);
        }

        @Override
        public boolean equals(Object other) {
            // short circuit if same object
            if (other == this) {
                return true;
            }

            // instanceof handles nulls
            if (!(other instanceof EditTaskDescriptor)) {
                return false;
            }

            // state check
            EditTaskDescriptor e = (EditTaskDescriptor) other;

            return getIndex().equals(e.getIndex())
                    && getWeekNumber().equals(e.getWeekNumber())
                    && getDescription().equals(e.getDescription())
                    && getOfficialDeadline().equals(e.getOfficialDeadline())
                    && getCustomizedDeadline().equals(e.getCustomizedDeadline())
                    && getRemark().equals(e.getRemark());
        }
    }
}
