package services;

import Dao.UserRolesDao;

public class UserRolesServices {
	UserRolesDao UserRoleDao = new UserRolesDao();
	
///////////////////////methods 
	/**
	 * makes sure string is not too long and is not empty 
	 * 
	 * @param check
	 * @return
	 */
	private static boolean checkUserInput(String check) {
		if (check.equals("")) {
			return false;
		} else if (check.length() >= 30) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * checks that an int is valued 
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
	
	//////////////////////////CREATE 
	/**
	 * @param role
	 * @return
	 */
	public boolean addUserRole (String role) {
		if(!checkUserInput (role)) {
			return false;
		}
		return UserRoleDao.insertUserRole(role);
	}
	
	/////////////////////////////// READ
	/**
	 * @param roleId
	 * @return
	 */
	public String getUserRole (int roleId) {
		if(!checkUserInput(roleId)) {
			return "not a valid input";
		}
		return UserRoleDao.selectUserRole(roleId);
	}
	
	//////////////////////////////////UPDATE
	/**
	 * @param changeTo
	 * @param UserRoleId
	 * @return
	 */
	public boolean changeUserRole (String changeTo, int UserRoleId) {
		if(!checkUserInput(UserRoleId)) {
			return false;
		}else if(!checkUserInput(changeTo)) {
			return false;
		}
		return UserRoleDao.updateUserRole(changeTo, UserRoleId);
	}
	
	////////////////////////////////DELETE  
	/**
	 * @param UserRoleId
	 * @return
	 */
	public boolean removeUserRole (int UserRoleId) {
		if(!checkUserInput(UserRoleId)) {
			return false;
		}
		return UserRoleDao.deleteUserRoles(UserRoleId);
	}
	

}
/*CREATE TABLE User_roles(
role_ID SERIAL PRIMARY KEY,
user_role varchar(10)
);*/