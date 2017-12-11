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

        commandFactory.addCommand("Create slide show", new CreateSlideShowCommand(new SlideShowService(), new ImageService()));
        commandFactory.addCommand("Show presentation", new ShowSlideShowCommand(new SlideShowService()));
        commandFactory.addCommand("Get total size", new GetTotalSizeCommand(new SlideShowService()));
        commandFactory.addCommand("Next slide", new NextSlideCommand(new SlideShowService()));
        commandFactory.addCommand("Show slide by slide", new NextSlideCommand(new SlideShowService()));
        commandFactory.addCommand("Show all presentations", new ShowAllPresentationsCommand(new SlideShowService()));
        commandFactory.addCommand("Show all images", new ShowAllImagesCommand(new ImageService()));


        return commandFactory;
    }
}
