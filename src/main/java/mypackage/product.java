package mypackage;
import java.util.ArrayList;
import java.util.List;
import mypackage.customer;
public class product {
	//hehehe
	private String name_p;
	private String Code;
	private String picture;
	private String material;
	private int Length;
	private int width;
	
	public customer cust= new customer();
	productList proList=new productList();
	
	public String getName_p() 
	{
		return name_p;
	}
	public void setName_p(String name_p) 
	{
		this.name_p = name_p;
	}
	public String getPicture()
	{
		return picture;
	}
	public void setPicture(String picture) 
	{
		this.picture = picture;
	}
	public String getMaterial() 
	{
		return material;
	}
	public void setMaterial(String material)
	{
		this.material = material;
	}
	public int getLength() 
	{
		return Length;
	}
	public void setLength(int length) 
	{
		Length = length;
	}
	public int getWidth() 
	{
		return width;
	}
	public void setWidth(int width)
	{
		this.width = width;
	}

	public static void addtoproductList(product pro) {
		// TODO Auto-generated method stub
		
		productList.Products.add(pro);
	}
	public String getcode() {
		// TODO Auto-generated method stub
		return Code;
	}
	public boolean checkisexist(String getcode) 
	{
		
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	

}
