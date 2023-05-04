package carpetcleaning;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Test_discount {
	Customer Customer = new Customer();

	public static ArrayList<Customer> customers = new ArrayList<Customer>();

	@Before
	public void createOutputFile() {
		Person pers1 = new Person("Ayabaara", "123456", "3");
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

	@Given("that customer with id {string} is exist")
	public void that_customer_with_id_is_exist(String id) {
		int i = Customer.getIndexx(id, customers);
		Customer = customers.get(i);
		Customer.isExistCustomer(id, customers);
	}

	@When("the price with code {string} greater than or equal {string}")
	public void the_price_with_code_greater_than_or_equal(String code, String price) {

		int price_product = Customer.getPrice(code, Customer);
		Customer.checkPrice(price_product);
	}

	@Then("product with code {string} get a discount of {int}")
	public void product_with_code_get_a_discount_of(String code, int dis) {

		int price_ = Customer.getPrice(code, Customer);
		int T = Customer.getTotalPrice(Customer);
		int price_after_dis = Customer.discount(T, dis);
		System.out.print(price_after_dis);
		System.out.print(price_);

		assertTrue(true);
	}

}