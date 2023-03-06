
package mypackage;


import java.util.ArrayList;

public class person {
	private String name;
	private String password;
	private String id_person;
	private String type;
	private int logged;  //1 log in  0 log out
	
	
	
	
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
	
	
	public static int getIndex(String name,ArrayList<person>persons) {
		int index=-1;

		for(int i=0;i<persons.size();i++) {
			
			if(persons.get(i).getName().equals(name)) { 
				
				return i;
			}
		}
		
		return index; 
	}
	public static boolean isExist(String id2,ArrayList<person>persons) {
		// TODO Auto-generated method stub
		// create common class contains all arrays list (customer, product ......)
		if(getIndex(id2,persons)==-1) {
			
			return false;
		}
		
		return true;
	}
	
	

}
/*
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
*/