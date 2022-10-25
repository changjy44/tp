package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.address.model.Model;

public class SortMemberCommand extends Command {

    public static final String COMMAND_WORD = "sort_member";
    public static final String MESSAGE_SUCCESS = "Sorted team members successfully";


    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.sortMembers();
        return new CommandResult(MESSAGE_SUCCESS);
    }
}
