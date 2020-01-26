package ua.train.project_logistics_servlets.controller.command;

import javax.servlet.http.HttpServletRequest;

public class LogOut implements Command{
    @Override
    public String execute(HttpServletRequest request) {
        return "redirect:/index.jsp";
    }
}
