package Calculator;
/**
 * 
 * @author Iliya Vukarski
 *
 */
public class Calculator {
	public static double sumElements(String operation, double numA, double numB) {
		System.out.println(operation + " " + numA + " " + numB);
		double result = numA + numB;
		return result;
	}
	
	public static double subtractElements(String operation, double numA, double numB) {
		System.out.println(operation + " " + numA + " " + numB);
		double result = numA - numB;
		return result;
	}
	
	public static double multiplyElements(String operation, double numA, double numB) {
		System.out.println(operation + " " + numA + " " + numB);
		double result = numA * numB;
		return result;
	}
	
	public static double divideElements(String operation, double numA, double numB) {
		System.out.println(operation + " " + numA + " " + numB);
		double result = numA / numB;
		return result;
	}
	
	public static double powerElement(String operation, double numA, double numB) {
		System.out.println(operation + " " + numA + " " + numB);
		double result = Math.pow(numA, numB);
		return result;
	}
	
	public static double percentageElement(String operation, double numA, double numB) {
		System.out.println(operation + " " + numA + " " + numB);
		double result = (numA * (numB / 100));
		return result;
	}

	public static double remainderElements(String operation, double numA, double numB) {
		System.out.println(operation + " " + numA + " " + numB);
		double result = numA % numB;
		return result;
	}
	
	public static double sqrtElement(String operation, double numA) {
		System.out.println(operation + " " + numA);
		double result = Math.sqrt(numA);
		return result;
	}
	
	public static double absElement(String operation, double numA) {
		System.out.println(operation + " " + numA);
		double result = Math.abs(numA);
		return result;
	}
	
	public static double logElement(String operation, double numA) {
		System.out.println(operation + " " + numA);
		double result = Math.log(numA);
		return result;
	}
	
	public static double sinElement(String operation, double numA) {
		System.out.println(operation + " " + numA);
		double result = Math.sin(numA);
		return result;
	}
	
	public static double cosElement(String operation, double numA) {
		System.out.println(operation + " " + numA);
		double result = Math.cos(numA);
		return result;
	}
	
	public static double tgElement(String operation, double numA, double numB) {
		System.out.println(operation + " " + numA);
		double result = Math.sin(numA) / Math.cos(numB);
		return result;
	}
	
	public static double cotgElement(String operation, double numA, double numB) {
		System.out.println(operation + " " + numA);
		double result =  Math.cos(numB) / Math.sin(numA);
		return result;
	}
}