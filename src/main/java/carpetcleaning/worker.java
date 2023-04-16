package carpetcleaning;

import java.util.ArrayList;

public class worker extends person{
	private String phone;
	private String address;
	private String salary;
	String id;
	
	private  ArrayList<product> productsForWorker=new ArrayList<product>();
	public worker(person work1) {
		// TODO Auto-generated constructor stub
		this.id=work1.getId_person();
		
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
	
	
	public int getNumInTreatment () {
		int count=0;
		for(int j=0;j<this.getProductsForWorker().size();j++) {
			if(this.getProductsForWorker().get(j).getStatus().equalsIgnoreCase(" in treatment")||this.getProductsForWorker().get(j).getStatus().equalsIgnoreCase("waiting")) {
				count++;
			}
		
		}
		return count;
		
	
	}
		
	

	public static worker getWorkerForOrder(ArrayList<worker> workers) {
		worker min=workers.get(0);
		int count=min.getNumInTreatment();
		for(int i=0;i<workers.size();i++) {
				if(workers.get(i).getNumInTreatment()<count) {
					min=workers.get(i);
				}
			}

		return min;
	}
	public static int getIndexOfWorker(String id,ArrayList<worker> workers) {
		int index=-1;
		for(int i=0;i<workers.size();i++) {
			if(workers.get(i).id.equalsIgnoreCase(id)){ 	
				return i;
			}
		}
		
		return index; 
	}
	
	
	public static int getIndexOfProduct(String id,worker w,ArrayList<worker> workers) {
		int index=-1;
		int wIndex=worker.getIndexOfWorker(w.getId(), workers);
		worker ww=workers.get(wIndex);
		for(int i=0;i<ww.getProductsForWorker().size();i++) {
			if(ww.getProductsForWorker().get(i).getCode().equalsIgnoreCase(id)){ 	
				return i;
			}
		}
		
		return index; 
	}
	
	
	public static boolean IsProductExist(String id,worker w,ArrayList<worker> workers) {
		int i=getIndexOfProduct( id, w,workers);
		if(i==-1) return false;
		return true;
	}
	
	
	/*
	 * public static int getIndex_for_product(String Code,ArrayList<product>
	 * productsForCusomer) { int index=-1;
	 * 
	 * for(int i=0;i<productsForCusomer.size();i++) {
	 * 
	 * if(productsForCusomer.get(i).getCode().equalsIgnoreCase(Code)) {
	 * 
	 * return i; } }
	 * 
	 * return index; } public static boolean check_is_exist_1(String code, worker w)
	 * { if(getIndex_for_product(code,w.productsForWorker)==-1) {
	 * 
	 * return false; }
	 * 
	 * return true; }
	 * 
	 */
	
	public static void distributeOrder(product pro,ArrayList<worker> workers) {
		worker w=getWorkerForOrder(workers);
		pro.setResponsibleWorkerId(w.getId());
		int index=worker.getIndexOfWorker(w.getId(), workers);		
		workers.get(index).productsForWorker.add(pro);

	}
	
	public static void AddProductToWorker(product pro,worker w1,ArrayList<worker> workers) {
		
		int index=worker.getIndexOfWorker(w1.getId(), workers);
		workers.get(index).productsForWorker.add(pro);

	}
	
	public static void deleteProductToWorker(product pro,String wID1,ArrayList<worker> workers) {
		int wIndex=worker.getIndexOfWorker(wID1,workers);
		
		worker w=workers.get(wIndex);
		
		int pIndex=worker.getIndexOfProduct(pro.getCode(),w,workers);
		
		workers.get(wIndex).productsForWorker.remove(pIndex);
		
		
	}

	public static boolean IsProductExist1(String string, worker w1, ArrayList<worker> workers) {
		// TODO Auto-generated method stub
		return false;
	}




	
	
	
	

	
}
