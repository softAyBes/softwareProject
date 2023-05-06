package carpetcleaning;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

	protected static final List<Customer> customers = new ArrayList<>();
	protected static final List<Person> persons = new ArrayList<>();
	protected static final List<Worker> workers = new ArrayList<>();
	protected static Person uesr;
	protected static int autoId = 4;
	private static final String CARPETWORD = "carpet";
	static Logger logger = Logger.getLogger(Main.class.getSimpleName());

	public static int setCutomers() {

		uesr = new Person();

		Person pers1 = new Person("aya", "123", "3", "customer");
		Customer c2 = new Customer(pers1, "3", "059967", "Arsad");
		c2.setEmail("ayabaara4@gmail.com");

		Person pers11 = new Person("beesan", "123", "8", "customer");
		Customer c22 = new Customer(pers11, "8", "58585", "Rafidya");
		c22.setEmail("ayabaara4@gmail.com");

		Person adm1 = new Person("admin1", "admin123", "5", "admin");

		Person work1 = new Person("worker1", "work123", "6", "worker");
		Worker worker1 = new Worker(work1, "6", "05987", "2000", "nablus");

		Person work2 = new Person("worker2", "work123", "7", "worker");

		Worker worker2 = new Worker(work2, "7", "05987", "3500", "hebron");

		persons.add(pers1);
		persons.add(adm1);
		persons.add(work1);
		persons.add(work2);

		String id = "3";
		if (!Customer.isExistCustomer(id, customers)) {

			workers.add(worker2);
			workers.add(worker1);

			Product pro1 = new Product("carpet12", "100");
			pro1.setCategory("Carpets");
			pro1.setLength("5");
			pro1.setwidth("5");
			pro1.setMaterial("silk");
			pro1.setIsspecial("yes");
			pro1.setStatus("wating");

			c2.addProduct(pro1, workers);

			Product pro2 = new Product("Salon carpet", "110");
			pro2.setCategory(CARPETWORD);
			pro2.setLength("6");
			pro2.setwidth("4");
			pro2.setMaterial("wool");
			pro2.setIsspecial("NO");
			c2.addProduct(pro2, workers);

			Product pro3 = new Product("cover", "120");
			pro3.setCategory("Bed Cover");
			pro3.setLength("3");
			pro3.setwidth("4");
			pro3.setMaterial("Soft fleece");
			pro3.setIsspecial("NO");
			c2.addProduct(pro3, workers);

			Product pro4 = new Product(CARPETWORD, "150");
			pro4.setCategory(CARPETWORD);
			pro4.setLength("6");
			pro4.setwidth("5");
			pro4.setMaterial("fleece");
			pro4.setIsspecial("yes");
			c22.addProduct(pro4, workers);

			Product pro5 = new Product("Salon carpet", "170");
			pro5.setCategory(CARPETWORD);
			pro5.setLength("3");
			pro5.setwidth("2");
			pro5.setMaterial("leather");
			pro5.setIsspecial("NO");

			c22.addProduct(pro5, workers);

			Customer.createCustomer(c2, customers);
			Customer.createCustomer(c22, customers);

		}
		return 1;
	}

	public static int itemsNum(List<Customer> customers2) {
		int num = 0;
		for (int i = 0; i < customers2.size(); i++) {
			num += customers2.get(i).getProductsForCusomer().size();
		}
		return num;
	}

	public static int totalWaitingNum(List<Customer> customers2) {
		int num = 0;
		for (int i = 0; i < customers2.size(); i++) {
			num += Customer.waitingProduct(customers2.get(i));

		}
		return num;
	}

	public static int totalIntreatment(List<Customer> customers2) {
		int num = 0;
		for (int i = 0; i < customers2.size(); i++) {
			num += Customer.inTreatmentProduct(customers2.get(i));

		}
		return num;
	}

	public static int totalDebts(List<Customer> customers2) {
		int num = 0;
		for (int i = 0; i < customers2.size(); i++) {
			num += customers2.get(i).getDebt();

		}
		return num;
	}

	public static int totalMoney(List<Customer> customers2) {
		int num = 0;
		for (int i = 0; i < customers2.size(); i++) {
			num += customers2.get(i).getMoney();

		}
		return num;
	}

	public static void showAllCustomersDetails(List<Customer> customers2) {
		logger.log(Level.INFO, "-------------Report about customers details-----------------");
		logger.log(Level.INFO, "");

		logger.log(Level.INFO,
				"ID \tName \tAddress \t \tpro_code \tpro_Name \tpro_Material \tpro_Category  \tpro_Length \tpro_Width \tIsspecial ");

		if (!customers2.isEmpty()) {
			for (int i = 0; i < customers2.size(); i++) {
				logger.log(Level.INFO, customers2.get(i).getId());
				if (customers2.get(i).getProductsForCusomer().isEmpty()) {
					logger.log(Level.INFO, "");
					logger.log(Level.INFO, "\t");

				}
				for (int j = 0; j < customers2.get(i).getProductsForCusomer().size(); j++) {

					logger.log(Level.INFO, "\t");

				}
				logger.log(Level.INFO,
						"------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			}
		}
	}

	public static void generateInvoice(String Id, int paying, List<Customer> customers2)

	{
		int totelPrice = 0;

		logger.log(Level.INFO, "---------------------------Invoice----------------------------------------");
		logger.log(Level.INFO, "------------------------Cleaning Services---------------------------------");
		int index = 0;
		if (!customers2.isEmpty()) {
			for (int i = 0; i < customers2.size(); i++) {
				if (customers2.get(i).getId().equalsIgnoreCase(Id)) {
					logger.log(Level.INFO, "Customer ID :     " + customers.get(i).getId());
					logger.log(Level.INFO, "\n");
					logger.log(Level.INFO, "Customer Name :   " + customers.get(i).getName());
					logger.log(Level.INFO, "\n");
					logger.log(Level.INFO, "Customer Address :" + customers.get(i).getAddress());
					logger.log(Level.INFO, "\n");
					logger.log(Level.INFO, "Customer Phone :  " + customers.get(i).getPhone());
					logger.log(Level.INFO, "\n");
					index = i;

					for (int j = 0; j < customers2.get(i).getProductsForCusomer().size(); j++) {

						logger.log(Level.INFO, "\n");
						logger.log(Level.INFO,
								"Product Name :    " + customers.get(i).getProductsForCusomer().get(j).getNamePro());
						logger.log(Level.INFO, "\n");
						logger.log(Level.INFO,
								"Product code :    " + customers.get(i).getProductsForCusomer().get(j).getCode());
						logger.log(Level.INFO, "\n");
						String k = customers2.get(i).getProductsForCusomer().get(j).getCode();
						int price = Customer.getPrice(k, customers2.get(i));
						logger.log(Level.INFO, "Price of product :" + price);
						logger.log(Level.INFO, "\n");
						totelPrice = totelPrice + price;
						logger.log(Level.INFO, "\n");

					}

					if (totelPrice >= paying) {

						int T = 0;
						int money = 0;

						logger.log(Level.INFO, "Totel Cash :" + paying);
						logger.log(Level.INFO, "\n");

						logger.log(Level.INFO, "Totel Price :" + totelPrice);
						logger.log(Level.INFO, "\n");
						money = Customer.getTotalPrice(customers2.get(index));
						int moneyAfterDis = Customer.discount(money, 15);
						logger.log(Level.INFO, "Totel Price after discount :" + moneyAfterDis);

						logger.log(Level.INFO, "\n");
						T = moneyAfterDis - paying;
						logger.log(Level.INFO, ("Total debts  :" + T));
						logger.log(Level.INFO, "\n");

						Main.customers.get(index).setDebt(T);
						Main.customers.get(index).setMoney(paying);

					}

				}
			}
		}

	}

	public static void showAllWorkerDetails(List<Worker> workers2) {

		logger.log(Level.INFO, "-------------Report about worker details-----------------");
		logger.log(Level.INFO, "");
		logger.log(Level.INFO, "ID \t \tName \t \tAddress   \tSalary  \tPhone  ");
		if (!workers2.isEmpty()) {
			for (int i = 0; i < workers2.size(); i++) {
				logger.log(Level.INFO,
						workers2.get(i).getId() + "\t" + "\t" + workers2.get(i).getName() + "\t" + "\t"
								+ workers2.get(i).getAddress() + "\t" + "\t" + workers2.get(i).getSalary() + "\t" + "\t"
								+ workers2.get(i).getPhone());
				logger.log(Level.INFO, "");
			}
		}

	}

}