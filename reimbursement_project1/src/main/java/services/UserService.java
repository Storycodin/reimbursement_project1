package services;

import java.util.regex.Pattern;

import Dao.UserRolesDao;
import Dao.UsersDao;
import model.User;

public class UserService {
	UsersDao myUser = new UsersDao();
	UserRolesDao myRole = new UserRolesDao(); // make sure the foreign key matches something.

///////////////////////methods 

	/**
	 * make sure the string will not be too long for a DB
	 
	 * @param check
	 * @param lenght
	 * @return
	 */
	private static boolean checkUserInput(String check, int lenght) {
		if (check.equals("")) {
			return false;
		} else if (check.length() >= lenght) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * makes sure they do not try to input 1 or a negative number.
	 * 
	 * @param check
	 * @return
	 */
	private static boolean checkUserInput(int check) {
		if (check <= 0) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * checks for makes sure the number input is on selectUserRole table boolean
	 * just used for over loading value does not matter
	 * 
	 * @param check
	 * @param checkUserRoles
	 * @return
	 */
	private boolean checkUserInput(int check, boolean checkUserRoles) {
		if (check <= 0) {
			return false;
		} else if (myRole.selectUserRole(check) != null) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * checks to see if the email is fomated correctly
	 * 
	 * @param email
	 * @param checkEmail
	 * @return
	 */
	private static boolean checkUserInput(String email, boolean checkEmail) {
		if (email == null)
			return false;

		String emailFormat = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
				+ "A-Z]{2,7}$";

		Pattern pat = Pattern.compile(emailFormat);

		return pat.matcher(email).matches();
	}

	////////////////////////// CREATE
	/**
	 * roleId should be chosen from a list not just input with a number, in the
	 * controllers
	 * 
	 * @param username
	 * @param password
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param roleId
	 * @return
	 */
	public boolean addUser(String username, String password, String firstName, String lastName, String email,
			int roleId) {
		if (!checkUserInput(username, 50)) {
			return false;
		} else if (!checkUserInput(password, 50)) {
			return false;
		} else if (!checkUserInput(firstName, 100)) {
			return false;
		} else if (!checkUserInput(lastName, 100)) {
			return false;
		} else if (!checkUserInput(email, true)) {
			return false;
		} else if (!checkUserInput(roleId, true)) {
			return false;
		}
		return myUser.insertUser(username, password, firstName, lastName, email, roleId);

	}

	/////////////////////////////// READ
	/**
	 * @param userId
	 * @return
	 */
	public User getUser(int userId) {
		if (!checkUserInput(userId)) {
			return null;
		}
		return myUser.selectUser(userId);
	}

	/**
	 * @param username
	 * @param password
	 * @return
	 */
	public User getUserLogin(String username, String password) {
		if (!checkUserInput(username, 50)) {
			return null;
		} else if (!checkUserInput(password, 50)) {
			return null;
		}
		return myUser.selectUserLogin(username, password);
	}

	////////////////////////////////// UPDATE
	/**
	 * @param userId
	 * @param username
	 * @param password
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param roleId
	 * @return
	 */
	public boolean changeUser(int userId, String username, String password, String firstName, String lastName,
			String email, int roleId) {
		if (!checkUserInput(userId)) {
			return false;
		} else if (!checkUserInput(username, 50)) {
			return false;
		} else if (!checkUserInput(password, 50)) {
			return false;
		} else if (!checkUserInput(firstName, 100)) {
			return false;
		} else if (!checkUserInput(lastName, 100)) {
			return false;
		} else if (!checkUserInput(email, true)) {
			return false;
		} else if (!checkUserInput(roleId, true)) {
			return false;
		}

		return myUser.updateUser(userId, username, password, firstName, lastName, email, roleId);
	}

	//////////////////////////////// DELETE
	/**
	 * @param userId
	 * @return
	 */
	public boolean removeUser(int userId) {
		if (!checkUserInput(userId)) {
			return false;
		}
		return myUser.deleteUser(userId);
	}

}

/*
 * CREATE TABLE Users ( users_ID SERIAL PRIMARY KEY, username varchar (50),
 * password varchar (50), first_name varchar (100), last_name varchar (100),
 * email varchar (100), role_ID int REFERENCES User_roles(role_ID) NOT null );
 */