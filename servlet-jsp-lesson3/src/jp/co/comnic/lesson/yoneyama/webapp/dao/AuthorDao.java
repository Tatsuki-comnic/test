package jp.co.comnic.lesson.yoneyama.webapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;

import jp.co.comnic.lesson.yoneyama.webapp.beans.Author;

public class AuthorDao {

	public static Author findById(Integer id) throws DaoException {
		
		Author author = new Author();
		String sql = "SELECT * FROM author WHERE id = ?";
				
		try (Connection conn = ConnectionFactory.getConnection();
			 PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			pstmt.setInt(1, id);
									
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					author.setId(rs.getInt("id"));
					author.setName(rs.getString("name"));
				}
			}
			
		} catch (NamingException | SQLException e) {
			throw new DaoException(e);
		}
		
		return author;
	}
	
}
