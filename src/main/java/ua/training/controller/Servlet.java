package ua.training.controller;

import ua.training.controller.command.CommandFactory;
import ua.training.model.dao.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Servlet extends HttpServlet {
    private CommandFactory commandFactory;

    @Override
    public void init() throws ServletException {
        super.init();
        commandFactory = CommandFactory.init();
    }

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        String page;

        page = commandFactory.executeCommand(httpServletRequest, httpServletResponse);
        httpServletRequest.getRequestDispatcher(page).forward(httpServletRequest, httpServletResponse);
    }
}
