package Strategy;

public class PaymentCredit implements Strategy{
	@Override
	public String paymentMethod() {
		return "Crédito";
	}

}