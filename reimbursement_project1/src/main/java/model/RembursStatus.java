package model;

public class RembursStatus {
	private int id;
	private String status;
	/**
	 * @param id
	 * @param status
	 */
	public RembursStatus(int id, String status) {
		super();
		this.id = id;
		this.status = status;
	}
	/**
	 * 
	 */
	public RembursStatus() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	@Override
	public String toString() {
		return "RembursStatus [id=" + id + ", status=" + status + "]";
	}
	
	
}
