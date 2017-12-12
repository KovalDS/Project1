package ua.training.controller.command;

import ua.training.model.entities.SlideShow;
import ua.training.model.service.SlideShowService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

import static ua.training.controller.text.AttributeNames.ALL_PRESENTATIONS_ATTRIBUTE;
import static ua.training.controller.text.PageNames.ALL_PRESENTATIONS_PAGE;

public class ShowAllPresentationsCommand implements Command {
    private SlideShowService slideShowService;

    ShowAllPresentationsCommand(SlideShowService slideShowService) {
        this.slideShowService = slideShowService;
    }

    @Override
    public String execute(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        List<SlideShow> slideShowList = slideShowService.getAllSlideShows();
        httpServletRequest.setAttribute(ALL_PRESENTATIONS_ATTRIBUTE, slideShowList);
        return ALL_PRESENTATIONS_PAGE;
    }
}
