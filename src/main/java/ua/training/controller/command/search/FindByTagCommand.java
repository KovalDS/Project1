package ua.training.controller.command.search;

import ua.training.controller.command.Command;
import ua.training.controller.command.ShowSlideShowCommand;
import ua.training.model.SlideShowModel;
import ua.training.model.entities.Slide;
import ua.training.model.entities.Tag;
import ua.training.model.search.strategies.FindByTag;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class FindByTagCommand implements Command {
    ShowSlideShowCommand showSlideShowCommand = new ShowSlideShowCommand();

    @Override
    public void execute(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        SlideShowModel slideShowModel = (SlideShowModel) httpServletRequest.getAttribute("model");
        String tag = httpServletRequest.getParameter("tag");

        try {
            slideShowModel.setSearchStrategy(new FindByTag(Tag.valueOf(tag))); //TODO think about composite pattern so you can call method execute() of ShowSlideShowCommand
        } catch (IllegalArgumentException illegalArgumentException) {
            httpServletRequest.setAttribute("message", "<p>No such tag<p>");
            try {
                httpServletRequest.getRequestDispatcher("index.jsp").forward(httpServletRequest, httpServletResponse);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        List<Slide> slides = slideShowModel.findSlides();
        slideShowModel.setSlideShow(slides);
        httpServletRequest.setAttribute("model", slideShowModel);
        showSlideShowCommand.execute(httpServletRequest, httpServletResponse);
    }
}
