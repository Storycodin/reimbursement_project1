package model;
//not done

public class UserRoles {

	
	private int id;
	private String role;
	
	/**
	 * @param id
	 * @param role
	 */
	public UserRoles(int id, String role) {
		super();
		this.id = id;
		this.role = role;
	}
	
	
	
	
	/**
	 * 
	 */
	public UserRoles() {
		super();
	}




	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
	
}
