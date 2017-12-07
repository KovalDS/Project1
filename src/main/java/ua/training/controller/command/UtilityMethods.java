package ua.training.controller.command;

import ua.training.model.SlideShowModel;
import ua.training.model.entities.Slide;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static ua.training.view.TextConstants.MODEL;

public class UtilityMethods {

    public static void findSlides(HttpServletRequest httpServletRequest) {
        SlideShowModel slideShowModel = (SlideShowModel) httpServletRequest.getAttribute(MODEL);
        List<Slide> slides = slideShowModel.findSlides();
        slideShowModel.setSlideShow(slides);
        httpServletRequest.setAttribute(MODEL, slideShowModel);
    }

    public static void forwardAndPrint(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        try {
            httpServletRequest.getRequestDispatcher("index.jsp").forward(httpServletRequest, httpServletResponse);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
