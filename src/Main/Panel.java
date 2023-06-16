package Main;
import java.util.ArrayList;
import java.util.List;

public class Panel {
	
	public static void showProducts(List<Product> products) {
		List<Object[]> ListObj = new ArrayList<>();

		products.forEach(product ->
		    ListObj.add(new Object[]{product.getId(), product.getName(), product.getPrice(), product.getStock()})
		);

		String[][] dados = new String[ListObj.size()][];

		for (int i = 0; i < ListObj.size(); i++) {
		    Object[] linha = ListObj.get(i);
		    String[] linhaString = new String[linha.length];

		    for (int j = 0; j < linha.length; j++) {
		        linhaString[j] = String.valueOf(linha[j]);
		    }

		    dados[i] = linhaString;
		}

		// Imprimir cabeçalho da tabela
		System.out.println(colorsText.yellow("------------------------------------------------------------------------------"));
		
		System.out.print(colorsText.yellow("| "));
		System.out.printf("%-5s | %-40s | %-10s | %-10s", "ID", "Nome", "Preço", "Estoque");
		System.out.print(colorsText.yellow(" |\n"));
		
		for (String[] linha : dados) {
		    String id = linha[0];
		    String nome = linha[1];
		    double preco = Double.parseDouble(linha[2]);
		    int estoque = Integer.parseInt(linha[3]);
		    System.out.print(colorsText.yellow("| "));
		    System.out.printf("%-5s | %-40s | %-10.2f | %-10d", id, nome, preco, estoque);
		    System.out.print(colorsText.yellow(" |\n"));
		}

		System.out.println(colorsText.yellow("------------------------------------------------------------------------------"));
		
	}
	
	public static void menu() {
		
		System.out.println( colorsText.yellow("-- Escolha uma opção de acordo com o número --"));

		
		System.out.println(colorsText.yellow("------------------------------------------"));
        System.out.println(colorsText.cyan("1") + " - Listar Produtos");
        System.out.println(colorsText.cyan("2") + " - Comprar Produto");
        System.out.println(colorsText.cyan("3") + " - Listar Vendas dos Fornecedores");
        System.out.println(colorsText.cyan("4") + " - Listar Produtos");
        System.out.println(colorsText.cyan("0") + " - Sair da Aplicação");
        System.out.println(colorsText.yellow("------------------------------------------"));
        
        System.out.print(colorsText.cyan(":"));     
        
	}
	
	public static void choiceMethodPayment() {
		System.out.print("\n");
		System.out.print(colorsText.cyan("Digite a forma de pagamento de acordo com o número "));
        System.out.print(colorsText.cyan(" 1 - Credito"));
        System.out.print(" | ");
        System.out.print(colorsText.cyan(" 2 - Debito"));        
		System.out.print(colorsText.cyan(" :"));
	}
	
	public static void selectById(String string) {
		System.out.printf(colorsText.cyan("Digite o Id do %s :"), string);
	}
	
	public static void desiredQuantity() {
		System.out.print(colorsText.cyan("Digite a Quantidade Desejada: "));
	}
	
	public static void clearPrompt() {
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }

	public static void choiceValidOption() {
		System.out.println( colorsText.red("\nEscolha uma opção válida"));
	}

	public static void pressToNext() {
		System.out.print("\nPressione S ou Y para continuar: ");
	}


	
	

}
