package carpetcleaning;

public class Admin extends Person {
	private String id;
	private static final String TYPEADMIN = "Admin";

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

	public static String login(String user, String pass) {

		for (int i = 0; i < Main.persons.size(); i++) 
		{
			if (Main.persons.get(i).getName().equals(user) && Main.persons.get(i).getPassword().equals(pass)) {
				if (Main.persons.get(i).getType().equalsIgnoreCase(TYPEADMIN)) {
					return TYPEADMIN;
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
