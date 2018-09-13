package Bank;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 * @author Iliya Vukarski
 *
 */
public class BankManagement {
	private List<Account> accounts;

	public BankManagement() {
		
	}
	
	
	public BankManagement(List<Account> accounts) {
		this.accounts = accounts;
	}
	
	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	
	public void printInfoAfterTransaction(String username, String password) {
		for(int index = 0; index < accounts.size(); index++) {
			if(accounts.get(index).getCredentials().getUsername().equals(username) &&
			   accounts.get(index).getCredentials().getPassword().equals(password)) {
				Account acc = accounts.get(index);
				System.out.printf("FName: %s LName: %s Balance: %.3f", 
																	acc.getOwnerFName(),
																	acc.getOwnerLName(),
																	acc.getAccountBalance());
			}
		}
	}
	public void remittingMoney(String username, String password, String accIBAN, double amount) {
		for(int index = 0; index < accounts.size(); index++) {
			if(accounts.get(index).getCredentials().getUsername().equals(username) &&
			   accounts.get(index).getCredentials().getPassword().equals(password)) {
				if(accounts.get(index).hasRightToWithdraw()) {
					accounts.get(index).withdrawAmount(username, password, accIBAN, amount);
					printInfoAfterTransaction(username, password);
				}else {
					System.out.println("This is not a deposit account. You don't have the right to withdraw");
				}
			}else {
				System.out.println("Passwords don't match!");
			}
		}
	}
	
	public void receiveMoney(String username, String password, String accIBAN, double amount) {
		for(int index = 0; index < accounts.size(); index++) {
			if(accounts.get(index).getCredentials().getUsername().equals(username) &&
			   accounts.get(index).getCredentials().getPassword().equals(password)) {
					accounts.get(index).depositAmount(username, password, accIBAN, amount);
					printInfoAfterTransaction(username, password);
			}else {
				System.out.println("Passwords don't match!");
			}
		}
	}
	
	public void printInfoAboutAccount(String username, String password) {
		for(int index = 0; index < accounts.size(); index++) {
			if(accounts.get(index).getCredentials().getUsername().equals(username) &&
			   accounts.get(index).getCredentials().getPassword().equals(password)) {
				Account acc = accounts.get(index);
				System.out.printf("FName: %s LName: %s Balance: %.3f MonthlyInterestRate: %.3f "
						+ "TypeOfAccount: %s AccountIBAN: %s Credentials: %s Number %d"
						+ "Customer: %s AcountOpenDate: %s %n", 
													 acc.getOwnerFName(),
													 acc.getOwnerLName(),
													 acc.getAccountBalance(),
													 acc.getMonthlyInterestRate(),
													 acc.getTypeOfAccount(),
													 acc.getAccountIBAN(),
													 acc.getCredentials().getUsername(),
													 acc.getCredentials().getUserId(),
													 acc.getCustomer().getTypeOfCustomer(),
													 acc.getAccOpenDate().toString());
			}
		}
	}
	
	public void printInfoAboutAccounts() {
		for(Account acc : accounts) {
			System.out.printf("FName: %s LName: %s Balance: %.3f MonthlyInterestRate: %.3f "
					+ "TypeOfAccount: %s AccountIBAN: %s Credentials: %s Number %d"
					+ "Customer: %s AcountOpenDate: %s %n", 
												 acc.getOwnerFName(),
												 acc.getOwnerLName(),
												 acc.getAccountBalance(),
												 acc.getMonthlyInterestRate(),
												 acc.getTypeOfAccount(),
												 acc.getAccountIBAN(),
												 acc.getCredentials().getUsername(),
												 acc.getCredentials().getUserId(),
												 acc.getCustomer().getTypeOfCustomer(),
												 acc.getAccOpenDate().toString());
		}
	}
}