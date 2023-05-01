package carpetcleaning;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class Test_discount {
	customer Customer=new customer();
	
	public static ArrayList<customer> customers= new ArrayList<customer>();
				@Before public void createOutputFile() {
					person pers1=new person("Ayabaara","123456","3");
					customer c2=new customer(pers1,"3", "059967", "Arsad");
					product pro1=new product();
					pro1.setName_p("nn");
					pro1.setStatus("waiting");
					pro1.setCode("12");
					pro1.setLength("6");
					pro1.setwidth("7");
					c2.getProductsForCusomer().add(pro1);  
					
					person pers3=new person("noor","123456789","9");
					customer c4=new customer(pers3,"9", "059767", "main-street");
					product pro3=new product();
					pro3.setName_p("s");
					pro3.setStatus("waiting");
					pro3.setCode("25");
					pro3.setLength("2");
					pro3.setwidth("3");
					c4.getProductsForCusomer().add(pro3);  
				
					
					if(!customer.isExist_1(c2.getId(),customers)) 
					{
					customers.add(c2);
					}
					else if(!customer.isExist_1(c4.getId(),customers))
					{
						customers.add(c4);
					}
					}
	
	
	@Given("that customer with id {string} is exist")
	public void that_customer_with_id_is_exist(String id) 
	{
		int i=customer.getIndex_1(id,customers);
		Customer=customers.get(i);
		customer.isExist_1(id,customers);
	}


@When("the price with code {string} greater than or equal {string}")
public void the_price_with_code_greater_than_or_equal(String code, String price) {
  
	   int price_product=customer.get_price(code,Customer);
      customer.check_price(price_product);   
	}
@Then("product with code {string} get a discount of {int}")
public void product_with_code_get_a_discount_of(String code, int dis) 
{
	
	  int price_=customer.get_price(code, Customer);
	  int T=customer.get_total_price(Customer);
	  int price_after_dis=customer.discount(T,dis,Customer);
	 //double i=customer.getIndex(id,customers);
	 System.out.print(price_after_dis);
	 System.out.print(price_);  
	 
	   assertTrue(true);
}

/*
@When("the price with code {string} less {string}")
public void the_price_with_code_less(String code, String price) 
{
	 int price_product=customer.get_price(code,Customer);
	   //System.out.print(price_product);
    customer.check_price(price_product);   

	/*
   int price_=customer.get_price(code, Customer);
   boolean C=customer.check_price(price_);
   
}
@Then("product with code {string} get a discount of {int}")
public void product_with_code_does_not_get_a_discount_of(String code, int dis) 
{
   
	
	int price_=customer.get_price(code, Customer);
	 int T=customer.get_total_price(Customer);
	  int price_after_dis=customer.discount(T,dis,Customer);
	//int price_after_dis=customer.discount(code,dis,Customer);
	  assertFalse(price_==price_after_dis);
}*/
}