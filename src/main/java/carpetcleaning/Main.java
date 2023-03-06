package carpetcleaning;

import java.util.ArrayList;
public class Main {
	
	public static ArrayList<customer> customers= new ArrayList<customer>();
	public static ArrayList<person> persons= new ArrayList<person>();
	public static person uesr;
	public static int autoId=4;
	

	
 
	public static int setCutomers() {
		uesr=new person();
								//(String id,String name,String pass,String phone,String address)
		person pers1=new person("Ayabaara","123456","3","customer");
		customer c2=new customer(pers1,"3", "059967", "Arsad");
		
		
		person adm1=new person("admin1","admin123",Integer. toString(Main.autoId++),"admin");
		Admin admin1=new Admin(adm1);
		
		persons.add(pers1);
		persons.add(adm1);
		
		
		product pro1=new product();
		String id="3";
		if(!customer.isExist(id,customers)) {
		
		pro1.setName_p("nn");
		pro1.setStatus("waiting");
		pro1.setCode("100");
		c2.getProductsForCusomer().add(pro1);
		
		customer.createCustomer(c2,customers); 
		}
		return 1;
	}
	public static void printArray(){
		for(int i=0;i<customers.size();i++) {
			System.out.println(customers.get(i).getId());
		}
	}
	
	
	
}
