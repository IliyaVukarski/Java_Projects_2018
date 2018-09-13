package PersonStreamRead;

/**
 * 
 * @author Iliya Vukarski
 *
 */

import java.time.LocalDate;
public class Person {
	private String firstName;
	private String middleName;
	private String lastName;
	private char gender;
	private final LocalDate dateOfBirth;
	private short height;
	private Address address;
	private Education education;
	
	public Person(String firstName, String middleName, String lastName,
			char gender, LocalDate dateOfBirth, short height) {
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.height = height;
	}
	
	public Person(String firstName, String middleName, String lastName,
			char gender, LocalDate dateOfBirth, short height, Address address,
			Education education) {
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.height = height;
		this.address = address;
		this.education = education;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public short getHeight() {
		return height;
	}

	public void setHeight(short height) {
		this.height = height;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Education getEducation() {
		return education;
	}

	public void setEducation(Education education) {
		this.education = education;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
}
