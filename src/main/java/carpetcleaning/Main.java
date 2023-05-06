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

////customer1
		Person pers1 = new Person("aya", "123", "3", "customer");
		Customer c2 = new Customer(pers1, "3", "059967", "Arsad");
		c2.setEmail("ayabaara4@gmail.com");

///// customer2
		Person pers11 = new Person("beesan", "123", "8", "customer");
		Customer c22 = new Customer(pers11, "8", "58585", "Rafidya");
		c22.setEmail("ayabaara4@gmail.com");

// admin
		Person adm1 = new Person("admin1", "admin123", "5", "admin");

///worker1
		Person work1 = new Person("worker1", "work123", "6", "worker");
		Worker worker1 = new Worker(work1, "6", "05987", "2000", "nablus");
///worker2
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

/// 3 products for cust1
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

	public static void printArray() {
		for (int i = 0; i < customers.size(); i++) {
			logger.log(Level.INFO, customers.get(i).getId());
		}
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
		System.out.println();

		logger.log(Level.INFO,
				"ID \tName \tAddress \t \tpro_code \tpro_Name \tpro_Material \tpro_Category  \tpro_Length \tpro_Width \tIsspecial ");

		if (!customers2.isEmpty()) {
			for (int i = 0; i < customers2.size(); i++) {
				System.out.print(customers2.get(i).getId() + "\t" + customers2.get(i).getName() + "\t"
						+ customers2.get(i).getAddress());
				if (customers2.get(i).getProductsForCusomer().isEmpty()) {
					System.out.println();
					System.out.println("\t");
				}
				for (int j = 0; j < customers2.get(i).getProductsForCusomer().size(); j++) {

					System.out.println("\t" + "\t" + "\t" + customers2.get(i).getProductsForCusomer().get(j).getCode()
							+ "\t" + "\t" + customers2.get(i).getProductsForCusomer().get(j).getNamePro() + "\t" + "\t"
							+ customers2.get(i).getProductsForCusomer().get(j).getMaterial() + "\t" + "\t"
							+ customers2.get(i).getProductsForCusomer().get(j).getCategory() + "\t" + "\t"
							+ customers2.get(i).getProductsForCusomer().get(j).getLength() + "\t" + "\t"
							+ customers2.get(i).getProductsForCusomer().get(j).getWidth() + "\t" + "\t"
							+ customers2.get(i).getProductsForCusomer().get(j).getIsspecial());

				}
				System.out.println(
						"------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			}
		}
	}

	public static void generateInvoice(String Id, int paying, List<Customer> customers2)

	{
		int totelPrice = 0;

		System.out.println("---------------------------Invoice----------------------------------------");
		System.out.println("------------------------Cleaning Services---------------------------------");
		int index = 0;
		if (!customers2.isEmpty()) {
			for (int i = 0; i < customers2.size(); i++) {
				if (customers2.get(i).getId().equalsIgnoreCase(Id)) {
					System.out.print("Customer ID :     " + customers.get(i).getId());
					System.out.print("\n");
					System.out.print("Customer Name :   " + customers.get(i).getName());
					System.out.print("\n");
					System.out.print("Customer Address :" + customers.get(i).getAddress());
					System.out.print("\n");
					System.out.print("Customer Phone :  " + customers.get(i).getPhone());
					System.out.print("\n");
					index = i;

					for (int j = 0; j < customers2.get(i).getProductsForCusomer().size(); j++) {

						System.out.print("\n");
						System.out.print(
								"Product Name :    " + customers.get(i).getProductsForCusomer().get(j).getNamePro());
						System.out.print("\n");
						System.out.print(
								"Product code :    " + customers.get(i).getProductsForCusomer().get(j).getCode());
						System.out.print("\n");
						String k = customers2.get(i).getProductsForCusomer().get(j).getCode();
						int price = Customer.getPrice(k, customers2.get(i));
						System.out.println("Price of product :" + price);
						System.out.print("\n");
						totelPrice = totelPrice + price;
						System.out.print("\n");

					}

					if (totelPrice >= paying) {

						int T = 0;
						int money = 0;

						System.out.print("Totel Cash :" + paying);
						System.out.print("\n");

						System.out.print("Totel Price :" + totelPrice);
						System.out.print("\n");
						money = Customer.getTotalPrice(customers2.get(index));
						int moneyAfterDis = Customer.discount(money, 15);
						System.out.print("Totel Price after discount :" + moneyAfterDis);

						System.out.print("\n");
						T = moneyAfterDis - paying;
						System.out.print("Total debts  :" + T);
						System.out.print("\n");

						Main.customers.get(index).setDebt(T);
						Main.customers.get(index).setMoney(paying);

					}

				}
			}
		}

	}

	public static void showAllWorkerDetails(List<Worker> workers2) {

		System.out.println("-------------Report about worker details-----------------");
		System.out.println();
		System.out.println("ID \t \tName \t \tAddress   \tSalary  \tPhone  ");
		if (!workers2.isEmpty()) {
			for (int i = 0; i < workers2.size(); i++) {
				System.out.print(workers2.get(i).getId() + "\t" + "\t" + workers2.get(i).getName() + "\t" + "\t"
						+ workers2.get(i).getAddress() + "\t" + "\t" + workers2.get(i).getSalary() + "\t" + "\t"
						+ workers2.get(i).getPhone());
				System.out.println();
			}
		}

	}

}