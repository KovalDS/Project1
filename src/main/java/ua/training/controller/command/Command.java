package ua.training.controller.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {
    void execute(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse);
}
