package ua.training.controller;

import ua.training.controller.command.CommandFactory;
import ua.training.model.SlideShowModel;
import ua.training.model.dao.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static ua.training.view.TextConstants.CREATE_ARRAY;
import static ua.training.view.TextConstants.MODEL;

public class Servlet extends HttpServlet {
    private CommandFactory commandFactory;
    private SlideShowModel slideShowModel;

    @Override
    public void init() throws ServletException {
        super.init();
        commandFactory = CommandFactory.init();
        slideShowModel = new SlideShowModel(DaoFactory.getInstance().createImageDao());
    }

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        String command = httpServletRequest.getParameter("param");
        httpServletRequest.setAttribute(MODEL, slideShowModel);
        PrintWriter out = httpServletResponse.getWriter();

        try {
            commandFactory.executeCommand(command, httpServletRequest, httpServletResponse);
        } catch (NullPointerException e){
            out.print("Please, create array first");
        }

        out.close();
    }
}
