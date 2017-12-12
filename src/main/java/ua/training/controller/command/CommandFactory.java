package ua.training.controller.command;

import ua.training.model.service.ImageService;
import ua.training.model.service.SlideShowService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

import static ua.training.controller.text.CommandNames.*;

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

        commandFactory.addCommand(CREATE_SLIDE_SHOW_COMMAND, new CreateSlideShowCommand(new SlideShowService(), new ImageService()));
        commandFactory.addCommand(SHOW_PRESENTATION_COMMAND, new ShowSlideShowCommand());
        commandFactory.addCommand(GET_TOTAL_SIZE_COMMAND, new GetTotalSizeCommand(new SlideShowService()));
        commandFactory.addCommand(NEXT_SLIDE_COMMAND, new NextSlideCommand(new SlideShowService()));
        commandFactory.addCommand(SHOW_SLIDE_BY_SLIDE_COMMAND, new NextSlideCommand(new SlideShowService()));
        commandFactory.addCommand(SHOW_ALL_PRESENTATIONS_COMMAND, new ShowAllPresentationsCommand(new SlideShowService()));
        commandFactory.addCommand(SHOW_ALL_IMAGES_COMMAND, new ShowAllImagesCommand());

        return commandFactory;
    }
}
