package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RembursTypeDao {
	
	
	//////////////////////////CREATE 
	/**
	 * @param type
	 * @return
	 */
	public boolean insertType (String type) {
		try (Connection conn = ConnectionFactory.getConnection()) {

			String sql = "INSERT INTO Remburs_type VALUES(DEFAULT, ?);";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, type);


			ps.executeUpdate(); // <----This line sends our statement to the DB

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}
	
	/////////////////////////////// READ
	
	/**
	 * @param typeId
	 * @return
	 */
	public String selectType (int typeId) {
		String role = new String();

		try (Connection conn = ConnectionFactory.getConnection()) {
			
			String sql = "SELECT * FROM Remburs_type WHERE type_id= ?;";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, typeId);


			ResultSet rs = ps.executeQuery(); // <----This line sends our statement to the DB

			//change to string
			if (rs.next()) {
				role = (rs.getString("reimburs_type"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

		return role;
	}
	
	//////////////////////////////////UPDATE
	/**
	 * @param changeTo
	 * @param typeId
	 * @return
	 */
	public boolean updateType (String changeTo, int typeId) {
		try (Connection conn = ConnectionFactory.getConnection()) {
			
			String sql = "UPDATE Remburs_type SET remburs_type = ? WHERE type_id = ?;";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, changeTo);
			ps.setInt(2, typeId);
			
			
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}
	
	
	
	
	
	////////////////////////////////DELETE  
	/**
	 * @param typeId
	 * @return
	 */
	public boolean deleteType (int typeId) {
		try (Connection conn = ConnectionFactory.getConnection()) {
			
			String sql = "DELETE FROM Remburs_type WHERE type_ID = ?;";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, typeId);
			
			
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}
	
	
	
}

/*CREATE TABLE Remburs_type(
type_ID SERIAL PRIMARY KEY,
reimburs_Type varchar(10)
);*/