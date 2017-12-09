//package ua.training.controller.command.sort;
//
//import ua.training.controller.command.Command;
//import ua.training.controller.command.UtilityMethods;
//import ua.training.model.comparators.TagComparator;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import static ua.training.view.TextConstants.MODEL;
//
//public class SortByTagCommand implements Command {
//    @Override
//    public void execute(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
//        SlideShowModel slideShowModel = (SlideShowModel) httpServletRequest.getAttribute(MODEL);
//
//        slideShowModel.setComparator(new TagComparator());
//        slideShowModel.sortSlides();
//
//        httpServletRequest.setAttribute("message", "Slides are sorted by tag");
//        UtilityMethods.forwardAndPrint(httpServletRequest, httpServletResponse);
//    }
//}
