package PersonStreamRead;
/**
 * 
 * @author Iliya Vukarski
 *
 */

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class PersonCharacteristics {

	private static DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("d.M.yyyy");
 	
	public static Person readPerson(String stream) {
		String[] split = stream.split(";");
		Person person = readPersonalDetails(split, 0);
		Address address = readAddress(split, 6);
		Education education = readEducation(split, 14);
		person.setAddress(address);
		person.setEducation(education);
		return person;
	}
	
	public static Person readPersonalDetails(String[] split, int idx) {
		String firstName = split[idx++];
		String middleName = split[idx++];
		String lastName = split[idx++];
		char gender = Character.toUpperCase(split[idx++].toCharArray()[0]);
		LocalDate dateOfBirth = LocalDate.parse(split[idx++].trim(), FORMATTER);
		short height = Short.parseShort(split[idx++].trim());
		
		return new Person(firstName, middleName, lastName, gender, dateOfBirth, height);
	}
 	
 	public static Address readAddress(String[] split, int idx) {
 		String country = split[idx++].trim();
 		String city = split[idx++].trim();
 		String postalCode = split[idx++].trim();
 		String municipality = split[idx++].trim();
 		String streetNumber = split[idx++].trim();
 		String streetName = split[idx++].trim();
 		String floorNumberStr = split[idx++].trim();
 		String appartmentNumberStr = split[idx++].trim();
 		Integer floorNumber = floorNumberStr.isEmpty() ? null : Integer.parseInt(floorNumberStr);
 		Integer appartmentNumber = appartmentNumberStr.isEmpty() ? null : Integer.parseInt(appartmentNumberStr);
 		return new Address(country, city, postalCode, municipality, streetNumber, streetName, floorNumber, appartmentNumber);
 	}
 	
 	public static Education readEducation(String[] split, int idx) {
 		String degree = split[idx++].trim();
 		String institutionName = split[idx++].trim();
 		LocalDate enrollmentDate = LocalDate.parse(split[idx++].trim(), FORMATTER);
 		LocalDate graduationDate = LocalDate.parse(split[idx++].trim(), FORMATTER);
 		return new Education(degree, institutionName, enrollmentDate, graduationDate);
 	}
 	
 	public static void printPersonCharacteristics(List<Person> people) {
 		for(Person per : people) {
 			System.out.println(per.getFirstName() + " " + 
 							   per.getMiddleName() + " " + 
 							   per.getLastName() + " " + 
 							   per.getGender() + " " + 
 							   per.getDateOfBirth() + " " +
 							   per.getHeight() + " " +  
 							   per.getEducation().getDegree() + " " +
 							   per.getEducation().getInstitutionName() + " " +
 							   per.getEducation().getEnrollmentDate() + " " +
 							   per.getEducation().getGraduationDate() + " " +
 							   per.getAddress().getCountry() + " " + 
 							   per.getAddress().getCity() + " " +
 							   per.getAddress().getPostalCode() + " " + 
 							   per.getAddress().getMunicipality() + " " + 
 							   per.getAddress().getStreetNumber() + " " +
 							   per.getAddress().getStreetName() + " " + 
 							   per.getAddress().getFloorNumber() + " " + 
 							   per.getAddress().getAppartmentNumber());
 		}
 	}
 	
 	public static void main(String[] args) {
 	 	List<Person> people = new ArrayList<Person>();
 		Scanner scanner = new Scanner(System.in);
 		boolean isValid = true;
 		int numberOfRecords = 0;
 		String stream = "";
 		System.out.println("Enter number of people.");
 		do {
 			if(scanner.hasNextInt()) {
 				numberOfRecords = scanner.nextInt();
 				isValid = true;
 			}else {
 				System.out.println("Enter correct value.");
 				isValid = false;
 				scanner.next();
 			}
 		}while(!isValid);
 		scanner.nextLine();
 		for(int index = 0; index < numberOfRecords; index++) {
 			System.out.println("firstName;middleName;lastName;gender;dateOfBirth;height;country;city;postalCode;municipality;streetNumber;streetName;floorNumber;appartmentNumber;degree;institutionName;enrollmentDate;graduationDate");
 			stream = scanner.nextLine();
 			Person person = readPerson(stream);
 			people.add(person);
 		}
 		PersonCharacteristics.printPersonCharacteristics(people);
 	}
}
