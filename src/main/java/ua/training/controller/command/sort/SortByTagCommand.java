package ua.training.controller.command.sort;

import ua.training.controller.command.Command;
import ua.training.model.SlideShowModel;
import ua.training.model.comparators.DateComparator;
import ua.training.model.comparators.TagComparator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SortByTagCommand implements Command {
    @Override
    public void execute(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        SlideShowModel slideShowModel = (SlideShowModel) httpServletRequest.getAttribute("model");
        slideShowModel.setComparator(new TagComparator());
        slideShowModel.sortSlides();

        httpServletRequest.setAttribute("message", "Slides are sorted by tag");
        try {
            httpServletRequest.getRequestDispatcher("index.jsp").forward(httpServletRequest, httpServletResponse);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
