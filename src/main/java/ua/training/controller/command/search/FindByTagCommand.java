package ua.training.controller.command.search;

import ua.training.controller.command.Command;
import ua.training.controller.command.ShowSlideShowCommand;
import ua.training.controller.command.UtilityMethods;
import ua.training.model.SlideShowModel;
import ua.training.model.entities.Tag;
import ua.training.model.search.strategies.FindByTag;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static ua.training.view.TextConstants.MODEL;

public class FindByTagCommand implements Command {
    private ShowSlideShowCommand showSlideShowCommand = new ShowSlideShowCommand();

    @Override
    public void execute(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        SlideShowModel slideShowModel = (SlideShowModel) httpServletRequest.getAttribute(MODEL);
        String tag = httpServletRequest.getParameter("tag");

        try {
            slideShowModel.setSearchStrategy(new FindByTag(Tag.valueOf(tag))); //TODO think about composite pattern so you can call method execute() of ShowSlideShowCommand
        } catch (IllegalArgumentException illegalArgumentException) {
            httpServletRequest.setAttribute("message", "<p>No such tag<p>");
            UtilityMethods.forwardAndPrint(httpServletRequest, httpServletResponse);
        }
        UtilityMethods.findSlides(httpServletRequest);

        showSlideShowCommand.execute(httpServletRequest, httpServletResponse);
    }
}
