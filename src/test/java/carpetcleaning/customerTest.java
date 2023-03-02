package carpetcleaning;

import static org.junit.Assert.assertEquals;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class customerTest {
	public customer cust;
	public boolean actual;
	public boolean expected;
	public Main mn=new Main();
	
	@Given("admin want to create new customer with id {string}")
	public void admin_want_to_create_new_customer_with_id(String id) {
	    // Write code here that turns the phrase above into concrete actions
	   cust=new customer();
	   cust.setId(id);
	}

	@When("user id {string} already exist")
	public void user_id_already_exist(String id) {
			cust.isExist(id); 
	}

	@Then("creating customer id {string} faild")
	public void creating_customer_id_faild(String id) {
	    // Write code here that turns the phrase above into concrete actions
		expected=true; 
	   actual=cust.isExist(id);
	   assertEquals(expected,actual);
	}
	
	
	@When("id {string} is not exist")
	public void id_is_not_exist(String id) {
	    // Write code here that turns the phrase above into concrete actions
		  cust=new customer();
	}

	@When("admin enter id {string} Name {string} phone {int} address {string}")
	public void admin_enter_id_name_phone_address(String id, String name, Integer phone, String address) {
	    // Write code here that turns the phrase above into concrete actions
	    cust.setAddress(address);
	    cust.setName(name);
	    cust.setPhone(phone);
	    cust.setId(id);
	    cust.setType("client");
	    customer.createCustomer(cust);
	 
	    
	}

	@Then("customer id {string} added successfully")
	public void customer_id_added_successfully(String id) {
		expected=false;
		   actual=cust.isExist(id);
		   assertEquals(expected,actual);
	}
	
	
	
}
