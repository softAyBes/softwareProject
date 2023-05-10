package carpetcleaning;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class workerTest {
	private String actual;
	private String expected;
	public static ArrayList<Customer> customers = new ArrayList<Customer>();

	@Before
	public void createOutputFile() {
		Person pers1 = new Person("Ayabaara", "123456", "3");
		Customer c2 = new Customer(pers1, "3", "059967", "Arsad");
		Product pro1 = new Product();
		pro1.setNamePro("nn");
		pro1.setStatus("waiting");
		pro1.setCode("100");
		c2.getProductsForCusomer().add(pro1);

		if (!Customer.isExistCustomer(c2.getId(), customers)) {
			customers.add(c2);
		}

	}

	@Given("that worker want to update status to {string} of product code {string} which is for customer id {string}")
	public void that_worker_want_to_update_status_to_of_product_code_which_is_for_customer_id(String status,
			String code, String id) {

		actual = Worker.updateStatusCustomer(code, id, status, customers);

	}

	@Then("product updated to {string} successfully")
	public void product_updated_to_successfully(String string) {
		// Write code here that turns the phrase above into concrete actions
		expected = string;
		assertEquals(actual, expected);
	}

}
