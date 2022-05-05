package Databass;

import static org.junit.jupiter.api.Assertions.assertEquals;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.*;

import Dao.ConnectionFactory;
import services.RembursStatusServices;

public class TestRembursStatusServices {
	RembursStatusServices myStatus = new RembursStatusServices();
	
			
	/////////////////////////// test stuff
	@BeforeAll
	void turnAutoCommitOff() {
		try(Connection conn = ConnectionFactory.getConnection()) {

			conn.setAutoCommit(false);
			
		} catch (SQLException e) {
			System.out.println("Auto comit is on. Tests will not work");
			myStatus = null;
		}		
		
		
	}
	
	// should rollback after each test
	@AfterEach
	void tearDown() throws Exception {
		try(Connection conn = ConnectionFactory.getConnection()) {

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
	void testAddStatus () {
		System.out.println("--------------------testAddStatus--------------------");
		assertEquals(true, myStatus.addStatus("test"));
		assertEquals(false, myStatus.addStatus(""));
		assertEquals(true, myStatus.addStatus("123341"));
		assertEquals(false, myStatus.addStatus("sadecasr redact asdfartrsdvt asdfes"));
		System.out.println("--------------------testAddStatus--------------------");

	}//test add status
	
///////////////////////////// READ
	@Test
	void testGetStatus () {
		System.out.println("--------------------testGetStatus--------------------");

		assertEquals("used to test DO NOT DELETE", myStatus.getStatus(1));
		assertEquals(null, myStatus.getStatus(2));
		assertEquals(null, myStatus.getStatus(-1));
		System.out.println("--------------------testGetStatus--------------------");

		
	}

////////////////////////////////////UPDATE
	@Test
	void testChangeStatus () {
		System.out.println("--------------------testChangeStatus--------------------");

		assertEquals(true, myStatus.changeStatus("did this work?", 1));
		assertEquals(false, myStatus.changeStatus("did this work?", 2));
		assertEquals(false, myStatus.changeStatus("", 1));
		assertEquals(false, myStatus.changeStatus("sadecasr redact asdfartrsdvt asdfes", 1));
		assertEquals(false, myStatus.changeStatus("", 2));
		assertEquals(false, myStatus.changeStatus("sadecasr redact asdfartrsdvt asdfes", 2));
		System.out.println("--------------------testChangeStatus--------------------");

		
	}

//////////////////////////////////DELETE  
	@Test
	void  testRemoveStatus () {
		
		System.out.println("--------------------testRemoveStatus--------------------");

		assertEquals(true, myStatus.removeStatus(1));
		assertEquals(true, myStatus.removeStatus(2));
		assertEquals(false, myStatus.removeStatus(-1));
		
		System.out.println("--------------------testRemoveStatus--------------------");

	}

}
