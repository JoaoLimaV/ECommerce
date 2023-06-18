package ecommerce.strategy;

public class PaymentCredit implements Strategy{
	@Override
	public double paymentMethod() {
		return 0.05;
	}

	@Override
	public String namePaymentMethod() {
		// TODO Auto-generated method stub
		return "Crédito";

	}

	@Override
	public String discount() {
		// TODO Auto-generated method stub
		return "Desconto 5%";
	}

}