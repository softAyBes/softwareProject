 package mypackage;

import java.util.ArrayList;
import java.util.Scanner;
public class mainFunc 
{
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
			stat=Admin.Login(name,password);
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
				while(logged==1) 
				{
						x=0;
						System.out.println("press 1. to add new customer ");
						System.out.println(emptyLine);
						System.out.println("      2. to Delete customer ");
						System.out.println(emptyLine);
						System.out.println("      0. log out ");
						x=input.nextInt();
						if(x==1) 
						{
							//add new customer
							customer cust =new customer();
							in=input.nextLine();
							System.out.println(" Enter Information : ID");
							in=input.nextLine();
							if(customer.isExist(in, Main.customers))
							{
									System.out.println("this Id already exist");
									System.out.println(emptyLine);
								}
							
							else 
							{
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
						}
					
				}
			}
			//customer
			if(stat.equalsIgnoreCase("customer"))
			{
				customer cust=new customer();
			    cust=Main.customers.get(customer.getIndex(user.getId_person(),Main.customers));
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
						//in=input.nextLine();
						//System.out.println(" Enter Youre : ID");
						//in=input.nextLine();
						//if(customer.isExist(in,Main.customers))
						//{
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
								
								
								cust.addProduct(pro);
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
						    customer.delete_product(in, cust);
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
					}
					
			}//end while
					
				}//end if
			}

				
			

}
}