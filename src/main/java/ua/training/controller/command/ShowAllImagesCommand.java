package ua.training.controller.command;

import ua.training.model.entities.Image;
import ua.training.model.entities.Tag;
import ua.training.model.service.ImageService;
import ua.training.model.sort.strategy.DateComparator;
import ua.training.model.sort.strategy.SizeComparator;
import ua.training.model.sort.strategy.TagComparator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
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
        List<Image> images;
        String sortType = httpServletRequest.getParameter("sort");
        String findBy = httpServletRequest.getParameter("search");

        if ("Find between size".equals(findBy)) {
            int minSize = Integer.parseInt(httpServletRequest.getParameter("lower_bound"));
            int maxSize = Integer.parseInt(httpServletRequest.getParameter("higher_bound"));
            images = imageService.findBetweenSize(minSize, maxSize);
        } else if ("Find between date".equals(findBy)){
            LocalDate firstDate = LocalDate.parse(httpServletRequest.getParameter("first_date"));
            LocalDate secondDate = LocalDate.parse(httpServletRequest.getParameter("second_date"));
            images = imageService.findBetweenDate(firstDate, secondDate);
        } else if ("Find by tag".equals(findBy)) {
            Tag tag = Tag.valueOf(httpServletRequest.getParameter("tag"));
            images = imageService.findByTag(tag);
        } else {
            images = imageService.findAllImages();
        }

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
