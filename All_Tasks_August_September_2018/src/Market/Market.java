package Market;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * 
 * @author Iliya Vukarski
 *
 */
public class Market {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] inputCommand = null;
		List<String> commands = new ArrayList<String>();
		List<Client> clientsRepo = new ArrayList<Client>();
		commands.add("END");
		commands.add("CLIENT");
		commands.add("BUY");
		commands.add("ALLCLIENTS");
		commands.add("ALLCLWITHPRBOUGHT");
		while(true) {
			Client client = new Client();
			Product product = new Product();
			System.out.println("Enter CLIENT, BUY, ALLCLIENTS, ALLCLWITHPRBOUGHT or END.");
			inputCommand = scanner.next().split(" ");
			if(inputCommand[0].equals(commands.get(0))) {
				break;
			}
			boolean isValid = true;
			for(String comm : inputCommand) {
				if(comm.equals(commands.get(1))) {
					System.out.println("Enter person name and balance.");
					String personName = scanner.next();
					double personBalance = 0;
					do {
						if(scanner.hasNextDouble()) {
							personBalance = scanner.nextDouble();
							isValid = true;
						}else {
							System.out.println("Enter correct value.");
							isValid = false;
							scanner.next();
						}
 					}while(!isValid);
					client.setName(personName);
					client.setBalance(personBalance);
					List<Product> productsBought = new ArrayList<Product>();
					client.setProductsBought(productsBought);
					clientsRepo.add(client);
				}else if(comm.equals(commands.get(2))) {
					Client currentCustomer = null;
					System.out.println("Enter client name.");
					String clientName = scanner.next();
					for(int index = 0; index < clientsRepo.size(); index++) {
						if(clientsRepo.get(index).getName().equals(clientName)) {
							currentCustomer = clientsRepo.get(index);
						}
					}
					System.out.println("Enter product name and price.");
					String productName = scanner.next();
					double productPrice = 0;
					do {
						if(scanner.hasNextDouble()) {
							productPrice = scanner.nextDouble();
							isValid = true;
						}else {
							System.out.println("Enter correct value.");
							isValid = false;
							scanner.next();
						}
					}while(!isValid);
					product.setName(productName);
					product.setPrice(productPrice);
					currentCustomer.tryToBuy(product);
				}else if(comm.equals(commands.get(3))) {
					client.printallClients(clientsRepo);
				}else if(comm.equals(commands.get(4))) {
					client.printAllCustomerGroseries(clientsRepo);
				}else {
					System.out.println("Wrong command.");
				}
			}
		}
	}
}
