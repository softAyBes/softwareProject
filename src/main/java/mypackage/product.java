package mypackage;
import java.util.ArrayList;
import java.util.List;
import mypackage.customer;
public class product {
	
	private String name_p;
	private String Code;
	private String picture;
	private String material;
	private int Length;
	private int width;
	private String status;
	private String category;
	private String isspecial;
	
   // public customer cust= new customer();
	//productList proList=new productList();
	/*
    public static int get_Index(String code) {
		int index=-1;
		
		for(int i=0;i<productList.Products.size();i++) {
			
			if(productList.Products.get(i).Code.equalsIgnoreCase(code)) {
				
				return i;
			}
		}return index;
	}

	
    public boolean check_is_exist(String c2) {
		// TODO Auto-generated method stub
		// create common class contains all arrays list (customer, product ......)
		if(get_Index(c2)==-1)
		{
			
			return false;
		}
		
		return true;
		}

*/
	public void setCategory(String category2) {
		// TODO Auto-generated method stub
		category=category2;
	}


	public void setStatus(String status2) {
		// TODO Auto-generated method stub
		status=status2;
	}


	public void setMaterial(String product_material) {
		// TODO Auto-generated method stub
		material=product_material;
	}


	public void setName_p(String product_name) {
		// TODO Auto-generated method stub
		name_p=product_name;
	}


	public  void setLength(String product_length) {
		// TODO Auto-generated method stub 
		int L=Integer.parseInt(product_length);
		L=Length;
	}


	public void setPicture(String product_picture) {
		// TODO Auto-generated method stub
	picture=product_picture;
	}


	public void setCode(String product_Code) {
		// TODO Auto-generated method stub
	Code=product_Code;
	}


	public void setIsspecial(String isspecial2) {
		// TODO Auto-generated method stub
		
		isspecial=isspecial2;
		
	}


	public void setwidth(String product_width) {
		// TODO Auto-generated method stub
	     int W=Integer.parseInt(product_width);
		width=W;
	}

	public Integer getWidth() {
		return width;
	}


	public String getName_p() {
		return name_p;
	}


	public String getPicture() {
		return picture;
	}


	public String getStatus() {
		return status;
	}


	public String getCode() {
		return Code;
	}


	public String getMaterial() {
		return material;
	}


	public Integer getLength() {
		return Length;
	}


	public String getCategory() {
		return category;
	}


	public String getIsspecial() {
		return isspecial;
	}
	/*
	public static int Price()
	{
		
	}
	
*/
/*
	public static void record_product(product pro) 
	
	{
		productList.Products.add(pro);
	}
*/

    /*
public void delete_product(String str)
	{
		int i=get_Index(str);
		productList.Products.remove(i);
		
	}
}
	
	
	
	*/
}