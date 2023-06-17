package Main;

public class Product {
	
	private int id; 
	private String name; 
	private double price;
	private int stock;
	private Vendor vendor;
	
	public Product(int id, String name, double price, int stock, Vendor vendor) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.stock = stock;
		this.vendor = vendor;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}


	public double getPrice() {
		return price;
	}

	public int getStock() {
		return stock;
	}

	public Vendor getVendor() {
		return vendor;
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
