package Main;

public class Vendor {

	private int id;
	private String name;
	private int CNPJ;
	private String ratingsStars;
	
	public Vendor(int id, String name, int cNPJ, String ratingsStars) {
		this.id = id;
		this.name = name;
		CNPJ = cNPJ;
		this.ratingsStars = ratingsStars;
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

	public int getCNPJ() {
		return CNPJ;
	}

	public void setCNPJ(int cNPJ) {
		CNPJ = cNPJ;
	}

	public String getRatingsStars() {
		return ratingsStars;
	}

	public void setRatingsStars(String ratingsStars) {
		this.ratingsStars = ratingsStars;
	}
	
	
	
	
}
