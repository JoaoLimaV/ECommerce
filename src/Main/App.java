package Main;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import Observer.SubjectProduct;
import Proxy.ProxyConnection;
import Strategy.PaymentCredit;
import Strategy.PaymentDebit;


public class App {

	public static void main(String[] args) throws IOException {
		// Esse linha é propositalmente projetada para permitir a visualização do acesso negado à classe SingletonKeyJson.
		ProxyConnection.getConnection();
		
		Scanner sc = new Scanner(System.in);
		ProductDAO ProductDAO = new ProductDAO();
		VendorDAO  VendorDAO  = new VendorDAO();

		List<Vendor> allVendors = VendorDAO.findAll();
		List<Product> allProducts = ProductDAO.findAll();
		
		SubjectProduct subject = new SubjectProduct();
		allVendors.forEach(e -> subject.attach(e));

		while (true ) {
			
			Panel.menu();
			int option = sc.nextInt();
			Panel.clearPrompt();
			
			switch (option) {
			case 1: 	
				Panel.showProducts(allProducts);
			break;
			
			case 2: 	
				Sale sale = new Sale();
				
				Panel.showProducts(allProducts);
				
				Panel.selectById("Produto");
				int productID = sc.nextInt();
				Panel.desiredQuantity();
				int qtd = sc.nextInt();
			    Panel.choiceMethodPayment();
				int paymentOption = sc.nextInt();
				
				Product product = ProductDAO.find(productID);
				Vendor vendor = VendorDAO.find(product.getVendorID());
				sale.setPaymentType( ( paymentOption == 1 ) ? new PaymentCredit() : new PaymentDebit() );
				sale.setProduct(product);
				sale.setVendor(vendor);
				sale.setQuant(qtd);
				sale.calculeSale();
				
				subject.selledProduct(sale);
			break;
			
			case 0: 
				System.exit(0);
			break;
			
			default:
				Panel.choiceValidOption();			
			}
			
			Panel.pressToNext();
			sc.next();
			
			Panel.clearPrompt();
		}
	}

}
