package carpetcleaning;

public class person {
	public String name;
	public String password;
	public String id_person;
	public String type;
	public int logged;  //1 log in  0 log out
	
	
	
	
	public person(String name,String pass,String id) {
		this.name=name;
		this.password=pass;	
		this.id_person=id;
	}
	public person() {
		this.logged=0;
	}
	
	
	
	public String getId_person() {
		return id_person;
	}
	public void setId_person(String id_person) {
		this.id_person = id_person;
	}
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
