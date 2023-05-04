package carpetcleaning;

public class Admin extends person {
	private String id;
	private final static String admin="Admin";

	private boolean status;

	public Admin(person pers) {
		this.setName(pers.getName());
		this.setPassword(pers.getPassword());
		this.setType("admin");
	}

	public Admin() {
		this.setType(admin);
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

	public static String login(String user, String pass) {

		for (int i = 0; i < Main.persons.size(); i++) {
			if (Main.persons.get(i).getName().equals(user) && Main.persons.get(i).getPassword().equals(pass)) {
				if (Main.persons.get(i).getType().equalsIgnoreCase(admin)) {
					return admin;
				}
				if (Main.persons.get(i).getType().equalsIgnoreCase("customer")) {
					return "customer";
				}
				if (Main.persons.get(i).getType().equalsIgnoreCase("worker")) {
					return "worker";
				}
			}

		}
		return "false";
	}
}
