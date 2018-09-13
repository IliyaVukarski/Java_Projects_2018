package Bank;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * 
 * @author Iliya Vukarski
 *
 */
public class BankManagementRepository {
	private static int count = 1;
	
	public static void main(String[] args) {
		List<Account> bankAccounts = new ArrayList<>();
		List<String> userCommands = new ArrayList<>();
		BankManagement bankManagement = new BankManagement(bankAccounts);
		userCommands.add("END");
		userCommands.add("OPEN");
		userCommands.add("PUT");
		userCommands.add("GET");
		userCommands.add("INFO");
		userCommands.add("CALCINTEREST");
		boolean isValid = true;
		Customer customer = null;
		Account account = null;
		Credentials credentials = null;
		
		while(true) {
			Scanner scanner = new Scanner(System.in);
			System.out.println(
				"END, OPEN, PUT, GET, INFO, CALCINTEREST");
			String[] input = scanner.next().split(" ");
			
			if(input[0].equalsIgnoreCase(
				userCommands.get(0))) {
				break;
			}
			
			for(String comm : input) {
				if(comm.equals(userCommands.get(1))) {
					System.out.println("Type of customer - Individual, Company");
					String typeOfCustomer = scanner.next();
					if(typeOfCustomer.equals("Individual")) {
						customer = new IndividualCustomer(typeOfCustomer);
					}else if(typeOfCustomer.equals("Company")) {
						customer = new CompanyCustomer(typeOfCustomer);
					}else {
						System.out.println("Wrong type of customer");
						break;
					}	
					
					System.out.println("Type of account - Deposit, Loan, Mortgage");
					String typeOfAccount = scanner.next();
					System.out.println("Enter FName, LName, accBalance, monthlyInterestRate, username, password.");
					LocalDate accOpenDate = LocalDate.now();
					String ownerFName = scanner.next();
					String ownerLName = scanner.next();
					double accountBalance = 0;
					do {
						if(scanner.hasNextDouble()) {
							accountBalance = scanner.nextDouble();
							isValid = true;
						}else {
							System.out.println("Enter correct value!");
							isValid = false;
							scanner.next();
						}
					}while(!isValid);
					double monthlyInterestRate = 0;
					do {
						if(scanner.hasNextDouble()) {
							monthlyInterestRate = scanner.nextDouble();
							isValid = true;
						}else {
							System.out.println("Enter correct value!");
							isValid = false;
							scanner.next();
						}
					}while(!isValid);
					String username = scanner.next();
					String password = scanner.next();
					LocalDate registerOpenDate = LocalDate.now();
					credentials = new Credentials(username, password, registerOpenDate);
					String accountIBAN = String.format("%016d", count++);
					if(typeOfAccount.equals("Deposit")) {
						account = new DepositAccount(accOpenDate, ownerFName, ownerLName, accountBalance, monthlyInterestRate, typeOfAccount, accountIBAN, credentials, customer);
					}else if(typeOfAccount.equals("Loan")) {
						account = new LoanAccount(accOpenDate, ownerFName, ownerLName, accountBalance, monthlyInterestRate, typeOfAccount, accountIBAN, credentials, customer);
					}else if(typeOfAccount.equals("Mortgage")) {
						account = new MortgageAccount(accOpenDate, ownerFName, ownerLName, accountBalance, monthlyInterestRate, typeOfAccount, accountIBAN, credentials, customer);
					}else {
						System.out.println("Wrong type!");
						break;
					}
					bankAccounts.add(account);
					bankManagement.printInfoAboutAccount(username, password);
					System.out.println();
				}else if(comm.equals(userCommands.get(2))) { 
					System.out.println("Enter username, password, accIBAN, amount ");
					String username = scanner.next();
					String password = scanner.next();
					String accIBAN = scanner.next();
					double amount = 0;
					do {
						if(scanner.hasNextDouble()) {
							amount = scanner.nextDouble();
							isValid = true;
						}else {
							System.out.println("Enter correct value!");
							isValid = false;
							scanner.next();
						}
					}while(!isValid);
					bankManagement.receiveMoney(username, password, accIBAN, amount);
				}else if(comm.equals(userCommands.get(3))) { 
					System.out.println("Enter username, password, accIBAN, amount ");
					String username = scanner.next();
					String password = scanner.next();
					String accIBAN = scanner.next();
					double amount = 0;
					do {
						if(scanner.hasNextDouble()) {
							amount = scanner.nextDouble();
							isValid = true;
						}else {
							System.out.println("Enter correct value!");
							isValid = false;
							scanner.next();
						}
					}while(!isValid);
					bankManagement.remittingMoney(username, password, accIBAN, amount);
				}else if(comm.equals(userCommands.get(4))) { 
					bankManagement.printInfoAboutAccounts();
					System.out.println();
				}else if(comm.equals(userCommands.get(5))) {
					System.out.println("Enter period of time");
					int periodOfTime = 0;
					do {
						if(scanner.hasNextInt()) {
							periodOfTime = scanner.nextInt();
							isValid = true;
						}else {
							System.out.println(
							"Enter correct data!");
							scanner.next();
							isValid = false;
						}
					}while(!isValid);
					for(Account acc : bankAccounts) {
						System.out.printf("FName: %s LName: %s Balance: %.3f "
										+ "TypeOfAccount: %s Customer: %s calculateInterest: %.8f %n", 
								acc.getOwnerFName(),
								acc.getOwnerLName(),
								acc.getAccountBalance(),
								acc.getTypeOfAccount(), 
								acc.getCustomer().getTypeOfCustomer(),
								acc.calculateInterestFor(periodOfTime));
					}
				}else {
					System.out.println("Wrong command");
				}
			}
		}
	}
}