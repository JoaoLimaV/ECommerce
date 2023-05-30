package Crud;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;
import java.io.FileWriter;

public class Delete {
    public static void main(String[] args) {
        try {
            // Ler o arquivo JSON existente
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader("src/teste.json"));
            JSONObject json = (JSONObject) obj;

            // Acessar a lista de usuários
            JSONArray usuarios = (JSONArray) json.get("usuarios");
            
            //Remover usuario por id
            for (Object ob : usuarios) {
                JSONObject usuario = (JSONObject) ob;
                long id = (long) usuario.get("id");
                if (id == 4) {
                    usuarios.remove(usuario);
                    break;
                }
            }
            

            // Escrever o objeto JSON atualizado de volta no arquivo com formatação legível
            FileWriter fileWriter = new FileWriter("src/teste.json");
            fileWriter.write(FormatJson.formatJson(json.toJSONString()));
            fileWriter.flush();
            fileWriter.close();

            System.out.println("usuário deletado com sucesso.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}