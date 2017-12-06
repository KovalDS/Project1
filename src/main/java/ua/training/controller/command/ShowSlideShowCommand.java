package ua.training.controller.command;

import ua.training.model.SlideShowModel;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class ShowSlideShowCommand implements Command {

    @Override
    public void execute(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        SlideShowModel slideShowModel = (SlideShowModel) httpServletRequest.getAttribute("model");
        try (PrintWriter out = httpServletResponse.getWriter();){
            if (slideShowModel.getSlideShow() == null) {
                out.print("<p>Please, create slide show first</p>");
                return;
            }
            while (slideShowModel.hasNext()) {
                out.print("<p>" + slideShowModel.next() + "</p>");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
