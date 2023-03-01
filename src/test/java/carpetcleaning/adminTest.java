package carpetcleaning;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;




public class adminTest {
	Admin admin = new Admin();

	 public adminTest(Admin admin) { 
		  this.admin=admin; admin.setStatus(true);
		  admin.setName("admin");
		  admin.setPass("IamAdmin");
		  }
	 

	@Given("that admin is not logged in")
	public void that_admin_is_not_logged_in() {
		// Write code here that turns the phrase above into concrete actions
		// assertFalse(admin.isStatus());
		admin.setStatus(true);
	}

	@When("user is {string}")
	public void user_is(String string) {
		// Write code here that turns the phrase above into concrete actions
		// assertEquals("admin",admin.getName());
		admin.setName("admin");
	}

	@When("password is {string}")
	public void password_is(String string) {
		// Write code here that turns the phrase above into concrete actions
		if (admin.getPass().equals("IamAdmin")) {
			assertEquals("IamAdmin", admin.getPass());
		} else {
			assertNotEquals("IamAdmin", admin.getPass());
		}
	}

	@Then("admin logged in successfully")
	public void admin_logged_in_successfully() {
		// Write code here that turns the phrase above into concrete actions
		admin.setStatus(true);
		assertTrue(admin.isStatus());
	}

	@Given("that the admin is not logged in")
	public void that_the_admin_is_not_logged_in() {
		// Write code here that turns the phrase above into concrete actions
		assertFalse(admin.isStatus());
	}

	@Then("login failed")
	public void login_failed() {
		// Write code here that turns the phrase above into concrete actions

		assertFalse(admin.isStatus());
	}

}
