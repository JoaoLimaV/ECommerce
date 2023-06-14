package Main;
import java.util.ArrayList;
import java.util.List;

public class Panel {
	
	public static void showProducts(List<Product> products) {
		List<Object[]> Lisboa = new ArrayList<>();

		// Adicionar dados à lista
		products.forEach(product ->
		    Lisboa.add(new Object[]{product.getId(), product.getName(), product.getPrice(), product.getStock()})
		);

		String[][] dados = new String[Lisboa.size()][];

		for (int i = 0; i < Lisboa.size(); i++) {
		    Object[] linha = Lisboa.get(i);
		    String[] linhaString = new String[linha.length];

		    for (int j = 0; j < linha.length; j++) {
		        linhaString[j] = String.valueOf(linha[j]);
		    }

		    dados[i] = linhaString;
		}

		// Imprimir cabeçalho da tabela
		System.out.println("------------------------------------------------------------------------------");
		System.out.printf("| %-5s | %-40s | %-10s | %-10s |\n", "ID", "Nome", "Preço", "Estoque");

		// Imprimir os dados da tabela
		for (String[] linha : dados) {
		    String id = linha[0];
		    String nome = linha[1];
		    double preco = Double.parseDouble(linha[2]);
		    int estoque = Integer.parseInt(linha[3]);

		    System.out.printf("| %-5s | %-40s | %-10.2f | %-10d |\n", id, nome, preco, estoque);
		}

		System.out.println("------------------------------------------------------------------------------");
		
	}
	
	public static void Menu() {
		
		System.out.println( colorsText.yellow("-- Escolha uma opção de acordo com o número --"));

		
		System.out.println(colorsText.yellow("------------------------------------------"));
        System.out.println(colorsText.cyan("1") + " - Listar Produtos");
        System.out.println(colorsText.cyan("2") + " - Comprar Produto");
        System.out.println(colorsText.cyan("3") + " - Listar Fornecedores");
        System.out.println(colorsText.cyan("4") + " - Listar Produtos");
        System.out.println(colorsText.cyan("0") + " - Sair da Aplicação");
        System.out.println(colorsText.yellow("------------------------------------------"));
        
        System.out.print(colorsText.cyan(":"));     
        
	}
	
	public static void PaymentMenu() {
		
		System.out.println( colorsText.yellow("-- Escolha uma opção de acordo com o número --"));

		
		System.out.println(colorsText.yellow("------------------------------------------"));
        System.out.println(colorsText.cyan("1") + " - Credito");
        System.out.println(colorsText.cyan("2") + " - Debito");
        System.out.println(colorsText.yellow("------------------------------------------"));
        
        System.out.print(colorsText.cyan(":"));  
        
		System.out.print(colorsText.cyan("Digite a forma de pagamento:"));
        
	}
	
	public static void clearPrompt() {
		
    }
}
