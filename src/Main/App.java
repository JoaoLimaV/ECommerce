package Main;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import Observer.SubjectProduct;
import Strategy.PaymentCredit;
import Strategy.PaymentDebit;
import Strategy.Strategy;


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
				Sale sale = new Sale();
				
				Panel.showProducts(allProducts);
				System.out.print(colorsText.cyan("Digite o Id do Produto:"));
				int productID = sc.nextInt();
				System.out.print(colorsText.cyan("Digite a quantidade desejada:"));
				int qtd = sc.nextInt();
			    Panel.PaymentMenu();
				int paymentOption = sc.nextInt();
				
				Product product = productDao.find(productID);
				Vendor vendor = vendorDao.find(product.getVendorID());
				sale.setPaymentType ( ( paymentOption == 1 ) ? new PaymentCredit() : new PaymentDebit() );
				sale.setProduct(product);
				sale.setVendor(vendor);
				sale.setQuant(qtd);
			  
				sale.descSale();
			break;
			
			case 0: 
				System.exit(0);
			break;
			default:
				System.out.println( colorsText.red("\nEscolha uma opção válida"));
			
			}
			
			System.out.print("Pressione S ou Y para continuar: ");
	        sc.next();
			
			Panel.clearPrompt();
		}
	}

}
