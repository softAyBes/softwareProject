package carpetcleaning;

import static org.junit.Assert.assertEquals;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class customerTest {
	public customer cust;
	public boolean actual;
	public boolean expected;
	private int x;
	
	@Given("admin want to create new customer with id {string}")
	public void admin_want_to_create_new_customer_with_id(String id) {
	    // Write code here that turns the phrase above into concrete actions
		
		x=Main.setCutomers();
	   cust=new customer();
	   cust.setId(id);
	}

	@When("user id {string} already exist")
	public void user_id_already_exist(String id) {
		customer.isExist(id); 
	}

	@Then("creating customer id {string} faild")
	public void creating_customer_id_faild(String id) {
	    // Write code here that turns the phrase above into concrete actions
		expected=true; 
	   actual=customer.isExist(id);
	   assertEquals(expected,actual);
	}
	
	
	@When("id {string} is not exist")
	
	public void id_is_not_exist(String id) {
	    // Write code here that turns the phrase above into concrete actions
		  cust=new customer();
		 x=Main.setCutomers();
	}

	@When("admin enter id {string} Name {string} phone {string} address {string}")
	public void admin_enter_id_name_phone_address(String id, String name, String phone, String address) {
	  
	
	    // Write code here that turns the phrase above into concrete actions
	    cust.setAddress(address);
	    cust.setName(name);
	    cust.setPhone(phone);
	    cust.setId(id);
	    cust.setType("client");
	
	   
	    
	}

	@Then("customer id {string} added successfully")
	public void customer_id_added_successfully(String id) {
		expected=false;
		   actual=customer.isExist(id);
		   customer.createCustomer(cust);
		   assertEquals(expected,actual);
	}
	
	/// update phone
	
	@Given("user is {string} with id {string} want to update  phone to {string}")
	public void user_is_with_id_want_to_update_phone_to(String role, String id, String phone) {
		Main.uesr.setType("customer");
		 x=Main.setCutomers();
		cust=new customer();
	  cust.logged=1;
	  customer.updatePhone(id, phone);
	  }
	 

	
	
	@Then("customer id {string} updated successfully")
	public void customer_id_updated_successfully(String id) {
	    // Write code here that turns the phrase above into concrete actions
		expected=true;
		   actual=customer.isExist(id);
		   assertEquals(expected,actual);
	}


	
	@Given("admin want to update customer id {string} with new address {string}")
	public void admin_want_to_update_customer_id_with_new_address(String id, String newAddress) {
	    // Write code here that turns the phrase above into concrete actions
		Main.uesr.setType("customer");
		x=Main.setCutomers();
		cust=new customer();
		cust.logged=1;
		customer.updatePhone(id, newAddress);
	}

	@Then("customer address id {string} updated successfully")
	public void customer_address_id_updated_successfully(String id) {
	    // Write code here that turns the phrase above into concrete actions
		expected=true;
		   actual=customer.isExist(id);
		   assertEquals(expected,actual);
	}
	
	
	@Given("admin want to delete customer id {string}")
	public void admin_want_to_delete_customer_id(String id) {
		Main.uesr.setType("admin");
		 x=Main.setCutomers();
		if(customer.isExist(id)) {
		customer.deleteCustomer(id);
		}
	
	    
	}

	@Then("customer {string} deleted successfully")
	public void customer_deleted_successfully(String string) {
	    actual=customer.isExist(string);
	    expected=false;
	    assertEquals(actual,expected);
	}
	
	@Given("customer id {string} is not exist")
	public void customer_id_is_not_exist(String string) {
	   actual=customer.isExist(string);
	}

	@Then("delete customer {string} faild")
	public void delete_customer_faild(String string) {
	    expected=false;
	    assertEquals(actual,expected);
	    
	}
	
	
	
}
