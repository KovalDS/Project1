package ua.training.controller.command;

import ua.training.model.service.SlideShowService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static ua.training.controller.text.AttributeNames.MESSAGE_ATTRIBUTE;
import static ua.training.controller.text.AttributeNames.PRESENTATION_ATTRIBUTE;
import static ua.training.controller.text.PageNames.SLIDE_SHOW_PAGE;

public class GetTotalSizeCommand implements Command {
    private SlideShowService slideShowService;

    GetTotalSizeCommand(SlideShowService slideShowService) {
        this.slideShowService = slideShowService;
    }

    @Override
    public String execute(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        int presentationId = Integer.parseInt(httpServletRequest.getParameter(PRESENTATION_ATTRIBUTE));
        int totalSize = slideShowService.getTotalSize(presentationId);
        httpServletRequest.setAttribute(MESSAGE_ATTRIBUTE, "Total size is " + totalSize);
        ShowSlideShowCommand showSlideShowCommand = new ShowSlideShowCommand();
        showSlideShowCommand.execute(httpServletRequest, httpServletResponse);
        return SLIDE_SHOW_PAGE;
    }
}
