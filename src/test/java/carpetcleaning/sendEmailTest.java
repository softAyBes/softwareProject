package carpetcleaning;

import static org.junit.Assert.assertEquals;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class sendEmailTest {
	Product pro;
	int actual;
	int expected=1;
	SendEmaill email;
	@Before public void createOutputFile() {
		 pro=new Product("pro","12");
		email=new SendEmaill();
		}
	
	
	@Given("product is in ready state")
	public void product_is_in_ready_state() {
	   pro.setStatus("ready");
	}

	@Then("email send")
	public void email_send() {
		
		actual=email.email("ayabaara4@gmail.com", "your product is ready");
		assertEquals(expected,actual);

	}

}
