package Credentials;

import java.time.LocalDateTime;
/**
 * 
 * @author Iliya Vukarski
 *
 */
public class PowerUser extends Credentials {
	public PowerUser() {
		
	}
	
	public PowerUser(String username, String password) {
		super(username, password);
	}

	public PowerUser(String username, String password,
			LocalDateTime timeOfRegister) {
		super(username, password, timeOfRegister);
	}
}