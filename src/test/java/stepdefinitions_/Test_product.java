package stepdefinitions_;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import mypackage.customer;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mypackage.product;
import mypackage.customer;


public class Test_product {
	
	product Pro=new product();
	customer Customer;

	public boolean act;
    public boolean predict;
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
	  	product.record_product(Pro);
	}

	@Then("customer record product with code {string} successfully")
	public void customer_record_product_with_code_successfully(String code) {
	/*predict=false;
		act=Pro.check_is_exist(code);
        assertEquals(predict,act);*/
		
		assertFalse(Pro.check_is_exist(code));
	}
	

@When("product with code {string} already exist")
public void product_with_code_already_exist(String Code) 
{
  
      Pro.check_is_exist(Code);
}

@Then("record product with code {string} is faild")
public void record_product_with_code_is_faild(String code) {
	
	assertTrue(Pro.check_is_exist(code));
}

/*
@When("customer delete product with code {string}")
public void customer_delete_product_with_code(String Str) 
{
   Pro.delete_product(Str);
	
	
}
@Then("product with code {string} deleted successfully")
public void product_with_code_deleted_successfully(String S) 
{
    predict=false;
	act=Pro.check_is_exist(S);
    assertEquals(predict,act);    

}
*/
}
















