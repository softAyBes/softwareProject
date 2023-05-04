package carpetcleaning;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;




public class Test_reports 
{
	String act;
	String exp;
	Admin admin=new Admin();
	Person user;
	public static ArrayList<Customer> customers= new ArrayList<Customer>();
	public static ArrayList<Worker> workers= new ArrayList<Worker>();
		
		@Before public void createOutputFile() 
		{
			Person pers1=new Person("Aya","123456","3");
			Customer c2=new Customer(pers1,"3", "059967", "Arsad");
			Product pro1=new Product();
			pro1.setName_p("nn");
			pro1.setStatus("waiting");
			pro1.setCode("12");
			pro1.setLength("6");
			pro1.setwidth("7");
			c2.getProductsForCusomer().add(pro1);  
			
			Person pers3=new Person("noor","123456789","9");
			Customer c4=new Customer(pers3,"9", "059767", "main-street");
			Product pro3=new Product();
			pro3.setName_p("s");
			pro3.setStatus("waiting");
			pro3.setCode("25");
			pro3.setLength("2");
			pro3.setwidth("3");
			c4.getProductsForCusomer().add(pro3);  
		
			Person pers4=new Person("Sandra","8989","1");
			///worker w1 =new worker(pers4,"1","05933","2000","Add");
			//workers.add(w1);
			
			if(!Customer.isExistCustomer(c2.getId(),customers)) 
			{
			    customers.add(c2);
			}
			else if(!Customer.isExistCustomer(c4.getId(),customers))
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
	Main.showAllWorkerDetails(workers);
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
