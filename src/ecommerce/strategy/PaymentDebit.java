package ecommerce.strategy;

public class PaymentDebit implements Strategy {
	@Override
	public double paymentMethod() {
		return 0.1;
	}

	@Override
	public String namePaymentMethod() {
		return "Débito";
	}

	@Override
	public String discount() {
		// TODO Auto-generated method stub
		return "Desconto 10%";
	}
	
	
}