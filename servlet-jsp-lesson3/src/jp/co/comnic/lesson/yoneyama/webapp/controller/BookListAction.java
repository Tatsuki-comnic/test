package jp.co.comnic.lesson.yoneyama.webapp.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.comnic.lesson.yoneyama.webapp.beans.Book;
import jp.co.comnic.lesson.yoneyama.webapp.dao.BookDao;
import jp.co.comnic.lesson.yoneyama.webapp.dao.DaoException;

public class BookListAction implements Action {

	@Override
	public Dispatcher execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String title = request.getParameter("title");
		
		try {
			
			ArrayList<Book> bookList = null;
			
			if (title == null) {
				bookList = BookDao.findAll();
			} else {
				bookList = BookDao.findByTitle(title);
			}
			
			request.setAttribute("bookList", bookList);
			
		} catch (DaoException e) {
			throw new ServletException(e);
		}		
		
		return new Forwarder(request, response, "book-list");
	}

}
