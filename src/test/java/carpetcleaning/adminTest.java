package carpetcleaning;

import static org.junit.Assert.assertEquals;



import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;




public class adminTest {
	Admin admin ;
	boolean actual;
	boolean expected;

	@Given("that admin is not logged in")
	public void that_admin_is_not_logged_in() {
	    // Write code here that turns the phrase above into concrete actions
		admin=new Admin();
	    admin.logged=0;
	}

	@When("user is {string}")
	public void user_is(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    admin.setName(string);
	}

	@When("password is {string}")
	public void password_is(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    admin.setPassword(string);
	}

	@Then("admin logged in successfully")
	public void admin_logged_in_successfully() {
		expected=true;
	    	actual=admin.getName().equals("admin")&&admin.getPassword().equals("IamAdmin");
	    	admin.logged=1;
	    
	    assertEquals(expected,actual);
	}

	@Then("login failed")
	public void login_failed() {
	    // Write code here that turns the phrase above into concrete actions
		expected=false;
	    	actual=admin.getName().equals("admin")&&admin.getPassword().equals("IamAdmin");
	    	admin.logged=0;
	    
	    assertEquals(expected,actual);
	}

}
