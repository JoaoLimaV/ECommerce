package Crud;

import java.io.FileReader;
import java.io.FileWriter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Create{
    public static void main(String[] args) {
        try {
            // Ler o arquivo JSON existente
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader("src/products.json"));
            JSONObject objJson = (JSONObject) obj;

            // Acessar a lista de produtos
            JSONArray products = (JSONArray) objJson.get("products");

            // Criar o novo produtos
            JSONObject product = new JSONObject();
            
            int id = 1;
            String name = "José";
            double price = 2.0;
            int stock = 10;
            
            product.put("id", id);
            product.put("name", name);
            product.put("price", price);
            product.put("stock", stock);
            
            // Adicionar o novo usu�rio � lista de usu�rios
            products.add(product);

            // Escrever o objeto JSON atualizado de volta no arquivo com formata��o leg�vel
            FileWriter fileWriter = new FileWriter("src/products.json");
            fileWriter.write(FormatJson.formatJson(objJson.toJSONString()));
            fileWriter.flush();
            fileWriter.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

