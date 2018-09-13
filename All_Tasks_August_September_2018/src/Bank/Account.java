package Bank;

import java.time.LocalDate;
/**
 * 
 * @author Iliya Vukarski
 *
 */
public abstract class Account {
	private LocalDate accOpenDate;
	private String ownerFName;
	private String ownerLName;
	private double accountBalance;
	private double monthlyInterestRate;
	private String typeOfAccount;
	private String accountIBAN;
	private Credentials credentials;
	private Customer customer;
	
	public Account() {
		
	}
	
	public Account(LocalDate accOpenDate, String ownerFName, String ownerLName,
			double accountBalance, double monthlyInterestRate,
			 String typeOfAccount, String accountIBAN, Credentials credentials, 
			 Customer customer) {
		this.accOpenDate = accOpenDate;
		this.ownerFName = ownerFName;
		this.ownerLName = ownerLName;
		this.accountBalance = accountBalance;
		this.monthlyInterestRate = monthlyInterestRate;
		this.typeOfAccount = typeOfAccount;
		this.accountIBAN = accountIBAN;
		this.credentials = credentials;
		this.customer = customer;
	}
	
	public LocalDate getAccOpenDate() {
		return accOpenDate;
	}

	public void setAccOpenDate(LocalDate accOpenDate) {
		this.accOpenDate = accOpenDate;
	}

	public String getOwnerFName() {
		return ownerFName;
	}

	public void setOwnerFName(String ownerFName) {
		this.ownerFName = ownerFName;
	}

	public String getOwnerLName() {
		return ownerLName;
	}

	public void setOwnerLName(String ownerLName) {
		this.ownerLName = ownerLName;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public double getMonthlyInterestRate() {
		return monthlyInterestRate;
	}

	public void setMonthlyInterestRate(double monthlyInterestRate) {
		this.monthlyInterestRate = monthlyInterestRate;
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
	
	public String getAccountIBAN() {
		return accountIBAN;
	}

	public void setAccountIBAN(String accountIBAN) {
		this.accountIBAN = accountIBAN;
	}
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
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
	
	public boolean hasAccess(String username, String password, String accIBAN) {
		boolean hasAccess = true;
		if(credentials.getUsername().equals(username) && 
		   credentials.getPassword().equals(password) &&
		   accountIBAN.equals(accIBAN)) {
			System.out.println("Access granted!");
			hasAccess = true;
		}else {
			System.out.println("Access denied!");
			hasAccess = false;
		}
		return hasAccess;
	}
	
	public void depositAmount(String username, String password, String accIBAN, double amount) {
		if(hasAccess(username, password, accIBAN)) {
			if(amount >= 0) {
				accountBalance = accountBalance + amount;
			}else {
				System.out.println("Can't accept negative amount.");
			}
		}else {
			System.out.println("Access denied!");
		}
	}
	
	public void withdrawAmount(String username, String password, String accIBAN, double amount) {
		if(hasAccess(username, password, accIBAN)) {
			if(amount >= 0 && accountBalance >= amount) {
				accountBalance = accountBalance - amount;
			}else {
				System.out.println("Can't accept negative amount.");
			}
		}else {
			System.out.println("Access denied!");
		}
	}
	
	public abstract double calculateInterestFor(int months);
}