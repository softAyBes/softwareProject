package carpetcleaning;

import java.util.ArrayList;

public class customer extends person{
	private String id;
	private String phone;
	private String address;
	private  ArrayList<product> productsForCusomer=new ArrayList<product>();
////
	
	public customer(){
		super();
		this.type="customer";
	}
	public customer(person pers,String id,String phone,String address) {
		super();
		this.id=id;
		this.name=pers.name;
		this.password=pers.password;
		this.phone=phone;
		this.address=address;
		this.type="customer";	
	}
	
	
	public ArrayList<product> getProductsForCusomer() {
		return productsForCusomer;
	}


	public void setProductsForCusomer(ArrayList<product> productsForCusomer) {
		this.productsForCusomer = productsForCusomer;
	}


	public String getId() {
		return id;
	}
	public void setId(String id2) { 
		this.id = id2;
	}
	
	
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
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
	public static boolean isExist(String id2) {
		// TODO Auto-generated method stub
		// create common class contains all arrays list (customer, product ......)
		if(getIndex(id2)==-1) {
			
			return false;
		}
		
		return true;
	}
	
	
	
	
	public static void createCustomer(customer cust) {
		// TODO Auto-generated method stub
		Main.customers.add(cust);	
	}
	

	
	public static void deleteCustomer(String id2) {
		// TODO Auto-generated method stub
		int index=getIndex(id2);
		Main.customers.remove(index);
	}
	public static void updatePhone(String id2, String newPhone) {
		// TODO Auto-generated method stub
		int index=customer.getIndex(id2);
		Main.customers.get(index).setPhone(newPhone);
		
	}
	public static void updateAdress(String id2, String newAdress) {
		// TODO Auto-generated method stub
		int index=customer.getIndex(id2);
		Main.customers.get(index).setAddress(newAdress);
		
	}
	public void addProduct(product pro) {
		this.productsForCusomer.add(pro);
	}
	
	public  int getIndexforProduct (String code) {
			int index=-1;
		
		for(int i=0;i<Main.customers.size();i++) {
			
			if(this.productsForCusomer.get(i).getcode().equals(code)) {
				
				return i;
			}
		}
		

		return index;
}
}
