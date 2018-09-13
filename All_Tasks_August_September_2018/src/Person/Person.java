package Person;

import java.time.Year;
/**
 * 
 * @author Iliya Vukarski
 *
 */
public class Person {
	private static short gradesCount = 4;
	private String firstName;
	private String lastName;
	private String placeOfBirth;
	private int yearBorn;
	private char gender;
	private double weight;
	private double height;
	private String occupation;
	private double[] grades;
	private String[] schoolInstitutionsStudied;
	private String[] languagesSpoken;
	
	public Person() {
		
	}
	
	public Person(String firstName, String lastName, String placeOfBirth,
			int yearBorn, char gender, double weight, double height,
			String occupation, double[] grades,
			String[] schoolInstitutionsStudied, String[] languagesSpoken) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.placeOfBirth = placeOfBirth;
		this.yearBorn = yearBorn;
		this.gender = gender;
		this.weight = weight;
		this.height = height;
		this.occupation = occupation;
		this.grades = grades;
		this.schoolInstitutionsStudied = schoolInstitutionsStudied;
		this.languagesSpoken = languagesSpoken;
	}
	
	public static short getGradesCount() {
		return gradesCount;
	}

	public static void setGradesCount(short gradesCount) {
		Person.gradesCount = gradesCount;
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

	public String getPlaceOfBirth() {
		return placeOfBirth;
	}

	public void setPlaceOfBirth(String placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
	}

	public int getYearBorn() {
		return yearBorn;
	}

	public void setYearBorn(int yearBorn) {
		this.yearBorn = yearBorn;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public double[] getGrades() {
		return grades;
	}

	public void setGrades(double[] grades) {
		this.grades = grades;
	}

	public String[] getSchoolInstitutionsStudied() {
		return schoolInstitutionsStudied;
	}

	public void setSchoolInstitutionsStudied(String[] schoolInstitutionsStudied) {
		this.schoolInstitutionsStudied = schoolInstitutionsStudied;
	}

	public String[] getLanguagesSpoken() {
		return languagesSpoken;
	}

	public void setLanguagesSpoken(String[] languagesSpoken) {
		this.languagesSpoken = languagesSpoken;
	}

	public double calculateAverageGrades() {
		double averageGrade = 0;
		double sum = 0;
		for(int index = 0; index < grades.length; index++) {
			sum = sum + grades[index];
			averageGrade = (sum / gradesCount);
		}
		return averageGrade;
	}
	
	public int getAge() {
		int currentYear = Year.now().getValue();
		int age = currentYear - yearBorn;
		return age;
	}
	
	public boolean isUnderAged() {
		boolean underAged = true;
		if(this.getAge() < 18) {
			underAged = true;
		}else {
			underAged = false;
		}
		return underAged;
	}
	
	public String getInfo() {
		String heOrShe = null;
		String hisOrHer = null;
		String isOrNotUnderAged = null;
		if(isUnderAged()) {
			isOrNotUnderAged = "is ";
		}else {
			isOrNotUnderAged = "is not";
		}
		if(gender == 'M') {
			heOrShe = "He";
			hisOrHer = "His";
		}else {
			heOrShe = "She";
			hisOrHer = "Her";
		}
		String result = String.format("%s, %s is %d years old, from %s. ", this.getFirstName(), 
				this.getLastName(), this.getAge(), this.getPlaceOfBirth());
		result = result + String.format("%s was born in %d year. ", heOrShe, this.getYearBorn());
		result = result + String.format(hisOrHer + " weight is " +  this.getWeight() + " and " +
										heOrShe.toLowerCase() + " is a " + this.getHeight() + " sm tall. ");
		result = result + " His highest grades from school are  ";
		for(int grade = 0; grade < grades.length; grade++) {
			result = " " + result + grades[grade] + ", ";
		}
		result = result + " and he speaks ";
		for(int language = 0; language < languagesSpoken.length; language++) {
			result = " " + result + languagesSpoken[language] + ",";
		}
		result = result + " He has been studied in ";
		for(int school = 0; school < schoolInstitutionsStudied.length; school++) {
			result = " " + result + schoolInstitutionsStudied[school] + ",";
		}
		
		result = result + String.format(" %s  %s  underaged ", heOrShe, isOrNotUnderAged);
		result = result + String.format("%s is a %s " + " with an average of %.2f ", heOrShe, this.getOccupation(), this.calculateAverageGrades());
		return result;
	}
}