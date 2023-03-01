package stepdefinitions_;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mypackage.product;


public class Test_product {
	
	product Pro=new product();

     @Given("that admin record a product to a customer with id {string}")
     public void that_admin_record_a_product_to_a_customer_with_id(String customer_id)
     {
    	 Pro.cust.setId(customer_id);	
    	 
     }

@When("the product has a code {string} name {string} and picture {string} and Length {int} and width {int} and material {string}")
public void the_product_has_a_code_name_and_picture_and_length_and_width_and_material(String product_Code, String product_name, 
		String product_picture, Integer product_length, Integer product_width, String product_material) {
  
	Pro.setName_p(product_Code);
	Pro.setName_p(product_name);
	Pro.setPicture(product_picture);
	Pro.setLength(product_length);
	Pro.setWidth(product_width);
	Pro.setMaterial(product_material);
}

@When("customer have a id {string} exist")
public void customer_have_a_id_exist(String customer_id) 
{
	assertTrue(Pro.cust.checkDublicate(Pro.cust.getId()));

}

@Then("record product successfully")
public void record_product_successfully() 
{	
	  product.addtoproductList(Pro);
	  assertTrue(true);
}

@When("the customer with id {string} is not exist")
public void the_customer_with_id_is_not_exist(String customer_id)
{
	assertFalse(Pro.cust.checkDublicate(Pro.cust.getId()));
}

@Then("record product failed")
public void record_product_failed() 
{
	 assertFalse(false);
}

@Given("that admin delete a product with code {string}")
public void that_admin_delete_a_product_with_code(String product_Code)
{

	
}

@When("admin enter the product code {string}")
public void admin_enter_the_product_code(String product_Code) 
{
  
}

@When("product code {string} is not exist")
public void product_code_is_not_exist(String string) 
{
  
}

@Then("delete product faild")
public void delete_product_faild() 
{

}

@When("product code {string} is exist")
public void product_code_is_exist(String string) 
{ 
     assertTrue(Pro.checkisexist(Pro.getcode()));
}

@Then("delete product successfully")
public void delete_product_successfully()
{

	
	
}
@Given("admin want to update product with code {string} and product is exist")
public void admin_want_to_update_product_with_code_and_product_is_exist(String string)
{
   
	
}

@When("admin enter {string}")
public void admin_enter(String string) 
{

	
	
}
@Then("product updated successfully")
public void product_updated_successfully() 
{

	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	///////////////////////
/*
	product Pro=new product();
	@Given("that admin record a product to a customer with id {String}")
	public void that_admin_record_a_product_to_a_customer_with_id(String customer_id) 
	{
		Pro.cust.setId(customer_id);
	}

	@When("the product has a name {string} and picture {string} and Length {int} and width {int} and material {string}")
	public void the_product_has_a_name_and_picture_and_length_and_width_and_material
	(String product_name, String product_picture,Integer product_length, Integer product_width, String product_material)
	{
	Pro.setName_p(product_name);
	Pro.setPicture(product_picture);
	Pro.setLength(product_length);
	Pro.setWidth(product_width);
	Pro.setMaterial(product_material);
	}

	@When("customer have a id {String} exist")
	public void customer_have_a_id_exist(String customer_id )
	{
		assertTrue(Pro.cust.checkDublicate(Pro.cust.getId()));
	}
	@Then("record product successfully")
	public void record_product_successfully() 
	{
	  product.addtoproductList(Pro);
	  assertTrue(true);
	}

	
	@When("the customer with id {String} is not exist")
	public void the_customer_with_id_is_not_exist(String customer_id)
	{
		assertFalse(Pro.cust.checkDublicate(Pro.cust.getId()));
	}

	@Then("record product failed")
	public void record_product_failed()
	{
	 
		
	}

	
	*/
	
	
	
	
}