//package ua.training.controller.command.sort;
//
//import ua.training.controller.command.Command;
//import ua.training.controller.command.UtilityMethods;
//import ua.training.model.comparators.DateComparator;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import static ua.training.view.TextConstants.MODEL;
//
//public class SortByDateCommand implements Command {
//
//    @Override
//    public void execute(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
//        SlideShowModel slideShowModel = (SlideShowModel) httpServletRequest.getAttribute(MODEL);
//
//        slideShowModel.setComparator(new DateComparator());
//        slideShowModel.sortSlides();
//
//        httpServletRequest.setAttribute("message", "<p>Slides are sorted by date</p>");
//        UtilityMethods.forwardAndPrint(httpServletRequest, httpServletResponse);
//    }
//}
