package Employee;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * @author Iliya Vukarksi
 *
 */                  
public class EmployeeRepo {
	public static void main(String[] args) {
		System.out.println("For how many people are you typing an information? ");
		Scanner scanner = new Scanner(System.in);
		int numberOfStaff = 0;
		boolean isValid = true;
		do {
			if(scanner.hasNextInt()) {
				numberOfStaff = scanner.nextInt();
				isValid = true;
			}else {
				System.out.println("Enter correct data! ");
				isValid = false;
				scanner.next();
			}
		}while(!isValid);
		List<Employee> employees = new ArrayList<Employee>();
		
		Employee employee = null;
		Manager manager = null;
		do {
			System.out.println("Choose type of staff: Employee or Manager.");
			String typeOfStaff = scanner.next();
			System.out.println("Enter first name.");
			String firstName = scanner.next();
			System.out.println("Enter last name.");
			String lastName = scanner.next();
			System.out.println("Enter salary.");
			double salary = 0;
			do {
				if(scanner.hasNextDouble()) {
					salary = scanner.nextDouble();
					isValid = true;
				}else {
					System.out.println("Enter correct data!");
					isValid = true;
					scanner.next();
				}
			}while(!isValid);
			System.out.println("Enter age.");
			int age = 0;
			do {
				if(scanner.hasNextInt()) {
					age = scanner.nextInt();
					isValid = true;
				}else {
					System.out.println("Enter correct data!");
					isValid = false;
					scanner.next();
				}
			}while(!isValid);
			System.out.println("Enter email.");
			String email = scanner.next();
			System.out.println("Enter department.");
			String department = scanner.next();
			System.out.println("Enter occupation.");
			String occupation = scanner.next();
			System.out.println("Enter hire date year/month/day.");
			String[] dateOfHiring = scanner.next().split("/");
			int[] empHireDate = new int[3];
			for(int index = 0; index < dateOfHiring.length; index++) {
				int date = Integer.parseInt(dateOfHiring[index]);
				empHireDate[index] = date;
			}
			LocalDate hireDate = LocalDate.of(empHireDate[0], empHireDate[1], empHireDate[2]);
			if(typeOfStaff.equals("Employee")) {
				employee = new Employee(firstName, lastName, salary, age, email, department, occupation, hireDate);
				employees.add(employee);
			}else if(typeOfStaff.equals("Manager")) {
				manager = new Manager(firstName, lastName, salary, age, email, department, occupation, hireDate);
				employees.add(manager);
			}else {
				System.out.println("Wrong type of staff");
			}
			numberOfStaff--;
		}while(numberOfStaff != 0);
		System.out.println("Ascending order of employee salary.");
		employee.employeeSalaryAscendingSort(employees);
		System.out.println("Descneding order of employee salary.");
		employee.employeeSalaryDescendingSort(employees);
		System.out.println("Enter percentage of salary raise.");
		double percentRaise = 0;
		do {
			if(scanner.hasNextDouble()) {
				percentRaise = scanner.nextDouble();
				isValid = true;
			}else {
				System.out.println("Enter correct data.");
				isValid = false;
				scanner.next();
			}
		}while(!isValid);
		employee.raiseSalary(employees, percentRaise);
		
		System.out.println("Enter the name of the person who's going to be fired.");
		String firedEmpFirstName = scanner.next();
		String firedEmpLastName = scanner.next();
		Employee empFired = new Employee(firedEmpFirstName, firedEmpLastName);
		
		System.out.println("Enter the name of the manager who's going to fire the employee.");
		String firingManFirstName = scanner.next();
		String firingManLastName = scanner.next();
		Manager manFiring = new Manager(firingManFirstName, firingManLastName);
		manFiring.fireEmployee(employees, empFired, manFiring);
		
		System.out.println("Enter amount of the bonus");
		double bonus = 0;
		do {
			if(scanner.hasNextDouble()) {
				bonus = scanner.nextDouble();
				isValid = true;
			}else {
				System.out.println("Enter correct data!");
				isValid = false;
				scanner.next();
			}
		}while(!isValid);
		manager.calculateBonus(employees, bonus);
		
		System.out.println("Enter the name of the person who's going to be hired. ");
		System.out.println("Enter first name.");
		String hiredEmpFirstName = scanner.next();
		System.out.println("Enter last name.");
		String hiredEmpLastName = scanner.next();
		System.out.println("Enter salary.");
		double salary = 0;
		do {
			if(scanner.hasNextDouble()) {
				salary = scanner.nextDouble();
				isValid = true;
			}else {
				System.out.println("Enter correct data!");
				isValid = true;
				scanner.next();
			}
		}while(!isValid);
		System.out.println("Enter age.");
		int age = 0;
		do {
			if(scanner.hasNextInt()) {
				age = scanner.nextInt();
				isValid = true;
			}else {
				System.out.println("Enter correct data!");
				isValid = false;
				scanner.next();
			}
		}while(!isValid);
		System.out.println("Enter email.");
		String email = scanner.next();
		System.out.println("Enter department.");
		String department = scanner.next();
		System.out.println("Enter occupation.");
		String occupation = scanner.next();
		LocalDate hiredDate = LocalDate.now();
		Employee empHired = new Employee(hiredEmpFirstName, hiredEmpLastName, salary, age, email, department, occupation, hiredDate);
		
		System.out.println("Enter the name of the manager who's going to hire the employee.");
		String hiringManFirstName = scanner.next();
		String hiringManLastName = scanner.next();
		Manager manHiring = new Manager(hiringManFirstName, hiringManLastName);
		manFiring.hireEmployee(employees, empHired, manHiring);
	}
}