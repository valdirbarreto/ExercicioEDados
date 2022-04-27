package exercicio_EDados;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;

public class UtilLocadora {

	Scanner lerOpcao = new Scanner (System.in);
	
	public Loja criaLoja (String nomeLoja) {
		String nome  = new String (nomeLoja);
		AtomicInteger indice = new AtomicInteger();
		Carro [ ] frota = new Carro [5]; 
		ArrayList <Cliente> clientes = new ArrayList <> ();
		ArrayList <Cliente> filaEspera = new ArrayList <> ();
		ArrayList <RegistroLog> alugados = new ArrayList <> ();
		Stack <RegistroLog> log = new Stack <> ();
		
		Loja loja = new Loja (nome, indice, frota, clientes, filaEspera, alugados, log);
		return loja;
	}
	
	public String menu () {
		StringBuilder prompt = new StringBuilder();
		
		prompt.append("\nDigite a op��o desejada: \n");
		prompt.append("1 - Ver lista de Lojas \n");
		prompt.append("2 - Selecionar loja \n");
		prompt.append("0 - Sair \n");
		
		System.out.println(prompt.toString ());

		return lerOpcao.nextLine();
	}

}
