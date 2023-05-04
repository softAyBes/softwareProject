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

	public void setProductsForCusomer(ArrayList<Product> productsForCusomer) {
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
		if (getIndexx(id2, customers) == -1) {

			return false;
		}

		return true;
	}

	///// This part for product check

	public int getIndexForProduct(String Code, List<Product> productsForCusomer2) {
		int index = -1;

		for (int i = 0; i < productsForCusomer2.size(); i++) {

			if (productsForCusomer2.get(i).getCode().equalsIgnoreCase(Code)) {

				return i;
			}
		}

		return index;
	}

	public static boolean checkIsExist1(String code, Customer Customer) {
		if (Customer.getIndexForProduct(code, Customer.productsForCusomer) == -1) {

			return false;
		}

		return true;
	}

	public static void deleteProduct(String Code, Customer Customer, List<Worker> workers) {
		int index = Customer.getIndexForProduct(Code, Customer.productsForCusomer);
		int pid = Customer.getIndexForProduct(Code, Customer.getProductsForCusomer());
		Product pro = Customer.getProductsForCusomer().get(pid);

		int WID = Worker.getIndexOfWorker(pro.getResponsibleWorkerId(), workers);
		System.out.println(WID);
		Worker w = workers.get(WID);
		Worker.deleteProductToWorker(pro, w.getId(), workers);
		Customer.productsForCusomer.remove(index);

	}

/////This part for product check

	public static void createCustomer(Customer cust, List<Customer> customers) {
		// TODO Auto-generated method stub
		customers.add(cust);
	}

	public static void deleteCustomer(String id2, List<Customer> customers) {
		// TODO Auto-generated method stub
		int index = getIndexx(id2, customers);
		customers.remove(index);
	}

	public static void updatePhone(String id2, String newPhone, ArrayList<Customer> customers) {
		// TODO Auto-generated method stub
		int index = Customer.getIndexx(id2, customers);
		customers.get(index).setPhone(newPhone);

	}

	public static void updateAdress(String id2, String newAdress, ArrayList<Customer> customers) {
		// TODO Auto-generated method stub
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

	public static void updatepicture(String code, String N_picture, Customer Customer) {

		int i = Customer.getIndexForProduct(code, Customer.getProductsForCusomer());
		Customer.productsForCusomer.get(i).setPicture(N_picture);
	}

	public static void update_width(String code, String width, Customer CCust) {
		int i = CCust.getIndexForProduct(code, CCust.getProductsForCusomer());
		CCust.productsForCusomer.get(i).setwidth(width);
	}

	public static void update_Length(String code, String length, Customer CCust) {
		int i = CCust.getIndexForProduct(code, CCust.getProductsForCusomer());
		CCust.productsForCusomer.get(i).setLength(length);
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
	public static int getPrice(String code, Customer CCust) {

		int i = CCust.getIndexForProduct(code, CCust.getProductsForCusomer());
		int w = CCust.productsForCusomer.get(i).getWidth();
		int l = CCust.productsForCusomer.get(i).getLength();

		return l * w * 25;

	}

	public static boolean check_price(int p) {
		return p >= 550;
	}

	public static int getTotalPrice(Customer CCust) {
		int total = 0;
		for (int i = 0; i < CCust.productsForCusomer.size(); i++) {
			total += getPrice(CCust.productsForCusomer.get(i).getCode(), CCust);
		}
		return total;
	}

	public static int discount(int total_price, int dis, Customer CCust) {
		int disc = (total_price * dis) / 100;
		int Discounted_price = total_price - disc;
		return Discounted_price;
	}
}