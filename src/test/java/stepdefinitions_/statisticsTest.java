package stepdefinitions_;

	import static org.junit.Assert.assertEquals;
	import static org.junit.Assert.assertTrue;

	import java.util.ArrayList;

	import io.cucumber.java.Before;
	import io.cucumber.java.en.Given;
	import io.cucumber.java.en.Then;
import mypackage.Main;

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
		
		@Given("I want to check the total number of Money")
		public void i_want_to_check_the_total_number_of_money() {
		    // Write code here that turns the phrase above into concrete actions
		   actual=Main.totalMoney(customerTest.customers);
		}

		@Then("total Money sent")
		public void total_money_sent() {
		    // Write code here that turns the phrase above into concrete actions
			expected=200;
			assertEquals(expected,actual);
		}

		@Given("I want to check the total number of debts")
		public void i_want_to_check_the_total_number_of_debts() {
		    // Write code here that turns the phrase above into concrete actions
			   actual=Main.totalDebts(customerTest.customers);
		}

		@Then("total debts sent")
		public void total_debts_sent() {
		    // Write code here that turns the phrase above into concrete actions
			expected=100;
			assertEquals(expected,actual);
		}
		

}
