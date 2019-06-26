package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;

import beans.Book;

public class BookDao {
    static String BASE_SQL =" select * from account a JOIN book b JOIN registration r WHERE b.isbn=r.isbn AND r.id =a.id AND a.user_name='?';";

public static Book findByIsbn(String userName)throws DaoException {
      Book book = new Book();        
     String sql ="select * from account a JOIN book b JOIN registration r WHERE b.isbn=r.isbn AND r.id =a.id AND a.user_name='?';";
                                                                    
        try (Connection conn = ConnectionFactory.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1,userName);
                try (ResultSet rs = pstmt.executeQuery()) {
                        if (rs.next()) {
                                book.setIsbn(rs.getString("isbn"));
                                book.setTitle(rs.getString("title"));
                                book.setAutor(rs.getString("author"));
                                
                        }
                }
        } catch (NamingException | SQLException e) {
                throw new DaoException(e);
        }
        return book;
}

public static ArrayList<Book> findAll(String userName) throws DaoException {
        ArrayList<Book> bookList = new ArrayList<>();                    
        String sql ="select * from account a JOIN book b JOIN registration r WHERE b.isbn=r.isbn AND r.id =a.id "+ "AND user_name = ?";
       
    try (Connection conn = ConnectionFactory.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1,userName);
            try (ResultSet rs = pstmt.executeQuery()) {
            	
            				while (rs.next()) {
                    		Book book = new Book();
                            book.setIsbn(rs.getString("isbn"));
                            book.setTitle(rs.getString("title"));
                            book.setAutor(rs.getString("author"));
                            bookList.add(book);
                            
                    }
            }
    } catch (NamingException | SQLException e) {
            throw new DaoException(e);
    }
    return bookList;
}

public static ArrayList<Book> findByTitle(String title) throws DaoException {

        String sql = BASE_SQL ;
        return findAllBy(sql);
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
                                        rs.getString("author")                                           
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