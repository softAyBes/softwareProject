package carpetcleaning;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class statisticsTest {
	int actual,expected;
	
	
	@Given("I want to check the total number of items")
	public void i_want_to_check_the_total_number_of_items() {
		actual=Main.itemsNum(customerTest.customers);
	}

	@Then("total number sent")
	public void total_number_sent() {
	    // Write code here that turns the phrase above into concrete actions
		
		expected=2;
		assertEquals(expected,actual);
	}
	
	


}
