package controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import beans.Account;
import beans.Book;
import dao.AccountDao;
import dao.BookDao;
import dao.DaoException;
public class BookRegistration implements Action {
	@Override
	public Dispatcher execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String isbn= request.getParameter("isbn");//システムIDをとってくる
		String title = request.getParameter("title");
		String author = request.getParameter("author");
	   String userName=request.getParameter("account.userName");
	   String i="a";
	   
	   
	   
		Book book=new Book(isbn,title,author);

		BookDao.saveBook(book,userName);
		
		return new Redirector(request, response, "top");
	}
}