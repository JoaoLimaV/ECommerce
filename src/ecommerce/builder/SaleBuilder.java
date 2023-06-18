package ecommerce.builder;

import ecommerce.main.Product;
import ecommerce.main.Sale;
import ecommerce.main.Vendor;
import ecommerce.strategy.Strategy;

public class SaleBuilder {

	private int saleID;
	private Product product; 
	private Vendor vendor;
	private Strategy paymentType;
	private int quant;
	private double priceSale; 
	private String datetime;
	
	public SaleBuilder withId (int id) {
		this.saleID = id;
		return this;
	}
	
	public SaleBuilder withProduct (Product product) {
		this.product = product;
		return this;
	}
	
	public SaleBuilder withVendor (Vendor vendor) {
		this.vendor = vendor;
		return this;
	}
	
	public SaleBuilder withStrategy (Strategy strategy) {
		this.paymentType = strategy;
		return this;
	}
	
	public SaleBuilder withQuant (int quant) {
		this.quant = quant;
		return this;
	}
	
	public SaleBuilder withPriceSale (double price) {
		this.priceSale =  price;
		return this;
	}
	
	public SaleBuilder withDatatime (String datetime) {
		this.datetime =  datetime;
		return this;
	}
		
	public Sale build() {
		return new Sale(this.saleID
				, this.product
				, this.vendor
				, this.paymentType
				, this.quant
				, this.priceSale
				, this.datetime);
	}
	
}
