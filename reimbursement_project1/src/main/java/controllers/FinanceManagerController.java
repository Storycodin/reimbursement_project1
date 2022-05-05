//package controllers;
//
//import java.io.IOException;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//import model.User;
//import services.UserService;
//
//public class FinanceManagerController {
//	
//	// for later development
//	
//	public static void userFetcher(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//		ObjectMapper mapper = new ObjectMapper();
//		
//		User targetUser = mapper.readValue(req.getInputStream(), User.class);
//		UserService newUser = new UserService();
//		
//		
//		System.out.println(newUser.getUser(targetUser.getId()));
//		
////		resp.setContentType("aplication/json");
////		String oldUser = mapper.writeValueAsString(targetUser);
////		resp.getWriter().write(foodJSON);
//	}
//
//	public static void userMaker(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//
//		System.out.println("in the user maker");
//		ObjectMapper mapper = new ObjectMapper();
//		User targetUser = mapper.readValue(req.getInputStream(), User.class);
//		
//		UserService newUser = new UserService();
//		newUser.addUser(targetUser.getUsername(), targetUser.getPassword(), targetUser.getFirstName(), targetUser.getLastName(), targetUser.getEmail(), targetUser.getRoleId());
//		System.out.println("should be a new user?");
//	}
//}