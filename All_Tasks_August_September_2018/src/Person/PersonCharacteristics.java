package Person;

import java.util.Scanner;
/**
 * 
 * @author Hristo
 *
 */
public class PersonCharacteristics {
	public static Person[] enroll() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("For how many people are you going to type an information?");
		int numberOfPeople = 0;
		boolean isValid = true;
		do {
			if(scanner.hasNextInt()) {
				numberOfPeople = scanner.nextInt();
				isValid = true;
			}else {
				System.out.println("Enter correct value! ");
				isValid = false;
				scanner.next();
			}
		}while(!isValid);
		Person[] people = new Person[numberOfPeople];
		for(int index = 0; index < people.length; index++) {
			System.out.println("Enter first name.");
			String firstName = scanner.next();
			System.out.println("Enter last name.");
			String lastName = scanner.next();
			System.out.println("Enter place of birth.");
			String placeOfBirth = scanner.next();
			System.out.println("Enter year born.");
			int yearBorn = 0;
			do {
				if(scanner.hasNextInt()) {
					yearBorn = scanner.nextInt();
					isValid = true;
				}else {
					System.out.println("Enter correct value!");
					isValid = false;
					scanner.next();
				}
			}while(!isValid);
			System.out.println("Enter gender.");
			char gender = scanner.next().toCharArray()[0];
			System.out.println("Enter weight.");
			double weight = 0;
			do {
				if(scanner.hasNextDouble()) {
					weight = scanner.nextDouble();
					isValid = true;
				}else {
					System.out.println("Enter correct value.");
					isValid = false;
					scanner.next();
				}
			}while(!isValid);
			System.out.println("Enter height.");
			double height = 0;
			do {
				if(scanner.hasNextDouble()) {
					height = scanner.nextDouble();
					isValid = true;
				}else {
					System.out.println("Enter correct value!");
					isValid = false;
					scanner.next();
				}
			}while(!isValid);
			System.out.println("Enter occupation. ");
			String occupation = scanner.next();
			System.out.println("Enter for grades.");
			double[] grades = new double[Person.getGradesCount()];
			for(int grade = 0; grade < grades.length; grade++) {
				double currentGrade = 0;
				do {
					if(scanner.hasNextDouble()) {
						currentGrade = scanner.nextDouble();
						isValid = true;
					}else {
						System.out.println("Enter correct value.");
						isValid = false;
						scanner.next();
					}
				}while(!isValid);
				grades[grade] = currentGrade;
			}
			System.out.println("Enter all school Institutions studied.");
			System.out.println("Enter number of schools.");
			int numberOfSchools = 0;
			do {
				if(scanner.hasNextInt()) {
					numberOfSchools = scanner.nextInt();
					isValid = true;
				}else {
					System.out.println("Enter correct value!");
					isValid = false;
					scanner.next();
				}
			}while(!isValid);
			String[] schoolInstitutionsStudied = new String[numberOfSchools];
			for(int school = 0; school < schoolInstitutionsStudied.length; school++) {
				String currentSchool = null;
				currentSchool = scanner.next();
				schoolInstitutionsStudied[school] = currentSchool;
			}
			System.out.println("Enter all languages spoken.");
			System.out.println("Enter number of languages.");
			int numberOfLanguages = 0;
			do {
				if(scanner.hasNextInt()) {
					numberOfLanguages = scanner.nextInt();
					isValid = true;
				}else {
					System.out.println("Enter correct value!");
					isValid = false;
					scanner.next();
				}
			}while(!isValid);
			String[] languagesSpoken = new String[numberOfLanguages];
			for(int language = 0; language < languagesSpoken.length; language++) {
				String  currentLanguage = null;
				currentLanguage = scanner.next();
				languagesSpoken[language] = currentLanguage;
			}
			
			Person person = new Person(firstName, lastName, placeOfBirth, yearBorn, gender, weight, height, occupation, grades, schoolInstitutionsStudied, languagesSpoken);
			people[index] = person;
		}
		return people;
	}
	
	public static void main(String[] args) {
		Person[] people = enroll();
		for(Person person : people) {
			System.out.println(person.getInfo());
		}
	}
}