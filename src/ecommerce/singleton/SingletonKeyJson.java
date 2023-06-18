package ecommerce.singleton;
import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import ecommerce.proxy.ServiceConnection;


public class SingletonKeyJson implements ServiceConnection {
	
	private static JSONObject con;
	
	public static JSONObject getConnection() {
		
		if( SingletonKeyJson.con == null ) {
			try {
				JSONParser parser = new JSONParser();
		        Object obj = parser.parse(new FileReader("src/database.json"));
				JSONObject objJson = (JSONObject) obj;
				
				SingletonKeyJson.con = objJson;
				
				
			} catch (Exception e) {
	            e.printStackTrace();
	        }
		}
		
        return SingletonKeyJson.con;
	}
}
