
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

	public void setNamePro(String productName) {
		namePro = productName;
	}

	public void setLength(String productLength) {
		this.length = Integer.parseInt(productLength);

	}

	public void setPicture(String productPicture) {
		picture = productPicture;
	}

	public void setCode(String productCode) {
		code = productCode;
	}

	public void setIsspecial(String isSpecial2) {

		isSpecial = isSpecial2;

	}

	public void setwidth(String productWidth) {
		
		width = Integer.parseInt(productWidth);
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