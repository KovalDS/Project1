package ua.training.controller.command;

import ua.training.model.entities.Image;
import ua.training.model.entities.SlideShow;
import ua.training.model.service.SlideShowService;
import ua.training.model.sort.strategy.DateComparator;
import ua.training.model.sort.strategy.SizeComparator;
import ua.training.model.sort.strategy.TagComparator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ShowSlideShowCommand implements Command {
    private SlideShowService slideShowService;
    private ShowAllPresentationsCommand showAllPresentationsCommand;

    public ShowSlideShowCommand(SlideShowService slideShowService) {
        this.slideShowService = slideShowService;
    }

    @Override
    public String execute(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        String page;
        List<Image> images;
        SlideShow slideShow;

        String sortType = httpServletRequest.getParameter("sort");

        String presentationIdStr = httpServletRequest.getParameter("presentation");
        if (presentationIdStr == null) {
            httpServletRequest.setAttribute("message", "Please, select presentation");
            showAllPresentationsCommand = new ShowAllPresentationsCommand(slideShowService);
            page = showAllPresentationsCommand.execute(httpServletRequest, httpServletResponse);
            return page;
        }

        slideShow = slideShowService.getSlideShow(Integer.parseInt(presentationIdStr));
        images = slideShow.getImages();
        if ("Sort by size".equals(sortType)) {
            images.sort(new SizeComparator());
        } else if ("Sort by date".equals(sortType)) {
            images.sort(new DateComparator());
        } else if ("Sort by tag".equals(sortType)) {
            images.sort(new TagComparator());
        }
        httpServletRequest.setAttribute("allImages", images);
        httpServletRequest.setAttribute("presentation", slideShow);
        page = "view/slide_show.jsp";
        return page;

    }
}
