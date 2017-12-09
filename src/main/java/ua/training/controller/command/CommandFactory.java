package ua.training.controller.command;

import ua.training.model.service.ImageService;
import ua.training.model.service.SlideShowService;

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

    public String executeCommand(HttpServletRequest httpServletRequest,
                               HttpServletResponse httpServletResponse) {
        String name = httpServletRequest.getParameter("param");
        String page;

        page = commands.getOrDefault(name, (req, resp) ->
                {throw new UnsupportedOperationException(name);}).execute(httpServletRequest, httpServletResponse);
        return page;
    }

    public static CommandFactory init() {
        CommandFactory commandFactory = new CommandFactory();

//        commandFactory.addCommand("Create Slide Show", new CreateSlideShowCommand());
//        commandFactory.addCommand("Show Presentation", new ShowSlideShowCommand());
//        commandFactory.addCommand("Find by date", new FindByDateCommand());
//        commandFactory.addCommand("Find by size", new FindBySizeCommand());
//        commandFactory.addCommand("Find by tag", new FindByTagCommand());
//        commandFactory.addCommand("Sort by date", new SortByDateCommand());
//        commandFactory.addCommand("Sort by size", new SortBySizeCommand());
//        commandFactory.addCommand("Sort by tag", new SortByTagCommand());
//        commandFactory.addCommand("Get total size", new GetTotalSizeCommand());
//        commandFactory.addCommand("Next", new NextSlideCommand());
//        commandFactory.addCommand("Show slide by slide", new NextSlideCommand());
        commandFactory.addCommand("Show all presentations", new ShowAllPresentationsCommand(new SlideShowService()));
        commandFactory.addCommand("Show all images", new ShowAllImages(new ImageService()));


        return commandFactory;
    }
}
