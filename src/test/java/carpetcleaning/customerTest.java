package carpetcleaning;

import static org.junit.Assert.assertEquals;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class customerTest {
	public customer cust;
	public boolean actual;
	public boolean expected;
	private int x=Main.setCutomers();
	
	@Given("admin want to create new customer with id {string}")
	public void admin_want_to_create_new_customer_with_id(String id) {
	    // Write code here that turns the phrase above into concrete actions
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
	
	
	@Given("admin want to delete customer id {string}")
	public void admin_want_to_delete_customer_id(String id) {
		Main.uesr.setType("admin");
		for(int i=0;i<Main.customers.size();i++) {
			System.out.println(Main.customers.get(i).getId());
		}
		customer.deleteCustomer(id);
		System.out.println("After delete");
		for(int i=0;i<Main.customers.size();i++) {
			System.out.println(Main.customers.get(i).getId());
		}
	    
	}

	@Then("customer {string} deleted successfully")
	public void customer_deleted_successfully(String string) {
	    actual=customer.isExist(string);
	    expected=false;
	    assertEquals(actual,expected);
	}
	
	
	
}
