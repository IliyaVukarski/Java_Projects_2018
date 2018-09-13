package BankManagement;

import java.time.LocalDate;
import java.util.List;
/**
 * 
 * @author Iliya Vukarski
 *
 */
public class Bank {
	private List<Account> bankAccounts;
	private List<String> oldPasswordRepo;
	
	public Bank() {
		
	}
	
	public Bank(List<Account> bankAccounts, List<String> oldPasswordRepo) {
		this.bankAccounts = bankAccounts;
		this.oldPasswordRepo = oldPasswordRepo;
	}
	
	public List<String> getOldPasswordRepo() {
		return oldPasswordRepo;
	}

	public void setOldPasswordRepo(List<String> oldPasswordRepo) {
		this.oldPasswordRepo = oldPasswordRepo;
	}
	
	public List<Account> getBankAccounts() {
		return bankAccounts;
	}

	public void setBankAccounts(List<Account> bankAccounts) {
		this.bankAccounts = bankAccounts;
	}
	
	public void openAccount(Account account) {
		System.out.printf("Openning account for %s %s with amount of %.2f. on date %s with number %d", 
				account.getFirstName(), 
				account.getLastName(), 
				account.getAccountBalance(),
				account.getCredentials().getTimeRegister().toString(),
				account.getCredentials().getUserId());
		if(!oldPasswordRepo.contains(account.getCredentials().getPassword())) {
			bankAccounts.add(new Account(account.getFirstName(),
								     account.getLastName(),
								     account.getGovernmentId(), 
								     account.getAccountBalance(),
								     account.getTypeOfAccount(),
								     account.getCredentials()));
		}else {
			System.out.println("Error. This password was used before.");
		}
	}
	
	public void closeAccount(String username, String password) {
		
		for(int index = 0; index < bankAccounts.size(); index++) {
			if(bankAccounts.get(index).getCredentials().getUsername().equals(username) &&
			   bankAccounts.get(index).getCredentials().getPassword().equals(password)) {
				oldPasswordRepo.add(password);
				int accountNumber = bankAccounts.get(index).getCredentials().getUserId();
				System.out.printf("Closing and deleting account %s with number %d.", username, accountNumber);
				bankAccounts.remove(index);
				System.out.println("Account has been successfully deleted!");
			}else {
				System.out.println("Passwords don't match.");
			}
		}
	}
	
	public void depositAccount(String username, String password, double amount) {
		for(int index = 0; index < bankAccounts.size(); index++) {
			bankAccounts.get(index).deposit(username, password, amount);
			System.out.printf("The new amount is now %.2f.", bankAccounts.get(index).getAccountBalance());
			continue;
		}
	}
	
	public void withdrawAccount(String username, String password, double amount) {
		for(int index = 0; index < bankAccounts.size(); index++) {
			if(bankAccounts.get(index).getTypeOfAccount().equals("Deposit")) {
				bankAccounts.get(index).withdraw(username, password, amount);
				System.out.printf("The new amount is now %.2f.", bankAccounts.get(index).getAccountBalance());
				LocalDate date = LocalDate.now();
				System.out.printf("You had withrawed %.2f on date %s", amount, date.toString());
				continue;
			}else {
				System.out.println("You can't now withdraw!");
			}
		}
	}
	
	public void printInfoOfAllBankAccounts() {
		for(Account acc : bankAccounts) {
			System.out.printf("Name: %s %s ID: %s Balance: %.2f Username: %s Password: %s",
							  acc.getFirstName(), 
							  acc.getLastName(),
							  acc.getGovernmentId(),
							  acc.getAccountBalance(),
							  acc.getCredentials().getUsername(),
							  acc.getCredentials().getPassword());
			System.out.println();
		}
	}
	
	public void transferToAnotherAccount(String remUsername, String remPassword, String recUsername, String recPassword, double amount) {
		for(int index = 0; index < bankAccounts.size(); index++) {
			if(bankAccounts.get(index).hasAccess(remUsername, remPassword)) {
				withdrawAccount(remUsername, remPassword, amount);
				depositAccount(recUsername, recPassword, amount);
				continue;
			}else {
				System.out.println("Access denied");
			}
		}
	}
	
	public double calculateAllAccountAssets() {
		double amountOfAccountAssets = 0;
		for(Account acc : bankAccounts) {
			amountOfAccountAssets = amountOfAccountAssets + acc.getAccountBalance();
		}
		System.out.printf("The current balance of all account assets is %.2f.",
						   amountOfAccountAssets);
		return amountOfAccountAssets;
	}
}