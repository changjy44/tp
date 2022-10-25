package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.commons.core.Messages.MESSAGE_UNKNOWN_COMMAND;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import seedu.address.logic.commands.AddCommand;
import seedu.address.logic.commands.AddLinkCommand;
import seedu.address.logic.commands.AddMemberCommand;
import seedu.address.logic.commands.AddTaskCommand;
import seedu.address.logic.commands.AddTeamCommand;
import seedu.address.logic.commands.AssignTaskCommand;
import seedu.address.logic.commands.ClearCommand;
import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.DeleteCommand;
import seedu.address.logic.commands.DeleteLinkCommand;
import seedu.address.logic.commands.DeleteMemberCommand;
import seedu.address.logic.commands.DeleteTaskCommand;
import seedu.address.logic.commands.DeleteTeamCommand;
import seedu.address.logic.commands.EditCommand;
import seedu.address.logic.commands.EditLinkCommand;
import seedu.address.logic.commands.EditTeamCommand;
import seedu.address.logic.commands.ExitCommand;
import seedu.address.logic.commands.FindCommand;
import seedu.address.logic.commands.FindMemberCommand;
import seedu.address.logic.commands.FindTaskCommand;
import seedu.address.logic.commands.HelpCommand;
import seedu.address.logic.commands.ListCommand;
import seedu.address.logic.commands.ListMembersCommand;
import seedu.address.logic.commands.ListTasksCommand;
import seedu.address.logic.commands.MarkCommand;
import seedu.address.logic.commands.RandomlyAssignTaskCommand;
import seedu.address.logic.commands.SetDeadlineCommand;
import seedu.address.logic.commands.SetTeamCommand;
import seedu.address.logic.commands.SortMemberCommand;
import seedu.address.logic.commands.TasksSummaryCommand;
import seedu.address.logic.commands.UnmarkCommand;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses user input.
 */
public class AddressBookParser {

    /**
     * Used for initial separation of command word and args.
     */
    private static final Pattern BASIC_COMMAND_FORMAT = Pattern.compile("(?<commandWord>\\S+)(?<arguments>.*)");

    /**
     * Parses user input into command for execution.
     *
     * @param userInput full user input string
     * @return the command based on the user input
     * @throws ParseException if the user input does not conform the expected format
     */
    public Command parseCommand(String userInput) throws ParseException {
        final Matcher matcher = BASIC_COMMAND_FORMAT.matcher(userInput.trim());
        if (!matcher.matches()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, HelpCommand.MESSAGE_USAGE));
        }

        final String commandWord = matcher.group("commandWord");
        final String arguments = matcher.group("arguments");
        switch (commandWord) {

        case AddCommand.COMMAND_WORD:
            return new AddCommandParser().parse(arguments);

        case EditCommand.COMMAND_WORD:
            return new EditCommandParser().parse(arguments);

        case DeleteCommand.COMMAND_WORD:
            return new DeleteCommandParser().parse(arguments);

        case ClearCommand.COMMAND_WORD:
            return new ClearCommand();

        case FindCommand.COMMAND_WORD:
            return new FindCommandParser().parse(arguments);

        case FindMemberCommand.COMMAND_WORD:
            return new FindMemberCommandParser().parse(arguments);

        case FindTaskCommand.COMMAND_WORD:
            return new FindTaskCommandParser().parse(arguments);

        case SortMemberCommand.COMMAND_WORD:
            return new SortMemberCommand();

        case ListCommand.COMMAND_WORD:
            return new ListCommand();

        case ExitCommand.COMMAND_WORD:
            return new ExitCommand();

        case HelpCommand.COMMAND_WORD:
            return new HelpCommand();

        case ListMembersCommand.COMMAND_WORD:
            return new ListMembersCommand();

        case AddMemberCommand.COMMAND_WORD:
            return new AddMemberCommandParser().parse(arguments);

        case DeleteMemberCommand.COMMAND_WORD:
            return new DeleteMemberCommandParser().parse(arguments);

        case SetTeamCommand.COMMAND_WORD:
            return new SetTeamCommandParser().parse(arguments);

        case EditTeamCommand.COMMAND_WORD:
            return new EditTeamCommandParser().parse(arguments);

        case AddTeamCommand.COMMAND_WORD:
            return new AddTeamCommandParser().parse(arguments);

        case DeleteTeamCommand.COMMAND_WORD:
            return new DeleteTeamCommandParser().parse(arguments);

        case ListTasksCommand.COMMAND_WORD:
            return new ListTasksCommandParser().parse(arguments);

        case TasksSummaryCommand.COMMAND_WORD:
            return new TasksSummaryCommand();

        case AddTaskCommand.COMMAND_WORD:
            return new AddTaskCommandParser().parse(arguments);

        case DeleteTaskCommand.COMMAND_WORD:
            return new DeleteTaskCommandParser().parse(arguments);

        case AssignTaskCommand.COMMAND_WORD:
            return new AssignTaskCommandParser().parse(arguments);

        case RandomlyAssignTaskCommand.COMMAND_WORD:
            return new RandomlyAssignTaskCommandParser().parse(arguments);

        case SetDeadlineCommand.COMMAND_WORD:
            return new SetDeadlineCommandParser().parse(arguments);

        case AddLinkCommand.COMMAND_WORD:
            return new AddLinkCommandParser().parse(arguments);

        case EditLinkCommand.COMMAND_WORD:
            return new EditLinkCommandParser().parse(arguments);

        case DeleteLinkCommand.COMMAND_WORD:
            return new DeleteLinkCommandParser().parse(arguments);

        case MarkCommand.COMMAND_WORD:
            return new MarkCommandParser().parse(arguments);

        case UnmarkCommand.COMMAND_WORD:
            return new UnmarkCommandParser().parse(arguments);

        default:
            throw new ParseException(MESSAGE_UNKNOWN_COMMAND);
        }
    }

}
