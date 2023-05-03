package carpetcleaning;

import java.util.ArrayList;

public class Main {
	
	public static final ArrayList<customer> customers= new ArrayList<customer>();
	public static  final ArrayList<person> persons= new ArrayList<person>();
	public static final ArrayList<worker> workers= new ArrayList<worker>();
	public static  person uesr;
	public static int autoId=4;
	
	

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
worker worker1=new worker(work1,"6","05987","2000","nablus");
///worker2
person work2=new person("worker2","work123456","7","worker");

worker worker2=new worker(work2,"7","05987","3500","hebron");


persons.add(pers1);
persons.add(adm1);
persons.add(work1);
persons.add(work2);

String id="3";
if(!customer.isExist_1(id,customers)) {

workers.add(worker2);
workers.add(worker1);

/// 3 products for cust1
product pro1=new product("carpet12","100");
pro1.setCategory("Carpets");
pro1.setLength("5");
pro1.setwidth("5");
pro1.setMaterial("silk");
pro1.setIsspecial("yes");
pro1.setStatus("wating");

c2.addProduct(pro1, workers);

product pro2=new product("Salon carpet","110");
pro2.setCategory("Carpets");
pro2.setLength("6");
pro2.setwidth("4");
pro2.setMaterial("wool");
pro2.setIsspecial("NO");
c2.addProduct(pro2,workers);

product pro3=new product("cover","120");
pro3.setCategory("Bed Cover");
pro3.setLength("3");
pro3.setwidth("4");
pro3.setMaterial("Soft fleece");
pro3.setIsspecial("NO");
c2.addProduct(pro3, workers);

product pro4=new product("carpet","150");
pro4.setCategory("Carpets");
pro4.setLength("6");
pro4.setwidth("5");
pro4.setMaterial("fleece");
pro4.setIsspecial("yes");
c22.addProduct(pro4, workers);

product pro5=new product("Salon carpet","170");
pro5.setCategory("Carpets");
pro5.setLength("3");
pro5.setwidth("2");
pro5.setMaterial("leather");
pro5.setIsspecial("NO");

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

	


	public static void Show_all_customers_details(ArrayList<customer> custt) 
	{
		System.out.println("-------------Report about customers details-----------------");	
		System.out.println();
		System.out.println("ID \tName \tAddress \t \tpro_code \tpro_Name \tpro_Material \tpro_Category  \tpro_Length \tpro_Width \tIsspecial ");
		if(!custt.isEmpty()) 
		{
			for(int i=0;i<custt.size();i++) 
			{
				System.out.print(custt.get(i).getId()+ "\t" +custt.get(i).getName()+ "\t" +custt.get(i).getAddress()
);
				if(custt.get(i).getProductsForCusomer().size()==0)
				{
					System.out.println();
					System.out.println("\t");
				}
				for(int j=0;j<custt.get(i).getProductsForCusomer().size();j++)
			{
					// System.out.println("\t");
			 System.out.println( "\t" +"\t" +"\t" +custt.get(i).getProductsForCusomer().get(j).getCode()+ "\t" +"\t"+
					custt.get(i).getProductsForCusomer().get(j).getName_p()+ "\t" +"\t"+custt.get(i).getProductsForCusomer().get(j).getMaterial()+"\t"+ "\t" +custt.get(i).getProductsForCusomer().get(j).getCategory()+
					"\t"+"\t"+custt.get(i).getProductsForCusomer().get(j).getLength()+
					"\t"+"\t"+custt.get(i).getProductsForCusomer().get(j).getWidth()+
					"\t"+"\t"+custt.get(i).getProductsForCusomer().get(j).getIsspecial());
				
		      }
	    System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");	
			}
		}
	}

	
	public static void generate_invoice(String Id,int paying,ArrayList<customer> customers2) 
	
	{ 
		int totel_price=0;
	
	 System.out.println("---------------------------Invoice----------------------------------------");
	 System.out.println("------------------------Cleaning Services---------------------------------");
	 int index=0;
		if(!customers2.isEmpty()) 
		{
		for(int i=0;i<customers2.size();i++)
		{
			if(customers2.get(i).getId().equalsIgnoreCase(Id))
			{
			 System.out.print("Customer ID :     " + customers.get(i).getId());
			 System.out.print("\n");
			 System.out.print("Customer Name :   " + customers.get(i).getName());
			 System.out.print("\n");
			 System.out.print("Customer Address :" + customers.get(i).getAddress());
			 System.out.print("\n");
			 System.out.print("Customer Phone :  " + customers.get(i).getPhone());
			 System.out.print("\n");
			 index=i;
			
			for(int j=0;j<customers2.get(i).getProductsForCusomer().size();j++)
			{
				
				
				 System.out.print("\n");
				 System.out.print("Product Name :    " + customers.get(i).getProductsForCusomer().get(j).getName_p());
				 System.out.print("\n");
				 System.out.print("Product code :    " + customers.get(i).getProductsForCusomer().get(j).getCode());
				 System.out.print("\n");
				 String k=customers2.get(i).getProductsForCusomer().get(j).getCode();
				 int price=customer.get_price(k,customers2.get(i));
				 System.out.println("Price of product :" + price);
				 System.out.print("\n");
				 totel_price=totel_price+price;
				 System.out.print("\n");
				 
			 }
			
			if(totel_price>=paying)
			 {
				
				int T=0;
				int money=0;
				//int d=0;
				//T=totel_price-paying;
				//d=money_after_dis-paying;
				//int money_after_dis=customer.discount(money,15,customers2.get(index));
				//System.out.print( money_after_dis );
			System.out.print("Totel Cash :" + paying);
			System.out.print("\n");
			
			System.out.print("Totel Price :" + totel_price);
			System.out.print("\n");
			 money=customer.get_total_price(customers2.get(index));
				int money_after_dis=customer.discount(money,15,customers2.get(index));
				System.out.print("Totel Price after discount :" +  money_after_dis);
				
				System.out.print("\n");
				T=money_after_dis-paying;
			System.out.print("Total debts  :" + T);
			System.out.print("\n");
			
			
			Main.customers.get(index).setDebt(T);
			Main.customers.get(index).setMoney(paying);
		
			 }
			
		}
		}
		}
	
	}
	public static void Show_all_worker_details(ArrayList <worker> W) 
	{
	
		System.out.println("-------------Report about worker details-----------------");	
		System.out.println();
		System.out.println("ID \t \tName \t \tAddress   \tSalary  \tPhone  ");
		if(!W.isEmpty()) 
		{
			for(int i=0;i<W.size();i++)
			{
				System.out.print(W.get(i).getId()+"\t"+"\t"+W.get(i).getName()+"\t"+"\t"+W.get(i).getAddress()+"\t"+"\t"+W.get(i).getSalary()+"\t"+"\t"+W.get(i).getPhone())	;
				System.out.println();
			}
		   }
			
	   }
	

	}