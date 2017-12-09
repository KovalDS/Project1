//package ua.training.controller.command.search;
//
//import ua.training.controller.command.Command;
//import ua.training.controller.command.ShowSlideShowCommand;
//import ua.training.controller.command.UtilityMethods;
//import ua.training.model.search.strategies.FindBetweenDate;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.time.LocalDate;
//
//import static ua.training.view.TextConstants.MODEL;
//
//public class FindByDateCommand implements Command {
//    private ShowSlideShowCommand showSlideShowCommand = new ShowSlideShowCommand();
//
//    @Override
//    public void execute(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
//        SlideShowModel slideShowModel = (SlideShowModel) httpServletRequest.getAttribute(MODEL);
//        String firstDate = httpServletRequest.getParameter("first_date");
//        String secondDate = httpServletRequest.getParameter("second_date");
//
//        slideShowModel.setSearchStrategy(new FindBetweenDate(LocalDate.parse(firstDate), LocalDate.parse(secondDate))); //TODO think about composite pattern so you can call method execute() of ShowSlideShowCommand
//        UtilityMethods.findSlides(httpServletRequest);
//
//        showSlideShowCommand.execute(httpServletRequest, httpServletResponse);
//    }
//}
