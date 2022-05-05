package controllers;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import model.Reimburs;
import model.User;
import services.ReimbursService;
//import services.UserRolesServices;

public class ReimburController {
	/**
	 * Returns reims for the logged in user
	 * 
	 * @param myId
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public static void allMyReim (int myId, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ReimbursService reimSer = new ReimbursService();
		ArrayList <Reimburs> myReim = new ArrayList <Reimburs>();
		ObjectMapper mapper = new ObjectMapper();
		
		
		// get all reimbursements
		ArrayList <Reimburs> allReim = (ArrayList<Reimburs>) reimSer.getAllReimburs();
		
		
		// find the reimbursements that belong to this user.
		for (int i = 0; i < allReim.size(); i++) {
			if (allReim.get(i).getAuthorId() == myId ) {
				myReim.add(allReim.get(i));
			}//if
		}//for
		
		//send back the request
		System.out.println(myReim);
		resp.setContentType("aplication/json");
		String foodJSON = mapper.writeValueAsString(myReim);
		resp.getWriter().write(foodJSON);
		
	}
	/**
	 * Returns ALL reims in the system, only if the user is an FM
	 * 
	 * @param myId
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public static void allReim (int myId, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ReimbursService reimSer = new ReimbursService();
//		UserRolesServices myType = new UserRolesServices();
		ArrayList <Reimburs> myReim = new ArrayList <Reimburs>();
		ObjectMapper mapper = new ObjectMapper();
		
		
		// get all reimbursements
		ArrayList <Reimburs> allReim = (ArrayList<Reimburs>) reimSer.getAllReimburs();
		
		for (int i = 0; i < allReim .size(); i++) {
			myReim.add(allReim .get(i));
		}//for

		
		//send back the request
		System.out.println(myReim);
		resp.setContentType("aplication/json");
		String foodJSON = mapper.writeValueAsString(myReim);
		resp.getWriter().write(foodJSON);
		
	}
	
	
	/**
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public static void  creatReimburs(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ReimbursService reimSer = new ReimbursService();
		ObjectMapper mapper = new ObjectMapper();

		try {
			
		Reimburs targetReim = mapper.readValue(req.getInputStream(), Reimburs.class);
		
		Date sumDate = Date.valueOf(LocalDate.now());
		
		Date resDate = null;
		
		User thisUser = (User) req.getSession().getAttribute("user");

		reimSer.addReimburs(targetReim.getAmount(), sumDate, resDate, targetReim.getDescription(),
				false, thisUser.getId(), 1, targetReim.getTypeId());
		}catch (InvalidFormatException e){
			System.out.println("in catch");
			//send back the request
			resp.setContentType("aplication/json");
			String badInputJSON = mapper.writeValueAsString("bad input");
			resp.getWriter().write(badInputJSON);
			
		}
			
	}//creatReimburs
	
	/**
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public static void  changeReimbursStatus (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ReimbursService reimSer = new ReimbursService();
		ObjectMapper mapper = new ObjectMapper();
		
		
		System.out.println("change a Reim");
		try {
			
		Reimburs targetReim = mapper.readValue(req.getInputStream(), Reimburs.class);
		
		System.out.println("status ID =" + targetReim.getStatusId());
		System.out.println("reim ID =" + targetReim.getReimbursId());
		
		Date date = Date.valueOf(LocalDate.now());
		
		reimSer.changeReimbursStatus (targetReim.getReimbursId() ,targetReim.getStatusId(), date);
		
		}catch (InvalidFormatException e){
			System.out.println("in catch");
			//send back the request
			resp.setContentType("aplication/json");
			String badInputJSON = mapper.writeValueAsString("bad input");
			resp.getWriter().write(badInputJSON);
			
		}
			
	}//update Reimburs status
	
	
}//class
