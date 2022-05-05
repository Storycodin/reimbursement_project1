package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RembursStatusDao {
	
	//////////////////////////CREATE 
	/**
	 * @param status
	 * @return
	 */
	public boolean insertStatus (String status) {
		try (Connection conn = ConnectionFactory.getConnection()) {

			String sql = "INSERT INTO Remburs_status VALUES(DEFAULT, ?);";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, status);


			ps.executeUpdate(); // <----This line sends our statement to the DB

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}
	
	/////////////////////////////// READ
	
	/**
	 * @param statusId
	 * @return
	 */
	public String selectStatus (int statusId) {
		String status = new String();

		try (Connection conn = ConnectionFactory.getConnection()) {
			
			String sql = "SELECT * FROM Remburs_status WHERE status_ID= ?;";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, statusId);


			ResultSet rs = ps.executeQuery(); // <----This line sends our statement to the DB

			//change to string
			if (rs.next()) {
				status = (rs.getString("status"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

		return status;
	}
	
	//////////////////////////////////UPDATE
	/**
	 * @param changeTo
	 * @param statusId
	 * @return
	 */
	public boolean updateStatus (String changeTo, int statusId) {
		try (Connection conn = ConnectionFactory.getConnection()) {
			
			String sql = "UPDATE Remburs_status SET status = ? WHERE status_ID = ?;";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, changeTo);
			ps.setInt(2, statusId);
			
			
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}
	
	
	
	
	
	////////////////////////////////DELETE  
	/**
	 * @param statusId
	 * @return
	 */
	public boolean deleteStatus (int statusId) {
		try (Connection conn = ConnectionFactory.getConnection()) {
			
			String sql = "DELETE FROM Remburs_status WHERE status_ID = ?;";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, statusId);
			
			
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}
	
	
	
}
/*CREATE TABLE Remburs_status(
	status_ID SERIAL PRIMARY KEY,
	status varchar(10)
);*/

