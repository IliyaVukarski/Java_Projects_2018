package PeoplePresentation;
/**
 * 
 * @author Iliya Vukarski
 *
 */
public abstract class Person {
	private String firstName;
	private String lastName;
	private final int DAYSOFWEEK = 5;
	
	public Person() {
		
	}
	
	public Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public int getDAYSOFWEEK() {
		return DAYSOFWEEK;
	}
}