package BankManagement;

import java.time.LocalDate;

/**
 * 
 * @author Iliya Vukarski
 *
 */
public class Account {
	private String firstName;
	private String lastName;
	private String governmentId;
	private double accountBalance;
	private String typeOfAccount;
	private Credentials credentials;
	
	public Account() {
		
	}
	
	public Account(String firstName, String lastName, String governmentId,
			double accountBalance, String typeOfAccount, Credentials credentials) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.governmentId = governmentId;
		this.accountBalance = accountBalance;
		this.typeOfAccount = typeOfAccount;
		this.credentials = credentials;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getGovernmentId() {
		return governmentId;
	}

	public void setGovernmentId(String governmentId) {
		this.governmentId = governmentId;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public Credentials getCredentials() {
		return credentials;
	}

	public void setCredentials(Credentials credentials) {
		this.credentials = credentials;
	}
	
	public String getTypeOfAccount() {
		return typeOfAccount;
	}

	public void setTypeOfAccount(String typeOfAccount) {
		this.typeOfAccount = typeOfAccount;
	}
	
	public boolean hasRightToWithdraw() {
		boolean hasRightToWithdraw = true;
		if(typeOfAccount.equals("Deposit")) {
			hasRightToWithdraw = true;
		}else if(typeOfAccount.equals("Mortgage")) {
			hasRightToWithdraw = false;
		}else if(typeOfAccount.equals("Loan")) {
			hasRightToWithdraw = false;
		}
		return hasRightToWithdraw;
	}
	
	public boolean hasAccess(String username, String password) {
		boolean hasAccess = true;
		if(this.credentials.getUsername().equals(username) && 
				this.credentials.getPassword().equals(password)) {
			hasAccess = true;
		}else {
			hasAccess = false;
		}
		return hasAccess;
	}
	
	public void deposit(String username, String password, double amount) {
		if(hasAccess(username, password)) {
			if(amount > 0) {
				accountBalance = accountBalance + amount;
				LocalDate date = LocalDate.now();
				System.out.printf("You had deposited %.2f on date %s", amount, date.toString());
				
			}else {
				System.out.println("Can't accept negativ deposit.");
			}
		}else {
			System.out.println("You are not authorized to deposit money.");
		}
	}
	
	public void withdraw(String username, String password, double amount) {
		if(hasAccess(username, password)) {
			if(amount > 0 && accountBalance >= amount) {
				accountBalance = accountBalance - amount;
				LocalDate date = LocalDate.now();
				System.out.printf("You had withdrawed %.2f on date %s", amount, date.toString());
			}else {
				System.out.println("You don't have enough money in your account.");
			}
		}else {
			System.out.println("You are not authorized to withdraw money.");
		}
	}
}