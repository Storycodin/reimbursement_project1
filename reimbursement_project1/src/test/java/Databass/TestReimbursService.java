package Databass;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import Dao.ConnectionFactory;
import services.ReimbursService;

public class TestReimbursService {
	ReimbursService myReimbur = new ReimbursService();
	/////////////////////////// test stuff
	
	@BeforeAll
	void turnAutoCommitOff() {
		try(Connection conn = ConnectionFactory.getConnection()) {

			conn.setAutoCommit(false);
			
		} catch (SQLException e) {
			System.out.println("Auto comit is on. Tests will not work");
			myReimbur = null;
		}
	}
	
	// should rollback after each test
	@AfterEach
	void tearDown() throws Exception {
		try (Connection conn = ConnectionFactory.getConnection()) {

			String sql = "ROLLBACK;";

			PreparedStatement ps = conn.prepareStatement(sql);


			ps.executeUpdate(); 
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		System.out.println("--------------------after each--------------------");
	}
	
	
//////////////////////////CREATE 
	
	@Test
	void testAddReimburs () {
		System.out.println("--------------------testAddReimburs--------------------");
		//proper input
//		assertEquals(true, myReimbur.addReimburs(100, "01/05/2020", "01/05/2020", "cool", false, 1, 1, 1, 1 ));
//		
//		// test amount
//		assertEquals(true, myReimbur.addReimburs(100000000, "01/05/2020", "01/05/2020", "cool", false, 1, 1, 1, 1 ));
//		assertEquals(false, myReimbur.addReimburs(-100, "01/05/2020", "01/05/2020", "cool", false, 1, 1, 1, 1 ));
//		assertEquals(false, myReimbur.addReimburs(0, "01/05/2020", "01/05/2020", "cool", false, 1, 1, 1, 1 ));
//		
//		// test submitted
//		assertEquals(false, myReimbur.addReimburs(100, "1/05/2020", "01/05/2020", "cool", false, 1, 1, 1, 1 ));
//		assertEquals(false, myReimbur.addReimburs(100, "01/05/20", "01/05/2020", "cool", false, 1, 1, 1, 1 ));
//		assertEquals(false, myReimbur.addReimburs(100, "01/5/2020", "01/05/2020", "cool", false, 1, 1, 1, 1 ));
//		assertEquals(false, myReimbur.addReimburs(100, "01/5", "01/05/2020", "cool", false, 1, 1, 1, 1 ));
//		assertEquals(false, myReimbur.addReimburs(100, "jan 5th", "01/05/2020", "cool", false, 1, 1, 1, 1 ));
//		
//		// test resolved
//		assertEquals(false, myReimbur.addReimburs(100, "01/05/2020", "1/05/2020", "cool", false, 1, 1, 1, 1 ));
//		assertEquals(false, myReimbur.addReimburs(100, "01/05/2020", "01/05/20", "cool", false, 1, 1, 1, 1 ));
//		assertEquals(false, myReimbur.addReimburs(100,  "01/05/2020", "01/5/2020", "cool", false, 1, 1, 1, 1 ));
//		assertEquals(false, myReimbur.addReimburs(100, "01/05/2020", "01/5", "cool", false, 1, 1, 1, 1 ));
//		assertEquals(false, myReimbur.addReimburs(100, "01/05/2020", "jan 5th", "cool", false, 1, 1, 1, 1 ));
//		
//		// test last name
//		assertEquals(false, myReimbur.addReimburs(100, "01/05/2020","01/05/2020", 
//				"I love a programmer\r\n"
//				+ "He is always there making codes\r\n"
//				+ "On different ways in order\r\n"
//				+ "To show how much he loves you so\r\n"
//				+ "\r\n"
//				+ "There are times when he would\r\n"
//				+ "Just throw some complex hints at me\r\n"
//				+ "With utmost best I could\r\n"
//				+ "Try to find the meaning and see\r\n"
//				+ "\r\n"
//				+ "See that maybe I'm right\r\n"
//				+ "With the theory that I have made\r\n"
//				+ "And maybe, just maybe\r\n"
//				+ "My words rhyme with what's in your head", false, 1, 1, 1, 1 ));
//		assertEquals(true, myReimbur.addReimburs(100, "01/05/2020", "01/05/2020", "", false, 1, 1, 1, 1 ));
//		assertEquals(true, myReimbur.addReimburs(100,  "01/05/2020", "01/05/2020", "546464987", false, 1, 1, 1, 1 ));
//		
//		// test authorId
//		assertEquals(true, myReimbur.addReimburs(100, "01/05/2020", "01/05/2020", "cool", false, -1, 1, 1, 1 ));
//		assertEquals(true, myReimbur.addReimburs(100, "01/05/2020", "01/05/2020", "cool", false, 2, 1, 1, 1 ));
//
//		// test resolverId
//		assertEquals(true, myReimbur.addReimburs(100, "01/05/2020", "01/05/2020", "cool", false, 1, -1, 1, 1 ));
//		assertEquals(true, myReimbur.addReimburs(100, "01/05/2020", "01/05/2020", "cool", false, 1, 2, 1, 1 ));
//								
//		// test resolverId		
//		assertEquals(true, myReimbur.addReimburs(100, "01/05/2020", "01/05/2020", "cool", false, 1, 1, -1,  1 ));
//		assertEquals(true, myReimbur.addReimburs(100, "01/05/2020", "01/05/2020", "cool", false, 1, 1, 2, 1 ));
//
//		
//		// test typeId
//		assertEquals(true, myReimbur.addReimburs(100, "01/05/2020", "01/05/2020", "cool", false,  1, 1, 1, -1 ));
//		assertEquals(true, myReimbur.addReimburs(100, "01/05/2020", "01/05/2020", "cool", false,  1, 1, 1, 2 ));
//	
				
		System.out.println("--------------------testAddReimburs--------------------");

	}//test add Reimburs
	
///////////////////////////// READ
	@Test
	void testGetReimburs () {
		System.out.println("--------------------testGetReimburs--------------------");
		assertEquals("used to test DO NOT DELETE", myReimbur.getReimburs(1));
		assertEquals(null, myReimbur.getReimburs(2));
		assertEquals(null, myReimbur.getReimburs(-1));
		System.out.println("--------------------testGetReimburs--------------------");

		
	}

////////////////////////////////////UPDATE
	@Test
	void testChangeReimburs () {
		System.out.println("--------------------testChangeReimburs--------------------");

		//proper input
		assertEquals(true, myReimbur.changeReimburs(1, 100, "01/05/2020", "01/05/2020", "cool", false, 1, 1, 1, 1 ));
		
		// test amount
		assertEquals(true, myReimbur.changeReimburs(1, 100000000, "01/05/2020", "01/05/2020", "cool", false, 1, 1, 1, 1 ));
		assertEquals(false, myReimbur.changeReimburs(1, -100, "01/05/2020", "01/05/2020", "cool", false, 1, 1, 1, 1 ));
		assertEquals(false, myReimbur.changeReimburs(1, 0, "01/05/2020", "01/05/2020", "cool", false, 1, 1, 1, 1 ));
		
		// test submitted
		assertEquals(false, myReimbur.changeReimburs(1, 100, "1/05/2020", "01/05/2020", "cool", false, 1, 1, 1, 1 ));
		assertEquals(false, myReimbur.changeReimburs(1, 100, "01/05/20", "01/05/2020", "cool", false, 1, 1, 1, 1 ));
		assertEquals(false, myReimbur.changeReimburs(1, 100, "01/5/2020", "01/05/2020", "cool", false, 1, 1, 1, 1 ));
		assertEquals(false, myReimbur.changeReimburs(1, 100, "01/5", "01/05/2020", "cool", false, 1, 1, 1, 1 ));
		assertEquals(false, myReimbur.changeReimburs(1, 100, "jan 5th", "01/05/2020", "cool", false, 1, 1, 1, 1 ));
		
		// test resolved
		assertEquals(false, myReimbur.changeReimburs(1, 100, "01/05/2020", "1/05/2020", "cool", false, 1, 1, 1, 1 ));
		assertEquals(false, myReimbur.changeReimburs(1, 100, "01/05/2020", "01/05/20", "cool", false, 1, 1, 1, 1 ));
		assertEquals(false, myReimbur.changeReimburs(1, 100,  "01/05/2020", "01/5/2020", "cool", false, 1, 1, 1, 1 ));
		assertEquals(false, myReimbur.changeReimburs(1, 100, "01/05/2020", "01/5", "cool", false, 1, 1, 1, 1 ));
		assertEquals(false, myReimbur.changeReimburs(1, 100, "01/05/2020", "jan 5th", "cool", false, 1, 1, 1, 1 ));
		
		// test last name
		assertEquals(false, myReimbur.changeReimburs(1, 100, "01/05/2020","01/05/2020", 
				"I love a programmer\r\n"
				+ "He is always there making codes\r\n"
				+ "On different ways in order\r\n"
				+ "To show how much he loves you so\r\n"
				+ "\r\n"
				+ "There are times when he would\r\n"
				+ "Just throw some complex hints at me\r\n"
				+ "With utmost best I could\r\n"
				+ "Try to find the meaning and see\r\n"
				+ "\r\n"
				+ "See that maybe I'm right\r\n"
				+ "With the theory that I have made\r\n"
				+ "And maybe, just maybe\r\n"
				+ "My words rhyme with what's in your head", false, 1, 1, 1, 1 ));
		assertEquals(true, myReimbur.changeReimburs(1, 100, "01/05/2020", "01/05/2020", "", false, 1, 1, 1, 1 ));
		assertEquals(true, myReimbur.changeReimburs(1, 100,  "01/05/2020", "01/05/2020", "546464987", false, 1, 1, 1, 1 ));
		
		// test authorId
		assertEquals(true, myReimbur.changeReimburs(1, 100, "01/05/2020", "01/05/2020", "cool", false, -1, 1, 1, 1 ));
		assertEquals(true, myReimbur.changeReimburs(1, 100, "01/05/2020", "01/05/2020", "cool", false, 2, 1, 1, 1 ));

		// test resolverId
		assertEquals(true, myReimbur.changeReimburs(1, 100, "01/05/2020", "01/05/2020", "cool", false, 1, -1, 1, 1 ));
		assertEquals(true, myReimbur.changeReimburs(1, 100, "01/05/2020", "01/05/2020", "cool", false, 1, 2, 1, 1 ));
								
		// test resolverId		
		assertEquals(true, myReimbur.changeReimburs(1, 100, "01/05/2020", "01/05/2020", "cool", false, 1, 1, -1,  1 ));
		assertEquals(true, myReimbur.changeReimburs(1, 100, "01/05/2020", "01/05/2020", "cool", false, 1, 1, 2, 1 ));

		
		// test typeId
		assertEquals(true, myReimbur.changeReimburs(1, 100, "01/05/2020", "01/05/2020", "cool", false,  1, 1, 1, -1 ));
		assertEquals(true, myReimbur.changeReimburs(1, 100, "01/05/2020", "01/05/2020", "cool", false,  1, 1, 1, 2 ));
				
		System.out.println("--------------------testChangeReimburs--------------------");

		
	}

//////////////////////////////////DELETE  
	@Test
	void  testRemoveReimburs () {
		
		System.out.println("--------------------testRemoveReimburs--------------------");

		assertEquals(true, myReimbur.removeReimburs(1));
		assertEquals(true, myReimbur.removeReimburs(2));
		assertEquals(false, myReimbur.removeReimburs(-1));
		
		System.out.println("--------------------testRemoveReimburs--------------------");

	}
}
