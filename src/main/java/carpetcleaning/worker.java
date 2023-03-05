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
	public static String updateStatusCustomer(String code,String id,String newStatus,ArrayList<customer>customers) {
		customer cust=new customer();
		int CustomerIndex=customer.getIndex(id,customers);
	    cust=customers.get(CustomerIndex);
	    int productIndex=cust.getIndexforProduct(code,customers);
	    customers.get(CustomerIndex).getProductsForCusomer().get(productIndex).setStatus(newStatus);
	    return customers.get(CustomerIndex).getProductsForCusomer().get(productIndex).getStatus();
	}
	
	
	

	
}
