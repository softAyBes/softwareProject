package carpetcleaning;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class distrWorkerTest {
	
	public static ArrayList<worker> workers= new ArrayList<worker>();
	public static ArrayList<customer> customers= new ArrayList<customer>();

	worker wr;
	String expected,actual;
	
	@Before public void createOutputFile() {
		person pers1=new person("w1","123","7");
		worker w1=new worker(pers1);
		
		person pers2=new person("w2","123","8");
		worker w2=new worker(pers2);
		
		person pers3=new person("w3","123","9");
		worker w3=new worker(pers3);
		
		
		if(worker.getIndexOfWorker("9", workers)==-1) {
		workers.add(w3);
		workers.add(w2);
		workers.add(w1);
		person pers11=new person("Ayabaara","123456","3");
		customer c2=new customer(pers11,"3", "059967", "Arsad");
		product pro1=new product("nn","20");
		product pro11=new product("nn","70");
		pro1.setStatus("in treatment");
		pro11.setStatus("in treatment");
		product pro2=new product("nn","12");
		pro2.setStatus("in treatment");
		c2.getProductsForCusomer().add(pro1);  
		c2.getProductsForCusomer().add(pro2);
		
		worker.AddProductToWorker(pro1, w1, workers);
		worker.AddProductToWorker(pro11, w1, workers);
		worker.AddProductToWorker(pro2, w2, workers);
		c2.getProductsForCusomer().add(pro2);
		customers.add(c2);
		}
		
		
		
		
		
		

		
	}



	@Given("worker id {string} has the least number of products in treatment")
	public void worker_id_has_the_least_number_of_products_in_treatment(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    wr= worker.getWorkerForOrder(workers);
	    expected=wr.getId();
	    product p=new product("carpet","205");
	    worker.distributeOrder(p, workers);
	}

	@Then("new order added to him")
	public void new_order_added_to_him() {
		actual="9";
		assertEquals(actual,expected);
		
	}
	
	
	
	@Given("product id {string} for worker id {string} deleted")
	public void product_id_for_worker_id_deleted(String code, String WID) {
	    // Write code here that turns the phrase above into concrete actions
		product pro=new product("nn",code);
		worker.deleteProductToWorker(pro,WID,workers);
	}

	@Then("product deleted successfully")
	public void product_deleted_successfully() {
		int windex=worker.getIndexOfWorker("7", workers);
		//System.out.println(windex+"jjjj");
		worker w=workers.get(windex);
	    boolean isexist=worker.IsProductExist1("20", w, workers);
	    assertEquals(isexist,false);
	}

}
