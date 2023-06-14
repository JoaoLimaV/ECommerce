package Strategy;

public class PaymentDebit implements Strategy {
	@Override
	public String paymentMethod() {
		return "Débito";
	}
}