package SwiftDate;
import java.util.Scanner;

/**
 * 
 * @author Iliya Vukarski
 *
 */
public class Calendar {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		SwiftDate date1 = new SwiftDate();
		SwiftDate date2 = new SwiftDate();
		System.out.println("Enter two dates from the calendar yyyy/mm/dd.");
		System.out.println("Enter first date.");
		String[] dateOne = scanner.next().split("/");
		int[] arrayDateOne = new int[3];
		for(int index = 0; index < dateOne.length; index++) {
			int date = Integer.parseInt(dateOne[index]);
			arrayDateOne[index] = date;
		}
		date1.setYear(arrayDateOne[0]);
		date1.setMonth(arrayDateOne[1]);
		date1.setDay(arrayDateOne[2]);
		date1.printInfo();
		System.out.println();
		System.out.println("Enter second date.");
		String[] dateTwo = scanner.next().split("/");
		int[] arrayDateTwo = new int[3];
		for(int index = 0; index < dateTwo.length; index++) {
			int date = Integer.parseInt(dateTwo[index]);
			arrayDateTwo[index] = date;
		}
		date2.setYear(arrayDateTwo[0]);
		date2.setMonth(arrayDateTwo[1]);
		date2.setDay(arrayDateTwo[2]);
		date2.printInfo();
		System.out.println();
		SwiftDate.getDateDifference(date1, date2);
		System.out.println();
		System.out.println("Check birthday Day");
		date1.checkBirthdayDate(date1);
		date2.checkBirthdayDate(date2);
		System.out.println();
		System.out.println("Check if date is odd or even");
		date1.checkIfTodaysDateIsEvenOrOdd(date1);
		date2.checkIfTodaysDateIsEvenOrOdd(date2);
	}
}