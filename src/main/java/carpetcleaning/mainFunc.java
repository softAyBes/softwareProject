package carpetcleaning;

import java.util.ArrayList;
import java.util.Scanner;

public class mainFunc {
	public static ArrayList<customer> customers= new ArrayList<customer>();
 
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		String name,password;
		String emptyLine="|						                      						                |";
		int logged=0;
		Admin admin=new Admin();
		// TODO Auto-generated method stub
			System.out.println(emptyLine);
			System.out.println(emptyLine);
			System.out.println("|						Welcome to  carpet cleaning foundation						|");
			System.out.println(emptyLine);
			System.out.println("|						press:  1. Enter as Admin 						        |");
			System.out.println("|						        2. Enter as client						        |");
				
			
			while(logged==0) {
				System.out.println(emptyLine);
			System.out.println("|						        Enter you username						        |");
			System.out.println("|_______________________________________________________________________________________________________________________________"
					+ "|");
			name=input.nextLine();
			System.out.println("|						        Enter you user password						        |");
			password=input.nextLine();
			if(name.equalsIgnoreCase(admin.getName()) && password.equalsIgnoreCase(admin.getPassword())) {
				System.out.println("|						Welcome Back						|");
				logged=1;
				admin.setStatus(true);
			}
			else {
					System.out.println("Login faild .... try again");
				}
			}
			
			
	}

}
