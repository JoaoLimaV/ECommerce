package Main;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import Observer.SubjectProduct;


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
				subject.sell(sc.nextInt());
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
