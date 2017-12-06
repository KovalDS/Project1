package ua.training.controller.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class CommandFactory {
    private final Map<String, Command> commands;

    CommandFactory() {
        commands = new HashMap<>();
    }

    public void addCommand(String name, Command command) {
        commands.put(name, command);
    }

    public void executeCommand(String name, HttpServletRequest httpServletRequest,
                               HttpServletResponse httpServletResponse) {
        commands.getOrDefault(name, (req, resp) ->
                {throw new UnsupportedOperationException();}).execute(httpServletRequest, httpServletResponse);
    }

    public static CommandFactory init() {
        CommandFactory commandFactory = new CommandFactory();

        commandFactory.addCommand("Create Slide Show", new CreateSlideShowCommand());
        commandFactory.addCommand("Show Presentation", new ShowSlideShowCommand());
        commandFactory.addCommand("Find by date", new FindByDateCommand());

        return commandFactory;
    }
}
