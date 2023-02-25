package carpetcleaning;

public class Admin {
	private String name;
	private String pass;
	private boolean status;
	
	public Admin() {
		this.status=false;
		this.pass="IamAdmin";
		this.name="admin";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
}
