package ua.training.controller.command;

import ua.training.model.entities.Image;
import ua.training.model.entities.SlideShow;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

import static ua.training.controller.text.AttributeNames.ALL_IMAGES_ATTRIBUTE;
import static ua.training.controller.text.AttributeNames.PRESENTATION_ATTRIBUTE;
import static ua.training.controller.text.PageNames.SLIDE_SHOW_PAGE;

public class ShowSlideShowCommand implements Command {

    @Override
    public String execute(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        List<Image> images;
        SlideShow slideShow;

        String presentationIdStr = httpServletRequest.getParameter(PRESENTATION_ATTRIBUTE);
        if (presentationIdStr == null) {
            return UtilityMethods.getAllSlidesPage(httpServletRequest, httpServletResponse);
        }

        slideShow = UtilityMethods.findImagesInSlide(httpServletRequest);
        images = UtilityMethods.sortImages(httpServletRequest, slideShow.getImages());

        httpServletRequest.setAttribute(ALL_IMAGES_ATTRIBUTE, images);
        httpServletRequest.setAttribute(PRESENTATION_ATTRIBUTE, slideShow);
        return SLIDE_SHOW_PAGE;

    }
}
