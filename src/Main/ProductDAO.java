package Main;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import Builder.ProductBuilder;
import Crud.FormatJson;
import Proxy.ProxyConnection;

public class ProductDAO {

	public Product find(int idProduct) {
		 JSONArray products = (JSONArray) ProxyConnection.getConnection().get("products");
		 Product productObj = null;
		 
         for (Object ob : products) {
             JSONObject product = (JSONObject) ob;

             int id = ((Number) product.get("id")).intValue();
             
             if (id == idProduct) {
     			 String name = (String) product.get("name");
                 Double price = (Double) product.get("price");   
                 int stock = ((Number) product.get("stock")).intValue();
                 int vendorID = ((Number) product.get("vendorID")).intValue();
                 
                 productObj = new ProductBuilder()
                		.withId(id)
                 		.withName(name)
                 		.withPrice(price)
                 		.withStock(stock)
                 		.withVendorID(vendorID)
                 		.build();
                 break;
             }
         }
         return productObj;
	}

	public List<Product> findAll() {
		List<Product> productsList = new ArrayList<>();
		
		JSONObject con = ProxyConnection.getConnection();
		JSONArray productsJsonArray = (JSONArray) con.get("products");
		 
		for ( Object ob : productsJsonArray) {
			
			JSONObject product = (JSONObject) ob;
						
			int id = ((Number) product.get("id")).intValue();
			String name = (String) product.get("name");
            Double price = (Double) product.get("price");   
            int stock = ((Number) product.get("stock")).intValue();
            int vendorID = ((Number) product.get("vendorID")).intValue();
                     
            Product productObj = new ProductBuilder()
            		.withId(id)
            		.withName(name)
            		.withPrice(price)
            		.withStock(stock)
            		.withVendorID(vendorID)
            		.build();
            
            productsList.add(productObj);
        }
		
		return productsList;
	}
	
	@SuppressWarnings("unchecked")
	
	public void create(int id, String name, Double price, int stock, int vendorID) throws IOException {
		 JSONArray productsList = (JSONArray) ProxyConnection.getConnection().get("products");
		 
		 JSONObject product = new JSONObject();
		 
		 product.put("id"    ,  id);
         product.put("name"  ,  name);
         product.put("price" ,  price);
         product.put("stock" ,  stock);
         product.put("vendorID" ,  vendorID);
         
         productsList.add(product);
         
         FileWriter fileWriter = new FileWriter("src/database.json");
         fileWriter.write(FormatJson.formatJson(ProxyConnection.getConnection().toJSONString()));
         fileWriter.flush();
         fileWriter.close();
	}

}
