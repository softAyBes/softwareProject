package carpetcleaning;

import java.util.List;

public class Admin extends Person {
	private String id;
	private static final String TYPEADMIN = "admin";

	private boolean status;

	public Admin(Person pers) {
		this.setName(pers.getName());
		this.setPassword(pers.getPassword());
		this.setType(TYPEADMIN);
	}

	public Admin() {
		this.setType(TYPEADMIN);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public static String login(String user, String pass, List<Person> persons) {

		for (int i = 0; i < persons.size(); i++) {

			if (persons.get(i).getName().equalsIgnoreCase(user) && persons.get(i).getPassword().equalsIgnoreCase(pass)) {

				if (persons.get(i).getType().equalsIgnoreCase(TYPEADMIN)) {
					
					return TYPEADMIN;
				}
				if (persons.get(i).getType().equalsIgnoreCase("customer")) {
					return "customer";
				}
				if (persons.get(i).getType().equalsIgnoreCase("worker")) {
					return "worker";
				}
			}

		}
		return "false";
	}
}
