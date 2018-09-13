package Credentials;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * 
 * @author Iliya Vukarski
 *
 */
public class SystemRepoMain {
	public static void main(String[] args) {
		List<Credentials> userRepository= new ArrayList<Credentials>();
		List<String> oldPasswordRepo = new ArrayList<String>();
		Credentials credentials = null;
		CredentialsManager credentialsManager = null;
		List<String> commands = new ArrayList<String>();
		commands.add("END");
		commands.add("ENROLL");
		commands.add("DELETE");
		commands.add("CHPASS");
		commands.add("AUTH");
		commands.add("PRINFO");
		Scanner scanner = new Scanner(System.in);
		String[] userInputCommand = null;
		while(true) {
			System.out.println("Please enter one of these operations:");
			System.out.println("ENROLL, DELETE, CHPASS, AUTH, PRINFO, END");
			System.out.println("ENROLL - adds new user.");
			System.out.println("DELETE - removes user.");
			System.out.println("CHPASS - changes password.");
			System.out.println("AUTH - checks if you have access.");
			System.out.println("PRINFO - Print info about user");
			System.out.println("END - exists the program.");
			userInputCommand = scanner.next().split(" ");
			if(userInputCommand[0].equals(commands.get(0))) {
				break;
			}
			for(String comm : userInputCommand) {
				if(comm.equals(commands.get(1))) {
					System.out.println("Choose type of user");
					System.out.println("RegularUser or PowerUser");
					String typeOfUser = scanner.next();
					if(typeOfUser.equals("RegularUser")) {
						System.out.println("Enter username and password.");
						credentials = new RegularUser(scanner.next(), scanner.next());
						credentialsManager = new CredentialsManager(credentials, userRepository, oldPasswordRepo);
					}else if(typeOfUser.equals("PowerUser")) {
						System.out.println("Enter username and password.");
						credentials = new PowerUser(scanner.next(), scanner.next());
						credentialsManager = new CredentialsManager(credentials, userRepository, oldPasswordRepo);
					}else {
						System.out.println("Wrong type of user");
						return;
					}
					credentialsManager.addNewUsers(credentials);
				}else if(comm.equals(commands.get(2))) {
					System.out.println("Enter username and password.");
					String username = scanner.next();
					String password = scanner.next();
					credentialsManager.removeUser(username, password);
				}else if(comm.equals(commands.get(3))) {
					System.out.println("Enter username and password.");
					String username = scanner.next();
					String password = scanner.next();
					for(int index = 0; index < userRepository.size(); index++) {
						if(userRepository.get(index).getUsername().equals(username) &&
						   userRepository.get(index).getPassword().equals(password)) {
							System.out.println("Please enter new password");
							String newPassword = scanner.next();
							credentialsManager.changePassword(username, password, newPassword);
							continue;
						}else {
							System.out.println("Username or password don't match!");
						}
					}
				}else if(comm.equals(commands.get(4))) {
					System.out.println("Enter username and password.");
					String username = scanner.next();
					String password = scanner.next();
					credentialsManager.authorizeUser(username, password);
				}else if(comm.equals(commands.get(5))) {
					System.out.println("Enter username and password.");
					String username = scanner.next();
					String password = scanner.next();
					for(int index = 0; index < userRepository.size(); index++) {
						if(userRepository.get(index).getUsername().equals(username) &&
						   userRepository.get(index).getPassword().equals(password) &&
						   userRepository.get(index) instanceof PowerUser) {
							credentialsManager.printAllUsersAndPasswords(userRepository);
						}
					}
				}else {
					System.out.println("Wrong operation!");
				}
			}
		}
	}
}