package ua.training.controller.command;

import ua.training.controller.command.search.FindByDateCommand;
import ua.training.controller.command.search.FindBySizeCommand;
import ua.training.controller.command.search.FindByTagCommand;
import ua.training.controller.command.sort.SortByDateCommand;
import ua.training.controller.command.sort.SortBySizeCommand;
import ua.training.controller.command.sort.SortByTagCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class CommandFactory {
    private final Map<String, Command> commands;

    private CommandFactory() {
        commands = new HashMap<>();
    }

    private void addCommand(String name, Command command) {
        commands.put(name, command);
    }

    public void executeCommand(String name, HttpServletRequest httpServletRequest,
                               HttpServletResponse httpServletResponse) {
        commands.getOrDefault(name, (req, resp) ->
                {throw new UnsupportedOperationException(name);}).execute(httpServletRequest, httpServletResponse);
    }

    public static CommandFactory init() {
        CommandFactory commandFactory = new CommandFactory();

        commandFactory.addCommand("Create Slide Show", new CreateSlideShowCommand());
        commandFactory.addCommand("Show Presentation", new ShowSlideShowCommand());
        commandFactory.addCommand("Find by date", new FindByDateCommand());
        commandFactory.addCommand("Find by size", new FindBySizeCommand());
        commandFactory.addCommand("Find by tag", new FindByTagCommand());
        commandFactory.addCommand("Sort by date", new SortByDateCommand());
        commandFactory.addCommand("Sort by size", new SortBySizeCommand());
        commandFactory.addCommand("Sort by tag", new SortByTagCommand());
        commandFactory.addCommand("Get total size", new GetTotalSizeCommand());
        commandFactory.addCommand("Next", new NextSlideCommand());
        commandFactory.addCommand("Show slide by slide", new NextSlideCommand());


        return commandFactory;
    }
}
