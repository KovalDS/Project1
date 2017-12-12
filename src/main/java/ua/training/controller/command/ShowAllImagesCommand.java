package ua.training.controller.command;

import ua.training.model.entities.Image;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

import static ua.training.controller.text.AttributeNames.ALL_IMAGES_ATTRIBUTE;
import static ua.training.controller.text.PageNames.ALL_IMAGES_PAGE;

public class ShowAllImagesCommand implements Command {

    @Override
    public String execute(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        List<Image> images;

        images = UtilityMethods.findImages(httpServletRequest);
        images = UtilityMethods.sortImages(httpServletRequest, images);

        httpServletRequest.setAttribute(ALL_IMAGES_ATTRIBUTE, images);
        return ALL_IMAGES_PAGE;
    }
}
