package Adapter;

public class AdapterLibFormatJson implements AdapterInterface {
	
	public String formatJson(String jsonString){
		ExternalLibFormatJson libFormatJson = new ExternalLibFormatJson();
		return libFormatJson.formatJson(jsonString);
	}
}
