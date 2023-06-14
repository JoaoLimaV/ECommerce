package Main;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import Observer.SubjectProduct;
import Strategy.PaymentCredit;
import Strategy.PaymentDebit;


public class App {

	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		ProductDao productDao = new ProductDao();
		VendorDao  vendorDao  = new VendorDao();
		
		List<Vendor> allVendors = vendorDao.findAll();
		List<Product> allProducts = productDao.findAll();
		
		SubjectProduct subject = new SubjectProduct();
		allVendors.forEach(e -> subject.attach(e));

		while (true ) {
			
			Panel.Menu();
			int option = sc.nextInt();
			
			
			switch (option) {
			case 1: 	
				Panel.showProducts(allProducts);
			break;
			
			case 2: 	
				Panel.showProducts(allProducts);
				System.out.print(colorsText.cyan("Digite o Id do Produto:"));
				int productID = sc.nextInt();
				System.out.print(colorsText.cyan("Digite a quantidade desejada:"));
				int qtd = sc.nextInt();
			    Panel.PaymentMenu();
				int paymentOption = sc.nextInt();
				
		    	Product product = productDao.find(productID);

			    if (paymentOption == 1) {
			        PaymentCredit payment = new PaymentCredit();
			        payment.PaymentStrategy(product.getName(), product.getPrice());
			    } else if (paymentOption == 2) {
			        PaymentDebit payment = new PaymentDebit();
			        payment.PaymentStrategy(product.getName(), product.getPrice());
			    } else {
			        System.out.println("Opção inválida.");
			    }
//				subject.sell(sc.nextInt());
			break;
			
			case 0: 
				System.exit(0);
			break;
			default:
				System.out.println( colorsText.red("\nEscolha uma opção válida"));
			
			}
			
			System.out.print("Pressione Enter para continuar...");
	        sc.nextLine();
			
			Panel.clearPrompt();
		}
	}

}
