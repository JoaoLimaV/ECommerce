package Main;
import java.io.IOException;
import java.util.List;

import Observer.SubjectProduct;


public class App {

	public static void main(String[] args) throws IOException {
		ProductDao productDao = new ProductDao();
		VendorDao  vendorDao  = new VendorDao();
		
		List<Vendor> allVendors = vendorDao.findAll();
		List<Product> allProducts = productDao.findAll();
		
		SubjectProduct subject = new SubjectProduct();
		
		allVendors.forEach(e -> subject.attach(e));
		subject.sell(8);
		subject.sell(1);
		subject.sell(5);
	}

}
