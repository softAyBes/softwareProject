package carpetcleaning;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class customerTest {
	
	customer cust=new customer();
	
	@Given("admin want to create new customer with id {string}")
	public void admin_want_to_create_new_customer_with_id(String id) {
	    // Write code here that turns the phrase above into concrete actions
		cust.setId(id);
	    
	}

	@When("user id {string} already exist")
	public void user_id_already_exist(String string) {
	    // Write code here that turns the phrase above into concrete actions

		assertTrue(cust.checkDublicate(cust.getId()));
	}

	@Then("creating faild")
	public void creating_faild() {
	    // Write code here that turns the phrase above into concrete actions
	   assertFalse(false);
	}

	@Given("admin want to create new customer")
	public void admin_want_to_create_new_customer() {
	   cust=new customer();
	}
	@When("{string} is not exist")
	public void is_not_exist(String id) {
	    // Write code here that turns the phrase above into concrete actions
		assertFalse(cust.checkDublicate(cust.getId()));
	}

	@When("admin enter {string},{string},{string},{string}") // id phone name address
	public void admin_enter(String id, int phone, String name, String address) {
	    // Write code here that turns the phrase above into concrete actions
	    cust.setAddress(address);
	    cust.setId(id);
	    cust.setName(name);
	    cust.setPhone(phone);
	}

	@Then("customer added successfully")
	public void customer_added_successfully() {
	    // Write code here that turns the phrase above into concrete actions
		customer.createCustomer(cust);
	   assertTrue(true);
	}
	
	
	

	@Given("admin want to update customer id {string} with new phone {int}")
	public void admin_want_to_update_customer_id_with_new_phone(String id, Integer newPhone) {
	    // Write code here that turns the phrase above into concrete actions
		customer.updatePhone(id,newPhone);
	}

	@Then("customer updated successfully")
	public void customer_updated_successfully() {
	    // Write code here that turns the phrase above into concrete actions
	    assert(true);
	}

@Given("admin want to update customer id {string} with new address {string}")
public void admin_want_to_update_customer_id_with_new_address(String id, String newAdress) {
    // Write code here that turns the phrase above into concrete actions
    customer.updateAdress(id,newAdress);
}

	
	@Given("admin want to delete")
	public void admin_want_to_delete() {
	    // Write code here that turns the phrase above into concrete actions
	    assert(true);
	}

	@When("enter the customer id {string}")
	public void enter_the_customer_id(String id) {
	    // Write code here that turns the phrase above into concrete actions
		  cust=new customer();
		    cust.setId(id);
		    assertTrue(cust.checkDublicate(cust.getId()));
	}

	@Then("customer {string} deleted successfully")
	public void customer_deleted_successfully(String id) {
	    // Write code here that turns the phrase above into concrete actions
	    customer.deleteCustomer(id);
	}
	

	@When("customer id {string} is not exist")
	public void customer_id_is_not_exist(String id) {
	    // Write code here that turns the phrase above into concrete actions
		 assertFalse(cust.checkDublicate(cust.getId()));
	}


	@Then("delete customer {string} faild")
	public void delete_customer_faild(String id) {
	    // Write code here that turns the phrase above into concrete actions
		 assertFalse(cust.checkDublicate(cust.getId()));	
	}
}
