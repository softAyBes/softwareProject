package carpetcleaning;

import static org.junit.Assert.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class workerTest {
	private String actual;
	private String expected;
	
	@Given("that worker want to update status to {string} of product code {string} which is for customer id {string}")
	public void that_worker_want_to_update_status_to_of_product_code_which_is_for_customer_id(String status, String code, String id) {
		
		actual =worker.updateStatusCustomer(code,id,status);
	   
	    
	    
	}

	@Then("product updated to {string} successfully")
	public void product_updated_to_successfully(String string) {
	    // Write code here that turns the phrase above into concrete actions
		expected=string;
		assertEquals(actual,expected);
	}

}
