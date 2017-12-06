package ua.training.controller.command.search;

import ua.training.controller.command.Command;
import ua.training.controller.command.ShowSlideShowCommand;
import ua.training.model.SlideShowModel;
import ua.training.model.entities.Slide;
import ua.training.model.search.strategies.FindBetweenDate;
import ua.training.model.search.strategies.FindBetweenSize;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.util.List;

public class FindBySizeCommand implements Command {
    ShowSlideShowCommand showSlideShowCommand = new ShowSlideShowCommand();

    @Override
    public void execute(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        SlideShowModel slideShowModel = (SlideShowModel) httpServletRequest.getAttribute("model");
        int minSize = Integer.parseInt(httpServletRequest.getParameter("lower_bound"));
        int maxSize = Integer.parseInt(httpServletRequest.getParameter("higher_bound"));
        slideShowModel.setSearchStrategy(new FindBetweenSize(minSize, maxSize)); //TODO think about composite pattern so you can call method execute() of ShowSlideShowCommand
        List<Slide> slides = slideShowModel.findSlides();
        slideShowModel.setSlideShow(slides);
        httpServletRequest.setAttribute("model", slideShowModel);
        showSlideShowCommand.execute(httpServletRequest, httpServletResponse);
    }
}
