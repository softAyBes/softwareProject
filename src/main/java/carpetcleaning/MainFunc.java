package carpetcleaning;

import java.util.Scanner;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainFunc {
	static Person user = new Person();
	final static String NOPRODUC = "No product with this id";
	Main main = new Main();

	static SendEmaill email = new SendEmaill();

	public static void main(String[] args) {
		 
		final String validNum="Enter valid number";
		int x;
		String in;
		Main.setCutomers();
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		String name, password;
		int logged = 0;
		String stat;
		Logger logger = Logger.getLogger(MainFunc.class.getSimpleName());

		logger.log(Level.INFO, "\n");

		logger.log(Level.INFO, "|						Welcome to  carpet cleaning foundation						|");
		logger.log(Level.INFO, "\n");

		while (logged == 0) {
			logger.log(Level.INFO, "");
			logger.log(Level.INFO, "|						        Enter you username						        |");
			logger.log(Level.INFO,
					"|_______________________________________________________________________________________________________________________________|");
			name = input.nextLine();
			logger.log(Level.INFO,
					"|						        Enter you user password						        |");
			password = input.nextLine();
			stat = Admin.login(name, password,Main.persons);
			if (stat.equals("false")) {
				logged = 0;
				logger.log(Level.INFO, "|						        Login faild						        |");

			} else {
				logged = 1;
				user = Main.persons.get(Person.getIndex(name, Main.persons));
				user.setIdPerson(Person.getIdFromName(name, Main.persons));
				logger.log(Level.INFO,
						"|______________________________________________________________________________________________________________________________|");
				logger.logp(Level.INFO, "|                                                Welcome Back ",
						user.getName(), "                                              |");
				logger.log(Level.INFO, "\n");
				logger.log(Level.INFO, "\n");
				logger.log(Level.INFO, "\n");
			}

			if (stat.equalsIgnoreCase("admin")) {
				while (logged == 1) {
					x = 0;
					logger.log(Level.INFO, "press 1. To add new customer ");
					logger.log(Level.INFO, "\n");
					logger.log(Level.INFO, "      2. To Delete customer ");
					logger.log(Level.INFO, "\n");
					logger.log(Level.INFO, "      3. To get statistic ");
					logger.log(Level.INFO, "\n");
					logger.log(Level.INFO, "      4. To generate reports  ");
					logger.log(Level.INFO, "\n");
					logger.log(Level.INFO, "      5. To generate invoice  ");
					logger.log(Level.INFO, "\n");
					logger.log(Level.INFO, "      0. log out ");
					x = input.nextInt();
					if (x == 1) {

						Customer cust = new Customer();
						in = input.nextLine();
						logger.log(Level.INFO, " Enter Information : ID");
						in = input.nextLine();
						if (Customer.isExistCustomer(in, Main.customers)) {
							logger.log(Level.INFO, "this Id already exist");
							logger.log(Level.INFO, "\n");
						} else {
							cust.setId(in);
							cust.setIdPerson(in);
							logger.log(Level.INFO, "Name");
							in = input.nextLine();
							cust.setName(in);

							logger.log(Level.INFO, "phone");
							in = input.nextLine();
							cust.setPhone(in);

							logger.log(Level.INFO, "Address");
							in = input.nextLine();
							cust.setAddress(in);

							logger.log(Level.INFO, "Email");
							in = input.nextLine();
							cust.setEmail(in);
							Customer.createCustomer(cust, Main.customers);
							logger.log(Level.INFO, " Added successfully");

						}

					} else if (x == 2) {
						logger.log(Level.INFO, " What ID you want to delete");
						in = input.nextLine();
						in = input.nextLine();
						if (!Customer.isExistCustomer(in, Main.customers)) {
							logger.log(Level.INFO, "No customer with this id");
							logger.log(Level.INFO, "\n");
							logger.log(Level.INFO, "\n");
						} else {
							Customer.deleteCustomer(in, Main.customers);
							logger.log(Level.INFO, " Deleted successfully");

						}
					}

					else if (x == 3) {
						logger.log(Level.INFO, " 		enter 1 to get total number of products");
						logger.log(Level.INFO, " 		enter 2 to get total number of waiting products");
						logger.log(Level.INFO, " 		enter 3 to get total number of in treatment products");
						logger.log(Level.INFO, " 		enter 4 to get total number of Money");
						logger.log(Level.INFO, " 		enter 5 to get total number of debts");

						x = input.nextInt();
						if (x == 1) {
							logger.log(java.util.logging.Level.SEVERE, "Total number of products  ",
									Main.itemsNum(Main.customers));
							logger.log(Level.INFO, "\n");
							logger.log(Level.INFO, "\n");

						} else if (x == 2) {
							logger.log(java.util.logging.Level.SEVERE, "Total number of waiting products is  ",
									Main.totalWaitingNum(Main.customers));
							logger.log(Level.INFO, "\n");
							logger.log(Level.INFO, "\n");

						}

						else if (x == 3) {
							logger.log(java.util.logging.Level.SEVERE, "Total number of waiting products is ",
									Main.totalIntreatment(Main.customers));
							logger.log(Level.INFO, "\n");
							logger.log(Level.INFO, "\n");

						} else if (x == 4) {
							logger.log(java.util.logging.Level.SEVERE, "Total number of Money ",
									Main.totalMoney(Main.customers));
							logger.log(Level.INFO, "\n");
							logger.log(Level.INFO, "\n");

						} else if (x == 5) {
							logger.log(java.util.logging.Level.SEVERE, "Total number of debts ",
									Main.totalDebts(Main.customers));
							logger.log(Level.INFO, "\n");
							logger.log(Level.INFO, "\n");

						}

					} else if (x == 4) {
						logger.log(Level.INFO, " 		enter 1 to generet report about worker details.");
						logger.log(Level.INFO, " 		enter 2 to generet report about customer details.");

						x = input.nextInt();
						if (x == 1) {
							Main.showAllWorkerDetails(Main.workers);
							logger.log(Level.INFO, "\n");
							logger.log(Level.INFO, "\n");
						} else if (x == 2) {
							Main.showAllCustomersDetails(Main.customers);
							logger.log(Level.INFO, "\n");
							logger.log(Level.INFO, "\n");

						}

					} else if (x == 5) {
						String z;
						logger.log(Level.INFO, "         Enter id customer to generet invoice.");
						z = input.next();
						logger.log(Level.INFO, "         Enter the amount you paid");
						x = input.nextInt();
						Main.generateInvoice(z, x, Main.customers);
						logger.log(Level.INFO, "\n");
						logger.log(Level.INFO, "\n");

					}

					else if (x == 0) {

						logged = 0;

					} else {
						logger.log(Level.INFO, validNum);
						logger.log(Level.INFO, "\n");
					}

				}

			} else if (stat.equalsIgnoreCase("worker")) {
				while (logged == 1) {

					Worker w = Main.workers.get(Worker.getIndexOfWorker(user.getIdPerson(), Main.workers));

					logger.log(Level.INFO, "To see your products enter 1");
					logger.log(Level.INFO, "IS there any change in product status? Enter 2");
					logger.log(Level.INFO, "Enter 0 to log out");

					x = input.nextInt();
					if (x == 1) {
						int size = w.getProductsForWorker().size();
						if (size == 0) {
							logger.log(Level.INFO, "No products added yet");
							logger.log(Level.INFO, "\n");
						} else {
							logger.log(Level.INFO,
									" Code		::	 	Category	::		status		::	Customer ID	::	Customer Name	::		cusomerPhone	");

							for (int i = 0; i < size; i++) {
								Product proo = w.getProductsForWorker().get(i);
								Customer cust = Main.customers
										.get(Customer.getIndexx(proo.getCustId(), Main.customers));
								logger.log(Level.INFO,
										" " + proo.getCode() + "		::	 	" + proo.getCategory()
												+ "		::		" + proo.getStatus() + "		::		" + cust.getId()
												+ "	::		" + cust.getName() + "	::	" + cust.getPhone() + "		");
								logger.log(Level.INFO, "\n");

							}
						}

					}

					else if (x == 2) {
						String proId;
						Customer cust;

						logger.log(Level.INFO, "If yes please enter customer id");
						in = input.nextLine();
						in = input.nextLine();

						if (!Customer.isExistCustomer(in, Main.customers)) {
							logger.log(Level.INFO, "No customer with this id");
							logger.log(Level.INFO, "\n");
						} else {
							cust = Main.customers.get(Customer.getIndexx(in, Main.customers));

							logger.log(Level.INFO, "What product id you want to change");
							in = input.nextLine();
							proId = in;

							if (!Customer.checkIsExist1(in, cust)) {
								logger.log(Level.INFO, NOPRODUC);
								logger.log(Level.INFO, "\n");
							} else {
								logger.log(Level.INFO,
										"what is the new status of the product ? waiting ... in treatment ... ready");
								in = input.nextLine();
								Worker.updateStatusCustomer(proId, cust.getId(), in, Main.customers);
								logger.log(Level.INFO, "Updated successfully");

								if (in.equalsIgnoreCase("ready")) {
									logger.log(Level.INFO,
											"Send email to notify customer that the product is ready ? Y/N");
									in = input.nextLine();
									if (in.equalsIgnoreCase("y")) {
										 email.email(cust.getEmail(),
												"your product is ready for more information visit us \n by: "
														+ w.getName());
									}

									logger.log(Level.INFO, "\n");
								}

							}
						}

					}

					else if (x == 0) {
						logged = 0;
					} else {
						logger.log(Level.INFO, validNum);
						logger.log(Level.INFO, "\n");
					}
				}

			}

			if (stat.equalsIgnoreCase("customer")) {
				Customer cust;
				cust = Main.customers.get(Customer.getIndexx(user.getIdPerson(), Main.customers));
				while (logged == 1) {
					x = 0;
					logger.log(Level.INFO, "press 1. to add new product ");
					logger.log(Level.INFO, "\n");
					logger.log(Level.INFO, "      2. to Update product ");
					logger.log(Level.INFO, "\n");
					logger.log(Level.INFO, "      3. to Delete product ");
					logger.log(Level.INFO, "\n");
					logger.log(Level.INFO, "      0. log out ");
					x = input.nextInt();
					if (x == 1) {

						Product pro = new Product();

						logger.log(Level.INFO, " Enter Code to your product");
						in = input.nextLine();
						in = input.nextLine();
						if (Customer.checkIsExist1(in, cust)) {
							logger.log(Level.INFO, "this Code already exist");
							logger.log(Level.INFO, "\n");

						}

						else if (!Customer.checkIsExist1(in, cust)) {
							pro.setStatus("Waiting");
							pro.setCode(in);
							logger.log(Level.INFO, "Name");
							in = input.nextLine();
							pro.setNamePro(in);

							logger.log(Level.INFO, "Category \n");
							in = input.nextLine();
							pro.setCategory(in);

							logger.log(Level.INFO, "picture \n");
							in = input.nextLine();
							pro.setPicture(in);

							logger.log(Level.INFO, "material \n");
							in = input.nextLine();
							pro.setMaterial(in);

							logger.log(Level.INFO, "Length \n");
							in = input.nextLine();
							pro.setLength(in);

							logger.log(Level.INFO, "width \n");
							in = input.nextLine();
							pro.setwidth(in);

							pro.setStatus("Waiting");

							logger.log(Level.INFO, "isspecial \n");
							in = input.nextLine();
							pro.setIsspecial(in);

							cust.addProduct(pro, Main.workers);
							logger.log(Level.INFO, "\n");
							logger.log(Level.INFO, " Added successfully");
						}

						else {
							logger.log(Level.INFO, "try later");
						}

					}

					else if (x == 3) {

						logger.log(Level.INFO, " What Code you want to delete");
						in = input.nextLine();
						in = input.nextLine();
						if (!Customer.checkIsExist1(in, cust)) {
							logger.log(Level.INFO, "No product with this Code");
							logger.log(Level.INFO, "\n");
						} else {
							Customer.deleteProduct(in, cust, Main.workers);
							logger.log(Level.INFO, "Deleted successfully");
						}
					}

					else if (x == 2) {

						System.out.println("press 1. to Update Length of product");
						logger.log(Level.INFO, "\n");
						System.out.println("      2. to Update Width of product ");
						logger.log(Level.INFO, "\n");
						logger.log(Level.INFO, "      3. to Update picture of product ");
						logger.log(Level.INFO, "\n");
						String code;
						x = input.nextInt();
						if (x == 1) {
							logger.log(Level.INFO, " What Code of your product ");
							code = input.nextLine();
							code = input.nextLine();

							if (!Customer.checkIsExist1(code, cust)) {

								logger.log(Level.INFO, NOPRODUC);
								logger.log(Level.INFO, "\n");
							} else {
								logger.log(Level.INFO, " new Length: ");
								in = input.nextLine();
								Customer.updateLength(code, in, cust);
								logger.log(Level.INFO, " Update Length successfully");
							}
						}

						else if (x == 2) {
							logger.log(Level.INFO, "What Code of your product ");
							code = input.nextLine();
							code = input.nextLine();

							if (!Customer.checkIsExist1(code, cust)) {

								logger.log(Level.INFO, NOPRODUC);
								logger.log(Level.INFO, "\n");
							} else {

								logger.log(Level.INFO, " new width: ");
								in = input.nextLine();
								Customer.updateWidth(code, in, cust);
								logger.log(Level.INFO, " Update Width successfully");

							}

						}

						else if (x == 3) {
							logger.log(Level.INFO, " What Code of your product ");
							code = input.nextLine();
							code = input.nextLine();

							if (!Customer.checkIsExist1(code, cust)) {

								logger.log(Level.INFO, NOPRODUC);
								logger.log(Level.INFO, "\n");
							} else {
								logger.log(Level.INFO, " new picture: ");
								in = input.nextLine();
								Customer.updatePicture(code, in, cust);
								logger.log(Level.INFO, " Update Picture successfully");
							}

						}
					}

					else if (x == 0) {
						// logOut
						logged = 0;
					} else {
						logger.log(Level.INFO, validNum);
						logger.log(Level.INFO, "\n");
					}

				}

			}

		}

	}
}
