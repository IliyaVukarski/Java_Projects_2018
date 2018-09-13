package Market;

import java.util.List;
/**
 * 
 * @author Iliya Vukarski
 *
 */
public class Client {
	private String name;
	private double balance;
	private List<Product> productsBought;
	
	public Client() {
		
	}
	
	public Client(String name, double balance, List<Product> productsBought) {
		this.name = name;
		this.balance = balance;
		this.productsBought = productsBought;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public List<Product> getProductsBought() {
		return productsBought;
	}

	public void setProductsBought(List<Product> productsBought) {
		this.productsBought = productsBought;
	}
	
	public void tryToBuy(Product product) {
		if(balance >= product.getPrice()) {
			balance = balance - product.getPrice();
			productsBought.add(product);
			System.out.printf("%s boutght for %.2f ", name, balance);
		}else {
			System.out.println("You don't have enough money to buy this product.");
		}
	}
	
	public void productsBought(List<Client > clients) {
		for(Client client : clients) {
			for(Product product : client.getProductsBought()) {
				System.out.printf("Product %s costs %.2f with number %d .", product.getName(), product.getPrice(), product.getProductNumber());
			}
			System.out.println();
		}
	}
	
	public void printallClients(List<Client> clients) {
		for(Client client : clients) {
			System.out.printf("Client %s with balance %.2f .", client.getName(), client.getBalance());
			System.out.println();
		}
	}
	
	public void printAllCustomerGroseries(List<Client > clients) {
		for(Client client : clients) {
			System.out.printf("Client %s with balance %.2f .", client.getName(), client.getBalance());
			for(Product product : client.getProductsBought()) {
				System.out.printf("Product %s costs %.2f with number %d .", product.getName(), product.getPrice(), product.getProductNumber());
				System.out.println();
			}
		}
	}
}
