package tp.acecs2103.logic.parser;

import static java.util.Objects.requireNonNull;

import tp.acecs2103.logic.commands.FilterCommand;
import tp.acecs2103.logic.commands.exceptions.CommandException;
import tp.acecs2103.logic.parser.exceptions.ParseException;
import tp.acecs2103.model.task.WeekNumber;

public class FilterCommandParser implements Parser<FilterCommand> {

    @Override
    public FilterCommand parse(String args) throws ParseException, CommandException {
        requireNonNull(args);
        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(
                        args, CliSyntax.PREFIX_WEEK_NUMBER, CliSyntax.PREFIX_KEYWORD, CliSyntax.PREFIX_DDLTYPE);

        if (!argMultimap.getValue(CliSyntax.PREFIX_KEYWORD).get().equals("")
                && argMultimap.getValue(CliSyntax.PREFIX_WEEK_NUMBER).get().equals("")
                && argMultimap.getValue(CliSyntax.PREFIX_DDLTYPE).get().equals("")) {
            return new FilterCommand(argMultimap.getValue(CliSyntax.PREFIX_KEYWORD).get());
        }
        if (!argMultimap.getValue(CliSyntax.PREFIX_KEYWORD).get().equals("")
                && !argMultimap.getValue(CliSyntax.PREFIX_WEEK_NUMBER).get().equals("")
                && argMultimap.getValue(CliSyntax.PREFIX_DDLTYPE).get().equals("")) {
            return new FilterCommand(
                    argMultimap.getValue(CliSyntax.PREFIX_KEYWORD).get(),
                    new WeekNumber(argMultimap.getValue(CliSyntax.PREFIX_WEEK_NUMBER).get()));
        }
        if (!argMultimap.getValue(CliSyntax.PREFIX_KEYWORD).get().equals("")
                && argMultimap.getValue(CliSyntax.PREFIX_WEEK_NUMBER).get().equals("")
                && !argMultimap.getValue(CliSyntax.PREFIX_DDLTYPE).get().equals("")) {
            return new FilterCommand(
                    argMultimap.getValue(CliSyntax.PREFIX_KEYWORD).get(),
                    argMultimap.getValue(CliSyntax.PREFIX_DDLTYPE).get());
        }
        if (!argMultimap.getValue(CliSyntax.PREFIX_KEYWORD).get().equals("")
                && !argMultimap.getValue(CliSyntax.PREFIX_WEEK_NUMBER).get().equals("")
                && !argMultimap.getValue(CliSyntax.PREFIX_DDLTYPE).get().equals("")) {
            return new FilterCommand(
                    argMultimap.getValue(CliSyntax.PREFIX_KEYWORD).get(),
                    argMultimap.getValue(CliSyntax.PREFIX_DDLTYPE).get(),
                    new WeekNumber(argMultimap.getValue(CliSyntax.PREFIX_WEEK_NUMBER).get()));
        }
        return new FilterCommand(argMultimap.getValue(CliSyntax.PREFIX_KEYWORD).get());
    }
}
