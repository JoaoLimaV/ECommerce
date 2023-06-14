package Strategy;

import Main.Sale;

public class PaymentCredit implements Strategy{
	@Override
	public void PaymentStrategy(String productName, Double productPrice) {
        Sale sale = new Sale();
        sale.setProductName(productName);
        sale.setProductPrice(productPrice);
        sale.setPaymentType("Crédito");
        sale.infoSale();
	}

}