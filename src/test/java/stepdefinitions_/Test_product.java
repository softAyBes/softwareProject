package stepdefinitions_;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import mypackage.customer;
import mypackage.person;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mypackage.product;
import mypackage.customer;


public class Test_product {

	public boolean act;
    public boolean predict;
	product Pro=new product();
	customer Customer;
	public static ArrayList<customer> customers= new ArrayList<customer>();
	@Before public void createOutputFile() {
		person pers1=new person("Ayabaara","123456","3");
		customer c2=new customer(pers1,"3", "059967", "Arsad");
		product pro1=new product();
		pro1.setName_p("nn");
		pro1.setStatus("waiting");
		pro1.setCode("20");
		c2.getProductsForCusomer().add(pro1);  
		product pro2=new product();
		pro2.setName_p("B");
		pro2.setStatus("waiting");
		pro2.setCode("12");
		c2.getProductsForCusomer().add(pro2);  

		
		if(!customer.isExist(c2.getId(),customers)) {
		customers.add(c2);
		}
		
		
	}

	@Given("that the user type is {string}")
	public void that_the_user_type_is(String Type)
	{
		 Customer=new customer();
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
		
		int index =customer.getIndex("3",customers);
		Customer=customers.get(index);
		Customer.addProduct(Pro);
	}

	@Then("customer record product with code {string} successfully")
	public void customer_record_product_with_code_successfully(String code) {
	/*predict=false;
		act=Pro.check_is_exist(code);
        assertEquals(predict,act);*/
		assertTrue(customer.check_is_exist_1(code,Customer));
	}
	

@When("product with code {string} already exist")
public void product_with_code_already_exist(String Code) 
{
	int index =customer.getIndex("3",customers);
	Customer=customers.get(index);
	customer.check_is_exist_1(Code,Customer);
}

@Then("record product with code {string} is faild")
public void record_product_with_code_is_faild(String code) {
	
	assertTrue(customer.check_is_exist_1(code,Customer));
}

@When("product code {string} is not exist")
public void product_code_is_not_exist(String Code)
{
	customer.check_is_exist_1(Code,Customer);
	
}

@Then("delete product {string} faild")
public void delete_product_faild(String Code) 
{
	int index =customer.getIndex("3",customers);
	Customer=customers.get(index);
    assertFalse(customer.check_is_exist_1(Code,Customer));
}

@When("customer id {string} want to delete product code {string}")
public void customer_id_want_to_delete_product_code(String id, String CODE) 
{
	int index =customer.getIndex("3",customers);
	Customer=customers.get(index);
	 if(customer.check_is_exist_1(CODE,Customer))
	 {
		 customer.delete_product(CODE,Customer);
	 }
}


@Then("delete product {string} successfully")
public void delete_product_successfully(String CODE) 
{
	 boolean A = customer.check_is_exist_1(CODE,Customer);
	 boolean E=false;
	  assertEquals(A,E);
	//assertTrue(customer.delete_product(CODE,Customer));
}


@When("customer want to Update product {string} with new picture {string}")
public void customer_want_to_update_product_with_new_picture(String Code, String picture) 
{

	int index =customer.getIndex("3",customers);
	Customer=customers.get(index);
	customer.updatepicture(Code,picture,Customer);
	
}

@Then("product picture code {string} Update successfully")
public void product_picture_code_update_successfully(String Code) 
{
	 boolean A = customer.check_is_exist_1(Code,Customer);
	 boolean E=true;
	  assertEquals(A,E);   
}


@When("customer want to Update product {string} with new Length {string}")
public void customer_want_to_update_product_with_new_length(String code, String Length) 
{
       int i=customer.getIndex("3",customers);
       Customer=customers.get(i);
       customer.update_Length(code,Length,Customer);
}

@When("customer want to Update product {string} with new width {string}")
public void customer_want_to_update_product_with_new_width(String code, String width) 
{

	  int i=customer.getIndex("3",customers);
      Customer=customers.get(i);
      customer.update_width(code,width,Customer);
}
	
}

















