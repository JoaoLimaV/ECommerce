package Singleton;
import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class SingletonKeyJson {
	
	private static JSONObject con;
	
	public static JSONObject getConnection() {
		
		if( SingletonKeyJson.con == null ) {
			try {
				JSONParser parser = new JSONParser();
		        Object obj = parser.parse(new FileReader("src/products.json"));
				JSONObject objJson = (JSONObject) obj;	
				SingletonKeyJson.con = objJson;
			} catch (Exception e) {
	            e.printStackTrace();
	        }
		}
		
        return SingletonKeyJson.con;
	}
}
