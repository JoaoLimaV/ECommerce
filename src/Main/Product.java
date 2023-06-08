package Main;

public class Product {
	
	private int id; 
	private String name; 
	private double price;
	private int stock;
	private int vendorID;
	
	public Product(int id, String name, double price, int stock, int vendorID) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.stock = stock;
		this.vendorID = vendorID;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	
	
	public int getVendorID() {
		return vendorID;
	}

	public void setVendorID(int vendorID) {
		this.vendorID = vendorID;
	}

	public void infoProduct() {
		System.out.printf("Nome: %s\nPreço: %.2f", 
						  this.name,
						  this.price
						  );
	}
	
	public void specProduct() {
		System.out.printf("Id: %d\nNome: %s\nPreço: %.2f\nEstoque: %d\n", 
						  this.id, 
						  this.name,
						  this.price,
						  this.stock
						  );
	}

}
