package Strategy;

public class PaymentDebit implements Strategy {
	@Override
	public double paymentMethod() {
		return -0.1;
	}

	@Override
	public String namePaymentMethod() {
		return "Débito c/ Desconto de 10%";
	}
	
	
}