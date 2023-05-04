package carpetcleaning;

import java.util.ArrayList;
import java.util.List;

public class Customer extends Person {
	private String id;
	private String phone;
	private String address;
	private String email;
	private int money = 0;
	private int debt = 0;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getDebt() {
		return debt;
	}

	public void setDebt(int debt) {
		this.debt = debt;
	}

	private List<Product> productsForCusomer = new ArrayList<>();

	public Customer() {
		super();
		this.setType("customer");
	}

	public Customer(Person pers, String id, String phone, String address) {
		super();
		this.id = id;
		this.setName(pers.getName());
		this.setPassword(pers.getPassword());
		this.phone = phone;
		this.address = address;
		this.setType("customer");
	}

	public List<Product> getProductsForCusomer() {
		return productsForCusomer;
	}

	public static void deleteProduct(String code, Customer customer) {
		int index = customer.getIndexForProduct(code, customer.productsForCusomer);
		customer.productsForCusomer.remove(index);
	}

	public void setProductsForCusomer(List<Product> productsForCusomer) {
		this.productsForCusomer = productsForCusomer;
	}

	public void addProduct(Product pro) {
		this.productsForCusomer.add(pro);
	}

	public String getId() {
		return id;
	}

	public void setId(String id2) {
		this.id = id2;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public static int getIndexx(String id, List<Customer> customers) {
		int index = -1;

		for (int i = 0; i < customers.size(); i++) {
			if (customers.get(i).id.equalsIgnoreCase(id)) {
				return i;
			}
		}

		return index;
	}

	public static boolean isExistCustomer(String id2, List<Customer> customers) {
/*		if (getIndexx(id2, customers) == -1) {

			return false;
		}

		return true;
	}*/
	return (getIndexx(id2, customers) != -1);
	}

	///// This part for product check

	public int getIndexForProduct(String code, List<Product> productsForCusomer2) {
		int index = -1;

		for (int i = 0; i < productsForCusomer2.size(); i++) {

			if (productsForCusomer2.get(i).getCode().equalsIgnoreCase(code)) {

				return i;
			}
		}

		return index;
	}

	public static boolean checkIsExist1(String code, Customer customer) {
		if (customer.getIndexForProduct(code, customer.productsForCusomer) == -1) {

			return false;
		}

		return true;
	}

	public static void deleteProduct(String code, Customer customer, List<Worker> workers) {
		int index = customer.getIndexForProduct(code, customer.productsForCusomer);
		int pid = customer.getIndexForProduct(code, customer.getProductsForCusomer());
		Product pro = customer.getProductsForCusomer().get(pid);

		int wID = Worker.getIndexOfWorker(pro.getResponsibleWorkerId(), workers);
		System.out.println(wID);
		Worker w = workers.get(wID);
		Worker.deleteProductToWorker(pro, w.getId(), workers);
		customer.productsForCusomer.remove(index);

	}

/////This part for product check

	public static void createCustomer(Customer cust, List<Customer> customers) {
		customers.add(cust);
	}

	public static void deleteCustomer(String id2, List<Customer> customers) {
		int index = getIndexx(id2, customers);
		customers.remove(index);
	}

	public static void updatePhone(String id2, String newPhone, ArrayList<Customer> customers) {
		int index = Customer.getIndexx(id2, customers);
		customers.get(index).setPhone(newPhone);

	}

	public static void updateAdress(String id2, String newAdress, ArrayList<Customer> customers) {
		int index = Customer.getIndexx(id2, customers);
		customers.get(index).setAddress(newAdress);

	}

	public void addProduct(Product pro, List<Worker> workers) {
		pro.setCustId(this.id);
		this.productsForCusomer.add(pro);

		Worker.distributeOrder(pro, workers);
	}

	public int getIndexforProduct(String code, List<Customer> customers) {
		int index = -1;

		for (int i = 0; i < this.productsForCusomer.size(); i++) {

			if (this.productsForCusomer.get(i).getCode().equals(code)) {

				return i;
			}
		}

		return index;
	}

	public static void updatepicture(String code, String nPicture, Customer customer) {

		int i = customer.getIndexForProduct(code, customer.getProductsForCusomer());
		customer.productsForCusomer.get(i).setPicture(nPicture);
	}

	public static void update_width(String code, String width, Customer cCust) {
		int i = cCust.getIndexForProduct(code, cCust.getProductsForCusomer());
		cCust.productsForCusomer.get(i).setwidth(width);
	}

	public static void update_Length(String code, String length, Customer cCust) {
		int i = cCust.getIndexForProduct(code, cCust.getProductsForCusomer());
		cCust.productsForCusomer.get(i).setLength(length);
	}

	public static int WaitingProduct(Customer cust) {
		int num = 0;
		for (int i = 0; i < cust.getProductsForCusomer().size(); i++) {
			if (cust.getProductsForCusomer().get(i).getStatus().equalsIgnoreCase("waiting")) {
				num++;
			}
		}
		return num;
	}

	public static int inTreatmentProduct(Customer cust) {
		int num = 0;
		for (int i = 0; i < cust.getProductsForCusomer().size(); i++) {
			if (cust.getProductsForCusomer().get(i).getStatus().equalsIgnoreCase("in treatment")) {
				num++;
			}
		}
		return num;
	}

	/// for price
	public static int getPrice(String code, Customer cCust) {

		int i = cCust.getIndexForProduct(code, cCust.getProductsForCusomer());
		int w = cCust.productsForCusomer.get(i).getWidth();
		int l = cCust.productsForCusomer.get(i).getLength();

		return l * w * 25;

	}

	public static boolean check_price(int p) {
		return p >= 550;
	}

	public static int getTotalPrice(Customer cust) {
		int total = 0;
		for (int i = 0; i < cust.productsForCusomer.size(); i++) {
			total += getPrice(cust.productsForCusomer.get(i).getCode(), cust);
		}
		return total;
	}

	public static int discount(int totalPrice, int dis, Customer cust) {
		int disc = (totalPrice * dis) / 100;
		int Discounted_price = totalPrice - disc;
		return Discounted_price;
	}
}
