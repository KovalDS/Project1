//package ua.training.controller.command.search;
//
//import ua.training.controller.command.Command;
//import ua.training.controller.command.ShowSlideShowCommand;
//import ua.training.controller.command.UtilityMethods;
//import ua.training.model.search.strategies.FindBetweenSize;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import static ua.training.view.TextConstants.MODEL;
//
//public class FindBySizeCommand implements Command {
//    private ShowSlideShowCommand showSlideShowCommand = new ShowSlideShowCommand();
//
//    @Override
//    public void execute(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
//        SlideShowModel slideShowModel = (SlideShowModel) httpServletRequest.getAttribute(MODEL);
//        int minSize = Integer.parseInt(httpServletRequest.getParameter("lower_bound"));
//        int maxSize = Integer.parseInt(httpServletRequest.getParameter("higher_bound"));
//
//        slideShowModel.setSearchStrategy(new FindBetweenSize(minSize, maxSize)); //TODO think about composite pattern so you can call method execute() of ShowSlideShowCommand
//        UtilityMethods.findSlides(httpServletRequest);
//
//        showSlideShowCommand.execute(httpServletRequest, httpServletResponse);
//    }
//}
