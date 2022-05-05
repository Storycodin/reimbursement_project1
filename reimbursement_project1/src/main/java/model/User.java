package model;

import lombok.Data;

@Data
@SuppressWarnings("unused")
public class User {
	private int id;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private int roleId;// int REFERENCES  User_roles(role_ID)
	
	//Retried in services during generation.
	private String role;// int REFERENCES  User_roles(role_ID)
	
	public User() {
		
	}
	
	
	/**
	 * used to creat a new user, no id because the the database will get make that for us
	 * @param username
	 * @param password
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param roleId
	 */
	
	public User(String username, String password, String firstName, String lastName, String email, int roleId) {
		super();
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.roleId = roleId;
	}
	
	
	

	/**
	 * used to read from the DB, or create an user
	 * @param id
	 * @param username
	 * @param password
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param roleId
	 */
	public User(int id, String username, String password, String firstName, String lastName, String email, int roleId) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.roleId = roleId;
	}




	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", email=" + email + ", roleId=" + roleId + ", role=" + role + "]";
	}
	
	
	
	
}
/*CREATE TABLE Users (
users_ID SERIAL PRIMARY KEY,
username varchar (50),
password varchar (50),
first_name varchar (100),
last_name varchar (100),
email varchar (100),
role_ID int REFERENCES  User_roles(role_ID) NOT null
);*/	