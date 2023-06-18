package ecommerce.observer;

import ecommerce.main.Sale;
import ecommerce.strategy.Strategy;

public interface InterfaceObserver {
		public void selledProduct(Sale sale);
}
