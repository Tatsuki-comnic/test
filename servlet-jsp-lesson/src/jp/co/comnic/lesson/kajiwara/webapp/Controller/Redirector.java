package jp.co.comnic.lesson.kajiwara.webapp.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Redirector extends AbstractDispatcher {

    public Redirector(HttpServletRequest request, HttpServletResponse response, String path) {
        super(request, response, path);
    }

    @Override
    public void dispatch() throws ServletException, IOException {
        response.sendRedirect(path);
    }
}