
package carpetcleaning;

public class Product {

	private String namePro;
	private String code;
	private String picture;
	private String material;
	private int length;
	private int width;
	private String status;
	private String category;
	private String isSpecial;
	private String responsibleWorkerId;
	private String custId;

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public Product(String namePro, String code) {
		this.namePro = namePro;
		this.code = code;
		this.status = "waiting";

	}

	public String getResponsibleWorkerId() {
		return responsibleWorkerId;
	}

	public void setResponsibleWorkerId(String responsibleWorkerId) {
		this.responsibleWorkerId = responsibleWorkerId;
	}

	public Product() {
		status = "waiting";
	}

	public void setCategory(String category2) {
		category = category2;
	}

	public void setStatus(String status2) {
		status = status2;
	}

	public void setMaterial(String productMaterial) {
		material = productMaterial;
	}

	public void setName_p(String productName) {
		namePro = productName;
	}

	public void setLength(String productLength) {
		int L = Integer.parseInt(productLength);
		this.length = L;

	}

	public void setPicture(String productPicture) {
		// TODO Auto-generated method stub
		picture = productPicture;
	}

	public void setCode(String productCode) {
		// TODO Auto-generated method stub
		code = productCode;
	}

	public void setIsspecial(String isSpecial2) {
		// TODO Auto-generated method stub

		isSpecial = isSpecial2;

	}

	public void setwidth(String productWidth) {
		// TODO Auto-generated method stub
		int W = Integer.parseInt(productWidth);
		width = W;
	}

	public Integer getWidth() {
		return width;
	}

	public String getNamePro() {
		return namePro;
	}

	public String getPicture() {
		return picture;
	}

	public String getStatus() {
		return status;
	}

	public String getCode() {
		return code;
	}

	public String getMaterial() {
		return material;
	}

	public Integer getLength() {
		return length;
	}

	public String getCategory() {
		return category;
	}

	public String getIsspecial() {
		return isSpecial;
	}
}