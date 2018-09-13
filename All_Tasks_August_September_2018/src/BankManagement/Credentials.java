package BankManagement;

import java.time.LocalDate;
/**
 * 
 * @author Iliya Vukarski
 *
 */
public class Credentials {
	private String username;
	private String password;
	private LocalDate timeRegister;
	private int userId = enrollId();
	private static int nextId = 1;
	
	public Credentials() {
		
	}
	
	public Credentials(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public Credentials(String username, String password, LocalDate timeRegister) {
		this.username = username;
		this.password = password;
		this.timeRegister = timeRegister;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDate getTimeRegister() {
		return timeRegister;
	}

	public void setTimeRegister(LocalDate timeRegister) {
		this.timeRegister = timeRegister;
	}
	
	public int getUserId() {
		return userId;
	}
	
	public int enrollId() {
		int r = nextId;
		nextId++;
		return r;
	}
}