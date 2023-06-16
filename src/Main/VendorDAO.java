package Main;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import Crud.FormatJson;
import Proxy.ProxyConnection;

public class VendorDAO {
	
	public Vendor find(int idVendor) {
		JSONArray vendors = (JSONArray) ProxyConnection.getConnection().get("vendors");
		 Vendor vendorObj = null;
		 
        for (Object ob : vendors) {
            JSONObject vendor = (JSONObject) ob;

            int id = ((Number) vendor.get("id")).intValue();
            
            if (id == idVendor) {
            	String name         = (String)  vendor.get("name");
    			String cnpj         = (String)  vendor.get("cnpj");   
                double ratingsStars = (Double)  vendor.get("ratingsStars");
                vendorObj = new Vendor(id, name, cnpj, ratingsStars);
                break;
            }
        }
        return vendorObj;
	}

	public List<Vendor> findAll() {
		List<Vendor> vendorsList = new ArrayList<>();

		JSONArray vendorsJsonArray = (JSONArray) ProxyConnection.getConnection().get("vendors");
		 
		for ( Object ob : vendorsJsonArray) {
			
			JSONObject vendor = (JSONObject) ob;
			
			int id              = ((Number) vendor.get("id")).intValue();
			String name         = (String)  vendor.get("name");
			String cnpj         = (String)  vendor.get("cnpj");   
            double ratingsStars = (Double)  vendor.get("ratingsStars");
                     
            Vendor vendorObj = new Vendor(id, name, cnpj, ratingsStars);
            vendorsList.add(vendorObj);
        }
		
		return vendorsList;
	}
	
	@SuppressWarnings("unchecked")
	
	public void create(int id, String name, String cnpj, int ratingsStars) throws IOException {
		 JSONArray vendorsList = (JSONArray) ProxyConnection.getConnection().get("vendors");
		 
		 JSONObject vendor = new JSONObject();
		 
		 vendor.put("id"    ,  id);
         vendor.put("name"  ,  name);
         vendor.put("cnpj" ,  cnpj);
         vendor.put("ratingsStars" ,  ratingsStars);
       
         vendorsList.add(vendor);
         
         FileWriter fileWriter = new FileWriter("src/database.json");
         fileWriter.write(FormatJson.formatJson(ProxyConnection.getConnection().toJSONString()));
         fileWriter.flush();
         fileWriter.close();
	}
}
