import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import Crud.FormatJson;

public class ProductDao {
	
	public String update(Product product) {
		return "Sucessfull update";
	}
	
	public Product find(long id) {
		return null;
	}

	public List<Product> findAll() {
		List<Product> productsList = new ArrayList<>();
		
		JSONObject con = SingletonKeyJson.getConnection();
		JSONObject jsonObject = (JSONObject) con;
		JSONArray productsJsonArray = (JSONArray) jsonObject.get("products");
		 
		for ( Object ob : productsJsonArray) {
			
			JSONObject product = (JSONObject) ob;
			
			
			int id = ((Number) product.get("id")).intValue();
			String name = (String) product.get("name");
            Double price = (Double) product.get("price");   
            int stock = ((Number) product.get("stock")).intValue();
                     
            Product productObj = new Product(id, name, price, stock);
            
            productsList.add(productObj);
        }
		
		return productsList;
	}
	
	@SuppressWarnings("unchecked")
	
	public void create(int id, String name, Double price, int stock) throws IOException {
		 JSONObject con = SingletonKeyJson.getConnection();
		 JSONArray productsList = (JSONArray) con.get("products");
		 
		 JSONObject product = new JSONObject();
		 
		 product.put("id"    ,  id);
         product.put("name"  ,  name);
         product.put("price" ,  price);
         product.put("stock" ,  stock);
         
         productsList.add(product);
         
         FileWriter fileWriter = new FileWriter("src/products.json");
         fileWriter.write(FormatJson.formatJson(con.toJSONString()));
         fileWriter.flush();
         fileWriter.close();
	}

}
