package ua.training.controller.command;

import ua.training.model.entities.Image;
import ua.training.model.service.ImageService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ShowAllImagesCommand implements Command {
    private ImageService imageService;

    public ShowAllImagesCommand(ImageService imageService) {
        this.imageService = imageService;
    }

    @Override
    public String execute(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        String page = "/view/images.jsp";
        List<Image> images = imageService.findAllImages();
        httpServletRequest.setAttribute("allImages", images);
        return page;
    }
}
