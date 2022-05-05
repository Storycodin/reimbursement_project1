package Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Reimburs;

public class ReimbursDao {

	
	//////////////////////////CREATE 
	/**
	 * @param amount
	 * @param submitted
	 * @param resulved
	 * @param description
	 * @param receipt
	 * @param authorId
	 * @param statusId
	 * @param typeId
	 * @return
	 */
	public boolean insertReimburs (int amount, Date submitted, Date resulved, String description, boolean receipt,
			int authorId, int statusId, int typeId){
		System.out.println("insert in SQL");
		try (Connection conn = ConnectionFactory.getConnection()) {
			System.out.println("in the try");
			String sql = "INSERT INTO Reimburs VALUES(DEFAULT, ?, ?, ?, ?, ?, ?, null, ?, ?);";

			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, amount);
			ps.setDate(2, submitted);
			ps.setDate(3, resulved);
			ps.setString(4, description);
			ps.setBoolean(5, receipt);
			ps.setInt(6, authorId);
//			ps.setInt (7,resolverId);
			ps.setInt(7, statusId);
			ps.setInt(8, typeId);
			
			System.out.println(ps);

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}
	
	/////////////////////////////// READ
	
	/**
	 * @param reimbursId
	 * @return
	 */
	public Reimburs selectReimburs (int reimbursId) {
		Reimburs reimburs = null;

		try (Connection conn = ConnectionFactory.getConnection()) {
			
			String sql = "SELECT * FROM Reimburs WHERE reimburs_ID= ?;";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, reimbursId);


			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				reimburs = new Reimburs(rs.getInt("reimburs_ID"), 
						rs.getInt("amount"), 
						rs.getDate("submitted"),
						rs.getDate("resulved"), 
						rs.getString("description"), 
						rs.getBoolean("receipt"), 
						rs.getInt("author"), 
						rs.getInt("resolver"), 
						rs.getInt("status_ID"), 
						rs.getInt("type_ID"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

		return reimburs;
	}
	
	/**
	 * @return
	 */
	public List<Reimburs> selectAllReimburs () {
		List<Reimburs> reimburslist = new ArrayList<>();
		try (Connection conn = ConnectionFactory.getConnection()) {

			String sql = "SELECT * FROM Reimburs";
			

			PreparedStatement ps = conn.prepareStatement(sql);


			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				reimburslist.add(new  Reimburs(rs.getInt("reimburs_ID"), 
						rs.getInt("amount"), 
						rs.getDate("submitted"),
						rs.getDate("resulved"), 
						rs.getString("description"), 
						rs.getBoolean("receipt"), 
						rs.getInt("author"), 
						rs.getInt("resolver"), 
						rs.getInt("status_ID"), 
						rs.getInt("type_ID")));
			}

			

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return reimburslist;
	}
	
	
	//////////////////////////////////UPDATE
	/**
	 * @param reimbursId
	 * @param amount
	 * @param submitted
	 * @param resulved
	 * @param description
	 * @param receipt
	 * @param authorId
	 * @param resolverId
	 * @param statusId
	 * @param typeId
	 * @return
	 */
	public boolean updateReimburs (int reimbursId, int amount, Date submitted, Date resulved, String description, boolean receipt,
			int authorId, int resolverId, int statusId, int typeId){
		try (Connection conn = ConnectionFactory.getConnection()) {
			String sql = "UPDATE Reimburs SET amount = ?, submitted = ?, resolved = ?, description = ?, receipt = ?, author = ?, resolver = ?,  status_ID = ?, type_ID= ? WHERE Remburs_type = ?;";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, amount);
			ps.setDate(2, submitted);
			ps.setDate(3, resulved);
			ps.setString(4, description);
			ps.setBoolean(5, receipt);
			ps.setInt(6, authorId);
			ps.setInt(7, resolverId);
			ps.setInt(8, statusId);
			ps.setInt(9, typeId);
			
			
			ps.setInt(7, reimbursId);
			
			
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}
	
	/**
	 * @param reimbursId
	 * @param statusId
	 * @param resulvDate
	 * @return
	 */
	public boolean updateReimbursStatus (int reimbursId, int statusId, Date resulvDate){
		try (Connection conn = ConnectionFactory.getConnection()) {
			String sql = "UPDATE Reimburs SET status_ID = ? , resulved = ? WHERE reimburs_ID = ?;";

			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, statusId);
			ps.setDate(2, resulvDate);
			
			ps.setInt(3, reimbursId);
			
			
			System.out.println(ps);
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}
	
	
	
	
	
	////////////////////////////////DELETE  
	/**
	 * @param reimbursId
	 * @return
	 */
	public boolean deleteReimburs (int reimbursId) {
		try (Connection conn = ConnectionFactory.getConnection()) {
			
			String sql = "DELETE FROM Reimburs WHERE reimburs_ID = ?;";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, reimbursId);
			
			
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}
	
	
	
}


/*CREATE TABLE Reimburs (
	  reimburs_ID SERIAL PRIMARY KEY, 
	  amount int NOT NULL,
	  submitted timestamp NOT NULL, 
	  resolved timestamp,
	  description varchar(250),
	  receipt boolean,
	  
	  
	  author int REFERENCES Users(users_Id) NOT NULL,
	  resolver int REFERENCES Users(role_ID) NOT NULL,--resolver 
	  status_ID int REFERENCES Remburs_status(status_ID) NOT NULL,
	  type_ID int REFERENCES Remburs_type (type_ID) NOT NULL	   
);*/	