package carpetcleaning;


import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class customerTest {
	public static ArrayList<customer> customers= new ArrayList<customer>();
	public customer cust;
	public person pers;
	public boolean actual;
	public boolean expected;
	@Before public void createOutputFile() {
		person pers1=new person("Ayabaara","123456","3");
		customer c2=new customer(pers1,"3", "059967", "Arsad");
		c2.setMoney(200);
		c2.setDebt(100);
		product pro1=new product("nn","100");
		product pro2=new product("nn","200");
		c2.getProductsForCusomer().add(pro1);  
		c2.getProductsForCusomer().add(pro2); 
		if(!customer.isExistCustomer(c2.getId(), customers)) {
		customers.add(c2);
		}
		
		
	}
	
	@Given("admin want to create new customer with id {string}")
	public void admin_want_to_create_new_customer_with_id(String id) {
	    // Write code here that turns the phrase above into concrete actions
	
		
	   cust=new customer();
	   cust.setId(id);
	}

	@When("user id {string} already exist")
	public void user_id_already_exist(String id) {
	customer.isExistCustomer(id,customers);
		
	}

	@Then("creating customer id {string} faild")
	public void creating_customer_id_faild(String id) {
	    // Write code here that turns the phrase above into concrete actions
		expected=true; 
	   actual=customer.isExistCustomer(id,customers);
	   assertEquals(expected,actual);
	}
	
	
	@When("id {string} is not exist")
	
	public void id_is_not_exist(String id) {
	    // Write code here that turns the phrase above into concrete actions
		expected=customer.isExistCustomer(id,customers);
	}

	@When("admin enter id {string} Name {string} phone {string} address {string}")
	public void admin_enter_id_name_phone_address(String id, String name, String phone, String address) {
		pers=new person(name,"123",id);
		 cust=new customer(pers,id,phone,address);
	    
	
	   
	    
	}

	@Then("customer id {string} added successfully")
	public void customer_id_added_successfully(String id) {
		
		   actual=customer.isExistCustomer(id,customers);
		   customer.createCustomer(cust,customers);
		   assertEquals(expected,actual);
	}
	
	/// update phone
	
	@Given("user is {string} with id {string} want to update  phone to {string}")
	public void user_is_with_id_want_to_update_phone_to(String role, String id, String phone) {
		cust=new customer();
	  cust.setLogged(1);
	  customer.updatePhone(id, phone,customers);
	  }
	 

	
	
	@Then("customer id {string} updated successfully")
	public void customer_id_updated_successfully(String id) {
	    // Write code here that turns the phrase above into concrete actions
		expected=true;
		   actual=customer.isExistCustomer(id,customers);
		   assertEquals(expected,actual);
	}


	
	@Given("admin want to update customer id {string} with new address {string}")
	public void admin_want_to_update_customer_id_with_new_address(String id, String newAddress) {
	    // Write code here that turns the phrase above into concrete actions
		cust=new customer();
		cust.setLogged(1);
		customer.updatePhone(id, newAddress,customers);
	}

	@Then("customer address id {string} updated successfully")
	public void customer_address_id_updated_successfully(String id) {
	    // Write code here that turns the phrase above into concrete actions
		expected=true;
		   actual=customer.isExistCustomer(id,customers);
		   assertEquals(expected,actual);
	}
	
	
	@Given("admin want to delete customer id {string}")
	public void admin_want_to_delete_customer_id(String id) {
		if(customer.isExistCustomer(id,customers)) {
		customer.deleteCustomer(id,customers);
		}
	
	    
	}

	@Then("customer {string} deleted successfully")
	public void customer_deleted_successfully(String string) {
	    actual=customer.isExistCustomer(string,customers);
	    expected=false;
	    assertEquals(actual,expected);
	}
	
	@Given("customer id {string} is not exist")
	public void customer_id_is_not_exist(String string) {
	   actual=customer.isExistCustomer(string,customers);
	}

	@Then("delete customer {string} faild")
	public void delete_customer_faild(String string) {
	    expected=false;
	    assertEquals(actual,expected);
	    
	}
	
	
	
}
