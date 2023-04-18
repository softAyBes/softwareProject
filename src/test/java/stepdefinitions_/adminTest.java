package stepdefinitions_;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mypackage.person;




	public class adminTest {
		person user;
		boolean actual;
		boolean expected;
		String status;
		private static ArrayList<person> persons=new ArrayList<person>(); 
		
		@Before public void createOutputFile() {
			user=new person();
			person adm1=new person("admin","IamAdmin","11");
			adm1.setType("admin");
			
			person cus1=new person("aya","aya123","12");
			cus1.setType("customer");
			
			person worker1=new person("jamal","jamal123","13");
			worker1.setType("worker");
			
			if(!person.isExist("admin", persons) && !person.isExist("aya", persons) && !person.isExist("jamal", persons)) {
				persons.add(worker1);
				persons.add(cus1);
				persons.add(adm1);
				
			}
			
		}

		@Given("that user is not logged in")
		public void that_user_is_not_logged_in() {
		    // Write code here that turns the phrase above into concrete actions
		    user.setLogged(0); 
		}

		@When("username is {string} which type is admin")
		public void username_is_which_type_is_admin(String name) {
			status=persons.get(person.getIndex(name, persons)).getType();
			user.setName(name);
		}

		@When("password is correct {string}")
		public void password_is_correct(String pass) {
		    // Write code here that turns the phrase above into concrete actions
		    actual=(persons.get(person.getIndex(user.getName(), persons)).getPassword() .equals(pass) );
		}

		@Then("logged in successfully")
		public void logged_in_successfully() {
		   expected=true;
		   user.setLogged(1);
		   assertEquals(actual,expected);
		}
		
		

		@When("password is false {string}")
		public void password_is_false(String pass) {
		    // Write code here that turns the phrase above into concrete actions
			 actual=(persons.get(person.getIndex(user.getName(), persons)).getPassword() .equals(pass) );
		}

		@Then("log in faild")
		public void log_in_faild() {
		    // Write code here that turns the phrase above into concrete actions
			expected=false;
			user.setLogged(0);
			   assertEquals(actual,expected);
		}

		@When("username is {string} which type is customer")
		public void username_is_which_type_is_customer(String name) {
		    // Write code here that turns the phrase above into concrete actions
			status=persons.get(person.getIndex(name, persons)).getType();
			user.setName(name);
		}


		@When("username is {string} which type is worker")
		public void username_is_which_type_is_worker(String name) {
		    // Write code here that turns the phrase above into concrete actions
			status=persons.get(person.getIndex(name, persons)).getType();
			user.setName(name);
		}
	}
	
	

