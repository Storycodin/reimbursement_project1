package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;

public class UsersDao {


	
	
	//////////////////////////CREATE 
	/**
	 * @param username
	 * @param password
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param roleId
	 * @return
	 */
	/**
	 * @param username
	 * @param password
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param roleId
	 * @return
	 */
	public boolean insertUser (String username, String password, String firstName, String lastName, String email, int roleId){
		try (Connection conn = ConnectionFactory.getConnection()) {

			String sql = "INSERT INTO Users VALUES(DEFAULT, ? , ? , ? , ? , ? , ? );";

			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setString(3, firstName);
			ps.setString(4, lastName);
			ps.setString(5, email);
			ps.setInt(6, roleId);


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
	public User selectUser (int userId) {
		User user = null;

		try (Connection conn = ConnectionFactory.getConnection()) {
			
			String sql = "SELECT * FROM Users WHERE users_ID= ?;";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);


			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				user = new User(rs.getInt("users_ID"), rs.getString("username"), rs.getString("password"),
						rs.getString("first_name"), rs.getString("last_name"), rs.getString("email"), rs.getInt("role_ID"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

		return user;
	}
	
	/**
	 * @param username
	 * @param password
	 * @return
	 */
	public User selectUserLogin (String username, String password) {
		User user = null;

		try (Connection conn = ConnectionFactory.getConnection()) {
			
			String sql = "SELECT * FROM users WHERE username = ? AND PASSWORD = ?;";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				user = new User(rs.getInt("users_ID"), rs.getString("username"), rs.getString("password"),
						rs.getString("first_name"), rs.getString("last_name"), rs.getString("email"), rs.getInt("role_ID"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

		return user;
	}
	
	
	
	//////////////////////////////////UPDATE
	/**
	 * @param UserId
	 * @param username
	 * @param password
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param roleId
	 * @return
	 */
	public boolean updateUser (int UserId, String username, String password, String firstName, String lastName, String email, int roleId) {
		try (Connection conn = ConnectionFactory.getConnection()) {
			
			String sql = "UPDATE Users SET username = ?, password = ?, first_name = ?, last_name = ?, email = ?, role_ID WHERE users_ID = ?;";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setString(3, firstName);
			ps.setString(4, lastName);
			ps.setString(5, email);
			ps.setInt(6, roleId);
			ps.setInt(7, UserId);
			
			
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}
	
	
	
	
	
	////////////////////////////////DELETE  
	/**
	 * @param userId
	 * @return
	 */
	public boolean deleteUser (int userId) {
		try (Connection conn = ConnectionFactory.getConnection()) {
			
			String sql = "DELETE FROM Users WHERE users_ID = ?;";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);
			
			
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}
	
	
	
}


/*SQL table creation 
 * CREATE TABLE Users (
	users_ID SERIAL PRIMARY KEY,
	username varchar (50),
	password varchar (50),
	first_name varchar (100),
	last_name varchar (100),
	email varchar (100),
	role_ID int REFERENCES  User_roles(role_ID) NOT null
);*/	