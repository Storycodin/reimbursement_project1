package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UserRolesDao {

	//////////////////////////CREATE 
	/**
	 * @param role
	 * @return
	 */
	public boolean insertUserRole (String role) {
		try (Connection conn = ConnectionFactory.getConnection()) {

			String sql = "INSERT INTO User_roles VALUES(default, ?);";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, role);


			ps.executeUpdate(); // <----This line sends our statement to the DB

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}
	
	/////////////////////////////// READ
	
	/**
	 * @param userId
	 * @return
	 */
	public String selectUserRole (int userId) {
		String role = new String();

		try (Connection conn = ConnectionFactory.getConnection()) {
			
			String sql = "SELECT * FROM user_roles  WHERE role_id= ?;";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);


			ResultSet rs = ps.executeQuery(); // <----This line sends our statement to the DB

			//change to string
			if (rs.next()) {
				role = (rs.getString("user_role"));
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
	 * @param roleId
	 * @return
	 */
	public boolean updateUserRole (String changeTo, int roleId) {
		try (Connection conn = ConnectionFactory.getConnection()) {
			
			String sql = "UPDATE User_roles SET user_role = ? WHERE role_id = ?;";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, changeTo);
			ps.setInt(2, roleId);
			
			
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}
	
	
	
	
	
	////////////////////////////////DELETE  
	/**
	 * @param roleId
	 * @return
	 */
	public boolean deleteUserRoles (int roleId) {
		try (Connection conn = ConnectionFactory.getConnection()) {
			
			String sql = "DELETE FROM User_roles WHERE role_ID = ?;";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, roleId);
			
			
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}
	
	
	
}
/*CREATE TABLE User_roles(
	role_ID SERIAL PRIMARY KEY,
	user_role varchar(10)
);*/

