package ua.training.controller.command;

import ua.training.model.entities.Image;
import ua.training.model.service.ImageService;
import ua.training.model.service.SlideShowService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

import static ua.training.controller.text.AttributeNames.IMAGES_ATTRIBUTE;
import static ua.training.controller.text.AttributeNames.MESSAGE_ATTRIBUTE;
import static ua.training.controller.text.AttributeNames.PRESENTATION_NAME;
import static ua.training.controller.text.PageNames.HOME_PAGE;

public class CreateSlideShowCommand implements Command {
    private SlideShowService slideShowService;
    private ImageService imageService;
    private ShowAllImagesCommand showAllImagesCommand;

    CreateSlideShowCommand(SlideShowService slideShowService, ImageService imageService) {
        this.slideShowService = slideShowService;
        this.imageService = imageService;
    }

    @Override
    public String execute(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        String[] imagesId  = httpServletRequest.getParameterValues(IMAGES_ATTRIBUTE);
        String name = httpServletRequest.getParameter(PRESENTATION_NAME);

        if (imagesId == null || name == null) {
            httpServletRequest.setAttribute(MESSAGE_ATTRIBUTE, "Please, select images and choose name of your slide show");
            showAllImagesCommand = new ShowAllImagesCommand();
            return showAllImagesCommand.execute(httpServletRequest, httpServletResponse);
        }

        List<Image> images = imageService.findImagesWithId(imagesId);
        slideShowService.createSlideShow(images, name);
        httpServletRequest.setAttribute(MESSAGE_ATTRIBUTE, "Slide show was created!");
        return HOME_PAGE;

    }
}
