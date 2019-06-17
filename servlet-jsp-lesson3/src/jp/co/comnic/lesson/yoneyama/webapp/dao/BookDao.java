package jp.co.comnic.lesson.yoneyama.webapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;

import jp.co.comnic.lesson.yoneyama.webapp.beans.Book;

public class BookDao {
	
	private final static String BASE_SQL = 
		"SELECT * FROM book b JOIN publisher p JOIN author a " +
		"WHERE b.publisher_id = p.id AND b.author_id = a.id ";
	
	public static Book findByIsbn(String isbn) throws DaoException {

		Book book = new Book();
		String sql = "SELECT * FROM book b JOIN publisher p " + "WHERE b.publisher_id = p.id " + "AND isbn = ?";

		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setString(1, isbn);

			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					book.setIsbn(rs.getString("isbn"));
					book.setTitle(rs.getString("title"));
					book.setPublisher(PublisherDao.findById(rs.getInt("p.id")));
					book.setPrice(rs.getDouble("price"));
				}
			}

		} catch (NamingException | SQLException e) {
			throw new DaoException(e);
		}

		return book;
	}
	
	public static ArrayList<Book> findAll() throws DaoException {
				
		return findAllBy(BASE_SQL);
	}
	
	public static ArrayList<Book> findByTitle(String title) throws DaoException {
	
		String sql = BASE_SQL + "AND title like ?";
		return findAllBy(sql, "%" + title + "%");
	}

	private static ArrayList<Book> findAllBy(String sql, Object... params) throws DaoException {

		ArrayList<Book> bookList = new ArrayList<>();

		try (Connection conn = ConnectionFactory.getConnection();
			 PreparedStatement pstmt = conn.prepareStatement(sql.toString())) {

			if (params != null) {
				int index = 1;
				for (Object param : params) {
					pstmt.setObject(index++, param);
				}
			}
			
			try (ResultSet rs = pstmt.executeQuery()) {

				while (rs.next()) {
					
					Book book = new Book(
						rs.getString("isbn"), 
						rs.getString("title"), 
						AuthorDao.findById(rs.getInt("a.id")),
						PublisherDao.findById(rs.getInt("p.id")), 
						rs.getDouble("price")
					);
					
					bookList.add(book);
				}
			}

		} catch (NamingException | SQLException e) {
			throw new DaoException(e);
		}

		return bookList;
	}
	
	
}
