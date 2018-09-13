package PeoplePresentation;
/**
 * 
 * @author Iliya Vukarski
 *
 */
public class Worker extends Person {
	private String title;
	private double weekSalary;
	private int workHoursPerDay;
	
	public Worker() {
		
	}
	
	public Worker(String firstName, String lastName, 
			   double weekSalary, int workHoursPerDay, String title) {
	super(firstName, lastName);
	this.weekSalary = weekSalary;
	this.workHoursPerDay = workHoursPerDay;
	this.title = title;
}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getWeekSalary() {
		return weekSalary;
	}

	public void setWeekSalary(double weekSalary) {
		this.weekSalary = weekSalary;
	}

	public int getWorkHoursPerDay() {
		return workHoursPerDay;
	}

	public void setWorkHoursPerDay(int workHoursPerDay) {
		this.workHoursPerDay = workHoursPerDay;
	}
	
	public double calculateSalary() {
		double totalSalary = 0;
		double titleCoeff = 0;
		switch(title) {
			case "Bachelor":
				titleCoeff = 0.4;
				break;
			case "Master":
				titleCoeff = 0.8;
				break;
			case "Phd":
				titleCoeff = 1;
				break;
			case "Doctor":
				titleCoeff = 1.5;
				break;
			case "Docent":
				titleCoeff = 1.8;
				break;
			case "Profesor":
				titleCoeff = 2;
				break;
			default:
				System.out.println("No such title.");
				break;
		}
		double salary = (weekSalary / workHoursPerDay) * this.getDAYSOFWEEK();
		double salaryCoeff = salary * titleCoeff;
		totalSalary = salary + salaryCoeff;
		return totalSalary;
	}
}
