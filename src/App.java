import java.io.IOException;


public class App {

	public static void main(String[] args) throws IOException {
		ProductDao productDao = new ProductDao();
		Panel.showPanel(productDao.findAll());
	}

}
