package ua.training.controller.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static ua.training.view.TextConstants.MODEL;

public class GetTotalSizeCommand implements Command {
    @Override
    public void execute(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        SlideShowModel slideShowModel = (SlideShowModel) httpServletRequest.getAttribute(MODEL);
        int totalSize = slideShowModel.getTotalSize();
        httpServletRequest.setAttribute("message", totalSize);

        UtilityMethods.forwardAndPrint(httpServletRequest, httpServletResponse);
    }
}
