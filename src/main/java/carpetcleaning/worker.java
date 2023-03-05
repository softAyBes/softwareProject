package carpetcleaning;

import java.util.ArrayList;

public class worker extends person{
	private String phone;
	private String address;
	private String salary;
	private  ArrayList<product> productsForWorker=new ArrayList<product>();
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
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public ArrayList<product> getProductsForWorker() {
		return productsForWorker;
	}
	public void setProductsForWorker(ArrayList<product> productsForWorker) {
		this.productsForWorker = productsForWorker;
	}
	public static String updateStatusCustomer(String code,String id,String newStatus) {
		customer cust=new customer();
		int CustomerIndex=customer.getIndex(id);
	    cust=Main.customers.get(CustomerIndex);
	    int productIndex=cust.getIndexforProduct(code);
	    Main.customers.get(CustomerIndex).getProductsForCusomer().get(productIndex).setStatus(newStatus);
	    return Main.customers.get(CustomerIndex).getProductsForCusomer().get(productIndex).getStatus();
	}
	
	
	

	
}
