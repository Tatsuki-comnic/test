package jp.co.comnic.lesson.kajiwara.webapp.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.comnic.lesson.kajiwara.webapp.beans.Account;
import jp.co.comnic.lesson.kajiwara.webapp.dao.DaoException;
import jp.co.comnic.lesson.kajiwara.webapp.model.LoginAuthenticator;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FrontController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 

                                 throws ServletException, IOException {


		ActionFactory.getAction(request.getServletPath())
		.execute(request, response)
		.dispatch();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}
}