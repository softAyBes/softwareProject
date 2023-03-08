package mypackage;

import java.util.ArrayList;

public class customer extends person{
	private String id;
	private String phone;
	private String address;
	private  ArrayList<product> productsForCusomer=new ArrayList<product>();
	
	public customer(){ 
		super();
		this.setType("customer"); 
	}
	public customer(person pers,String id,String phone,String address) {
		super();
		this.id=id;
		this.setName(pers.getName());
		this.setPassword(pers.getPassword());
		this.phone=phone;
		this.address=address;
		this.setType("customer"); 
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
	public static int getIndex(String id,ArrayList<customer>customers) {
		int index=-1;

		for(int i=0;i<customers.size();i++) {
			
			if(customers.get(i).id.equalsIgnoreCase(id)){ 	
				return i;
			}
		}
		
		return index; 
	}
	public static boolean isExist(String id2,ArrayList<customer>customers) {
		// TODO Auto-generated method stub
		// create common class contains all arrays list (customer, product ......)
		if(getIndex(id2,customers)==-1) {
			
			return false;
		}
		
		return true;
	}
	
	
	/////This part for product check
	
	public static int getIndex_for_product(String Code,ArrayList<product> productsForCusomer) {
		int index=-1;

		for(int i=0;i<productsForCusomer.size();i++)
		{
			
			if(productsForCusomer.get(i).getCode().equalsIgnoreCase(Code))
			{ 	
				
				return i;
			}
		}
		
		return index; 
	}
	public static boolean check_is_exist_1(String code, customer Customer) {
		if(getIndex_for_product(code,Customer.productsForCusomer)==-1)
		
		{
			
			
			return false;
		}
		
		return true;
	}
	
	public static void delete_product(String Code,customer Customer)
	{
		int index=getIndex_for_product(Code,Customer.productsForCusomer);
		Customer.productsForCusomer.remove(index);
	}

/////This part for product check
	
	public static void createCustomer(customer cust,ArrayList<customer>customers) {
		// TODO Auto-generated method stub
		customers.add(cust);	
	}
	

	public int getIndexforProduct (String code,ArrayList<customer>customers) {
			int index=-1;
		
		for(int i=0;i<customers.size();i++) {
			
			if(this.productsForCusomer.get(i).getCode().equals(code)) {
				
				return i;
			}
		}
		

		return index;
		}
	
	
	public static void deleteCustomer(String id2,ArrayList<customer>customers) {
		// TODO Auto-generated method stub
		int index=getIndex(id2,customers);
		customers.remove(index);
	}
	public static void updatePhone(String id2, String newPhone,ArrayList<customer>customers) {
		// TODO Auto-generated method stub
		int index=customer.getIndex(id2,customers);
		customers.get(index).setPhone(newPhone);
		
	}
	public static void updateAdress(String id2, String newAdress,ArrayList<customer>customers) {
		// TODO Auto-generated method stub
		int index=customer.getIndex(id2,customers);
		customers.get(index).setAddress(newAdress);
		
	}
	public void addProduct(product pro) {
		this.productsForCusomer.add(pro);
	}
	public static void updatepicture(String code, String N_picture, customer Customer) {
		
		int i=Customer.getIndex_for_product(code,Customer.getProductsForCusomer());
		Customer.productsForCusomer.get(i).setPicture(N_picture);
	}
		
}
/*
import java.util.ArrayList;

import mypackage.customer;
import mypackage.person;

public class customer extends person{
	private String id;
	private String name;
	private int phone;
	private String address;
	private  ArrayList<product> productsForCusomer=new ArrayList<product>();

	public customer(){
		super();
		this.type="client";
	}
	
	//private Main main=new Main();
	
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
	public boolean isExist(String id2) {
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
	public static void updatePhone(String id2, int newPhone) {
		// TODO Auto-generated method stub
		int index=customer.getIndex(id2);
		Main.customers.get(index).setPhone(newPhone);
		
	}
	public static void updateAdress(String id2, String newAdress) {
		// TODO Auto-generated method stub
		int index=customer.getIndex(id2);
		Main.customers.get(index).setAddress(newAdress);
		
	}
	
	
	
}*/