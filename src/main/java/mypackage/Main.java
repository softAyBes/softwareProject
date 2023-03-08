package mypackage;

import java.util.ArrayList;

public class Main {
	
	public static ArrayList<customer> customers= new ArrayList<customer>();
	public static ArrayList<person> persons= new ArrayList<person>();
	public static person uesr;
	public static int autoId=4;

	
	public static int setCutomers()
	{
		uesr=new person();
		person pers1=new person("Ayabaara","123456","3","customer");
		customer c2=new customer(pers1,"3", "059967", "Arsad");
		
		person pers2=new person("Beesan","555","4","customer");
		customer c3=new customer(pers2,"4","059744","Huwwara");
		
		person pers3=new person("Adam","999","5","customer");
		customer c4=new customer(pers3,"5","059787","Nablus");
		
		person pers_w=new person("Samer","654321","6","worker");
	    worker W1 = new worker(pers_w,"059787","Main-street","1000");
		
		
		person adm1=new person("admin1","admin123",Integer. toString(Main.autoId++),"admin");
		Admin admin1=new Admin(adm1);
		
		persons.add(pers1);
		persons.add(adm1);
		persons.add(pers2);
		persons.add(pers_w);
		persons.add(pers3);
		
		product pro1=new product();
		String id="3";
		if(!customer.isExist(id,customers))
		{
		
		pro1.setName_p("nn");
		pro1.setStatus("waiting");
		pro1.setCode("100");
		c2.getProductsForCusomer().add(pro1);
		customer.createCustomer(c2,customers); 
		
		}
	
	product pro2=new product();
	String id2= "4";
	if(!customer.isExist(id2,customers))
	{
	
	pro2.setName_p("A");
	pro2.setStatus("waiting");
	pro2.setCode("200");
	c3.getProductsForCusomer().add(pro2);
	customer.createCustomer(c3,customers); 
	
	}
	return 1;
}


	public static void printArray(){
		for(int i=0;i<customers.size();i++) {
			System.out.println(customers.get(i).getId());
		}
	}
	
	
	
}