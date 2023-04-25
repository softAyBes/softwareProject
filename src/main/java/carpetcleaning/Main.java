package carpetcleaning;

import java.util.ArrayList;
public class Main {
	
	public static ArrayList<customer> customers= new ArrayList<customer>();
	public static ArrayList<person> persons= new ArrayList<person>();
	public static ArrayList<worker> workers= new ArrayList<worker>();
	public static person uesr;

 
	public static int setCutomers() {
		uesr=new person();
								//(String id,String name,String pass,String phone,String address)
		
		////customer1
		person pers1=new person("aya","123456","3","customer");
		customer c2=new customer(pers1,"3", "059967", "Arsad");
		c2.setEmail("ayabaara4@gmail.com");
		
		///// customer2
		person pers11=new person("beesan","123456","8","customer");
		customer c22=new customer(pers11,"8", "58585", "Rafidya");
		c22.setEmail("ayabaara4@gmail.com");
		
		// admin
		person adm1=new person("admin1","admin123","5","admin");
		Admin admin1=new Admin(adm1);
		
		///worker1
		person work1=new person("worker1","work123456","6","worker");
		worker worker1=new worker(work1);
		///worker2
		person work2=new person("worker2","work123456","7","worker");
		worker worker2=new worker(work2);
		
	
		persons.add(pers1);
		persons.add(adm1);
		persons.add(work1);
		persons.add(work2);
		
		String id="3";
		if(!customer.isExist1(id,customers)) {
		
			workers.add(worker2);
			workers.add(worker1);
			
			/// 3 products for cust1
			product pro1=new product("carpet12","100");
			pro1.setCategory("Carpets");
			c2.addProduct(pro1, workers);
			
			product pro2=new product("Salon carpet","110");
			pro2.setCategory("Carpets");
			c2.addProduct(pro2, workers);
			
			product pro3=new product("cover","120");
			pro3.setCategory("Bed Cover");
			c2.addProduct(pro3, workers);
			
			product pro4=new product("carpet","150");
			pro4.setCategory("Carpets");
			c22.addProduct(pro4, workers);
			
			product pro5=new product("Salon carpet","170");
			pro5.setCategory("Carpets");
			c22.addProduct(pro5, workers);
			
			customer.createCustomer(c2,customers); 
			customer.createCustomer(c22,customers);
			

	
		}
		return 1;
	}
	public static void printArray(){
		for(int i=0;i<customers.size();i++) {
			System.out.println(customers.get(i).getId());
		}
	}
	
	
	public static int itemsNum(ArrayList<customer> cust) {
		int num=0;
		for(int i=0;i<cust.size();i++) {
			num+=cust.get(i).getProductsForCusomer().size();
		}
		return num;
	}
	

	
	public static int totalWaitingNum(ArrayList<customer> cust) {
		int num=0;
		for(int i=0;i<cust.size();i++) {
			num+=	customer.WaitingProduct(cust.get(i));
		
		}
		return num;
	}
	
	public static int totalIntreatment(ArrayList<customer> cust) {
		int num=0;
		for(int i=0;i<cust.size();i++) {
			num+=	customer.inTreatmentProduct(cust.get(i));
		
		}
		return num;
	}
	
	public static int totalDebts(ArrayList<customer> cust) {
		int num=0;
		for(int i=0;i<cust.size();i++) {
			num+=	cust.get(i).getDebt();
		
		}
		return num;
	}
	public static int totalMoney(ArrayList<customer> cust) {
		int num=0;
		for(int i=0;i<cust.size();i++) {
			num+=	cust.get(i).getMoney();
		
		}
		return num;
	}

	
	
	
}
