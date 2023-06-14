package Main;

import java.util.concurrent.ThreadLocalRandom;

import Strategy.Strategy;

public class Sale <T extends Strategy> {
	private int saleId = ThreadLocalRandom.current().nextInt(); 
	private Product product; 
	private Vendor vendor;
	private T paymentType;
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

	public T getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(T paymentType) {
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

	public void descSale() {
		System.out.printf("Id da Venda: %d, Produto: %s,  Vendedor: %s, Método de Pagamento: %s, Quantidade de Produto: %d, Preço da Compra: %.2f", this.saleId, this.product.getName(),this.vendor.getName(), this.paymentType.paymentMethod(), this.quant, this.priceSale  );
	}

	
}
