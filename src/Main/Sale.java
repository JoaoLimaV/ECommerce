package Main;

import java.util.concurrent.ThreadLocalRandom;

import Strategy.Strategy;

public class Sale{
	private int saleId = Math.abs(ThreadLocalRandom.current().nextInt(Integer.MAX_VALUE));
	private Product product; 
	private Vendor vendor;
	private Strategy paymentType;
	private int quant;
	private double priceSale; 
	
	public int getSaleId() {
		return saleId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

	public  Strategy getPaymentType() {
		return paymentType;
	}

	public void setPaymentType( Strategy paymentType) {
		this.paymentType = paymentType;
	}

	public int getQuant() {
		return quant;
	}

	public void setQuant(int quant) {
		this.quant = quant;
	}

	public double getPriceSale() {
		return priceSale;
	}
	
	public void calculeSale() {
		this.priceSale = (this.quant * this.product.getPrice()) + (this.product.getPrice() * paymentType.paymentMethod()) ;
	}

	public void descSaleForVendor() {
		System.out.printf("Id da Venda: %d, Produto: %s, Método de Pagamento: %s, Quantidade de Produto: %d, Preço da Compra: %.2f\n", this.saleId, this.product.getName(), this.paymentType.namePaymentMethod(), this.quant, this.priceSale  );
	}

	
}
