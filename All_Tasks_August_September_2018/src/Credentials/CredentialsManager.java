package Credentials;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
/**
 * 
 * @author Iliya Vukarski
 *
 */
public class CredentialsManager {
	private Credentials credentials;
	private List<Credentials> userRepository;
	private List<String> oldPasswordRepo;
	
	public CredentialsManager() {
		
	}
	
	public CredentialsManager(Credentials credentials,
			List<Credentials> userRepository, List<String> oldPasswordRepo) {
		super();
		this.credentials = credentials;
		this.userRepository = userRepository;
		this.oldPasswordRepo = oldPasswordRepo;
	}
	
	public Credentials getCredentials() {
		return credentials;
	}

	public void setCredentials(Credentials credentials) {
		this.credentials = credentials;
	}

	public List<Credentials> getUserRepository() {
		return userRepository;
	}

	public void setUserRepository(List<Credentials> userRepository) {
		this.userRepository = userRepository;
	}

	public List<String> getOldPasswordRepo() {
		return oldPasswordRepo;
	}

	public void setOldPasswordRepo(List<String> oldPasswordRepo) {
		this.oldPasswordRepo = oldPasswordRepo;
	}
	public void addNewUsers(Credentials credentials) {
		LocalDateTime timeOfRegister = LocalDateTime.now();
		String date = timeOfRegister.toString();
		List<String> allUsers = new ArrayList<String>();
		for(int index = 0; index < userRepository.size(); index++) {
			String currentUser = userRepository.get(index).getUsername();
			allUsers.add(currentUser);
		}
		if(!allUsers.contains(credentials.getUsername())) {
			credentials.setTimeOfRegister(timeOfRegister);
			userRepository.add(credentials);
			System.out.printf("Successfully added new user %s register on %s.", credentials.getUsername(), date);
		}else {
			System.out.println("This user already exists in the system.");
		}
	}
	
	public void removeUser(String username, String password) {
		for(int index = 0; index < userRepository.size(); index++) {
			if(userRepository.get(index).getUsername().equals(username) &&
			   userRepository.get(index).getPassword().equals(password)) {
				System.out.printf("Remove user %s from the system!", userRepository.get(index).getUsername());
				userRepository.remove(index);
			}else if(userRepository.get(index).getUsername() != (username) ||
					 userRepository.get(index).getPassword() != (password)) {
				System.out.println("Wrong username or password.");
			}
		}
	}
	
	public void changePassword(String username, String password, String newPassword) {
		for(int index = 0; index < userRepository.size(); index++) {
			if(userRepository.get(index).getUsername().equals(username) &&
			   userRepository.get(index).getPassword().equals(password)) {
				String oldPassword = userRepository.get(index).getPassword();
				oldPasswordRepo.add(oldPassword);
				for(String pass : oldPasswordRepo) {
					if(newPassword != pass) {
						userRepository.get(index).setPassword(newPassword);
						System.out.printf("The user %s has successfully changed his password.", username);
					}else {
						System.out.println("Error! This password already exists in the system.");
					}
				}
				System.out.println();
			}else if(userRepository.get(index).getUsername() != (username) ||
					 userRepository.get(index).getPassword() != (password)) {
				System.out.println("Wrong username or password.");
			}
		}
	}
	
	public void authorizeUser(String username, String password) {
		for(int index = 0; index < userRepository.size(); index++) {
			if(userRepository.get(index).getUsername().equals(username) &&
					userRepository.get(index).getPassword().equals(password)) {
				System.out.println("Access granted!");
			}else if(userRepository.get(index).getUsername() != (username) ||
					userRepository.get(index).getPassword() != (password)) {
				System.out.println("Access denied!");
			}
		}
	}
	
	public void printAllUsersAndPasswords(List<Credentials> userRepository) {
		if(credentials instanceof PowerUser) {
			for(Credentials credentials : userRepository) {
				System.out.printf("Username %s Password %s  %d",credentials.getUsername(), credentials.getPassword(), credentials.getId());
				System.out.println();
			}
		}
	}
}