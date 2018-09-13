package PeoplePresentation;
/**
 * 
 * @author Iliya Vukarski
 *
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UniversityRepo {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		List<String> commands = new ArrayList<String>();
		commands.add("END");
		commands.add("STUDENT");
		commands.add("WORKER");
		commands.add("STINFO");
		commands.add("WORINFO");
		Person person = null;
		List<Person> peopleRepo = new ArrayList<Person>();
		String[] inputCommand = null;
		while(true) {
			System.out.println("Choose command: END, STUDENT, WORKER, STINFO, WORINFO.");
			inputCommand = scanner.next().split(" ");
			boolean isValid = true;
			if(inputCommand[0].endsWith(commands.get(0))) {
				break;
			}
			for(String comm : inputCommand) {
				if(comm.equals(commands.get(1))) {
					System.out.println("FName LName lectureCount exerciseCount numberOfDisciplines");
					String firstName = scanner.next();
					String lastName = scanner.next();
					int lectureCount = 0;
					int exerciseCount = 0;
					int numberOfDisciplines = 0;
					
					do {
						if(scanner.hasNextInt()) {
							lectureCount = scanner.nextInt();
							isValid = true;
						}else {
							System.out.println("Enter valid value");
							scanner.next();
							isValid = false;
						}
					}while(!isValid);
					
					do {
						if(scanner.hasNextInt()) {
							exerciseCount = scanner.nextInt();
							isValid = true;
						}else {
							System.out.println("Enter valid value");
							scanner.next();
							isValid = false;
						}
					}while(!isValid);
					
					do {
						if(scanner.hasNextInt()) {
							numberOfDisciplines = scanner.nextInt();
							isValid = true;
						}else {
							System.out.println("Enter valid value");
							scanner.next();
							isValid = false;
						}
					}while(!isValid);
					person = new Student(firstName, lastName, lectureCount, exerciseCount, numberOfDisciplines);
					peopleRepo.add(person);
				}else if(comm.equals(commands.get(2))) {
					System.out.println("FName LName weekSalary workHoursPerDay title");
					String firstName = scanner.next();
					String lastName = scanner.next();
					double weekSalary = 0;
					do {
						if(scanner.hasNextDouble()) {
							weekSalary = scanner.nextDouble();
							isValid = true;
						}else {
							System.out.println("Enter valid value");
							scanner.next();
							isValid = false;
						}
					}while(!isValid);
					
					int workHoursPerDay = 0;
					do {
						if(scanner.hasNextInt()) {
							workHoursPerDay = scanner.nextInt();
							isValid = true;
						}else {
							System.out.println("Enter valid value");
							scanner.next();
							isValid = false;
						}
					}while(!isValid);
					String title = scanner.next();
					person = new Worker(firstName, lastName, weekSalary, workHoursPerDay, title);
					peopleRepo.add(person);
					System.out.println();
				}else if(comm.equals(commands.get(3))) {
					for(int index = 0; index < peopleRepo.size(); index++) {
						if(peopleRepo.get(index) instanceof Student) {
							System.out.printf("%.2f hours per day for student %s %s: %n",
												((Student)peopleRepo.get(index)).calculateHoursPerWeek(),
												peopleRepo.get(index).getFirstName(), 
												peopleRepo.get(index).getLastName());
						}else {
							System.out.printf("This %s %s is not a student! %n", 
													peopleRepo.get(index).getFirstName(),
													peopleRepo.get(index).getLastName());
						}
						if(peopleRepo.get(index) instanceof Student) {
							System.out.printf("%.2f Credits per student %s %s: %n", 
												((Student)peopleRepo.get(index)).calculateCredits(),
												peopleRepo.get(index).getFirstName(), 
												peopleRepo.get(index).getLastName());
						}else {
							System.out.printf("This %s %s is not a student! %n", 
												peopleRepo.get(index).getFirstName(),
												peopleRepo.get(index).getLastName());
						}
					}
					System.out.println();
				}else if(comm.equals(commands.get(4))) {
					for(int index = 0; index < peopleRepo.size(); index++) {
						if(peopleRepo.get(index) instanceof Worker) {
							System.out.printf("Salary %.2f per hour for worker %s %s. %n",
									((Worker)peopleRepo.get(index)).calculateSalary(),
									peopleRepo.get(index).getFirstName(),
									peopleRepo.get(index).getLastName());
						}else {
							System.out.printf("This %s %s is not a Wokrer! %n",
												peopleRepo.get(index).getFirstName(),
												peopleRepo.get(index).getLastName());
						}
					}
					System.out.println();
				}else {
					System.out.println("Wrong command!");
				}
			}
		}
	}
}