package Employee;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 
 * @author Iliya Vukarksi
 *
 */
public class Employee {
	private String firstName;
	private String lastName;
	private double salary;
	private int age;
	private String email;
	private String department;
	private String occupation;
	private LocalDate hireDate;
	
	public Employee() {
		
	}
	
	public Employee(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public Employee(String firstName, String lastName, double salary, int age,
			String email, String department, String occupation, LocalDate hireDate) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
		this.age = age;
		this.email = email;
		this.department = department;
		this.occupation = occupation;
		this.hireDate = hireDate;
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

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	
	public LocalDate getHireDate() {
		return hireDate;
	}

	public void setHireDate(LocalDate hireDate) {
		this.hireDate = hireDate;
	}
	
	public void raiseSalary(List<Employee> employees, double percentRaise) {
		for(Employee emp : employees) {
			System.out.println("Employee salary before raise. ");
			System.out.println(emp.getFirstName() + " " + 
							   emp.getLastName() + " " + 
							   emp.getSalary());
		}
		
		for(int index = 0; index < employees.size(); index++) {
			double raise = ((employees.get(index).getSalary()) * (percentRaise / 100));
			double currentSalaryEmployee = employees.get(index).getSalary();
			employees.get(index).setSalary(currentSalaryEmployee + raise); 
		}
		
		for(Employee emp : employees) {
			System.out.println("Employee salary after raise. ");
			System.out.println(emp.getFirstName() + " " + 
							   emp.getLastName() + " " + 
							   emp.getSalary());
		}
	}
	
	public void employeeSalaryAscendingSort(List<Employee> employees) {
		Collections.sort(employees, new Comparator<Employee>() {
			@Override
			public int compare(Employee emp1, Employee emp2) {
				return (int) (emp1.getSalary() - emp2.getSalary());
			}
		});
		for(Employee emp : employees) {
			System.out.println(emp.getFirstName() + " " + 
							   emp.getLastName() + " " + 
							   emp.getSalary() + " " +
							   emp.getAge() + " " + 
							   emp.getEmail() + " " +
							   emp.getDepartment() + " " + 
							   emp.getOccupation() + " " +
							   emp.getHireDate());
		}
	}
	
	public void employeeSalaryDescendingSort(List<Employee> employees) {
		Collections.sort(employees, new Comparator<Employee>() {
			@Override
			public int compare(Employee emp1, Employee emp2) {
				return (int) (emp2.getSalary() - emp1.getSalary());
			}
		});
		for(Employee emp : employees) {
			System.out.println(emp.getFirstName() + " " + 
							   emp.getLastName() + " " + 
							   emp.getSalary() + " " +
							   emp.getAge() + " " + 
							   emp.getEmail() + " " +
							   emp.getDepartment() + " " + 
							   emp.getOccupation() + " " +
							   emp.getHireDate());
		}
	}
}
