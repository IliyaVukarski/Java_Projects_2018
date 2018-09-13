package Calculator;
/**
 * 
 * @author Iliya Vukarski
 * 
 */
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CalculatorClient {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String operation = null;
		while(true) {
			System.out.println("Please chooce type of operation between:");
			System.out.println("SUM, SUB, MUL, DIV, PER, POW, REM, SQRT, ABS, LOG, SIN, COS, TG, COTG, END");
			List<String> operations = Arrays.asList("SQRT", "ABS", "SIN", "COS", "LOG"); // asList
			operation = scanner.next();
			boolean isValid = true;
			if(operation.equalsIgnoreCase("END")) {
				break;
			}
			System.out.println("Enter first number.");
			double numA = 0;
			do {
				if(scanner.hasNextDouble()) {
					numA = scanner.nextDouble();
					isValid = true;
				}else {
					System.out.println("Enter correct value! ");
					isValid = false;
					scanner.next();
				}
			}while(!isValid);
			double numB = 0;
			
			if(!operations.contains(operation)) {
				System.out.println("Enter second number.");
				do {
					if(scanner.hasNextDouble()) {
						numB = scanner.nextDouble();
						isValid = true;
					}else {
						System.out.println("Enter correct value! ");
						isValid = false;
						scanner.next();
					}
				}while(!isValid);
			}
			double result = 0;
			switch(operation) {
				case "SUM":
					result = Calculator.sumElements(operation, numA, numB);
					break;
				case "SUB":
					result = Calculator.subtractElements(operation, numA, numB);
					break;
				case "MUL":
					result = Calculator.multiplyElements(operation, numA, numB);
					break;
				case "DIV":
					result = Calculator.divideElements(operation, numA, numB);
					break;
				case "PER":
					result = Calculator.percentageElement(operation, numA, numB);
					break;
				case "POW":
					result = Calculator.powerElement(operation, numA, numB);
					break;
				case "REM":
					result = Calculator.remainderElements(operation, numA, numB);
					break;
				case "SQRT":
					result = Calculator.sqrtElement(operation, numA);
					break;
				case "ABS":
					result = Calculator.absElement(operation, numA);
					break;
				case "LOG":
					result = Calculator.logElement(operation, numA);
					break;
				case "SIN":
					result = Calculator.sinElement(operation, numA);
					break;
				case "COS":
					result = Calculator.cosElement(operation, numA);
					break;
				case "TG":
					result = Calculator.tgElement(operation, numA, numB);
					break;
				case "COTG":
					result = Calculator.cotgElement(operation, numA, numB);
					break;
				default: 
					System.out.println("Wrong operation! ");
					break;
 			}
			System.out.println("The result is: " + result);
		}
	}
}