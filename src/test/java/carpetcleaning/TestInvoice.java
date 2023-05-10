package carpetcleaning;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TestInvoice {

	Admin admin = new Admin();
	public static ArrayList<Customer> customers = new ArrayList<Customer>();

	@Before
	public void createOutputFile() {
		Person pers1 = new Person("smai", "123456", "3");
		Customer c2 = new Customer(pers1, "3", "059967", "Arsad");
		Product pro1 = new Product();
		pro1.setNamePro("nn");
		pro1.setStatus("waiting");
		pro1.setCode("12");
		pro1.setLength("6");
		pro1.setwidth("7");
		c2.getProductsForCusomer().add(pro1);

		Person pers3 = new Person("noor", "123456789", "9");
		Customer c4 = new Customer(pers3, "9", "059767", "main-street");
		Product pro3 = new Product();
		pro3.setNamePro("s");
		pro3.setStatus("waiting");
		pro3.setCode("25");
		pro3.setLength("2");
		pro3.setwidth("3");
		c4.getProductsForCusomer().add(pro3);

		if (!Customer.isExistCustomer(c2.getId(), customers)) {
			customers.add(c2);
		} else if (!Customer.isExistCustomer(c4.getId(), customers)) {
			customers.add(c4);
		}

	}

	@Given("that the Admin is logged in is {string}.")
	public void that_the_admin_is_logged_in_is(String status) {
		if (status.equalsIgnoreCase("true")) {
			admin.setStatus(true);
		}
	}

	@Then("generate invoice to customer with id {string} and paid {int} successfully.")
	public void generate_invoice_to_customer_with_id_and_paid_successfully(String id, Integer paid) {

		Main.setCutomers();
		Main.generateInvoice(id, paid, customers);
	}

}
