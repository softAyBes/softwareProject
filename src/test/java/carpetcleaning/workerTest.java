package carpetcleaning;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class workerTest {
	private String actual;
	private String expected;
	public static ArrayList<customer> customers= new ArrayList<customer>();
	@Before public void createOutputFile() {
		person pers1=new person("Ayabaara","123456","3");
		customer c2=new customer(pers1,"3", "059967", "Arsad");
		product pro1=new product();
		pro1.setName_p("nn");
		pro1.setStatus("waiting");
		pro1.setCode("100");
		c2.getProductsForCusomer().add(pro1);
		
		if(!customer.isExistCustomer(c2.getId(), customers)) {
		customers.add(c2);
		}
		
		
	}
	
	@Given("that worker want to update status to {string} of product code {string} which is for customer id {string}")
	public void that_worker_want_to_update_status_to_of_product_code_which_is_for_customer_id(String status, String code, String id) {
		
		actual =worker.updateStatusCustomer(code,id,status,customers);
	   
	    
	    
	}

	@Then("product updated to {string} successfully")
	public void product_updated_to_successfully(String string) {
	    // Write code here that turns the phrase above into concrete actions
		expected=string;
		assertEquals(actual,expected);
	}

}
