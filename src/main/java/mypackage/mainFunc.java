package  mypackage;

import java.util.Scanner;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
@SpringBootApplication
public class mainFunc {
	static person user=new person();
	Main main=new Main();
	
	  static sending_Email email=new sending_Email();
	  
	  @Autowired private JavaMailSender mailSender;
	 
	
 
	public static void main(String[] args) { 
		
		String recipientEmail = "ayabaara4@gmail.com";
		String subject = "Hello from my Spring Boot app!";
		String message = "This is a test email from my Spring Boot application.";
		
		  try { 
			  System.out.println("hi");
			  email.sendEmail(recipientEmail, subject, message); } catch (Exception
		  e) { // TODO Auto-generated catch block e.printStackTrace(); }
		 
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
				user.setId_person(person.getIdFromName(name, Main.persons));
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
						System.out.println("press 1. To add new customer ");
						System.out.println(emptyLine);
						System.out.println("      2. To Delete customer ");
						System.out.println(emptyLine);
						System.out.println("      3. To get statistic ");
						System.out.println(emptyLine);
						System.out.println("      0. log out ");
						x=input.nextInt();
						if(x==1) {
							// add new customer
							customer cust =new customer();
							in=input.nextLine();
							System.out.println(" Enter Information : ID");
							in=input.nextLine();
							if(customer.isExist_1(in, Main.customers)) {
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
								
								
								System.out.println("Email");
								in=input.nextLine();
								cust.setEmail(in);
								customer.createCustomer(cust, Main.customers);
								System.out.println(" Added successfully");
							
							}
							 
						}
						else if(x==2) {
							System.out.println(" What ID you want to delete");
							in=input.nextLine();
							if(!customer.isExist_1(in, Main.customers)) {
									System.out.println("No customer with this id");
									System.out.println(emptyLine);
								}
							else {
								customer.deleteCustomer(in, Main.customers);
								System.out.println(" Deleted successfully");

							}
						}
						
						else if (x==3) {
							System.out.println(" 		enter 1 to get total number of products");
							System.out.println(" 		enter 2 to get total number of waiting products");
							System.out.println(" 		enter 3 to get total number of in treatment products");
							System.out.println(" 		enter 4 to get total number of Money");
							System.out.println(" 		enter 5 to get total number of debts");

							x=input.nextInt();
							if (x==1) {
								System.out.println("Total number of products  "+Main.itemsNum(Main.customers));
								System.out.println(emptyLine);
								System.out.println(emptyLine);

								
							}
							else if(x==2) {
								System.out.println("Total number of waiting products is  "+Main.totalWaitingNum(Main.customers));
								System.out.println(emptyLine);
								System.out.println(emptyLine);

							}
							
							else if(x==3) {
								System.out.println("Total number of waiting products is "+Main.totalIntreatment(Main.customers));
								System.out.println(emptyLine);
								System.out.println(emptyLine);

							}
							else if(x==4) {
								System.out.println("Total number of Money "+Main.totalMoney(Main.customers));
								System.out.println(emptyLine);
								System.out.println(emptyLine);

							}
							else if(x==5) {
								System.out.println("Total number of debts "+Main.totalDebts(Main.customers));
								System.out.println(emptyLine);
								System.out.println(emptyLine);

							}
							
						}
						
						else if(x==0) {
							/// log out
							logged=0;
							
						}
						else {
							System.out.println("Enter valid number");
							System.out.println();
						}
					
					}
				
				
				
				
			}
else if(stat.equalsIgnoreCase("worker")) {
	while(logged==1) {
		// worker ::::::::::::Main.workers.get(worker.getIndexOfWorker(user.getId_person(), Main.workers))
		
	
		
		System.out.println("To see your products enter 1");
		System.out.println("IS there any change in product status? Enter 2");
		System.out.println("Enter 0 to log out");
		
		x=input.nextInt();
		if(x==1) {
			
			worker w=Main.workers.get(worker.getIndexOfWorker(user.getId_person(), Main.workers));
			int size=w.getProductsForWorker().size();
			if(size==0) {
				System.out.println("No products added yet");
				System.out.println(emptyLine);
			}
			else {
				System.out.println(" Code		::	 	Category	::		status		::		CustomerName	::		cusomerPhone	");
				
				for(int i=0;i<size;i++) {
					product proo=w.getProductsForWorker().get(i);
					customer cust=Main.customers.get(customer.getIndex_1(proo.getCustId(), Main.customers));
					System.out.println(" "+proo.getCode()+"		::	 	"+proo.getCategory()+"		::		"+proo.getStatus()+"		::		"+cust.getName()+"		::		"+cust.getPhone()+"		");
					System.out.println(emptyLine);

					
				}
			}
			
		}
		
		else if(x==2) {
			String proId;
			customer cust=new customer();
			
			System.out.println("If yes please enter customer id");
			in=input.nextLine();
			in=input.nextLine();
			
			if(!customer.isExist_1(in, Main.customers)) {
					System.out.println("No customer with this id");
					System.out.println(emptyLine);
				}
			else {
				cust=Main.customers.get(customer.getIndex_1(in, Main.customers));
				
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
		else {
			System.out.println("Enter valid number");
			System.out.println();
		}
	}
	
	
				
			}
			
			
			if(stat.equalsIgnoreCase("customer"))
			{
				customer cust=new customer();
			    cust=Main.customers.get(customer.getIndex_1(user.getId_person(),Main.customers));
				while(logged==1)
				{
					x=0;
					
					System.out.println("press 1. to add new product ");
					System.out.println(emptyLine);
					System.out.println("      2. to Update product ");
					System.out.println(emptyLine);
					System.out.println("      3. to Delete product ");
					System.out.println(emptyLine);
					System.out.println("      4. to Update your Address ");
					System.out.println(emptyLine);
					System.out.println("      5. to Update your phone ");
					System.out.println(emptyLine);
					System.out.println("      0. log out ");
					x=input.nextInt();
					if(x==1)
					{
					   
						product pro=new product();
					
							System.out.println(" Enter Code to your product"); 
							in=input.nextLine();
							in=input.nextLine();
							if(customer.check_is_exist_1(in,cust)) 
							 {
								System.out.println("this Code already exist");
								System.out.println(emptyLine);
								
							 }
							
							else if(!customer.check_is_exist_1(in,cust))
					        	{
							   //cust.setId(in);
								pro.setStatus("Waiting");
								pro.setCode(in);
								System.out.println("Name");
								in=input.nextLine();
								pro.setName_p(in);
								
								
								
								System.out.print("Category \n");
								in=input.nextLine();
								pro.setCategory(in);
							

								System.out.print("picture \n");
								in=input.nextLine();
								pro.setPicture(in);
							
								System.out.print("material \n");
								in=input.nextLine();
								pro.setMaterial(in);
								
								System.out.print("Length \n");
								in=input.nextLine();
								pro.setLength(in);
								

								System.out.print("width \n");
								in=input.nextLine();
								pro.setwidth(in);
								
								
						
								pro.setStatus("Waiting");
								
								System.out.print("isspecial \n");
								in=input.nextLine();
								pro.setIsspecial(in);
								
								
								cust.addProduct(pro,Main.workers);
								System.out.println(emptyLine);
								System.out.println(" Added successfully");
						}
						
						else
						{
							System.out.print("try later");
						}
						
				}
			
			
					
					else if(x==3)
					{
						
							System.out.println(" What Code you want to delete");
							in=input.nextLine();
							in=input.nextLine();
							if(!customer.check_is_exist_1(in,cust)) 
							{
							System.out.println("No product with this Code");
						 	System.out.println(emptyLine);
						    }
				  	     else
				        	{
						    customer.delete_product(in, cust,Main.workers);
						  System.out.println(" Deleted successfully");
				        	}
					}
					
					else if(x==2)
					{
						System.out.println(" What Code your product ");
						in=input.nextLine();
						in=input.nextLine();
					
						if(!customer.check_is_exist_1(in,cust)) 
						{
						System.out.println("No product with this Code");
					 	System.out.println(emptyLine);
					    }
			  	     else
			        	{
			  	    	String CODE=in;
			  	    	System.out.println("What you want to update");
			  	    	in=input.nextLine();
						
			  	       	if("Length".equalsIgnoreCase(in))
			  	       	{
			  	       	 System.out.println(" new Length: ");
			  	       		in=input.nextLine();
			  	         customer.update_Length(CODE,in,cust);	
						 System.out.println(" Update Length successfully");
			  	       	}
			  	       	else if("Picture".equalsIgnoreCase(in))
			  	       	{
			  	       	 System.out.println(" new picture: ");
			  	      	in=input.nextLine();
			  	        customer.updatepicture(CODE, in, cust);	
			  	       	 System.out.println(" Update Picture successfully");
			  	       	}
			  	       	else if("Width".equalsIgnoreCase(in))
			  	       	{
			  	       	 System.out.println(" new width: ");
			  	        	in=input.nextLine();
			  	       		customer.update_width(CODE,in,cust);	
			  	       		System.out.println(" Update Width successfully");
			  	       	}
			        	}
						
						
						
					}
					else if(x==4)
					{
						
						
							 System.out.println(" new Addres: ");
				  	        	in=input.nextLine();
				  	        	in=input.nextLine();
							customer.updateAdress(user.getId_person(), in,Main.customers);
							System.out.println(" Update Addres successfully");
					}
					
					else if(x==5)
					{
							 System.out.println(" new Phone: ");
				  	        	in=input.nextLine();
				  	        	in=input.nextLine();
							customer.updatePhone(user.getId_person(), in, Main.customers);
							System.out.println(" Update phone successfully");
					}
					else if(x==0) {
						//logOut
						logged=0;
					}
					else {
						System.out.println("Enter valid number");
						System.out.println();
					}
					
			}//end while
					
				}//end if
			
			
			
			
			}
			
			
			
	}}
	
	  @Bean public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
	  return args -> { System.out.println("Checking for mailSender bean...");
	  System.out.println(mailSender); }; }
	 
	
	

}