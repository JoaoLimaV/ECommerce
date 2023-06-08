package Main;

import Observer.InterfaceObserver;

public class Vendor implements InterfaceObserver{

	private int id;
	private String name;
	private String cnpj;
	private double ratingsStars;
	
	public Vendor(int id, String name, String cnpj, double ratingsStars) {
		this.id = id;
		this.name = name;
		this.cnpj = cnpj;
		this.ratingsStars = ratingsStars;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getCNPJ() {
		return cnpj;
	}

	public double getRatingsStars() {
		return ratingsStars;
	}

	@Override
	public void sellProduct(Product product) {
		System.out.println("\n\u001B[32m Você Acaba de Vender um Produto!!! \033[0m");
		product.infoProduct();
	}

}
