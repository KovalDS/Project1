package ua.training.controller;

import ua.training.controller.command.CommandFactory;
import ua.training.model.SlideShowModel;
import ua.training.model.dao.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Servlet extends HttpServlet {
    CommandFactory commandFactory;
    SlideShowModel slideShowModel;

    @Override
    public void init() throws ServletException {
        super.init();
        commandFactory = CommandFactory.init();
        slideShowModel = new SlideShowModel(DaoFactory.getInstance().createImageDao());
    }

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        String command = httpServletRequest.getParameter("param");
        httpServletRequest.setAttribute("model", slideShowModel);
        commandFactory.executeCommand(command, httpServletRequest, httpServletResponse);
    }
}
