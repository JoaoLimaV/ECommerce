package Strategy;

public class PaymentCredit implements Strategy{
	@Override
	public double paymentMethod() {
		return 0.1;
	}

	@Override
	public String namePaymentMethod() {
		// TODO Auto-generated method stub
		return "Crédito  c/ Juros de 10%";

	}

}