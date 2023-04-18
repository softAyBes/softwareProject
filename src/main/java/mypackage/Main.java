package mypackage;

import java.util.ArrayList;

public class Main {
	
	public static ArrayList<customer> customers= new ArrayList<customer>();
	public static ArrayList<person> persons= new ArrayList<person>();
	public static ArrayList<worker> workers= new ArrayList<worker>();
	public static person uesr;
	public static int autoId=4;
	
	

	public static int setCutomers() {
		uesr=new person();
		 
								//(String id,String name,String pass,String phone,String address)
		person pers1=new person("aya","123456","3","customer");
		customer c2=new customer(pers1,"3", "059967", "Arsad");
		
		person pers2=new person("SARA","112233","4","customer"); 
		customer c3=new customer(pers2,"4", "05677", "nablus");
		
		person pers3=new person("lolo","777","5","customer"); 
		customer c4=new customer(pers3,"5", "056232", "bita");
		
		person adm1=new person("admin1","admin123","5","admin");
		Admin admin1=new Admin(adm1);
		
		person work1=new person("worker1","work123456","6","worker");
		worker worker1=new worker(work1);
		
		person work2=new person("worker2","work123456","7","worker");
		worker worker2=new worker(work2);
		
		product pro3=new product("pro1","200","mr1",4,6);
		product pro4=new product("pro2","398","mr2",5,5);
		
	     
	    customers.add(c3);
	    c3.addProduct(pro3);
	    c3.addProduct(pro4);
	    //customers.add(c4);
	    // c4.addProduct(pro4);
	   //c3.addProduct(pro3);
	   //System.out.print(c2.getAddress());	    
	   //customers.add(c3);	
		persons.add(pers1);
		persons.add(adm1);
		persons.add(work1);
		persons.add(work2);
		
		String id="3";
		if(!customer.isExist_1(id,customers)) {
		
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

	


	public static boolean Show_all_customers_details(ArrayList<customer> custt) 
	{
		System.out.println("-------------Report about customers details-----------------");	
		System.out.println();
		System.out.println("ID \tName \tAddress \tpro_code \tpro_Name \tpro_Material \tpro_Length \tpro_Width ");
		if(!custt.isEmpty()) 
		{
			for(int i=0;i<custt.size();i++) 
			{
				System.out.print(custt.get(i).getId()+ "\t" +custt.get(i).getName()+"\t"+custt.get(i).getAddress()
);
				if(custt.get(i).getProductsForCusomer().size()==0)
				{
					System.out.println();
					//System.out.println("\n");
				}
				for(int j=0;j<custt.get(i).getProductsForCusomer().size();j++)
			{
					
			 System.out.println("\t"+"\t"+custt.get(i).getProductsForCusomer().get(j).getCode()+"\t"+"\t"+custt.get(i).getProductsForCusomer().get(j).getName_p()+
					 "\t"+"\t"+custt.get(i).getProductsForCusomer().get(j).getMaterial()+
					 "\t"+"\t"+custt.get(i).getProductsForCusomer().get(j).getLength()+
					 "\t"+"\t"+custt.get(i).getProductsForCusomer().get(j).getWidth());
				
		      }
			}
            return true ;
	}
		
		return false;
	}

	
	public static boolean generate_invoice(String id, ArrayList<customer> customers2) 
	
	{ int totel_price=0;
	//System.out.println(customers2.size());
		if(!customers2.isEmpty()) 
		{
		for(int i=0;i<customers2.size();i++)
		{
			for(int j=0;j<customers2.get(i).getProductsForCusomer().size();j++)
			{
			 if(customers2.get(i).getId()=="3")
			 {
				 System.out.println("---------------------------Invoice----------------------------------------");
				 System.out.println("------------------------Cleaning Services---------------------------------");
				 System.out.print("Customer ID :     " + customers.get(i).getId());
				 System.out.print("\n");
				 System.out.print("Customer Name :   " + customers.get(i).getName());
				 System.out.print("\n");
				 System.out.print("Customer Address :" + customers.get(i).getAddress());
				 System.out.print("\n");
				 System.out.print("Customer Phone :  " + customers.get(i).getPhone());
				 System.out.print("\n");
				 System.out.print("Product Name :    " + customers.get(i).getProductsForCusomer().get(j).getName_p());
				 System.out.print("\n");
				 System.out.print("Product code :    " + customers.get(i).getProductsForCusomer().get(j).getCode());
				 System.out.print("\n");
				 String k=customers2.get(i).getProductsForCusomer().get(j).getCode();
				 int price=customer.get_price(k,customers2.get(i));
				System.out.println("Price of product :" + price);
				 totel_price=totel_price+price;
				 //System.out.print("Totel Price :" +  totel_price);
				 
				 
			 }
		}
		}
		
		return true;
		}
		return false;	
	}

	}

