package services;

import Dao.RembursTypeDao;

public class RembursTypeServices {
	RembursTypeDao typeDao = new RembursTypeDao();
	
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
	 * @param type
	 * @return
	 */
	public boolean addType (String type) {
		if(!checkUserInput(type)) {
			return false;
		}
		return typeDao.insertType(type);
	}
	
	/////////////////////////////// READ
	/**
	 * @param typeId
	 * @return
	 */
	public String getType (int typeId) {
		if(!checkUserInput(typeId)) {
			return "not a valid input";
		}
		return typeDao.selectType(typeId);
	}
	
	//////////////////////////////////UPDATE
	/**
	 * @param changeTo
	 * @param typeId
	 * @return
	 */
	public boolean changeType (String changeTo, int typeId) {
		if(!checkUserInput(typeId)) {
			return false;
		}else if(!checkUserInput(changeTo)) {
			return false;
		}
		return typeDao.updateType(changeTo, typeId);
	}
	
	////////////////////////////////DELETE  
	/**
	 * @param typeId
	 * @return
	 */
	public boolean removeType (int typeId) {
		if(!checkUserInput(typeId)) {
			return false;
		}
		return typeDao.deleteType(typeId);
	}
	

}

/*CREATE TABLE Remburs_type(
type_ID SERIAL PRIMARY KEY,
reimburs_Type varchar(10)
);*/