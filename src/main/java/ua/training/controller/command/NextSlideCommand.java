package ua.training.controller.command;

import ua.training.model.entities.Image;
import ua.training.model.entities.SlideShow;
import ua.training.model.service.SlideShowService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NextSlideCommand implements Command {
    private SlideShowService slideShowService;

    NextSlideCommand(SlideShowService slideShowService) {
        this.slideShowService = slideShowService;
    }

    @Override
    public String execute(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        String page;
        int currentSlide;
        String presentationIdStr = httpServletRequest.getParameter("presentation");
        SlideShow slideShow;
        Image image;

        if (presentationIdStr == null) {
            return UtilityMethods.getAllSlidesPage(httpServletRequest, httpServletResponse);
        }

        int presentationId = Integer.parseInt(presentationIdStr);
        String currentSlideStr = httpServletRequest.getParameter("current_slide");

        if (currentSlideStr == null) {
            currentSlide = 0;
        } else {
            currentSlide = Integer.parseInt(currentSlideStr);
        }

        slideShow = slideShowService.getSlideShow(presentationId);

        if (currentSlide >= slideShow.getImages().size()) {
            page = "index.jsp";
            return page;
        }

        image = slideShow.getImages().get(currentSlide);
        currentSlide++;
        httpServletRequest.setAttribute("image", image);
        httpServletRequest.setAttribute("presentation", slideShow);
        httpServletRequest.setAttribute("current_slide", currentSlide);
        page = "view/slide.jsp";
        return page;
    }
}
