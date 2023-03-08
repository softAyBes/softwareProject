package carpetcleaning;

import java.util.ArrayList;
import java.util.Scanner;

public class mainFunc {
	static person user=new person();
	Main main=new Main();
	
	
 
	public static void main(String[] args) {
		int x;
		String in;
		Main.setCutomers();
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in); 
		String name,password;
		String emptyLine="|						                      						                |";
		int logged=0;
		String stat;
		// TODO Auto-generated method stub
			System.out.println(emptyLine);
			System.out.println(emptyLine);
			System.out.println("|						Welcome to  carpet cleaning foundation						|");
			System.out.println(emptyLine);
			
			while(logged==0) {
				System.out.println(emptyLine);
			System.out.println("|						        Enter you username						        |");
			System.out.println("|_______________________________________________________________________________________________________________________________"
					+ "|");
			name=input.nextLine();
			System.out.println("|						        Enter you user password						        |");
			password=input.nextLine();
			stat=Admin.login(name, password);
			if(stat.equals("false")) {
				logged=0;
				System.out.println("|						        Login faild						        |");

			}
			else {
				logged=1;
				user=Main.persons.get(person.getIndex(name, Main.persons));
				System.out.println("|_______________________________________________________________________________________________________________________________"
						+ "|");
				System.out.println("|                                                Welcome Back "+ user.getName()+"                               | ");
				System.out.println(emptyLine);
				System.out.println(emptyLine);
				System.out.println(emptyLine);
			}
			
			
			//// Admin 
			if(stat.equalsIgnoreCase("admin")) {
				while(logged==1) {
						x=0;
						System.out.println("press 1. to add new customer ");
						System.out.println(emptyLine);
						System.out.println("      2. to Delete customer ");
						System.out.println(emptyLine);
						System.out.println("      0. log out ");
						x=input.nextInt();
						if(x==1) {
							// add new customer
							customer cust =new customer();
							in=input.nextLine();
							System.out.println(" Enter Information : ID");
							in=input.nextLine();
							if(customer.isExist(in, Main.customers)) {
									System.out.println("this Id already exist");
									System.out.println(emptyLine);
								}
							else {
								
								cust.setId(in);
								cust.setId_person(in);
								System.out.println("Name");
								in=input.nextLine();
								cust.setName(in);
								
								System.out.println("phone");
								in=input.nextLine();
								cust.setPhone(in);
								
								System.out.println("Address");
								in=input.nextLine();
								cust.setAddress(in);
								customer.createCustomer(cust, Main.customers);
								System.out.println(" Added successfully");
							
							}
							
						}
						else if(x==2) {
							System.out.println(" What ID you want to delete");
							in=input.nextLine();
							if(!customer.isExist(in, Main.customers)) {
									System.out.println("No customer with this id");
									System.out.println(emptyLine);
								}
							else {
								customer.deleteCustomer(in, Main.customers);
								System.out.println(" Deleted successfully");

							}
						}
						
						else if(x==0) {
							/// log out
							logged=0;
							
						}
					
					}
				
				
				
				
			}
else if(stat.equalsIgnoreCase("worker")) {
	while(logged==1) {
		System.out.println("IS there any change in product status? Enter 1");
		System.out.println("Enter 0 to log out");
		
		x=input.nextInt();
		
		if(x==1) {
			String proId;
			customer cust=new customer();
			
			System.out.println("If yes please enter customer id");
			in=input.nextLine();
			if(!customer.isExist(in, Main.customers)) {
					System.out.println("No customer with this id");
					System.out.println(emptyLine);
				}
			else {
				cust=Main.customers.get(customer.getIndex(in, Main.customers));
				
				System.out.println("What product id you want to change");
				in=input.nextLine();
				proId=in;
				if(!customer.check_is_exist_1(in, cust)) {
					System.out.println("No product with this id");
					System.out.println(emptyLine);
				}
				else {
					System.out.println("what is the new status of the product ? waiting ... in treatment ... ready");
					in=input.nextLine();
					worker.updateStatusCustomer(proId, cust.getId(), in, Main.customers);
					System.out.println("Updated successfully");
					
						
				}
			}
			
			
	
		}
		else if(x==0) {
			logged=0;
		}
	}
	
	
				
			}
			
			}
			
			
			
	}
	
	

}
