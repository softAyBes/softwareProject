package stepdefinitions_;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mypackage.Admin;
import mypackage.Main;
import mypackage.person;
import mypackage.product;
import mypackage.worker;
import mypackage.customer;



public class Test_reports 
{
	String act;
	String exp;
	Admin admin=new Admin();
	person user;
	public static ArrayList<customer> customers= new ArrayList<customer>();
	public static ArrayList<worker> workers= new ArrayList<worker>();
		
		@Before public void createOutputFile() 
		{
			person pers1=new person("Aya","123456","3");
			customer c2=new customer(pers1,"3", "059967", "Arsad");
			product pro1=new product();
			pro1.setName_p("nn");
			pro1.setStatus("waiting");
			pro1.setCode("12");
			pro1.setLength("6");
			pro1.setwidth("7");
			c2.getProductsForCusomer().add(pro1);  
			
			person pers3=new person("noor","123456789","9");
			customer c4=new customer(pers3,"9", "059767", "main-street");
			product pro3=new product();
			pro3.setName_p("s");
			pro3.setStatus("waiting");
			pro3.setCode("25");
			pro3.setLength("2");
			pro3.setwidth("3");
			c4.getProductsForCusomer().add(pro3);  
		
			person pers4=new person("Sandra","8989","1");
			///worker w1 =new worker(pers4,"1","05933","2000","Add");
			//workers.add(w1);
			
			if(!customer.isExist_1(c2.getId(),customers)) 
			{
			    customers.add(c2);
			}
			else if(!customer.isExist_1(c4.getId(),customers))
			{
				customers.add(c4);
			}
			
		}
	
	@Given("that the Admin is logged in is {string} now.")
	public void that_the_admin_is_logged_in_is_now(String status) 
	{
		act="true";
		if(status.equalsIgnoreCase("true")) 
		{
			admin.setStatus(true);
		}
	
	}
	

@Then("Admin generated all customers details report successfully.")
public void admin_generated_all_customers_details_report_successfully() 
{
    exp="true";
    //Main.Show_all_customers_details(customers);
	assertFalse(exp==act);
	
}


@Given("that the admin is not logged in is {string} now")
public void that_the_admin_is_not_logged_in_is_now(String status) 
{
	act=status;
	System.out.print(act);
	if(status.equalsIgnoreCase("false"))   
	{
		  admin.setStatus(false);
	}
}
@Then("the report  generated failed.")
public void the_report_generated_failed()
{
	 exp="false";
	assertEquals(exp,act);
}


@Then("Admin generated all worker details report successfully.")
public void admin_generated_all_worker_details_report_successfully() 
{
	 exp="true";
	Main.Show_all_worker_details(workers);
	assertFalse(exp==act);
}



/*
@Given("he generated all customers names")
public void he_generated_all_customers_names() 
{
	Main.setCutomers();
	Main.Show_all_customers_names();
}

@Then("the report generated successfully")
public void the_report_generated_successfully()
{
 //System.out.print(Main.Show_all_customers_names());
   assertFalse(Main.Show_all_customers_names());
}

*/
}
