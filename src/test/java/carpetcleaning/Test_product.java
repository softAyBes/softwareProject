package carpetcleaning;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;


public class Test_product {

	public boolean act;
    public boolean predict;
	Product Pro=new Product();
	Customer Customer;
	public static ArrayList<Customer> customers= new ArrayList<Customer>();
	public static ArrayList<Worker> workers= new ArrayList<Worker>();

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
		pro1.setResponsibleWorkerId(w1.id);
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

	@Given("that the user type is {string}")
	public void that_the_user_type_is(String Type)
	{
		 Customer=new Customer();
	  if(Type.equals(Customer.getType())) 
		assertTrue(true);
	  
	}


@When("the product has a code {string} name {string} picture {string} isspecial {string} status {string} category {string} Length {string} width {string} material {string}")
public void the_product_has_a_code_name_picture_isspecial_status_category_length_width_material(String product_Code, String product_name, String product_picture, String isspecial, String status, String category, String product_length, String product_width, String product_material) {
	    
	    Pro.setCategory(category);
		Pro.setName_p(product_name);
		Pro.setCode(product_Code);
		Pro.setName_p(product_name);
		Pro.setPicture(product_picture);
		Pro.setIsspecial(isspecial);
		Pro.setStatus(status);
		Pro.setLength(product_length);
		Pro.setwidth(product_width);
		Pro.setMaterial(product_material);
		//Customer=new customer();
		
		int index =Customer.getIndexx("3",customers);
		Customer=customers.get(index);
		Customer.addProduct(Pro,Test_product.workers);
	}

	@Then("customer record product with code {string} successfully")
	public void customer_record_product_with_code_successfully(String code) {
	/*predict=false;
		act=Pro.check_is_exist(code);
        assertEquals(predict,act);*/
		assertTrue(Customer.checkIsExist1(code,Customer));
	}
	

@When("product with code {string} already exist")
public void product_with_code_already_exist(String Code) 
{
	int index =Customer.getIndexx("3",customers);
	Customer=customers.get(index);
	Customer.checkIsExist1(Code,Customer);
}

@Then("record product with code {string} is faild")
public void record_product_with_code_is_faild(String code) {
	
	assertTrue(Customer.checkIsExist1(code,Customer));
}

@When("product code {string} is not exist")
public void product_code_is_not_exist(String Code)
{
	Customer.checkIsExist1(Code,Customer);
	
}

@Then("delete product {string} faild")
public void delete_product_faild(String Code) 
{
	int index =Customer.getIndexx("3",customers);
	Customer=customers.get(index);
    assertFalse(Customer.checkIsExist1(Code,Customer));
}

@When("customer id {string} want to delete product code {string}")
public void customer_id_want_to_delete_product_code(String id, String CODE) 
{
	int index =Customer.getIndexx("3",customers);
	Customer=customers.get(index);
	 if(Customer.checkIsExist1(CODE,Customer))
	 {
		 Customer.deleteProduct(CODE,Customer,workers);
	 }
}


@Then("delete product {string} successfully")
public void delete_product_successfully(String CODE) 
{
	 boolean A = Customer.checkIsExist1(CODE,Customer);
	 boolean E=false;
	  assertEquals(A,E);
	//assertTrue(customer.delete_product(CODE,Customer));
}


@When("customer want to Update product {string} with new picture {string}")
public void customer_want_to_update_product_with_new_picture(String Code, String picture) 
{

	int index =Customer.getIndexx("3",customers);
	Customer=customers.get(index);
	Customer.updatePicture(Code,picture,Customer);
	
}

@Then("product picture code {string} Update successfully")
public void product_picture_code_update_successfully(String Code) 
{
	 boolean A = Customer.checkIsExist1(Code,Customer);
	 boolean E=true;
	  assertEquals(A,E);   
}



}
