package Market;
/**
 * 
 * @author Iliya Vukarski
 *
 */
public class Product {
	private String name;
	private double price;
	private int productNumber = enrollNumber();
	private static int nextNumber = 1;
	
	public Product() {
		
	}
	
	public Product(String name, double price) {
		this.name = name;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public int getProductNumber() {
		return productNumber;
	}
	
	public static int enrollNumber() {
		int r = 0;
		r = nextNumber;
		nextNumber++;
		return r;
	}
}