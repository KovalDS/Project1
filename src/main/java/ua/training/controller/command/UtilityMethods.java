package ua.training.controller.command;

import ua.training.model.SlideShowModel;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UtilityMethods {
    static boolean checkPresentationIsCreated(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        SlideShowModel slideShowModel = (SlideShowModel) httpServletRequest.getAttribute("model");

        try (PrintWriter out = httpServletResponse.getWriter()){
            if (slideShowModel.getSlideShow() == null) {
                out.print("<p>Please, create slide show first</p>");
                return false;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
