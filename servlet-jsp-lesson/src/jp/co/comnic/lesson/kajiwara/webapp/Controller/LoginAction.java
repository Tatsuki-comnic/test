package jp.co.comnic.lesson.kajiwara.webapp.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.comnic.lesson.kajiwara.webapp.beans.Account;
import jp.co.comnic.lesson.kajiwara.webapp.dao.DaoException;
import jp.co.comnic.lesson.kajiwara.webapp.model.LoginAuthenticator;

public class LoginAction implements Action {
        
    @Override
    public Dispatcher execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String forwardPath = "login.jsp";

        Account account;
        try {
            account = LoginAuthenticator.authenticate(userName, password);
                                    
            if (account.isAuthenticated()) {

                HttpSession session = request.getSession();
                session.setAttribute("account", account);
                forwardPath = "top.jsp";
                
                return new Redirector(request, response, forwardPath);
                
            } else {
               request.setAttribute("error", "Invalid username or password.");
                return new Forwarder(request, response, forwardPath);
            }
                
        } catch (DaoException e) {
            throw new ServletException(e);
        }
    }
}