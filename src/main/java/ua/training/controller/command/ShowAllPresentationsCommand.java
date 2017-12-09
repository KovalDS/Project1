package ua.training.controller.command;

import ua.training.model.entities.SlideShow;
import ua.training.model.service.SlideShowService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ShowAllPresentationsCommand implements Command {
    SlideShowService slideShowService;

    public ShowAllPresentationsCommand(SlideShowService slideShowService) {
        this.slideShowService = slideShowService;
    }

    @Override
    public String execute(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        String page = "/view/presentations.jsp";
        List<SlideShow> slideShowList = slideShowService.getAllSlideShows();
        httpServletRequest.setAttribute("allPresentations", slideShowList);
        return page;
    }
}
