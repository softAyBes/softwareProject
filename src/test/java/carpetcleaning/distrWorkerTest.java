package carpetcleaning;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class distrWorkerTest{
	
	public static ArrayList<Worker> workers= new ArrayList<Worker>();
	public static ArrayList<Customer> customers= new ArrayList<Customer>();

	Worker wr;
	String expected,actual;
	
	@Before public void createOutputFile() {
		Person pers1=new Person("w1","123","7");
		Worker w1=new Worker(pers1);
		
		Person pers2=new Person("w2","123","8");
		Worker w2=new Worker(pers2);
		
		Person pers3=new Person("w3","123","9");
		Worker w3=new Worker(pers3);
		
		
		if(Worker.getIndexOfWorker("9", workers)==-1) {
		workers.add(w3);
		workers.add(w2);
		workers.add(w1);
		Person pers11=new Person("Ayabaara","123456","3");
		Customer c2=new Customer(pers11,"3", "059967", "Arsad");
		Product pro1=new Product("nn","20");
		Product pro11=new Product("nn","70");
		pro1.setStatus("in treatment");
		pro11.setStatus("in treatment");
		Product pro2=new Product("nn","12");
		pro2.setStatus("in treatment");
		c2.getProductsForCusomer().add(pro1);  
		c2.getProductsForCusomer().add(pro2);
		
		Worker.addProductToWorker(pro1, w1, workers);
		Worker.addProductToWorker(pro11, w1, workers);
		Worker.addProductToWorker(pro2, w2, workers);
		c2.getProductsForCusomer().add(pro2);
		customers.add(c2);
		}
		
		
		
		
		
		

		
	}



	@Given("worker id {string} has the least number of products in treatment")
	public void worker_id_has_the_least_number_of_products_in_treatment(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    wr= Worker.getWorkerForOrder(workers);
	    expected=wr.getId();
	    Product p=new Product("carpet","205");
	    Worker.distributeOrder(p, workers);
	}

	@Then("new order added to him")
	public void new_order_added_to_him() {
		actual="9";
		assertEquals(actual,expected);
		
	}
	
	
	
	@Given("product id {string} for worker id {string} deleted")
	public void product_id_for_worker_id_deleted(String code, String WID) {
	    // Write code here that turns the phrase above into concrete actions
		Product pro=new Product("nn",code);
		Worker.deleteProductToWorker(pro,WID,workers);
	}

	@Then("product deleted successfully")
	public void product_deleted_successfully() {
		int windex=Worker.getIndexOfWorker("7", workers);
		//System.out.println(windex+"jjjj");
		Worker w=workers.get(windex);
	    boolean isexist=Worker.isProductExist("20", w, workers);
	    assertEquals(isexist,false);
	}

}
