package carpetcleaning;

import java.util.ArrayList;
import java.util.List;

public class Worker extends Person {
	private String phone;
	private String address;
	private String salary;
	String id;

	private List<Product> productsForWorker = new ArrayList<>();

	public Worker(Person work1) {
		// TODO Auto-generated constructor stub
		this.id = work1.getId_person();

	}

	public Worker(Person pers4, String string, String string2, String string3, String string4) {
		this.setName(pers4.getName());
		this.setId(string);
		this.setPhone(string2);
		this.setSalary(string3);
		this.setAddress(string4);

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public List<Product> getProductsForWorker() {
		return productsForWorker;
	}

	public void setProductsForWorker(ArrayList<Product> productsForWorker) {
		this.productsForWorker = productsForWorker;
	}

	public static String updateStatusCustomer(String code, String id, String newStatus, List<Customer> customers) {
		Customer cust = new Customer();
		int CustomerIndex = Customer.getIndexx(id, customers);
		cust = customers.get(CustomerIndex);
		int productIndex = cust.getIndexProduct(code);
		customers.get(CustomerIndex).getProductsForCusomer().get(productIndex).setStatus(newStatus);
		return customers.get(CustomerIndex).getProductsForCusomer().get(productIndex).getStatus();
	}

	////// to distribute products over workers
	public int getNumInTreatment() {
		int count = 0;
		for (int j = 0; j < this.getProductsForWorker().size(); j++) {
			if (this.getProductsForWorker().get(j).getStatus().equalsIgnoreCase(" in treatment")
					|| this.getProductsForWorker().get(j).getStatus().equalsIgnoreCase("waiting")) {
				count++;
			}

		}
		return count;

	}

	public static Worker getWorkerForOrder(List<Worker> workers) {
		Worker min = workers.get(0);
		int count = min.getNumInTreatment();
		for (int i = 0; i < workers.size(); i++) {
			if (workers.get(i).getNumInTreatment() < count) {
				min = workers.get(i);
			}
		}

		return min;
	}

	public static int getIndexOfWorker(String id, List<Worker> workers) {
		int index = -1;
		for (int i = 0; i < workers.size(); i++) {
			if (workers.get(i).id.equalsIgnoreCase(id)) {
				return i;
			}
		}

		return index;
	}

	public static int getIndexOfProduct(String id, Worker w, List<Worker> workers) {
		int index = -1;
		int wIndex = Worker.getIndexOfWorker(w.getId(), workers);
		Worker ww = workers.get(wIndex);
		for (int i = 0; i < ww.getProductsForWorker().size(); i++) {
			if (ww.getProductsForWorker().get(i).getCode().equalsIgnoreCase(id)) {
				return i;
			}
		}

		return index;
	}

	public static boolean isProductExist(String id, Worker w, ArrayList<Worker> workers) {
		int i = getIndexOfProduct(id, w, workers);
		if (i == -1)
			return false;
		return true;
	}

	public static void distributeOrder(Product pro, List<Worker> workers) {
		Worker w = getWorkerForOrder(workers);
		pro.setResponsibleWorkerId(w.getId());
		int index = Worker.getIndexOfWorker(w.getId(), workers);
		workers.get(index).productsForWorker.add(pro);

	}

	public static void addProductToWorker(Product pro, Worker w1, ArrayList<Worker> workers) {

		int index = Worker.getIndexOfWorker(w1.getId(), workers);
		workers.get(index).productsForWorker.add(pro);

	}

	public static void deleteProductToWorker(Product pro, String wID1, List<Worker> workers) {
		int wIndex = Worker.getIndexOfWorker(wID1, workers);

		Worker w = workers.get(wIndex);

		int pIndex = Worker.getIndexOfProduct(pro.getCode(), w, workers);

		workers.get(wIndex).productsForWorker.remove(pIndex);

	}

}
