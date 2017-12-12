package ua.training.controller.command;

import ua.training.model.entities.Image;
import ua.training.model.entities.SlideShow;
import ua.training.model.service.SlideShowService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static ua.training.controller.text.AttributeNames.CURRENT_SLIDE_ATTRIBUTE;
import static ua.training.controller.text.AttributeNames.IMAGE_ATTRIBUTE;
import static ua.training.controller.text.AttributeNames.PRESENTATION_ATTRIBUTE;
import static ua.training.controller.text.PageNames.HOME_PAGE;
import static ua.training.controller.text.PageNames.SLIDE_PAGE;

public class NextSlideCommand implements Command {
    private SlideShowService slideShowService;

    NextSlideCommand(SlideShowService slideShowService) {
        this.slideShowService = slideShowService;
    }

    @Override
    public String execute(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        int currentSlide;
        String presentationIdStr = httpServletRequest.getParameter(PRESENTATION_ATTRIBUTE);
        SlideShow slideShow;
        Image image;

        if (presentationIdStr == null) {
            return UtilityMethods.getAllSlidesPage(httpServletRequest, httpServletResponse);
        }

        int presentationId = Integer.parseInt(presentationIdStr);
        String currentSlideStr = httpServletRequest.getParameter(CURRENT_SLIDE_ATTRIBUTE);

        if (currentSlideStr == null) {
            currentSlide = 0;
        } else {
            currentSlide = Integer.parseInt(currentSlideStr);
        }

        slideShow = slideShowService.getSlideShow(presentationId);

        if (currentSlide >= slideShow.getImages().size()) {
            return HOME_PAGE;
        }

        image = slideShow.getImages().get(currentSlide);
        currentSlide++;
        httpServletRequest.setAttribute(IMAGE_ATTRIBUTE, image);
        httpServletRequest.setAttribute(PRESENTATION_ATTRIBUTE, slideShow);
        httpServletRequest.setAttribute(CURRENT_SLIDE_ATTRIBUTE, currentSlide);
        return SLIDE_PAGE;
    }
}
