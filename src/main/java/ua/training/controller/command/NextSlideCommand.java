package ua.training.controller.command;

import ua.training.model.SlideShowModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static ua.training.view.TextConstants.MODEL;

public class NextSlideCommand implements Command {
    @Override
    public void execute(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {

        SlideShowModel slideShowModel = (SlideShowModel) httpServletRequest.getAttribute(MODEL);
        if (slideShowModel.hasNext()) {
            httpServletRequest.setAttribute("image", slideShowModel.next().toString());
            try {
                httpServletRequest.getRequestDispatcher("slide_show.jsp").forward(httpServletRequest,
                        httpServletResponse);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            UtilityMethods.forwardAndPrint(httpServletRequest, httpServletResponse);
        }
    }
}
