package FrontEnd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.fasterxml.jackson.databind.ObjectMapper;

import controllers.LoginController;
import model.User;
import services.UserService;

public class TestLoginController {

	LoginController mockLogin = Mockito.mock(LoginController.class);


//	convert=new Converter(new ConverterHelper());
////	OR
//	convert=new Converter(coworkerObjectMock);

	UserService mockUserSer = Mockito.mock(UserService.class);
	User mockUser = Mockito.mock(User.class);
	User mockBadUser = null;

	HttpServletRequest mockReq = mock(HttpServletRequest.class);
	HttpServletResponse mockResp = mock(HttpServletResponse.class);

	@Test
	void testLogin() {
		User testGoodUser = new User();
		testGoodUser.setPassword("asdf");
		testGoodUser.setUsername("user1");
//		InputStream mockInput = new InputStream(); can't initialize input streams
		
		ObjectMapper mapper = new ObjectMapper();
		
		// try to get a mappper to fake the json.
		
		String logJSON = mapper.writeValueAsString("{password : asdf, username : user1}");
		
		
		
		User testBadUser = null;
		
		
		
		/////////ARRANGE
		//HERE, we will tell this SPECIFIC mock to give us a SPECIFIC value when a SPECIFIC method is called
		Mockito.when(mockReq.getInputStream()).thenReturn("{password : asdf, username : user1}");
		Mockito.when(mockReq.getInputStream()).thenReturn("{password : asdf, username : user1}");
				
//				.thenReturn()));
		

		/////////ACT
		int twoMiles = convert.howManyFeet(2);
		int fiveMiles = convert.howManyFeet(5);
		
		//////////ASSERT
		assertEquals(2*5280, twoMiles);
		assertEquals(5*5280, fiveMiles);
		//verifying checks for method invocations
		
		Mockito.verify(mockUserSer, Mockito.times(1)).getUserLogin(mockUser.getUsername(), user.getPassword();
		
		
		Mockito.verify(coworkerObjectMock, Mockito.times(2)).findMilesToFeetMultiplier(5+100);
		
		System.out.println("what's the state of the OTHER mocked methods (pi)? "+coworkerObjectMock.findPi());	
		System.out.println("what's the state of the OTHER mocked methods (other)? "+coworkerObjectMock.mocksDefaultValueTwo());
	}
}}
