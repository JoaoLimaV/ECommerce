package Observer;

import java.util.ArrayList;
import java.util.List;

import Main.Product;
import Main.ProductDao;
import Main.Vendor;

public class SubjectProduct {
	
	    private List<Vendor> observers = new ArrayList<>();
	    private ProductDao productDao = new ProductDao();
	        
	    public void sell(int productID) {
	    	Product product = this.productDao.find(productID);
	    	notifyVendors(product);
	    }

	    public void attach(Vendor observerVendor) {
			observers.add(observerVendor);
		}
		
	    public void detach(Vendor observer) {
	        observers.remove(observer);
	    }

	    private void notifyVendors(Product product) {
	    	
	    	for (Vendor observer : observers) {
	    	    if (observer.getId() == product.getVendorID()) {
	    	    	observer.sellProduct(product);
	    	    }
	    	}
	    }
}
