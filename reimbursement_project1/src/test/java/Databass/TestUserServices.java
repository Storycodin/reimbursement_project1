package Databass;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import Dao.ConnectionFactory;
import services.UserService;

public class TestUserServices{
	UserService myUser = new UserService();
	/////////////////////////// test stuff
	@BeforeAll
	void turnAutoCommitOff() {
		try(Connection conn = ConnectionFactory.getConnection()) {

			conn.setAutoCommit(false);
			
		} catch (SQLException e) {
			System.out.println("Auto comit is on. Tests will not work");
			myUser = null;
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
	void testAddUser () {
		System.out.println("--------------------testAddUser--------------------");
		//proper input
		assertEquals(true, myUser.addUser("test", "asdf", "first", "last", "asdf@email.com", 1));
		
		// test username
		assertEquals(false, myUser.addUser("", "asdf", "first", "last", "asdf@email.com", 1));
		assertEquals(true, myUser.addUser("65498454", "asdf", "first", "last", "asdf@email.com", 1));
		assertEquals(false, myUser.addUser("sadecasr redact asdfartrsdvt asdfes adlkfasdfahsdfhoh eart", "asdf", "first", "last", "asdf@email.com", 1));
		
		// test password
		assertEquals(false, myUser.addUser("test", "", "first", "last", "asdf@email.com", 1));
		assertEquals(true, myUser.addUser("test", "65498454", "first", "last", "asdf@email.com", 1));
		assertEquals(false, myUser.addUser("test", "sadecasr redact asdfartrsdvt asdfes adlkfasdfahsdfhoh eart", "first", "last", "asdf@email.com", 1));
		
		// test first name
		assertEquals(false, myUser.addUser("test", "asdf", "", "last", "asdf@email.com", 1));
		assertEquals(true, myUser.addUser("test", "asdf", "65498454", "last", "asdf@email.com", 1));
		assertEquals(false, myUser.addUser("test", "asdf", "sadecasr redact asdfartrsdvt asdfes adlkfasdfahsdfhoh eartsadecasr redact asdfartrsdvt asdfes adlkfasdfahsdfhoh eart", "last", "asdf@email.com", 1));

		// test last name
		assertEquals(false, myUser.addUser("test", "asdf", "first", "", "asdf@email.com", 1));
		assertEquals(true, myUser.addUser("test", "asdf", "first", "65498454", "asdf@email.com", 1));
		assertEquals(false, myUser.addUser("test", "asdf", "first", "sadecasr redact asdfartrsdvt asdfes adlkfasdfahsdfhoh eartsadecasr redact asdfartrsdvt asdfes adlkfasdfahsdfhoh eart", "asdf@email.com", 1));
				
		// test email
		assertEquals(false, myUser.addUser("test", "asdf", "first", "last", "", 1));
		assertEquals(true, myUser.addUser("test", "asdf", "first", "last", "65498454", 1));
		assertEquals(false, myUser.addUser("test", "asdf", "first", "last", "sadecasr redact asdfartrsdvt asdfes adlkfasdfahsdfhoh eartsadecasr redact asdfartrsdvt asdfes adlkfasdfahsdfhoh eart", 1));
						
		// test roleId
		assertEquals(true, myUser.addUser("test", "asdf", "first", "last", "asdf@email.com", 1));
		assertEquals(false, myUser.addUser("test", "asdf", "first", "last", "asdf@email.com", 2));
		assertEquals(false, myUser.addUser("test", "asdf", "first", "last", "asdf@email.com", -1));
								
									
				
				
		System.out.println("--------------------testAddUser--------------------");

	}//test add User
	
///////////////////////////// READ
	@Test
	void testGetUser () {
		System.out.println("--------------------testGetUser--------------------");
		assertEquals("used to test DO NOT DELETE", myUser.getUser(1));
		assertEquals(null, myUser.getUser(2));
		assertEquals(null, myUser.getUser(-1));
		System.out.println("--------------------testGetUser--------------------");

		
	}

////////////////////////////////////UPDATE
	@Test
	void testChangeUser () {
		System.out.println("--------------------testChangeUser--------------------");

				
		//proper input
		assertEquals(true, myUser.changeUser(1, "test", "asdf", "first", "last", "asdf@email.com", 1));
		
		// test roleId
		assertEquals(false, myUser.changeUser(2, "test", "asdf", "first", "last", "asdf@email.com", 1));
		assertEquals(false, myUser.changeUser(-1, "test", "asdf", "first", "last", "asdf@email.com", 1));

		// test username
		assertEquals(false, myUser.changeUser(1, "", "asdf", "first", "last", "asdf@email.com", 1));
		assertEquals(true, myUser.changeUser(1, "65498454", "asdf", "first", "last", "asdf@email.com", 1));
		assertEquals(false, myUser.changeUser(1, "sadecasr redact asdfartrsdvt asdfes adlkfasdfahsdfhoh eart", "asdf", "first", "last", "asdf@email.com", 1));
		
		// test password
		assertEquals(false, myUser.changeUser(1, "test", "", "first", "last", "asdf@email.com", 1));
		assertEquals(true, myUser.changeUser(1, "test", "65498454", "first", "last", "asdf@email.com", 1));
		assertEquals(false, myUser.changeUser(1, "test", "sadecasr redact asdfartrsdvt asdfes adlkfasdfahsdfhoh eart", "first", "last", "asdf@email.com", 1));
		
		// test first name
		assertEquals(false, myUser.changeUser(1, "test", "asdf", "", "last", "asdf@email.com", 1));
		assertEquals(true, myUser.changeUser(1, "test", "asdf", "65498454", "last", "asdf@email.com", 1));
		assertEquals(false, myUser.changeUser(1, "test", "asdf", "sadecasr redact asdfartrsdvt asdfes adlkfasdfahsdfhoh eartsadecasr redact asdfartrsdvt asdfes adlkfasdfahsdfhoh eart", "last", "asdf@email.com", 1));

		// test last name
		assertEquals(false, myUser.changeUser(1, "test", "asdf", "first", "", "asdf@email.com", 1));
		assertEquals(true, myUser.changeUser(1, "test", "asdf", "first", "65498454", "asdf@email.com", 1));
		assertEquals(false, myUser.changeUser(1, "test", "asdf", "first", "sadecasr redact asdfartrsdvt asdfes adlkfasdfahsdfhoh eartsadecasr redact asdfartrsdvt asdfes adlkfasdfahsdfhoh eart", "asdf@email.com", 1));
				
		// test email
		assertEquals(false, myUser.changeUser(1, "test", "asdf", "first", "last", "", 1));
		assertEquals(true, myUser.changeUser(1, "test", "asdf", "first", "last", "65498454", 1));
		assertEquals(false, myUser.changeUser(1, "test", "asdf", "first", "last", "sadecasr redact asdfartrsdvt asdfes adlkfasdfahsdfhoh eartsadecasr redact asdfartrsdvt asdfes adlkfasdfahsdfhoh eart", 1));
						
		// test roleId
		assertEquals(false, myUser.changeUser(1, "test", "asdf", "first", "last", "asdf@email.com", 2));
		assertEquals(false, myUser.changeUser(1, "test", "asdf", "first", "last", "asdf@email.com", -1));
		
				
		System.out.println("--------------------testChangeUser--------------------");

		
	}

//////////////////////////////////DELETE  
	@Test
	void  testRemoveUser () {
		
		System.out.println("--------------------testRemoveUser--------------------");

		assertEquals(true, myUser.removeUser(1));
		assertEquals(true, myUser.removeUser(2));
		assertEquals(false, myUser.removeUser(-1));
		
		System.out.println("--------------------testRemoveUser--------------------");

	}
}