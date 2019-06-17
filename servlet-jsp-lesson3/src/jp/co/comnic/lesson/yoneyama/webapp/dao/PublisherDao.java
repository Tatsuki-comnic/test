package jp.co.comnic.lesson.yoneyama.webapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;

import jp.co.comnic.lesson.yoneyama.webapp.beans.Publisher;

public class PublisherDao {

	public static Publisher findById(Integer id) throws DaoException {
		
		Publisher publisher = new Publisher();
		String sql = "SELECT * FROM publisher WHERE id = ?";
				
		try (Connection conn = ConnectionFactory.getConnection();
			 PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			pstmt.setInt(1, id);
									
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					publisher.setId(rs.getInt("id"));
					publisher.setName(rs.getString("name"));
				}
			}
			
		} catch (NamingException | SQLException e) {
			throw new DaoException(e);
		}
		
		return publisher;
	}
}
