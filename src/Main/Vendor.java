package Main;

import java.util.Scanner;

import Observer.InterfaceObserver;
import Strategy.PaymentCredit;
import Strategy.PaymentDebit;

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
	public void sellProduct() {
	
	}

}
