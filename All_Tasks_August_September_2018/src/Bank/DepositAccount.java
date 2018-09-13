package Bank;

import java.time.LocalDate;
/**
 * 
 * @author Iliya Vukarski
 *
 */
public class DepositAccount extends Account {

	public DepositAccount() {
		
	}
	
	public DepositAccount(LocalDate accOpenDate, String ownerFName,
			String ownerLName, double accountBalance,
			double monthlyInterestRate, String typeOfAccount,
			String accountIBAN, Credentials credentials, Customer customer) {
		super(accOpenDate, ownerFName, ownerLName, accountBalance, monthlyInterestRate,
				typeOfAccount, accountIBAN, credentials, customer);
	}
	
	public double calculateInterestFor(int months) {
		double interest = 0;
		Customer customer = getCustomer();
		int amountOfDeposit = (int) this.getAccountBalance();
		double amountCoeff = 0;
		if(amountOfDeposit <= 1000) {
			amountCoeff = 0.01;
		}else if(amountOfDeposit > 1000 && amountOfDeposit <= 2000) {
			amountCoeff = 0.05;
		}else if(amountOfDeposit > 2000 && amountOfDeposit <= 5000) {
			amountCoeff = 0.10;
		}else if(amountOfDeposit > 5000 && amountOfDeposit >= 50000) {
			amountCoeff = 0.15;
		}else if(amountOfDeposit > 50000) {
			amountCoeff = 0.25;
		}
		
		if(customer.getTypeOfCustomer().equals("Individual")) {
			if(months <= 12) {
				interest = (this.getAccountBalance() * (this.getMonthlyInterestRate() / 100)) * (months * 0.02) * (amountOfDeposit * amountCoeff);
			}else if(months > 12 && months <= 24) { 
				interest = (this.getAccountBalance() * (this.getMonthlyInterestRate() / 100)) * (months * 0.05) * (amountOfDeposit * amountCoeff);
			}else if(months > 24 && months <= 36) { 
				interest = (this.getAccountBalance() * (this.getMonthlyInterestRate() / 100)) * (months * 0.08) * (amountOfDeposit * amountCoeff);
			}else if(months > 36){
				interest = (this.getAccountBalance() * (this.getMonthlyInterestRate() / 100)) * (months * 0.10) * (amountOfDeposit * amountCoeff);
			}
		}else if(customer.getTypeOfCustomer().equals("Company")) {
			interest = (this.getAccountBalance() * (this.getMonthlyInterestRate() / 100)) * (months * 0.10) * (amountOfDeposit * amountCoeff * 0.15);
		}else {
			System.out.println("Unknown type of customer");
		}
		return interest;
	}
}