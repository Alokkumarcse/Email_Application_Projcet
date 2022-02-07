/*
 * Your application should do the following:
 * Generate an email with the following syntax: firstname.lastname@department.company.com
 * Determine the department(sales, development, accounting). if none leave blank
 * Generate a random String for a password
 * Have set methods to change the password,set the mailbox capacity and define an alternate email address
 * Have get methods to display the name, email, mailbox capacity
 */

package emailApp;
import java.util.Scanner;

public class Email {
	
	private String firstName;
	private String lastName;
	private String password;
	private String department;
	private String email;
	private int mailboxCapacity = 500;
	private int defautlPasswordLength = 10;
	private String aletrnateEmail;
	private String companySuffix = "xyzcompany.com";
	
	// Constructor to receive the first name and last name
	
	public Email( String firstName, String lastName) {
		
		this.firstName = firstName;
		this.lastName = lastName;
       // System.out.println("EMAIL CREATED: "+this.firstName+" "+this.lastName);
        
        // Call a method asking for the department - return the department
        this.department = setDepartment();
//        System.out.println("Department: "+this.department);
        
        // Call a method that returns a random password
        this.password = randomPassword(defautlPasswordLength);
//        System.out.println("Your password is: "+this.password);
        
        // Combine elements to generate email
        email = firstName.toLowerCase()+"."+lastName.toLowerCase()+"@"+ department+"."+ companySuffix;
//        System.out.println("Your email is: "+email);
	}
	
	// Ask for the department
	private String setDepartment() {
		System.out.print("New Worker: "+firstName+"\nDepartment code:\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter department code: ");
	    Scanner input = new Scanner(System.in);
	     int depChoice = input.nextInt();
	     
	    if( depChoice == 1 ) {return "Sales";}
	    else if(depChoice == 2) {return "Development";}
	    else if(depChoice == 3) {return "Accounting";}
	    else {return "None";}
	}
	
	// Generate a random password
	private String randomPassword(int length) {
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ123456789@#$";
		char[] password = new char[length];
		for(int i=0; i<length; i++) {
			int rand = (int)(Math.random() * passwordSet.length());
			password[i] = passwordSet.charAt(rand);
		}
		 // Converting char[] into string
//		String str =new String(password);
//		return str;
		return new String(password);
	}
	
	// Set the mailbox Capacity
	public void setMailboxCapacity(int capacity) {
		this.mailboxCapacity = capacity;
	}
	// Get the mailbox Capacity
	public int getMailboxCapacity() {
		return this.mailboxCapacity;
	}
	
	// Set the alternate email
	public void setAlternateEmail(String alterEmail) {
		this.aletrnateEmail = alterEmail;
	}
	// Get the alternate email
	public String getAletrnateEmail() {
		return this.aletrnateEmail;
	}
	
	// Change the password
	public void changePassword(String password) {
		this.password = password;
	}
	// Get the Change password
	public String getPassword() {
		return this.password;
	}
	
	public String showInfo() {
		
		return "DISPLAY NAME: "+firstName+" "+lastName+
				"\nCOMPANY EMAIL: "+ email+
				"\nMAILBOX CAPACITY: "+mailboxCapacity + "mb";
	}
	
}
