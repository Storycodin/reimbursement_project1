package model;

import java.sql.Date;

import lombok.Data;
import services.RembursStatusServices;
import services.RembursTypeServices;
import services.UserService;

@Data
@SuppressWarnings("unused")
public class Reimburs {
	
	// MIGHT BE USED LATTER
	UserService myUser = new UserService();
	RembursStatusServices myStatus = new RembursStatusServices();
	RembursTypeServices myType = new RembursTypeServices();
	
	private int reimbursId;
	private int amount;
	private Date submitted; // timestamp
	private Date resulved; // timestamp 
	private String description;
	private boolean receipt;
	private int authorId; //REFERENCES Users(users_Id) NOT NULL,
	private int resolverId; // int REFERENCES Users(role_ID) NOT NULL, 
	private int statusId; // REFERENCES Remburs_status(status_ID) NOT NULL,
	private int typeId; // REFERENCES Remburs_type (type_ID) NOT NULL	   
	
	
	//Retried in services during generation.
	private String author;
	private String resolver;
	private String status;
	private String type;
	/**
	 * Automatically gets status and type from IDs
	 * 
	 * @param reimburs_ID
	 * @param amount
	 * @param submitted
	 * @param resulved
	 * @param description
	 * @param receipt
	 * @param authorId
	 * @param resolverId
	 * @param statusId
	 * @param typeId
	 */
	public Reimburs(int reimburs_ID, int amount, Date submitted, Date resulved, String description, boolean receipt,
			int authorId, int resolverId, int statusId, int typeId) {
		super();
		this.reimbursId = reimburs_ID;
		this.amount = amount;
		this.submitted = submitted;
		this.resulved = resulved;
		this.description = description;
		this.receipt = receipt;
		this.authorId = authorId;
		this.resolverId = resolverId;
		this.statusId = statusId;
		this.typeId = typeId;
			
//		this.author = myUser.getUser(authorId).getFirstName() + "  " +myUser.getUser(authorId).getLastName();
		this.status = myStatus.getStatus(statusId);
		this.type = myType.getType(typeId);
	}
	
	
	/**
	 * 
	 */
	public Reimburs() {
		super();
	}
	
	
	public Reimburs(int int1, int int2, String string, String string2, String string3, boolean boolean1, int int3,
			int int4, int int5, int int6) {
	}
	
	

//////////////////////////////////////////////getters and setters
	public int getReimbursId() {
		return reimbursId;
	}




	public void setReimbursId(int reimbursId) {
		this.reimbursId = reimbursId;
	}




	public int getAmount() {
		return amount;
	}




	public void setAmount(int amount) {
		this.amount = amount;
	}




	public Date getSubmitted() {
		return submitted;
	}




	public void setSubmitted(Date submitted) {
		this.submitted = submitted;
	}




	public Date getResulved() {
		return resulved;
	}




	public void setResulved(Date resulved) {
		this.resulved = resulved;
	}




	public String getDescription() {
		return description;
	}




	public void setDescription(String description) {
		this.description = description;
	}




	public boolean isReceipt() {
		return receipt;
	}




	public void setReceipt(boolean receipt) {
		this.receipt = receipt;
	}




	public int getAuthorId() {
		return authorId;
	}




	public void setAuthorId(int authorId) {
		this.authorId = authorId;
//		this.author = myUser.getUser(authorId).getFirstName() + "  " +myUser.getUser(authorId).getLastName();
	}




	public int getResolverId() {
		return resolverId;
	}




	/**
	 * updates resolver name when called, no otherway to do this.
	 * 
	 * @param resolverId
	 */
	public void setResolverId(int resolverId) {
		this.resolverId = resolverId;
		this.resolver = myUser.getUser(resolverId).getFirstName() + "  " +myUser.getUser(resolverId).getLastName();
	}




	public int getStatusId() {
		return statusId;
	}




	public void setStatusId(int statusId) {
		this.statusId = statusId;
//		this.status = myStatus.getStatus(statusId);
	}




	public int getTypeId() {
		return typeId;
	}




	public void setTypeId(int typeId) {
		this.typeId = typeId;
//		this.type = myType.getType(typeId);
	}




	public String getAuthor() {
		return author;
	}




	public void setAuthor(String author) {
		this.author = author;
	}




	public String getStatus() {
		return status;
	}




	public void setStatus(String status) {
		this.status = status;
	}




	public String getType() {
		return type;
	}




	public void setType(String type) {
		this.type = type;
	}




	@Override
	public String toString() {
		return "Reimburs [reimbursId=" + reimbursId + ", amount=" + amount + ", submitted=" + submitted + ", resulved="
				+ resulved + ", description=" + description + ", receipt=" + receipt + ", authorId=" + authorId
				+ ", resolver=" + resolver + ", statusId=" + statusId + ", typeId=" + typeId + ", author=" + author
				+ ", status=" + status + ", type=" + type + "]";
	}
	  
	

}
