package mypackage;

import java.util.ArrayList;

public class customer extends person{
	private String id;
	private String phone;
	private String address;
	private String email;
	private int money=0;
	private int debt=0;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public int getDebt() {
		return debt;
	}
	public void setDebt(int debt) {
		this.debt = debt;
	}

	private  ArrayList <product> productsForCusomer=new ArrayList<product>();
	
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

	public static void delete_product(String Code,customer Customer)
	{
		int index=getIndex_for_product(Code,Customer.productsForCusomer);
		Customer.productsForCusomer.remove(index);
	}
	public void setProductsForCusomer(ArrayList<product> productsForCusomer) {
		this.productsForCusomer = productsForCusomer;
	}
	public void addProduct(product pro) {
		this.productsForCusomer.add(pro);
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
	public static int getIndex_1(String id,ArrayList<customer>customers) {
		int index=-1;

		for(int i=0;i<customers.size();i++) {
			if(customers.get(i).id.equalsIgnoreCase(id)){ 	
				return i;
			}
		}
		
		return index; 
	}
	public static boolean isExist_1(String id2,ArrayList<customer>customers) 
	{
		if(getIndex_1(id2,customers) == -1) {
			
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
	
	public static void delete_product(String Code,customer Customer,ArrayList<worker>workers)
	{
		int index=getIndex_for_product(Code,Customer.productsForCusomer);
		int pid=customer.getIndex_for_product(Code, Customer.getProductsForCusomer());
		product pro =Customer.getProductsForCusomer().get (pid);
		
		int WID=worker.getIndexOfWorker(pro.getResponsibleWorkerId(),workers);
		System.out.println(WID);
		worker w=workers.get(WID);
		worker.deleteProductToWorker(pro, w.getId(), workers);
		Customer.productsForCusomer.remove(index);
		
		
	}

/////This part for product check
	
	public static void createCustomer(customer cust,ArrayList<customer>customers) {
		// TODO Auto-generated method stub
		customers.add(cust);	
	}
	

	
	public static void deleteCustomer(String id2,ArrayList<customer>customers) {
		// TODO Auto-generated method stub
		int index=getIndex_1(id2,customers);
		customers.remove(index);
	}
	public static void updatePhone(String id2, String newPhone,ArrayList<customer>customers) {
		// TODO Auto-generated method stub
		int index=customer.getIndex_1(id2,customers);
		customers.get(index).setPhone(newPhone);
		
	}
	public static void updateAdress(String id2, String newAdress,ArrayList<customer>customers) {
		// TODO Auto-generated method stub
		int index=customer.getIndex_1(id2,customers);
		customers.get(index).setAddress(newAdress);
		
	}
	public void addProduct(product pro,ArrayList<worker> workers) {
		pro.setCustId(this.id);
		this.productsForCusomer.add(pro);
		
		worker.distributeOrder(pro, workers);
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
	
	public static void updatepicture(String code, String N_picture, customer Customer) {
		
		int i=customer.getIndex_for_product(code,Customer.getProductsForCusomer());
		Customer.productsForCusomer.get(i).setPicture(N_picture);
	}
	
	
	public static void update_width(String code, String width, customer CCust) {
		int i=customer.getIndex_for_product(code,CCust.getProductsForCusomer());
		 CCust.productsForCusomer.get(i).setwidth(width);
	}
	public static void update_Length(String code, String length, customer CCust) {
		int i=customer.getIndex_for_product(code,CCust.getProductsForCusomer());
		 CCust.productsForCusomer.get(i).setLength(length);
	}
	
	public static int WaitingProduct(customer cust) {
		int num=0;
		for(int i=0;i<cust.getProductsForCusomer().size();i++) {
			if(cust.getProductsForCusomer().get(i).getStatus().equalsIgnoreCase("waiting")) {
				num++;
			}
		}
		return num;
	}
	
	
	public static int inTreatmentProduct(customer cust) {
		int num=0;
		for(int i=0;i<cust.getProductsForCusomer().size();i++) {
			if(cust.getProductsForCusomer().get(i).getStatus().equalsIgnoreCase("in treatment")) {
				num++;
			}
		}
		return num;
	}
	
	
	
	///for price
	public static int get_price(String code,customer CCust) 
	{
	   
		int i=customer.getIndex_for_product(code,CCust.getProductsForCusomer());
		int w=CCust.productsForCusomer.get(i).getWidth();
		int l=CCust.productsForCusomer.get(i).getLength();
		
		//System.out.print(w);
        //System.out.print(l);
	    //String d=CCust.productsForCusomer.get(i).getCode();
        
	    return l*w*25;
		
	}	

	public static boolean check_price(int p) {
		return p>=550;
	}
	
	public static int discount(String code,String dis,customer CCust)
	{
			
		//int indexxx=customer.getIndex(code,CCust.getProductsForCusomer());
		int p=customer.get_price(code, CCust);
		if(p<550)
		{
			return p;
		}
		else	
		{
		int disc=(p*Integer.parseInt(dis))/100;
		int Discounted_price=p-disc;
		return Discounted_price;
		}
	}
}
/*
package mypackage;

import java.util.ArrayList;

public class customer extends person{
	private String id;
	private String phone;
	private String address;
	private  ArrayList<product> productsForCusomer=new ArrayList<product>();
	
	public customer()
	{ 
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
		
		int i=customer.getIndex_for_product(code,Customer.getProductsForCusomer());
		Customer.productsForCusomer.get(i).setPicture(N_picture);
	}
	public static void update_width(String code, String width, customer CCust) {
		int i=customer.getIndex_for_product(code,CCust.getProductsForCusomer());
		 CCust.productsForCusomer.get(i).setwidth(width);
	}
	public static void update_Length(String code, String length, customer CCust) {
		int i=customer.getIndex_for_product(code,CCust.getProductsForCusomer());
		 CCust.productsForCusomer.get(i).setLength(length);
	}
	public static int get_price(String code,customer CCust) 
	{
	   
		int i=customer.getIndex_for_product(code,CCust.getProductsForCusomer());
		int w=CCust.productsForCusomer.get(i).getWidth();
		
		int l=CCust.productsForCusomer.get(i).getLength();
	    //String d=CCust.productsForCusomer.get(i).getCode();
	    
		return l*w*25;
	}	

	public static boolean check_price(double p) {
		return p>=550;
	}
	
	public static double discount(String code,String dis,customer CCust)
	{
			
		//int indexxx=customer.getIndex(code,CCust.getProductsForCusomer());
		double p=customer.get_price(code, CCust);
		if(p<550)
		{
			return p;
		}
		else	
		{
		double disc=(p*Integer.parseInt(dis))/100;
		double Discounted_price=p-disc;
		return Discounted_price;
		}
	}


}
*/