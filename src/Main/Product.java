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
	
	
	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

	public void descProduct() {
		System.out.printf("Id: %d, Nome : %s, Preço: %.2f, Estoque: %d\n", 
						  this.id, 
						  this.name,
						  this.price,
						  this.stock,
						  this.vendor);
	}

}
