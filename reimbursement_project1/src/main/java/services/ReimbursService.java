package services;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

import Dao.ReimbursDao;
import Dao.RembursStatusDao;
import Dao.RembursTypeDao;
import model.Reimburs;

public class ReimbursService {
	ReimbursDao myReimburs = new ReimbursDao();

	RembursTypeDao myType = new RembursTypeDao();
	RembursStatusDao myStatus = new RembursStatusDao();


///////////////////////methods 
	/**
	 * makes sure string is not too long and is not empty 
	 * 
	 * @param check
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

	/**
	 * makes sure status (true) OR type (false) exists on table
	 * mostly double checking, earlier logic should filter this out.
	 * 
	 * @param check
	 * @param status
	 * @return
	 */
	private boolean checkUserInput(int check, boolean status) {

		if (status) {
			if (check <= 0) {
				return false;
			} else if (myStatus.selectStatus(check).equals(null)) {
				return false;
			} else {
				return true;
			}

		} else {

			if (check <= 0) {
				return false;
			} else if (myType.selectType(check).equals(null)) {
				return false;
			} else {
				return true;
			}
		}
	}

	/** 
	 * checks date configuration matches SQL
	 * mostly double checking, earlier logic should filter this out.
	 * 
	 * @param check
	 * @param checkDate
	 * @return
	 */
	private boolean checkUserInput(String check, boolean checkDate) {

		String input = check;

		DateTimeFormatter f = DateTimeFormatter.ofPattern("MM/dd/uuuu");
		try {
			LocalDate ld = LocalDate.parse(input, f);
			System.out.println("ld: " + ld);
			return true;
		} catch (DateTimeParseException e) {
			System.out.println("ERROR incorrect date: " + e);
			return false;
		}
	}

	/**
	 * @param check
	 * @return
	 */
	private boolean checkUserInput(Date check) {
		if (check == null) {
			return false;
		} else {
			return true;
		}
	}

	////////////////////////// CREATE
	/**
	 * @param amount
	 * @param submitted
	 * @param resolved
	 * @param description
	 * @param receipt
	 * @param authorId
	 * @param statusId
	 * @param typeId
	 * @return
	 */
	public boolean addReimburs(int amount, Date submitted, Date resolved, String description, boolean receipt,
			int authorId, int statusId, int typeId) {
//		System.out.println("in services add reim");
		if (!checkUserInput(amount)) {
			return false;
		} else if (!checkUserInput(submitted)) {// check
			return false;
		} else/*
				 * if(!checkUserInput (resolved, true)) {//check return false; }else
				 */ if (!checkUserInput(description, 250)) {
			return false;
		} else
		/*
		 * noting for receipt, it is a bool no need to check. authorId always input by
		 * system statusId allays 1 until relieved hard coded
		 */
		if (!checkUserInput(typeId, false)) {
			return false;
		}

//		Date submitDate = Date.valueOf(submitted);
//		Date resulvDate = Date.valueOf(resolved);

		return myReimburs.insertReimburs(amount, submitted, resolved, description, receipt, authorId, statusId, typeId);
	}

	/////////////////////////////// READ

	/**
	 * @param reimbursId
	 * @return
	 */
	public Reimburs getReimburs(int reimbursId) {
		return myReimburs.selectReimburs(reimbursId);
	}

	public List<Reimburs> getAllReimburs() {
		return myReimburs.selectAllReimburs();
	}

	////////////////////////////////// UPDATE
	// fix if statmentdfor new data type
	/**
	 * @param reimbursId
	 * @param amount
	 * @param submitted
	 * @param resolved
	 * @param description
	 * @param receipt
	 * @param authorId
	 * @param resolverId
	 * @param statusId
	 * @param typeId
	 * @return
	 */
	public boolean changeReimburs(int reimbursId, int amount, String submitted, String resolved, String description,
			boolean receipt, int authorId, int resolverId, int statusId, int typeId) {
		if (!checkUserInput(amount)) {
			return false;
		} else if (!checkUserInput(submitted, true)) {// check
			return false;
		} else if (!checkUserInput(resolved, true)) {// check
			return false;
		} else if (!checkUserInput(description, 250)) {
			return false;
		} else /* noting for receip, it is a bool no need to check. */
		if (!checkUserInput(authorId, true)) {
			return false;
		} else if (!checkUserInput(resolverId, true)) {
			return false;
		} else if (!checkUserInput(statusId, true)) {
			return false;
		} else if (!checkUserInput(typeId, false)) {
			return false;
		}

		Date submitDate = Date.valueOf(submitted);
		Date resulvDate = Date.valueOf(resolved);

		return myReimburs.updateReimburs(reimbursId, amount, submitDate, resulvDate, description, receipt, authorId,
				resolverId, statusId, typeId);
	}

	public boolean changeReimbursStatus(int reimbursId, int statusId, Date resulvDate) {
		if (!checkUserInput(statusId, true)) {
			return false;
		}
		return myReimburs.updateReimbursStatus(reimbursId, statusId, resulvDate);
	}

	//////////////////////////////// DELETE
	/**
	 * @param reimbursId
	 * @return
	 */
	public boolean removeReimburs(int reimbursId) {
		return myReimburs.deleteReimburs(reimbursId);
	}

}
/*
 * CREATE TABLE Reimburs ( reimburs_ID SERIAL PRIMARY KEY, amount int NOT NULL,
 * submitted timestamp NOT NULL, resolved timestamp, description varchar(250),
 * receipt boolean, author int REFERENCES Users(users_Id) NOT NULL, --resolver
 * int REFERENCES Users(role_ID) NOT NULL,--resolver status_ID int REFERENCES
 * Remburs_status(status_ID) NOT NULL, type_ID int REFERENCES Remburs_type
 * (type_ID) NOT NULL );
 */
