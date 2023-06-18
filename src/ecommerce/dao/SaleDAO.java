package ecommerce.dao;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import ecommerce.adapter.AdapterLibFormatJson;
import ecommerce.builder.SaleBuilder;
import ecommerce.main.Product;
import ecommerce.main.Sale;
import ecommerce.main.Vendor;
import ecommerce.proxy.ProxyConnection;
import ecommerce.strategy.PaymentCredit;
import ecommerce.strategy.PaymentDebit;
import ecommerce.strategy.Strategy;

public class SaleDAO {
	
	@SuppressWarnings("unchecked")
	
	public void create(Sale sale) throws IOException {
		 JSONArray saleList = (JSONArray) ProxyConnection.getConnection().get("sales");
		 
		 JSONObject saleJson = new JSONObject();
		 
		 saleJson.put("id",  		 sale.getSaleId());
		 saleJson.put("productID",   sale.getProduct().getId());
		 saleJson.put("vendorID",    sale.getVendor().getId());
		 saleJson.put("paymentType", sale.getPaymentType().namePaymentMethod());
		 saleJson.put("quantity",    sale.getQuant());
		 saleJson.put("price", 		 sale.getPriceSale());
		 saleJson.put("datetime", 	 sale.getDatetime());
      
		 saleList.add(saleJson);
        
         AdapterLibFormatJson format = new AdapterLibFormatJson();
         String formattedJson = format.formatJson(ProxyConnection.getConnection().toJSONString());
       
		 FileWriter fileWriter = new FileWriter("src/database.json");
	     fileWriter.write(formattedJson);
	     fileWriter.flush();
	     fileWriter.close();
	}
	
	@SuppressWarnings("unused")
	
	public List<Sale> findAll() {
		List<Sale> salesList = new ArrayList<>();
		
		JSONObject con = ProxyConnection.getConnection();
		JSONArray salesJsonArray = (JSONArray) con.get("sales");
		 
		for ( Object ob : salesJsonArray) {
			
			JSONObject sale = (JSONObject) ob;
						
			int id = ((Number) sale.get("id")).intValue();
            int productID = ((Number) sale.get("productID")).intValue();   
            int vendorID = ((Number) sale.get("vendorID")).intValue();
            String payment = (String) sale.get("paymentType");
            int quantity = ((Number) sale.get("quantity")).intValue();   
            Double price = (Double) sale.get("price");   
            String datetime = (String) sale.get("paymentType");

            ProductDAO productDAO = new ProductDAO();
            VendorDAO vendorDAO   = new VendorDAO();

            Product product = productDAO.find(productID);
            Vendor  vendor  = vendorDAO.find(vendorID);
			Strategy paymentMethod = ( payment == "Crédito" ) ? new PaymentCredit() : new PaymentDebit();

			Sale saleObj = new SaleBuilder()
            		.withId(id)
             		.withProduct(product)
             		.withVendor(vendor)
             		.withStrategy(paymentMethod)
             		.withQuant(quantity)
             		.withPriceSale(price)
             		.withDatatime(datetime)
             		.build();
                                 
            salesList.add(saleObj);
        }
		
		return salesList;
	}
	
}
