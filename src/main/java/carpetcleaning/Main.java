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
		person pers1=new person("aya","123456","3","customer");
		customer c2=new customer(pers1,"3", "059967", "Arsad");
		
		
		person adm1=new person("admin1","admin123","5","admin");
		Admin admin1=new Admin(adm1);
		
		person work1=new person("worker1","work123456","6","worker");
		worker worker1=new worker(work1);
		
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
			product pro1=new product("nn","100");
			pro1.setStatus("waiting");
			c2.addProduct(pro1, workers);
			customer.createCustomer(c2,customers); 

	
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
