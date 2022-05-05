package services;

import Dao.RembursStatusDao;

public class RembursStatusServices {
	RembursStatusDao statusDao = new RembursStatusDao();

	/////////////////////// methods
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

	////////////////////////// CREATE
	/**
	 * @param status
	 * @return
	 */
	public boolean addStatus(String status) {
		if (!checkUserInput(status)) {
			return false;
		}
		return statusDao.insertStatus(status);

	}

	/////////////////////////////// READ
	/**
	 * @param statusId
	 * @return
	 */
	public String getStatus(int statusId) {
		if (!checkUserInput(statusId)) {
			return "No entry found";
		}
		return statusDao.selectStatus(statusId);
	}

	////////////////////////////////// UPDATE
	/**
	 * @param changeTo
	 * @param statusId
	 * @return
	 */
	public boolean changeStatus(String changeTo, int statusId) {
		if (!checkUserInput(changeTo)) {
			return false;
		} else if (checkUserInput(statusId)) {
			return false;
		}
		return statusDao.updateStatus(changeTo, statusId);
	}

	//////////////////////////////// DELETE
	/**
	 * does not test to make sure the status exists

	 * @param statusId
	 * @return
	 */
	public boolean removeStatus(int statusId) {
		if (checkUserInput(statusId)) {
			return false;
		}
		return statusDao.deleteStatus(statusId);
	}
}
/*
 * CREATE TABLE Remburs_status( status_ID SERIAL PRIMARY KEY, status varchar(10)
 * );
 */
