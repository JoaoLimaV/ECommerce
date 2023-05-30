package Crud;
import java.io.FileReader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Find {
    public static void main(String[] args) {
        JSONParser parser = new JSONParser();

        try (FileReader reader = new FileReader("src/teste.json")) {
            // Faz o parsing do arquivo JSON
            Object obj = parser.parse(reader);

            // Converte o objeto para um JSONObject
            JSONObject jsonObject = (JSONObject) obj;

            
            JSONArray usuarios = (JSONArray) jsonObject.get("usuarios");
            
            for (Object ob : usuarios) {
                JSONObject usuario = (JSONObject) ob;
                long id = (long) usuario.get("id");
                if (id == 4) {
                    String login = (String) usuario.get("login");
                    String senha = (String) usuario.get("senha");
                    System.out.println("Login: " + login);
                    System.out.println("Senha: " + senha);
                    break;
                }
            }
            
            // Imprime os valores obtidos
            

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}