package carpetcleaning;

import java.util.ArrayList;
import java.util.List;

public class Person {
	private String name;
	private String password;
	private String id_person;
	private String type;
	private int logged;  
	

	
	
	public Person(String name,String pass,String id) {
		this.name=name;
		this.password=pass;	
		this.id_person=id;
	}

	public Person() {
		this.logged=0;
	}
	
	
	
	public Person(String name2, String pass, String id, String type2) {
		
		this.name=name2;
		this.password=pass;	
		this.id_person=id;
		this.type=type2;
		// TODO Auto-generated constructor stub
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
	
	
	public static int getIndex(String name,List<Person> persons) {
		int index=-1;

		for(int i=0;i<persons.size();i++) {
			
			if(persons.get(i).getName().equals(name)) { 
				
				return i;
			}
		}
		
		
		return index; 
	}
	public static boolean isExist(String id2,ArrayList<Person>persons) {
		// TODO Auto-generated method stub
		// create common class contains all arrays list (customer, product ......)
		if(getIndex(id2,persons)==-1) {
			
			return false;
		}
		
		return true;
	}
	
	public static String getIdFromName(String name,List<Person> persons) {
		for(int i=0;i<persons.size();i++) {
			if(persons.get(i).getName().equals(name)) {
				return persons.get(i).getId_person();
			}
		}
		return "-1";
		
	}
	
	

}
