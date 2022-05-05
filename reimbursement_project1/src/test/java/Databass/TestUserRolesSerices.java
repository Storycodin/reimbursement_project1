package Databass;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import Dao.ConnectionFactory;
import services.UserRolesServices;

public class TestUserRolesSerices {
	UserRolesServices myUserRole = new UserRolesServices();
	/////////////////////////// test stuff
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
	void testAddUserRole () {
		System.out.println("--------------------testAddUserRole--------------------");
		assertEquals(true, myUserRole.addUserRole("test"));
		assertEquals(false, myUserRole.addUserRole(""));
		assertEquals(true, myUserRole.addUserRole("123341"));
		assertEquals(false, myUserRole.addUserRole("sadecasr redact asdfartrsdvt asdfes"));
		System.out.println("--------------------testAddUserRole--------------------");

	}//test add UserRole
	
///////////////////////////// READ
	@Test
	void testGetUserRole () {
		System.out.println("--------------------testGetUserRole--------------------");
		assertEquals("used to test DO NOT DELETE", myUserRole.getUserRole(1));
		assertEquals(null, myUserRole.getUserRole(2));
		assertEquals(null, myUserRole.getUserRole(-1));
		System.out.println("--------------------testGetUserRole--------------------");

		
	}

////////////////////////////////////UPDATE
	@Test
	void testChangeUserRole () {
		System.out.println("--------------------testChangeUserRole--------------------");

		assertEquals(true, myUserRole.changeUserRole("did this work?", 1));
		assertEquals(false, myUserRole.changeUserRole("did this work?", 2));
		assertEquals(false, myUserRole.changeUserRole("", 1));
		assertEquals(false, myUserRole.changeUserRole("sadecasr redact asdfartrsdvt asdfes", 1));
		assertEquals(false, myUserRole.changeUserRole("", 2));
		assertEquals(false, myUserRole.changeUserRole("sadecasr redact asdfartrsdvt asdfes", 2));
		System.out.println("--------------------testChangeUserRole--------------------");

		
	}

//////////////////////////////////DELETE  
	@Test
	void  testRemoveUserRole () {
		
		System.out.println("--------------------testRemoveUserRole--------------------");

		assertEquals(true, myUserRole.removeUserRole(1));
		assertEquals(true, myUserRole.removeUserRole(2));
		assertEquals(false, myUserRole.removeUserRole(-1));
		
		System.out.println("--------------------testRemoveUserRole--------------------");

	}
}
