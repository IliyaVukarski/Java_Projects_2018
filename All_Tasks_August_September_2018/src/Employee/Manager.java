package Employee;
import java.time.LocalDate;
import java.util.List;

/**
 * 
 * @author Iliya Vukarksi
 *
 */
public class Manager extends Employee {
	
	private double bonus; 
	
	public Manager() {
		
	}
	
	public Manager(String firstName, String lastName) {
		super(firstName, lastName);
	}
	
	public Manager(String firstName, String lastName, double salary, int age,
			String email, String department, String occupation, LocalDate hireDate) {
		super(firstName, lastName, salary, age, email, department, occupation, hireDate);
	}
	
	public double getBonus() {
		return bonus;
	}
	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
	
	public void calculateBonus(List<Employee> employees, double bonus) {
		for(int index = 0; index < employees.size(); index++) {
			if(employees.get(index) instanceof Manager) {
				double empSalary = employees.get(index).getSalary();
				employees.get(index).setSalary(empSalary + bonus);
			}
		}
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
	
	public void fireEmployee(List<Employee> employees, Employee emp, Manager man) {
		if(man instanceof Manager) {
			for(int index = 0; index < employees.size(); index++) {
				if(employees.get(index).getFirstName().equals(emp.getFirstName()) &&
				   employees.get(index).getLastName().equals(emp.getLastName())) {
					System.out.println("I am firing " + employees.get(index).getFirstName() 
												+ " " +	employees.get(index).getLastName() +
										 " Today is " + LocalDate.now());	
					System.out.println("This employee was fired by" + man.getFirstName() + 
																" " + man.getLastName());	
					employees.remove(index);
				}
			}
		}else {
			System.out.println("You are not authorized to hire this employee!");
		}
		
		for(Employee employee : employees) {
			System.out.println(employee.getFirstName() + " " +
							   employee.getLastName() + " " +
							   employee.getSalary() + " " +
							   employee.getAge() + " " + 
							   employee.getEmail() + " " +
							   employee.getDepartment() + " " + 
							   employee.getOccupation() + " " +
							   employee.getHireDate());
		}
	}
	
	public void hireEmployee(List<Employee> employees, Employee emp, Manager man) {
		if(man instanceof Manager) {
			System.out.println("Hiring new person " + emp.getFirstName() + " " 
					+ emp.getLastName() + " Today is " 
					+ LocalDate.now());
			employees.add(emp);
		}else {
			System.out.println("You are not authorized to hire this employee!");
		}
		
		System.out.println(emp.getFirstName() + " " + 
				   emp.getLastName() + " " + 
				   emp.getSalary() + " " +
				   emp.getAge() + " " + 
				   emp.getEmail() + " " +
				   emp.getDepartment() + " " + 
				   emp.getOccupation() + " " +
				   emp.getHireDate());
		System.out.println("This employee was hired by " + man.getFirstName() + " "
				   										 + man.getLastName());	
	}
}