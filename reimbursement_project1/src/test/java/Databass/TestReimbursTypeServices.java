package Databass;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import Dao.ConnectionFactory;
import services.RembursTypeServices;

public class TestReimbursTypeServices {
	RembursTypeServices myType = new RembursTypeServices();
	/////////////////////////// test stuff
	@BeforeAll
	void turnAutoCommitOff() {
		try(Connection conn = ConnectionFactory.getConnection()) {

			conn.setAutoCommit(false);
			
		} catch (SQLException e) {
			System.out.println("Auto comit is on. Tests will not work");
			myType = null;
		}
	}
	
	
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
	void testAddType () {
		System.out.println("--------------------testAddType--------------------");
		assertEquals(true, myType.addType("test"));
		assertEquals(false, myType.addType(""));
		assertEquals(true, myType.addType("123341"));
		assertEquals(false, myType.addType("sadecasr redact asdfartrsdvt asdfes"));
		System.out.println("--------------------testAddType--------------------");

	}//test add Type
	
///////////////////////////// READ
	@Test
	void testGetType () {
		System.out.println("--------------------testGetType--------------------");
		assertEquals("used to test DO NOT DELETE", myType.getType(1));
		assertEquals(null, myType.getType(2));
		assertEquals(null, myType.getType(-1));
		System.out.println("--------------------testGetType--------------------");

		
	}

////////////////////////////////////UPDATE
	@Test
	void testChangeType () {
		System.out.println("--------------------testChangeType--------------------");

		assertEquals(true, myType.changeType("did this work?", 1));
		assertEquals(false, myType.changeType("did this work?", 2));
		assertEquals(false, myType.changeType("", 1));
		assertEquals(false, myType.changeType("sadecasr redact asdfartrsdvt asdfes", 1));
		assertEquals(false, myType.changeType("", 2));
		assertEquals(false, myType.changeType("sadecasr redact asdfartrsdvt asdfes", 2));
		System.out.println("--------------------testChangeType--------------------");

		
	}

//////////////////////////////////DELETE  
	@Test
	void  testRemoveType () {
		
		System.out.println("--------------------testRemoveType--------------------");

		assertEquals(true, myType.removeType(1));
		assertEquals(true, myType.removeType(2));
		assertEquals(false, myType.removeType(-1));
		
		System.out.println("--------------------testRemoveType--------------------");

	}
	
	
	
}


