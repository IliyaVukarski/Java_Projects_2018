package Credentials;

import java.time.LocalDateTime;
/**
 * 
 * @author Iliya Vukarski
 *
 */
public class RegularUser extends Credentials {
	
	public RegularUser() {
		
	}
	
	public RegularUser(String username, String password) {
		super(username, password);
	}

	public RegularUser(String username, String password,
			LocalDateTime timeOfRegister) {
		super(username, password, timeOfRegister);
	}
}