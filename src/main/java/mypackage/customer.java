package mypackage;

import mypackage.Main;

public class customer {
	
	private String id;
	private String name;
	private int phone;
	private String address;
	//oooooooooooooooo
	//lklklklkl
	//jjhjuiohouijkhoipuhjb
	//tnvktnktmghffffffff
	int x;
	//jjjj
	private Main main=new Main();
	public String getId() {
		return id;
	}
	public void setId(String id2) {
		this.id = id2;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public static int getIndex(String id) {
		int index=-1;
		for(int i=0;i<Main.customers.size();i++) {
			if(Main.customers.get(i).id.equalsIgnoreCase(id)) {
				return i;
			}
		}
		return index;
		
	}
	public boolean checkDublicate(String id2) {
		// TODO Auto-generated method stub
		// create common class contains all arrays list (customer, product ......)
		if(getIndex(id2)==-1) return false;
		return true;
		
	}
	
	
	public static void createCustomer(customer cust) {
		// TODO Auto-generated method stub
		Main.customers.add(cust);
		
	}
	
	public void update(String newValue) 
	{
	
		
		
	}
	
	public static void deleteCustomer(String id2) {
		// TODO Auto-generated method stub
		int index=getIndex(id2);
		Main.customers.remove(index);
	}
	
	
	
	
	

}
