package ua.training.controller.command;

import ua.training.model.SlideShowModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateSlideShowCommand implements Command {
    @Override
    public void execute(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        SlideShowModel slideShowModel = (SlideShowModel) httpServletRequest.getAttribute("model");
        slideShowModel.createSlideShow();
        httpServletRequest.setAttribute("message", "Slide show is created.");
        try {
            httpServletRequest.getRequestDispatcher("index.jsp").forward(httpServletRequest, httpServletResponse);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
