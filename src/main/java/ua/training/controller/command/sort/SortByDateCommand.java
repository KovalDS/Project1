package ua.training.controller.command.sort;

import ua.training.controller.command.Command;
import ua.training.model.SlideShowModel;
import ua.training.model.comparators.DateComparator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SortByDateCommand implements Command {

    @Override
    public void execute(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        SlideShowModel slideShowModel = (SlideShowModel) httpServletRequest.getAttribute("model");

        slideShowModel.setComparator(new DateComparator());
        slideShowModel.sortSlides();

        httpServletRequest.setAttribute("message", "<p>Slides are sorted by date</p>");
        try {
            httpServletRequest.getRequestDispatcher("index.jsp").forward(httpServletRequest, httpServletResponse);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
