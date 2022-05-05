package controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.User;
import services.ReimbursService;

public class EmployeeController {
	
	//for later development 
	
	public static void reimbursFetcher(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		
		User targetReimburs = mapper.readValue(req.getInputStream(), User.class);
		ReimbursService newReimburs = new ReimbursService();
		
		
		System.out.println(newReimburs.getReimburs(targetReimburs.getId()));
		
//		resp.setContentType("aplication/json");
//		String oldUser = mapper.writeValueAsString(targetUser);
//		resp.getWriter().write(foodJSON);
	}
	
	

}
