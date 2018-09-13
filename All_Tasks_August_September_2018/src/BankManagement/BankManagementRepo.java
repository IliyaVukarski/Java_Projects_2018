package BankManagement;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * 
 * @author Iliya Vukarski
 *
 */
public class BankManagementRepo {

	public static void main(String[] args) {
		List<Account> bankAccounts = new ArrayList<Account>();
		List<String> oldPasswordRepo = new ArrayList<String>();
		List<String> commands = new ArrayList<String>();
		commands.add("END");
		commands.add("OPEN");
		commands.add("CLOSE");
		commands.add("PRINFO");
		commands.add("DEPOSIT");
		commands.add("WITHDRAW");
		commands.add("TRANSFER");
		commands.add("CHECKASSETS");
		boolean isValid = true;
		String[] userInputCommand = null;
		while(true) {
			Account account = null;
			Credentials credentials = null;
			Bank bank = new Bank(bankAccounts, oldPasswordRepo);
			Scanner scanner = new Scanner(System.in);
			System.out.println("Choose commands - END, OPEN, CLOSE, PRINFO, DEPOSIT, WITHDRAW, TRANSFER, CHECKASSETS");
			userInputCommand = scanner.next().split(" ");
			if(userInputCommand[0].equals(commands.get(0))) {
				break;
			}
			for(String comm : userInputCommand) {
				if(comm.equals(commands.get(1))) {
					System.out.println("Enter FName, LName, GovId, Balance, AccType, Username and Password.");
					String firstName = scanner.next();
					String lastName = scanner.next();
					String governmentId = scanner.next();
					double accountBalance = 0;
					do {
						if(scanner.hasNextDouble()) {
							accountBalance = scanner.nextDouble();
							isValid = true;
						}else {
							System.out.println("Enter valid amount of value.");
							isValid = false;
							scanner.next();
						}
					}while(!isValid);
					String typeOfAccount = scanner.next();
					String username = scanner.next();
					String password = scanner.next();
					LocalDate timeRegister = LocalDate.now();
					credentials = new Credentials(username, password, timeRegister);
					account = new Account(firstName, lastName, governmentId, accountBalance, typeOfAccount, credentials);
					bank.openAccount(account);
					System.out.println();
				}else if(comm.equals(commands.get(2))) {
					System.out.println("Enter username and password.");
					String username = scanner.next();
					String password = scanner.next();
					bank.closeAccount(username, password);
					System.out.println();
				}else if(comm.equals(commands.get(3))) {
					System.out.println("Information about all accounts.");
					bank.printInfoOfAllBankAccounts();
					System.out.println();
				}else if(comm.equals(commands.get(4))) {
					System.out.println("Enter username and password.");
					String username = scanner.next();
					String password = scanner.next();
					System.out.println("Enter amount to deposit");
					double amount = 0;
					do {
						if(scanner.hasNextDouble()) {
							amount = scanner.nextDouble();
							isValid = true;
						}else {
							System.out.println("Enter valid amount of value.");
							isValid = false;
							scanner.next();
						}
					}while(!isValid);
					bank.depositAccount(username, password, amount);
					System.out.println();
				}else if(comm.equals(commands.get(5))) {
					System.out.println("Enter username and password.");
					String username = scanner.next();
					String password = scanner.next();
					System.out.println("Enter amount withdraw");
					double amount = 0;
					do {
						if(scanner.hasNextDouble()) {
							amount = scanner.nextDouble();
							isValid = true;
						}else {
							System.out.println("Enter valid amount of value.");
							isValid = false;
							scanner.next();
						}
					}while(!isValid);
					bank.withdrawAccount(username, password, amount);
					System.out.println();
				}else if(comm.equalsIgnoreCase(commands.get(6))) {
					System.out.println("Enter username and password for the remitter.");
					String remUsername = scanner.next();
					String remPassword = scanner.next();
					System.out.println("Enter amount to tranfer");
					double amount = 0;
					do {
						if(scanner.hasNextDouble()) {
							amount = scanner.nextDouble();
							isValid = true;
						}else {
							System.out.println("Enter valid value.");
							isValid = false;
							scanner.next();
						}
					}while(!isValid);
					System.out.println("Enter username and password for the recipient.");
					String recUsername = scanner.next();
					String recPassword = scanner.next();
					bank.transferToAnotherAccount(remUsername, remPassword, recUsername, recPassword, amount);
					System.out.println();
				}else if(comm.equalsIgnoreCase(commands.get(7))) {
					bank.calculateAllAccountAssets();
					System.out.println();
				}else {
					System.out.println("Wrong command!");
				}
			}
		}
	}
}