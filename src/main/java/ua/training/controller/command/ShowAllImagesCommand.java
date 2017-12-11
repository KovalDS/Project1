package ua.training.controller.command;

import ua.training.model.entities.Image;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ShowAllImagesCommand implements Command {

    @Override
    public String execute(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        String page = "/view/images.jsp";
        List<Image> images;

        images = UtilityMethods.findImages(httpServletRequest);
        images = UtilityMethods.sortImages(httpServletRequest, images);

        httpServletRequest.setAttribute("allImages", images);
        return page;
    }
}
