package Bank;

import java.time.LocalDate;
/**
 * 
 * @author Iliya Vukarski
 *
 */
public class LoanAccount extends Account {
	
	
	public LoanAccount() {
		
	}
	
	public LoanAccount(LocalDate accOpenDate, String ownerFName,
			String ownerLName, double accountBalance,
			double monthlyInterestRate, String typeOfAccount,
			String accountIBAN, Credentials credentials, Customer customer) {
		super(accOpenDate, ownerFName, ownerLName, accountBalance, monthlyInterestRate,
				typeOfAccount, accountIBAN, credentials, customer);
	}

	public double calculateInterestFor(int months) {
		double interest = 0;
		Customer customer = getCustomer();
		if(customer.getTypeOfCustomer().equals("Individual")) {
			interest = (this.getAccountBalance() * (this.getMonthlyInterestRate() / 100)) * (months * 0.2);
		}else if(customer.getTypeOfCustomer().equals("Company")) {
			if(months <= 12) {
				interest = (this.getAccountBalance() * (this.getMonthlyInterestRate() / 100)) * (months * 0.5);
			}else {
				interest = (this.getAccountBalance() * (this.getMonthlyInterestRate() / 100)) * (months * 0.3);
			}
		}else {
			System.out.println("Unknown type of customer");
		}
		return interest;
	}
}
