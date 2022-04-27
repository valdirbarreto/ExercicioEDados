package exercicio_EDados;

import java.util.LinkedList;
import java.util.Scanner;

public class Locadora {
	
	

	public static void main(String[] args) {
		LinkedList <Loja> lojas = new LinkedList <> ();
		
		UtilLocadora utilLocadora = new UtilLocadora ();
		
		lojas.add(utilLocadora.criaLoja ("Matriz"));
		lojas.add(utilLocadora.criaLoja ("RJ"));
		lojas.add(utilLocadora.criaLoja ("BH"));
		
		Monitor monitor = new Monitor ();
		Scanner lerOpcao = new Scanner (System.in);
		String opcao = utilLocadora.menu ();
		
		do {
			switch (opcao) {
			case "1":
				System.out.println ("Lista de Lojas \n");
				lojas.forEach(loja -> System.out.printf("Loja: %s\n", loja.getNome()));
				break;
			case "2":
				System.out.println ("Digite o nome da loja \n");
				String lojaaPesquisar = lerOpcao.nextLine();
				int i;
				for (i = 0; i < lojas.size(); i++) {
					if (lojas.get(i).getNome().equalsIgnoreCase(lojaaPesquisar)) {
						System.out.printf("******************* LOJA %s  ******************** \n", lojas.get(i).getNome().toUpperCase());
						monitor.monitor (lojas.get(i).getNome(), lojas.get(i).getIndice(),lojas.get(i).getFrota(), lojas.get(i).getClientes(),
								lojas.get(i).getFilaEspera(), lojas.get(i).getAlugados(), lojas.get(i).getLog());
						break;
					}
				}
				if (i == lojas.size()) System.out.println ("Loja não existe");
				break;
			case "0":				// sair
				System.out.println("Saindo do Sistema Pangeia de Gerenciamento de Locadoras");
				return;
			default:
				System.out.println("Opção Inválida\n");
			}
			
			opcao = utilLocadora.menu ();
			
		} while (true);
		
		
		
	
	}

}
