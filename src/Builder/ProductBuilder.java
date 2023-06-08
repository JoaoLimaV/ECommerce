package Builder;

import Main.Vendor;
import Main.Product;

public class ProductBuilder {
	
	private int id; 
	private String name; 
	private double price;
	private int stock;
	private int vendorID;
	
	public ProductBuilder withId (int id) {
		this.id = id;
		return this;
	}
	
	public ProductBuilder withName (String name) {
		this.name = name;
		return this;
	}
	
	public ProductBuilder withPrice (double price) {
		this.price = price;
		return this;
	}
	
	public ProductBuilder withStock (int stock) {
		this.stock = stock;
		return this;
	}
	
	public ProductBuilder withVendorID (int vendorID) {
		this.vendorID = vendorID;
		return this;
	}
	
	public Product build() {
		return new Product(this.id
				, this.name
				, this.price
				, this.stock
				, this.vendorID);
	}

}
