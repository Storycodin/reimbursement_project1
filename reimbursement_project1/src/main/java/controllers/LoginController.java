package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.User;
import services.UserService;

public class LoginController  {

	/**
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public static void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("loging in");

		
		User user = new User();
		UserService userSer = new UserService();
		ObjectMapper mapper = new ObjectMapper();
		String myPath;
		
		//maps JSON to a java object
		user = mapper.readValue(req.getInputStream() , User.class);
		
		//get a user that has that username and passowrd
		try {
			user = userSer.getUserLogin(user.getUsername(), user.getPassword());
		}catch(Exception e) {
			user = null;
		}
		
//		System.out.println("user before checking =" + user );
		
		if (user != null) {
			req.getSession().setAttribute("user", user);

			
			// Redirect user to proper home page, Employee or 
			if (user.getRoleId() == 1) {//Employee
				myPath = "http://localhost:8080/reimbursement_project1/Employee.html";
			}else if(user.getRoleId() == 2) {//Finance Manager
				myPath = "http://localhost:8080/reimbursement_project1/FinaceManager.html";
			}else {
				myPath = "/login/incorrectcredentials";
				req.getRequestDispatcher(myPath).forward(req, resp);
				System.out.println("not a corect role ID" + user.getRoleId());
			}
		}else{
			myPath = "http://localhost:8080/reimbursement_project1/login/incorrectcredentials";
		}
			
		
		
		//send request back
		System.out.println("user " + user);
		System.out.println("path " + myPath);
		resp.setContentType("aplication/json");
		String logJSON = mapper.writeValueAsString(myPath);
		System.out.println(logJSON);
		resp.getWriter().write(logJSON);
	}

	
	/**
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public static void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("loging out");
		
		ObjectMapper mapper = new ObjectMapper();
		String myPath;
		
		req.getSession().invalidate();
		
		//back to login screen
		myPath = "http://localhost:8080/reimbursement_project1/index.html";
		
		//send request back
		resp.setContentType("aplication/json");
		String logJSON = mapper.writeValueAsString(myPath);
		System.out.println(logJSON);
		resp.getWriter().write(logJSON);
	}	
	
}
