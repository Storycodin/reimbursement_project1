package frontcontroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "FrontController", urlPatterns = { "/home/*" , "/login/*", "/reimbursement/*", "/Employee/*", "/financeManager/*"})
public class FrontController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 9041713507202130654L;

	/**
	 * checks to make sure they are logged in needs to be before any request.
	 * */
	
	private static void loginCheck(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//this might work, did not try https://intellipaat.com/community/34188/how-to-use-a-servlet-filter-in-java-to-change-an-incoming-servlet-request-url
//		HttpSession session = req.getSession(false);
////		String myPath;
//		System.out.println("Checking for session");
//		System.out.println("session " + session);
//		
////		req.getRequestURI().indexOf("/HelloFrontController/login/")==-1 &&  req.getSession(false)==null
//		if (session == null && req.getRequestURI().indexOf("reimbursement_project1/login/")==-1) {
//			System.out.println("No session found");
//			
//			// Redirect
//			req.getRequestDispatcher("/reimbursement_project1/login/login").forward(req, resp);
//
//			
//			
////			HttpServletRequest request = (HttpServletRequest) req;
////	        String requestURI = request.getRequestURI();
////
////            String toReplace = requestURI.substring(requestURI.indexOf("/Dir_My_App"), requestURI.lastIndexOf("/") + 1);
////            String newURI = requestURI.replace(toReplace, "?Contact_Id=");
//		}
	}

	
	
	
	////////////////////////////////// DO methods
	//all of them track what sort of request was reserved, and that they went back to the user
	//time stamps can be added for more accurate information they have been removed for speed, and ease of reading
	
	////////////////////////// CREATE
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("in the post");
		
		loginCheck(req, resp);		
		Dispatcher.routerMethod(req, resp);
		
		System.out.println("back to JS");
	}

	/////////////////////////////// READ
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("in the get");
		loginCheck(req, resp);
		Dispatcher.routerMethod(req, resp);
		System.out.println("back to JS");
	}

	//////////////////////////////////UPDATE
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("in the put");
		loginCheck(req, resp);		
		Dispatcher.routerMethod(req, resp);
		System.out.println("back to JS");
	}

	////////////////////////////////DELETE 
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("in the delete");
		loginCheck(req, resp);
		System.out.println("back to JS");
	}
	

}
