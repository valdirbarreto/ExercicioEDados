package exercicio_EDados;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;

public class Relatorios {
	
	Scanner lerOpcao = new Scanner (System.in);	
	Utilities utilities = new Utilities ();
	
	public void relatorios (String nome, int indice, Carro[] fiftyCar, ArrayList<Cliente> clientes, ArrayList<Cliente> fila,
			 ArrayList<RegistroLog> alugados, Stack<RegistroLog> log) {
		
		String opcao = menuRelatorios ();
		switch (opcao) {
		case "1": // listar carros disponíveis
			if (indice != 0) {	
				System.out.printf("******************* LOJA %s  ******************** \n", nome.toUpperCase());
				utilities.listarCarrosDisponiveis (fiftyCar, indice);
			} else {
				System.out.println("Não há carros cadastrados!\n");
			}
			break;
		case "2":  // listar por preço
			if (indice != 0) {
				System.out.printf("******************* LOJA %s  ******************** \n", nome.toUpperCase());
				utilities.listarPorPreco (fiftyCar, indice);
			} else {
				System.out.println("Não há carros cadastrados!\n");
			}
			break;
		case "3":		// imprimir lista de espera
			if (fila.size() != 0) {
				System.out.printf("******************* LOJA %s  ******************** \n", nome.toUpperCase());
				Cliente clienteEmEspera = new Cliente ();
				System.out.printf("Número de clientes na fila de espera: %d%n",fila.size());
				for (int i = 0; i < fila.size(); i++) {
					clienteEmEspera = fila.get(i);
					System.out.println(clienteEmEspera.toString());
				}
			} else {
				System.out.println ("Fila de espera vazia \n");
			}
			break;
		case "4":						
			if (alugados.size() !=0) {
				System.out.printf("******************* LOJA %s  ******************** \n", nome.toUpperCase());
				alugados.forEach((RegistroLog registro) -> {
					String data = new SimpleDateFormat ("dd/MM/yyyy 'às' HH:mm 'horas'").format (registro.getDataEntrada());
					System.out.printf("Carro Marca: %s, Modelo: %s, Placa: %s, alugado para cliente: %s, Fone: %s no dia %s%n%n",
							registro.getCarro().getMarca(), registro.getCarro().getModelo(), registro.getCarro().getPlaca(),registro.getCliente().getNome(),
							registro.getCliente().getTelefone(), data );
				});
			} else {
				System.out.println("Não há carros alugados!\n");
			}
			break;
		case "5":			//relatório de movimentação
			System.out.printf("******************* LOJA %s  ******************** \n", nome.toUpperCase());
			RegistroLog l = new RegistroLog ();
			l.imprimeLog (log);
			break;
		case "6":			// valor total em diárias
			System.out.printf("******************* LOJA %s  ******************** \n", nome.toUpperCase());
			double totalDiarias = 0;
			if (alugados.size() != 0) {
				for (RegistroLog registro : alugados) {
					totalDiarias += registro.getCarro().getValorDiaria();
				}
				System.out.printf("Valor total de diárias: R$ %.2f", totalDiarias);
			} else {
				System.out.println("Não há carros alugados!\n");
			}
			break;
		case "7":			// totais de carros
			System.out.printf("******************* LOJA %s  ******************** \n", nome.toUpperCase());
			System.out.printf("Total de carros: %d%n", indice );
			System.out.printf("Total de carros alugados: %d%n", alugados.size());
			System.out.printf("Total de carros disponíveis: %d%n", indice - alugados.size());
			break;
		case "0":
			System.out.println("Obrigado por consultar nossas opções! Volte sempre à Pangeia Locadora!");
			return;
		default:
			System.out.println("Opção Inválida\n");
		}
	}
	
	public String menuRelatorios () {
		StringBuilder prompt = new StringBuilder();
		
		prompt.append("Digite a opção desejada: \n");
		prompt.append("1 - Imprimir lista dos carros disponíveis\n");
		prompt.append("2 - Imprimir lista por preço (mais baratos primeiro) \n");
		prompt.append("3 - Imprimir lista de espera \n");
		prompt.append("4 - Imprimir relatório de carros alugados\n");
		prompt.append ("5 - Imprimir relatório de movimentação (alugados já devolvidos)\n"); 
		prompt.append("6 - Imprimir valor total em diárias dos carros alugados \n");
		prompt.append("7 - Imprimir o número de carros alugados e o total de carros \n");
		prompt.append("0 - Sair \n");
		
		System.out.println(prompt.toString ());

		return lerOpcao.nextLine();
	}

}
