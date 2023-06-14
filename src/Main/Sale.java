package Main;

public class Sale {
	private int id; 
	private int productId; 
	private String productName; 
	private double productPrice;
	private int vendorID;
	private String paymentType;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public int getVendorID() {
		return vendorID;
	}

	public void setVendorID(int vendorID) {
		this.vendorID = vendorID;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	
	public void infoSale() {
		System.out.printf("Nome: %s\nPreço: %.2f\nForma de pagamento: %s\n", 
						  this.productName,
						  this.productPrice,
						  this.paymentType
						  );
	}
	
}
