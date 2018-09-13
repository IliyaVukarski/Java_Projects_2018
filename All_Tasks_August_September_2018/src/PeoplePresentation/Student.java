package PeoplePresentation;
/**
 * 
 * @author Iliya Vukarski
 *
 */
public class Student extends Person {
	private String facultyNumber;
	private int lectureCount;
	private int exerciseCount;
	private int numberOfDisciplines;
	private final int NUMBEROFSEMESTERS = 8;

	
	public Student() {
		
	}
	
	public Student(String firstName, String lastName, 
				   int lectureCount, int exerciseCount, int numberOfDisciplines) {
		super(firstName, lastName);
		this.lectureCount = lectureCount;
		this.exerciseCount = exerciseCount;
		this.numberOfDisciplines = numberOfDisciplines;
	}
	
	public String getFacultyNumber() {
		return facultyNumber;
	}

	public void setFacultyNumber(String facultyNumber) {
		this.facultyNumber = facultyNumber;
	}

	public int getLectureCount() {
		return lectureCount;
	}

	public void setLectureCount(int lectureCount) {
		this.lectureCount = lectureCount;
	}

	public int getExerciseCount() {
		return exerciseCount;
	}

	public void setExerciseCount(int exerciseCount) {
		this.exerciseCount = exerciseCount;
	}
	
	public int getNumberOfDisciplines() {
		return numberOfDisciplines;
	}

	public void setNumberOfDisciplines(int numberOfDisciplines) {
		this.numberOfDisciplines = numberOfDisciplines;
	}
	
	public int getNumberofsemesters() {
		return NUMBEROFSEMESTERS;
	}

	public double calculateHoursPerWeek() {
		if(lectureCount >= 0 && exerciseCount >= 0) {
			double totalHours = 0;
 			double lecturesCount = lectureCount * 2;
			double exercisesCount = exerciseCount * 1.5;
			totalHours = (lecturesCount + exercisesCount) / this.getDAYSOFWEEK();
			return totalHours;
		}else {
			System.out.println("Wrong input!");
			return 0;
		}
	}
	
	public double calculateCredits() {
		if(lectureCount >= 0 && exerciseCount >= 0) {
			double totalCredits = 0;
			double lecturesCredit = lectureCount * 1.75;
			double exercisesCredit = exerciseCount * 1.25;
			totalCredits = ((lecturesCredit + exercisesCredit) * numberOfDisciplines) * NUMBEROFSEMESTERS; 
			return totalCredits;		
		}else {
			System.out.println("Wrong input!");
			return 0;
		}
	}
}