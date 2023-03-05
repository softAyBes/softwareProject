package carpetcleaning;

public class Admin extends person{
	private String id;

	private boolean status;

	public Admin(person pers) {
		this.setName(pers.getName());
		this.setPassword(pers.getPassword());
		this.setType("admin");
	}
		

	
	public Admin() {
		this.setType("admin");
	}
	


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
}
