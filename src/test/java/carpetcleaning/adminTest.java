package carpetcleaning;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class adminTest {
	Person user;
	boolean actual;
	boolean expected;
	String status;
	String actualType;
	private static ArrayList<Person> persons = new ArrayList<Person>();

	@Before
	public void createOutputFile() {
		user = new Person();
		Person adm1 = new Person("admin", "IamAdmin", "11");
		adm1.setType("admin");

		Admin admin = new Admin(adm1);
		admin.isStatus();
		admin.setId("12");
		admin.getId();

		Person cus1 = new Person("aya", "aya123", "12");
		cus1.setType("customer");

		Person worker1 = new Person("jamal", "jamal123", "13");
		worker1.setType("worker");

		if (!Person.isExist("admin", persons) && !Person.isExist("aya", persons) && !Person.isExist("jamal", persons)) {
			persons.add(worker1);
			persons.add(cus1);
			persons.add(adm1);

		}

	}

	@Given("that user is not logged in")
	public void that_user_is_not_logged_in() {
		// Write code here that turns the phrase above into concrete actions
		user.setLogged(0);
		user.getLogged();

	}

	@When("username is {string} which type is admin")
	public void username_is_which_type_is_admin(String name) {
		status = persons.get(Person.getIndex(name, persons)).getType();
		user.setName(name);
		user.setIdPerson("12");
	}

	@When("password is correct {string}")
	public void password_is_correct(String pass) {
		// Write code here that turns the phrase above into concrete actions
		actual = (persons.get(Person.getIndex(user.getName(), persons)).getPassword().equals(pass));
	}

	@Then("logged in successfully")
	public void logged_in_successfully() {
		expected = true;
		user.setLogged(1);
		assertEquals(actual, expected);
	}

	@When("password is false {string}")
	public void password_is_false(String pass) {
		// Write code here that turns the phrase above into concrete actions

		actualType = Admin.login(user.getName(), "123", persons);
	}

	@Then("log in faild")
	public void log_in_faild() {
		// Write code here that turns the phrase above into concrete actions
		expected = false;
		user.setLogged(0);
		assertEquals("false", actualType);
	}

	@When("username is {string} which type is customer")
	public void username_is_which_type_is_customer(String name) {
		// Write code here that turns the phrase above into concrete actions
		status = persons.get(Person.getIndex(name, persons)).getType();
		user.setName(name);
	}

	@When("username is {string} which type is worker")
	public void username_is_which_type_is_worker(String name) {
		// Write code here that turns the phrase above into concrete actions
		status = persons.get(Person.getIndex(name, persons)).getType();
		user.setName(name);
	}

	@Given("that admin is logged")
	public void thatAdminIsLogged() {
		user.setType("admin");
		user.setName("admin");
		user.setPassword("IamAdmin");
	}
	
	@Then("type is admin")
	public void typeIsAdmin() {
		assertTrue("admin".equalsIgnoreCase(Admin.login(user.getName(), "IamAdmin", persons)));
	}

	@Given("that worker is logged")
	public void thatWorkerIsLogged() {
		user.setType("worker");
		user.setName("worker");
		user.setPassword("123");
		persons.add(user);

	}
	
	@Then("type is worker")
	public void typeIsWorker() {
		assertTrue("worker".equalsIgnoreCase(Admin.login(user.getName(), "123", persons)));

	}

	@Given("that customer is logged")
	public void thatCustomerIsLogged() {
		user.setType("customer");
		user.setName("worker");
		user.setPassword("123");
		persons.add(user);
	}
	
	@Then("type is customer")
	public void typeIsCustomer() {
		assertTrue("worker".equalsIgnoreCase(Admin.login(user.getName(), "123", persons)));
	}

	@Given("that name is {string}")
	public void thatNameIs(String string) {
		actualType = Person.getIdFromName(string, persons);

	}
	
	@Then("id is {int}")
	public void idIs(Integer int1) {
		assertEquals(actualType, "11");
	}
	
	@Then("id is not valid")
	public void idIsNotValid() {
		assertEquals(actualType, "-1");
	}
}
