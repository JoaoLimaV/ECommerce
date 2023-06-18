package ecommerce.main;


import ecommerce.strategy.Strategy;

public class Sale{
	private int saleID;
	private Product product; 
	private Vendor vendor;
	private Strategy paymentType;
	private int quant;
	private double priceSale; 
	private String datetime;
	
    public Sale(int saleID, Product product, Vendor vendor, Strategy paymentType, int quant, double priceSale, String datetime) {
        this.saleID = saleID;
    	this.product = product;
        this.vendor = vendor;
        this.paymentType = paymentType;
        this.quant = quant;
        this.priceSale = priceSale;
        this.datetime = datetime;
    }
    
	public int getSaleId() {
		return saleID;
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
	
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	
	public String getDatetime() {
		return datetime;
	}
	
	public void calculeSale() {
		this.priceSale = (this.quant * this.product.getPrice()) - (this.product.getPrice() * paymentType.paymentMethod()) ;
	}

//	public void descSaleForVendor() {
//		System.out.printf("Id da Venda: %d, Produto: %s, Método de Pagamento: %s, Quantidade de Produto: %d, Preço da Compra: %.2f\n", this.saleId, this.product.getName(), this.paymentType.namePaymentMethod(), this.quant, this.priceSale  );
//	}
}
