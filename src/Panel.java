import java.util.List;

public class Panel {
	
	public static void showPanel(List<Product> products) {
		products.forEach( product -> product.descProduct());
	}
}
