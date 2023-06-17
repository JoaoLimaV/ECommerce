package Main;

import java.util.ArrayList;
import java.util.List;

import Observer.InterfaceObserver;

public class Vendor implements InterfaceObserver{

	private int id;
	private String name;
	private String cnpj;
	private double ratingsStars;
	public List<Sale> sales =  new ArrayList<>();
	
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
	
	public void selledProduct(Sale sale) {
		this.sales.add(sale);
	}


}
