package frontcontroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controllers.LoginController;
import controllers.ReimburController;
import model.User;


public class Dispatcher {

	/**
	 * master dispatcher handles all requests
	 * 
	 * @param req
	 * @param resp
	 * @throws IOException
	 * @throws ServletException
	 */
	public static void routerMethod(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		// needed to get info from current user for input
		User thisUser = (User) req.getSession().getAttribute("user");
		
		// for dev to see where each request is going.
		System.out.println(req.getRequestURI() + "~~~~~~~~~~~~~~~~~");
		
		switch(req.getRequestURI()) {
		//login 
		case "/reimbursement_project1/login/login":
			LoginController.login(req, resp);
			break;
			
		case "/reimbursement_project1/login/logout":
			LoginController.logout(req, resp);
			
		case "/reimbursement_project1/login/incorrectcredentials":
			System.out.println("Incorrect log in");// send them to http://localhost:8080/reimbursement_project1/incorrectcredentials
			break;
			
		//Employee cases
		case "/reimbursement_project1/Employee/my-reimburs":
			ReimburController.allMyReim(thisUser.getId() ,req, resp);
			break;
		case "/reimbursement_project1/Employee/create-reimburs":
			ReimburController.creatReimburs(req, resp);
			break;

			
			
		//financeManager cases
		case "/reimbursement_project1/financeManager/all-reimburs":

			ReimburController.allReim(thisUser.getId() ,req, resp);
			break;
		case "/reimbursement_project1/financeManager/update-reimburs-status":
			System.out.println("in case update status");
			ReimburController.changeReimbursStatus(req, resp);
			break;	
			
			
			
			// ideas for latter 
//		case "/reimbursement_project1/home/create-user":
//			System.out.println("in case create");
//			FinanceManagerController.userMaker(req, resp);
//			break;
//			
//		case "reimbursement_project1/home/read-user":
//			System.out.println("in case read");
//			FinanceManagerController.userFetcher(req, resp);
//			break;
//		case "reimbursement_project1/home/all-reimburs":
////			System.out.println("in case read");
////			EmployeeController.userFetcher(req, resp);
//			break;
//		case "reimbursement_project1/home/all-pending-reimburs":
////			System.out.println("in case read");
////			EmployeeController.userFetcher(req, resp);
//			break;		
//		case "reimbursement_project1/home/all-denied-reimburs":
////			System.out.println("in case read");
////			EmployeeController.userFetcher(req, resp);
//			break;				
//		case "reimbursement_project1/home/all-approved-reimburs":
////			System.out.println("in case read");
////			EmployeeController.userFetcher(req, resp);
//			break;	
			
			
		default:
			System.out.println("bad url: " + req.getRequestURI());
		}
	}
}
