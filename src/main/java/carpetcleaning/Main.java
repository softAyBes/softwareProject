package carpetcleaning;

import java.util.ArrayList;
public class Main {
	
	public static ArrayList<customer> customers= new ArrayList<customer>();
	public static person uesr;
	
 
	public static int setCutomers() {
		uesr=new person();
		customer c2=new customer();
		String id="3";
		if(!customer.isExist(id)) {
		c2.setName("Aya");
		c2.setAddress("Rafidya");
		c2.setId("3");
		c2.setPhone("0599");
		customer.createCustomer(c2); 
		}
		return 1;
	}
	public static void printArray(){
		for(int i=0;i<customers.size();i++) {
			System.out.println(customers.get(i).getId());
		}
	}
	
	
	
}
