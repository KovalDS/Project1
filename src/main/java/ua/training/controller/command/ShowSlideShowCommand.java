//package ua.training.controller.command;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.PrintWriter;
//
//import static ua.training.view.TextConstants.MODEL;
//
//public class ShowSlideShowCommand implements Command {
//
//    @Override
//    public void execute(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
//        SlideShowModel slideShowModel = (SlideShowModel) httpServletRequest.getAttribute(MODEL);
//
//
//        try (PrintWriter out = httpServletResponse.getWriter()){
//            while (slideShowModel.hasNext()) {
//                out.print("<p>" + slideShowModel.next() + "</p>");
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//
//    }
//}
