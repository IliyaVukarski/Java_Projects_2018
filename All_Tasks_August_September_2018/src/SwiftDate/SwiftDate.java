package SwiftDate;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * 
 * @author Iliya Vukarski
 *
 */
public class SwiftDate {
	private int year;
	private int month;
	private int day;
	
	public SwiftDate() {
		
	}
	
	public SwiftDate(int year, int month, int day) {
		super();
		this.year = year;
		this.month = month;
		this.day = day;
	}
	
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}
	
	public void  checkBirthdayDate(SwiftDate date) {
		int year = date.getYear();
		int month = date.getMonth();
		int day = date.getDay();
		LocalDate todaysDate = LocalDate.now();
		LocalDate birthdayDate = LocalDate.of(year, month, day);
		long dateDifference = 0;
		if(birthdayDate.isBefore(todaysDate)) {
			dateDifference = ChronoUnit.DAYS.between(birthdayDate, todaysDate);
			System.out.printf("You still have time to buy him/her a present. You have left %d days", Math.abs(dateDifference));
		}else if(birthdayDate.isEqual(todaysDate)) {
			System.out.println("Today is his/her birthday! Buy him/her a present.");
		}else if(birthdayDate.isAfter(todaysDate)) {
			System.out.printf("You missed his/her birthday. It was before %d days", Math.abs(dateDifference));
		}else {
			System.out.println("Wrong date.");
		}
	}
	
	public boolean isLeapYear() {
		boolean isValid = true;
		if(this.getYear() % 4 == 0 && this.getYear() % 100 != 0) {
			return isValid = true;
		}else if(this.getYear() % 100 == 0 && this.getYear() % 400 == 0) {
			return isValid = true;
		}else {
			return isValid = false;
		}
	}
	
	public int getCentury() {
		int century = 0;
		if(this.getYear() % 100 == 0) {
			century = this.getYear() / 100;
		}else {
			century = ((this.getYear() / 100)+ 1);
		}
		return century; 
	}
	
	public void printInfo() {
		if(isLeapYear()) {
			System.out.printf("%d %d %d - <%d> century. It's a leap year.", 
					this.getYear(), this.getMonth(), this.getDay(), this.getCentury());
		}else {
			System.out.printf("%d %d %d - <%d> century. It's not a leap year.",
					this.getYear(), this.getMonth(), this.getDay(), this.getCentury());
		}
	}
	
	public static void getDateDifference(SwiftDate d1, SwiftDate d2) {
		d1.printInfo();
		d2.printInfo();
		LocalDate localDate1 = LocalDate.of(d1.getYear(), d1.getMonth(), d1.getDay());
		LocalDate localDate2 = LocalDate.of(d2.getYear(), d2.getMonth(), d2.getDay());
		long dateDifferenceInDays = ChronoUnit.DAYS.between(localDate1, localDate2);
		System.out.printf("\n%d days. ", Math.abs(dateDifferenceInDays));
	}
	
	public void checkIfTodaysDateIsEvenOrOdd(SwiftDate date) {
		int todaysDate = date.getDay();
		if(todaysDate % 2 == 0) {
			System.out.println("Today's date is even.");
		}else if(todaysDate % 2 != 0) {
			System.out.println("Today's date is odd.");
		}else {
			System.out.println("Wron input!");
		}
	}
}