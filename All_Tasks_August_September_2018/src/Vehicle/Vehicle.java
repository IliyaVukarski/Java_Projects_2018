package Vehicle;

import java.time.LocalDate;
import java.time.Year;
/**
 * 
 * @author Iliya Vukarski
 *
 */
public class Vehicle {
	private String type;
	private String model;
	private double power;
	private double fuelConsumption;
	private int yearProduced;
	private String licenceNo;
	private double distanceTravelled;
	private int weight;
	private String color;
	private int numberOfSeats; 
	private LocalDate dateOfRegister; 

	public Vehicle() {
		
	}
	
	public Vehicle(String type, String model, double power,
			double fuelConsumption, int yearProduced,
			double distanceTravelled, int weight, String color, int numberOfSeats, LocalDate dateOfRegister) {
		this.type = type;
		this.model = model;
		this.power = power;
		this.fuelConsumption = fuelConsumption;
		this.yearProduced = yearProduced;
		this.distanceTravelled = distanceTravelled;
		this.weight = weight;
		this.color = color;
		this.numberOfSeats = numberOfSeats;
		this.dateOfRegister = dateOfRegister;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getPower() {
		return power;
	}

	public void setPower(double power) {
		this.power = power;
	}

	public double getFuelConsumption() {
		return fuelConsumption;
	}

	public void setFuelConsumption(double fuelConsumption) {
		this.fuelConsumption = fuelConsumption;
	}

	public int getYearProduced() {
		return yearProduced;
	}

	public void setYearProduced(int yearProduced) {
		this.yearProduced = yearProduced;
	}

	public String getLicenceNo() {
		return licenceNo;
	}

	public void setLicenceNo(String licenceNo) {
		this.licenceNo = licenceNo;
	}

	public double getDistanceTravelled() {
		return distanceTravelled;
	}

	public void setDistanceTravelled(double distanceTravelled) {
		this.distanceTravelled = distanceTravelled;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	public int getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}
	
	public LocalDate getDateOfRegister() {
		return dateOfRegister;
	}

	public void setDateOfRegister(LocalDate dateOfRegister) {
		this.dateOfRegister = dateOfRegister;
	}
	
	public double getInsurancePrice() {
		int currentYear = Year.now().getValue();
		int vehicleAge = currentYear - this.getYearProduced();
		System.out.printf("This car is %d years old. ", vehicleAge);
		double priceInsurance = 0;
		double typeCoefficient = 0;
		double yearCoefficient = 0;
		if(vehicleAge <= 5) {
			yearCoefficient = 1.00;
		}else if(vehicleAge > 5 && vehicleAge <= 10) {
			yearCoefficient = 2.00;
		}else if(vehicleAge > 10 && vehicleAge <= 15) {
			yearCoefficient = 4.00;
		}else if(vehicleAge > 15) {
			yearCoefficient = 5.00;
		}else {
			System.out.println("Wrong input! ");
		}
		switch(type) {
			case "car":
				typeCoefficient = 1.00;
				break;
			case "suv":
				typeCoefficient = 1.12;
				break;
			case "truck":
				typeCoefficient = 1.20;
				break;
			case "motorcycle":
				typeCoefficient = 1.50;
				break;
			default:
				System.out.println("Not available data! ");
		}
		priceInsurance = (((power * 0.16) + (vehicleAge * 1.25) + (fuelConsumption * 0.05) + yearCoefficient) * typeCoefficient); 
		return priceInsurance;
	}
	
	public double calculatePriceTravel(double fuelPrice) {
		double travelCost = 0;
		travelCost = ((fuelPrice * fuelConsumption) * (distanceTravelled / 100));
		return travelCost;
	}
	
	public double getVignetteTax(String periodOfValidity) {
		double priceVignette = 0;
		switch(periodOfValidity) {
		 	case "Daily":
		 		if(weight <= 3500 && numberOfSeats <= 8) {
		 			System.out.println("You cann't buy a vignette for one day");
		 		}else if((weight > 3500 && weight <= 12000) || numberOfSeats > 8) {
		 			priceVignette = 11.00;
		 		}else if(weight > 12000 || numberOfSeats > 8) {
		 			priceVignette = 11.00;
		 		}
		 		break;
		 	case "Weekly":
		 		if(weight <= 3500 && numberOfSeats <= 8) {
		 			priceVignette = 8.00;
		 		}else if((weight > 3500 && weight <= 12000) || numberOfSeats > 8) {
		 			priceVignette = 21.00;
		 		}else if(weight > 12000 || numberOfSeats > 8) {
		 			priceVignette = 27.00;
		 		}
		 		break;
		 	case "Monthly":
		 		if(weight <= 3500 && numberOfSeats <= 8) {
		 			priceVignette = 15.00;
		 		}else if((weight > 3500 && weight <= 12000) || numberOfSeats > 8) {
		 			priceVignette = 41.00;
		 		}else if(weight > 12000 || numberOfSeats > 8) {
		 			priceVignette = 54.00;
		 		}
		 		break;
		 	case "Annual":
		 		if(weight <= 3500 && numberOfSeats <= 8) {
		 			priceVignette = 50.00;
		 		}else if((weight > 3500 && weight <= 12000) || numberOfSeats > 8) {
		 			priceVignette = 413.00;
		 		}else if(weight > 12000 || numberOfSeats > 8) {
		 			priceVignette = 537.00;
		 		}
		 		break;
		 	default:
		 		System.out.println("Not available data!");
		}
		return priceVignette;
	}
}