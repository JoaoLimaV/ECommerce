package Observer;

import java.util.ArrayList;
import java.util.List;

import Main.Sale;
import Main.Vendor;

public class SubjectProduct {
	
	    private List<Vendor> observers = new ArrayList<>();
	    
	    public void selledProduct(Sale sale) {
	    	notifyAll(sale);
	    }

	    public void attach(Vendor observerVendor) {
			observers.add(observerVendor);
		}
		
	    public void detach(Vendor observer) {
	        observers.remove(observer);
	    }

	    private void notifyAll(Sale sale) {
	    	
	    	for (Vendor obVendor : observers) {
	    	    	if (obVendor.getId() == sale.getVendor().getId()) {
	    	    		obVendor.selledProduct(sale);
	    	    		break;
	    	    	}
	    	}
	    }
}
