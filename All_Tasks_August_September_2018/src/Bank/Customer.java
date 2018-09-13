package Bank;
/**
 * 
 * @author Iliya Vukarski
 *
 */
public abstract class Customer {
	private String typeOfCustomer;
	
	public Customer() {
		
	}
	
	public Customer(String typeOfCustomer) {
		this.typeOfCustomer = typeOfCustomer;
	}
	
	public String getTypeOfCustomer() {
		return typeOfCustomer;
	}

	public void setTypeOfCustomer(String typeOfCustomer) {
		this.typeOfCustomer = typeOfCustomer;
	}
}