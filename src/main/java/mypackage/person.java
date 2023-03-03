package mypackage;

public class person {
	public String name;
	public String password;
	public String type;
	public int logged;  //1 log in  0 log out
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getLogged() {
		return logged;
	}
	public void setLogged(int logged) {
		this.logged = logged;
	}
	
	

}