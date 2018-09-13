package Vehicle;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * 
 * @author Iliya Vukarski
 *
 */
public class InsuranceVehicleRepo {
	public static void main(String[] args) {
		List<Vehicle> vehicles = new ArrayList<Vehicle>();
		Scanner scanner = new Scanner(System.in);
		System.out.println("For how many vehicles are you typing an information?");
		int numberOfVehicles = 0;
		boolean isValid = true;
		do {
			if(scanner.hasNextInt()) {
				numberOfVehicles = scanner.nextInt();
				isValid = true;
			}else {
				System.out.println("Enter valid value!");
				isValid = false;
				scanner.next();
			}
		}while(!isValid);
		System.out.println("Enter gas price! ");
		double fuelPrice = 0;
		do {
			if(scanner.hasNextDouble()) {
				fuelPrice = scanner.nextDouble();
				isValid = true;
			}else {
				System.out.println("Enter valid value!");
				isValid = false;
				scanner.next();
			}
		}while(!isValid);
		Vehicle vehicle = null;
		do {
			vehicle = new Vehicle();
			System.out.println("Enter type. Choose between car, suv, truck, motorcycle.");
			String type = scanner.next();
			vehicle.setType(type);
			System.out.println("Enter model.");
			String model = scanner.next();
			vehicle.setModel(model);
			System.out.println("Enter power.");
			double power = 0;
			do {
				if(scanner.hasNextDouble()) {
					power = scanner.nextDouble();
					isValid = true;
				}else {
					System.out.println("Enter valid value.");
					isValid = false;
					scanner.next();
				}
			}while(!isValid);
			vehicle.setPower(power);
			System.out.println("Enter fuel consumption.");
			double fuelConsumption = 0;
			do {
				if(scanner.hasNextDouble()) {
					fuelConsumption = scanner.nextDouble();
					isValid = true;
				}else {
					System.out.println("Enter valid value.");
					isValid = false;
					scanner.next();
				}
			}while(!isValid);
			vehicle.setFuelConsumption(fuelConsumption);
			System.out.println("Enter year produced.");
			int yearProduced = 0;
			do {
				if(scanner.hasNextInt()) {
					yearProduced = scanner.nextInt();
					isValid = true;
				}else {
					System.out.println("Enter valid value.");
					isValid = false;
					scanner.next();
				}
			}while(!isValid);
			vehicle.setYearProduced(yearProduced);
			System.out.println("Enter distance travelled.");
			double distanceTravelled = 0;
			do {
				if(scanner.hasNextDouble()) {
					distanceTravelled = scanner.nextDouble();
					isValid = true;
				}else {
					System.out.println("Enter valid value.");
					isValid = false;
					scanner.next();
				}
			}while(!isValid);
			vehicle.setDistanceTravelled(distanceTravelled);
			System.out.println("Enter weight.");
			int weight = 0;
			do {
				if(scanner.hasNextInt()) {
					weight = scanner.nextInt();
					isValid = true;
				}else {
					System.out.println("Enter valid value.");
					isValid = false;
					scanner.next();
				}
			}while(!isValid);
			vehicle.setWeight(weight);
			System.out.println("Enter color. ");
			String color = scanner.next();
			vehicle.setColor(color);
			System.out.println("Enter number of seats.");
			int numberOfSeats = 0;
			do {
				if(scanner.hasNextInt()) {
					numberOfSeats = scanner.nextInt();
					isValid = true;
				}else {
					System.out.println("Enter valid value.");
					isValid = false;
					scanner.next();
				}
			}while(!isValid);
			vehicle.setNumberOfSeats(numberOfSeats);
			System.out.println("Enter year/month/day of licence number");
			String[] dateArray = scanner.next().split("/");
			int[] dateArr = new int[3];
			for(int index =0; index < dateArray.length; index++) {
				int date = Integer.parseInt(dateArray[index]);
				dateArr[index] = date;
			}
			LocalDate dateOfRegister = LocalDate.of(dateArr[0], dateArr[1], dateArr[2]);
			vehicle.setDateOfRegister(dateOfRegister);
			vehicles.add(new Vehicle(vehicle.getType(), 
								     vehicle.getModel(), 
									 vehicle.getPower(), 
									 vehicle.getFuelConsumption(),
									 vehicle.getYearProduced(), 
									 vehicle.getDistanceTravelled(),
									 vehicle.getWeight(), 
									 vehicle.getColor(), 
									 vehicle.getNumberOfSeats(),
									 vehicle.getDateOfRegister()));
			numberOfVehicles--;
		}while(numberOfVehicles !=0);
		for(Vehicle veh : vehicles) {
			int carNumber = 0;
			DecimalFormat decimalFormat = new DecimalFormat("0000");
			for(int index = 0; index < vehicles.size(); index++) {
				carNumber++;
				vehicles.get(index).setLicenceNo(decimalFormat.format(carNumber));
			}
			System.out.println("Choose period of validaty - Daily, Weekly, Monthly, Annual");
			String periodOfValidity = scanner.next();
			System.out.println("Model: " + veh.getModel() + 
							   " Type: " + veh.getType() + 
							   " Year produced: " + veh.getYearProduced() + 
							   " Color: " + veh.getColor() + 
							   " Distance travelled: " + veh.getDistanceTravelled() +
							   " Number of seats: " +  veh.getNumberOfSeats() + 
							   " Date of licence number register " + veh.getDateOfRegister() +
							   " Insurance cost: " +  veh.getInsurancePrice() + " Dollars" +
							   " Travel cost: " + veh.calculatePriceTravel(fuelPrice) + 
							   " Licence number: " + veh.getLicenceNo() + 
							   " Vignette tax " +  veh.getVignetteTax(periodOfValidity) + " dollars.");
		}
	}
}