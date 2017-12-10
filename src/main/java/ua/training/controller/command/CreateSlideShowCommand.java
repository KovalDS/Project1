package ua.training.controller.command;

import ua.training.model.entities.Image;
import ua.training.model.service.ImageService;
import ua.training.model.service.SlideShowService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class CreateSlideShowCommand implements Command {
    private SlideShowService slideShowService;
    private ImageService imageService;
    private ShowAllImagesCommand showAllImagesCommand;

    public CreateSlideShowCommand(SlideShowService slideShowService, ImageService imageService) {
        this.slideShowService = slideShowService;
        this.imageService = imageService;
    }

    @Override
    public String execute(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        String page;

        String[] imagesId  = httpServletRequest.getParameterValues("images");
        String name = httpServletRequest.getParameter("presentation_name");
        if (imagesId == null || name == null) {
            httpServletRequest.setAttribute("message", "Please, select images and choose name of your slide show");
            showAllImagesCommand = new ShowAllImagesCommand(imageService);
            page = showAllImagesCommand.execute(httpServletRequest, httpServletResponse);
            return page;
        }
        List<Image> images = imageService.findImagesWithId(imagesId);
        slideShowService.createSlideShow(images, name);
        httpServletRequest.setAttribute("message", "Slide show was created!");
        page = "index.jsp";
        return page;

    }
}
