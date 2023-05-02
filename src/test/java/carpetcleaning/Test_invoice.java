package carpetcleaning;


import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class Test_invoice
{
	
	
	Admin admin=new Admin();
	public static ArrayList<customer> customers= new ArrayList<customer>();

	
	@Before public void createOutputFile() 
	{
		person pers1=new person("smai","123456","3");
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
	
		
		if(!customer.isExistCustomer(c2.getId(),customers)) 
		{
		    customers.add(c2);
		}
		else if(!customer.isExistCustomer(c4.getId(),customers))
		{
			customers.add(c4);
		}
		
	}
	@Given("that the Admin is logged in is {string}.")
	public void that_the_admin_is_logged_in_is(String status) {
		if(status.equalsIgnoreCase("true")) 
		{
			admin.setStatus(true);
		}
	}


@Then("generate invoice to customer with id {string} and paid {int} successfully.")
public void generate_invoice_to_customer_with_id_and_paid_successfully(String id, Integer paid) {
   
    Main.setCutomers();
    Main.generate_invoice(id,paid,customers);
}

	
	
	
	
	
}
