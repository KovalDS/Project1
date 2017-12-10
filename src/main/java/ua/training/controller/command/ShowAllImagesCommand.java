package ua.training.controller.command;

import ua.training.model.entities.Image;
import ua.training.model.service.ImageService;
import ua.training.model.sort.strategy.DateComparator;
import ua.training.model.sort.strategy.SizeComparator;
import ua.training.model.sort.strategy.TagComparator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Comparator;
import java.util.List;

public class ShowAllImagesCommand implements Command {
    private ImageService imageService;

    public ShowAllImagesCommand(ImageService imageService) {
        this.imageService = imageService;
    }

    @Override
    public String execute(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        String page = "/view/images.jsp";
        String sortType = httpServletRequest.getParameter("sort");
        List<Image> images = imageService.findAllImages();
        if ("Sort by size".equals(sortType)) {
            images.sort(new SizeComparator());
        } else if ("Sort by date".equals(sortType)) {
            images.sort(new DateComparator());
        } else if ("Sort by tag".equals(sortType)) {
            images.sort(new TagComparator());
        }
        httpServletRequest.setAttribute("allImages", images);
        return page;
    }
}
