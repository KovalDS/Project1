package ua.training.controller.command;

import ua.training.model.service.SlideShowService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetTotalSizeCommand implements Command {
    private SlideShowService slideShowService;

    GetTotalSizeCommand(SlideShowService slideShowService) {
        this.slideShowService = slideShowService;
    }

    @Override
    public String execute(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        String page = "view/slide_show.jsp";

        int presentationId = Integer.parseInt(httpServletRequest.getParameter("presentation"));
        int totalSize = slideShowService.getTotalSize(presentationId);
        httpServletRequest.setAttribute("message", "Total size is " + totalSize);
        ShowSlideShowCommand showSlideShowCommand = new ShowSlideShowCommand();
        showSlideShowCommand.execute(httpServletRequest, httpServletResponse);
        return page;


    }
}
