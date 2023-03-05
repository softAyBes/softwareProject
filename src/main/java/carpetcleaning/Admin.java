package carpetcleaning;

public class Admin extends person{
	private String id;

	private boolean status;

	public Admin(person pers) {
		this.name=pers.name;
		this.password=pers.getPassword();
		this.type="admin";
		
	} 
	
	public Admin() {
		this.type="admin";
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
