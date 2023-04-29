
package carpetcleaning;


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
	private String responsibleWorkerId;
	private String custId;
	
	
	public String getCustId() {
		return custId;
	}
	public void setCustId(String custId) {
		this.custId = custId;
	}
	public product(String name_p,String Code) {
		this.name_p=name_p;
		this.Code=Code;
		this.status="waiting";
		
	}
	public String getResponsibleWorkerId() {
		return responsibleWorkerId;
	}
	public void setResponsibleWorkerId(String responsibleWorkerId) {
		this.responsibleWorkerId = responsibleWorkerId;
	}
	public product() {
		status="waiting";
	}
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
		L=this.Length;
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
}