package ua.training.controller.command;

import ua.training.model.SlideShowModel;
import ua.training.model.entities.Slide;
import ua.training.model.search.strategies.FindBetweenDate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.util.List;

public class FindByDateCommand implements Command {
    ShowSlideShowCommand showSlideShowCommand = new ShowSlideShowCommand();

    @Override
    public void execute(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        SlideShowModel slideShowModel = (SlideShowModel) httpServletRequest.getAttribute("model");
        String firstDate = httpServletRequest.getParameter("first_date");
        String seconDate = httpServletRequest.getParameter("second_date");
        slideShowModel.setSearchStrategy(new FindBetweenDate(LocalDate.parse(firstDate), LocalDate.parse(seconDate))); //TODO think about composite pattern so you can call method execute() of ShowSlideShowCommand
        List<Slide> slides = slideShowModel.findSlides();
        slideShowModel.setSlideShow(slides);
        httpServletRequest.setAttribute("model", slideShowModel);
        showSlideShowCommand.execute();
    }
}
