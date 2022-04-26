package exercicio_EDados;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class Utilities {

	Scanner lerOpcao = new Scanner (System.in);
	Scanner lerDouble = new Scanner (System.in);
	Scanner lerInt = new Scanner (System.in);
	
	public String menu () {
		
		
		StringBuilder prompt = new StringBuilder();
		
		prompt.append("Digite a opção desejada: \n");
		prompt.append("1 - Cadastrar carro novo \n");
		prompt.append("2 - Remover carro \n");
		prompt.append("3 - Tornar carro disponível ou indisponível \n");
		prompt.append ("4 - Cadastrar Cliente\n");
		prompt.append("5 - Aluguel de carro\n");
		prompt.append ("6 - Devolução de carro\n");
		prompt.append ("7 - Relatórios\n");
		prompt.append("0 - Sair \n");
		
		System.out.println(prompt.toString ());

		return lerOpcao.nextLine();
	}

	public void cadastrarCarro (Carro [] fiftyCar, Integer indice) {
		
		fiftyCar [indice] = menuCadastro ();
	}
	
	public boolean removerCarro (Carro [] fiftyCar, Integer indice) {
		String placa = menuRemocao ();
		int ind = buscaPlaca (placa, fiftyCar, indice); // ind é indice do carro a ser removido
		if (ind  < indice && ind >= 0) {
			fiftyCar [ind] = fiftyCar [indice - 1];
			return true;
		} else {
			System.out.println("Placa inválida");
			return false;
		}
	}
	
	public void listarCarrosDisponiveis (Carro [] fiftyCar, Integer indice) {
		System.out.println("FIFTY CARS \n");
		System.out.println("Confira nossos modelos: \n");
		int carDisp = 0;
		for (int i = 0; i < indice; i++) {
			if (fiftyCar [i].isDisponivel()) {
				carDisp++;
				System.out.printf ("Carro disponível número %d%n", i+1);
				System.out.printf ("Marca: %s%n", fiftyCar[i].getMarca());
				System.out.printf ("Modelo: %s%n", fiftyCar[i].getModelo());
				System.out.printf ("Cor: %s%n", fiftyCar[i].getCor());
				System.out.printf ("Placa: %s%n", fiftyCar[i].getPlaca());
				System.out.printf ("Valor da diária: %.2f%n%n", fiftyCar[i].getValorDiaria());
	//			System.out.printf ("Carro disponível: %s%n%n", (frota[i].isDisponivel()==true)?"Sim":"Não");
			}	
		}	
		if (carDisp == 0) System.out.println(" Não há carros disponíveis");
	}
	
	public void listarPorPreco (Carro [] fiftyCar, int indice) {
		Carro [] temp = new Carro [fiftyCar.length];
		System.arraycopy(fiftyCar, 0, temp, 0, fiftyCar.length);
		if (indice > 2) {
			Arrays.sort(temp);
		}
		System.out.println("FIFTY CARS \n");
		System.out.println("Confira nossos modelos (listados por preço): \n");
		int carDisp = 0;
		for (int i = 0; i < indice; i++) {
			if (temp [i].isDisponivel()) {
				System.out.printf ("Carro número %d%n", ++carDisp);
				System.out.printf ("Marca: %s%n", temp[i].getMarca());
				System.out.printf ("Modelo: %s%n", temp[i].getModelo());
				System.out.printf ("Cor: %s%n", temp[i].getCor());
				System.out.printf ("Placa: %s%n", temp[i].getPlaca());
				System.out.printf ("Valor da diária: %.2f%n%n", temp[i].getValorDiaria());
			}			
		}
		if (carDisp == 0) System.out.println(" Não há carros disponíveis");	
	}
	
	public void mudarEstado (Carro [] fiftyCar, int indice) {
		
		System.out.println("Digite a placa do carro a mudar a disponibilidade: ");
		String placa = lerOpcao.nextLine();
		int ind = buscaPlaca (placa, fiftyCar, indice);
		if (ind < indice  && ind >=0) {
			System.out.println("Digite I/i - Indisponível ou D/d - Disponível ");
			switch (lerOpcao.nextLine()){
			case "I":
			case "i":
				fiftyCar [ind].setDisponivel(false);
				break;
			case "D":
			case "d":
				fiftyCar [ind].setDisponivel(true);
				break;
			default:
				System.out.println("Opção inválida\n");
			}
		} else {
			System.out.println("Placa inválida \n");
		}
	
		
	}
	
	public void cadastrarCliente (ArrayList<Cliente> clientes) {
		clientes.add(menuCliente ());
		
	}
	
		
	public void alugarCarro (Carro [] fiftyCar, int indice, ArrayList <Cliente> clientes, ArrayList <Cliente> fila,
			ArrayList <RegistroLog> alugados) {
		
		System.out.println("Digite o telefone com o DDD do cliente (somente números): ");
		String fone = lerOpcao.nextLine();
		int i;
		for (i = 0; i < clientes.size(); i++) {
			if (!(clientes.get(i).getTelefone().equals (fone))) {
			} else {
				break; // cliente cadastrado
			}
		}
		if (i == clientes.size()) { // cliente não cadastrado
			clientes.add(menuCliente ());
		}
		System.out.println("Digite o modelo do carro a ser alugado: ");
		String modelo = lerOpcao.nextLine();
		int numCar = buscaModeloDisponivel (modelo, fiftyCar, indice);  //índice carro disponível
		
		if (numCar != -1) {
			fiftyCar [numCar].setDisponivel(false);
			for (int j = 0; j < fila.size (); j++) {
				if (fila.get(j).getTelefone().equals (fone) ) { // cliente em fila de espera
					fila.remove(j);
					break;
				}
			}
			RegistroLog aluguel = new RegistroLog ();
			aluguel.setCarro (fiftyCar [numCar]);
			aluguel.setCliente(clientes.get(i));
			aluguel.setDataEntrada (new Date ());
			alugados.add(aluguel);
			System.out.printf("Carro Marca: %s Modelo: %s Placa: %s alugado para cliente: %s Fone: %s%n%n",
					fiftyCar [numCar].getMarca(), fiftyCar [numCar].getModelo(), fiftyCar [numCar].getPlaca(), 
					clientes.get(i).getNome(), clientes.get(i).getTelefone() );
				
		} else {
			System.out.println("Não há carros deste modelo. Cliente ficará em lista de espera\n");
			fila.add(clientes.get(i));
		}
	}
	
	public void devolverCarro (Carro [] fiftyCar, int indice, ArrayList <Cliente> clientes, ArrayList <Cliente> fila,
			ArrayList <RegistroLog> alugados) {
		
		System.out.println("Digite a placa do carro sendo devolvido (somente letras e números): ");
		String placa = lerOpcao.nextLine();
		int numCar = buscaPlaca (placa, fiftyCar, indice);
		if (numCar != -1) {
			fiftyCar [numCar].setDisponivel(true);
			for (int j = 0; j < alugados.size(); j++) {
				if (alugados.get(j).getCarro().getPlaca().equalsIgnoreCase(placa)) {
					alugados.get(j).setDataSaida(new Date());
					RegistroLog novoRegistro = new RegistroLog ();
//					novoRegistro.gravaLog (alugados.get(j));
					System.out.printf("Carro Marca: %s Modelo: %s Placa: %s devolvido.%n%n",
							fiftyCar [numCar].getMarca(), fiftyCar [numCar].getModelo(), fiftyCar [numCar].getPlaca());
					checaFila (alugados.get(j).getCarro().getModelo(),fila);
					alugados.remove(j);
					break;
				}
			}
		} else {
			System.out.println("Placa inválida! ");
		}
	}
	
	
	private Carro menuCadastro () {
		
		Carro carroNovo = new Carro ();
		
		System.out.println("Digite a marca: ");
		carroNovo.setMarca (lerOpcao.nextLine());
		
		System.out.println("Digite o modelo: ");
		carroNovo.setModelo (lerOpcao.nextLine());
		
		System.out.println("Digite a cor: ");
		carroNovo.setCor (lerOpcao.nextLine());
		
		System.out.println("Digite a placa (somente letras e números): ");
		carroNovo.setPlaca (lerOpcao.nextLine());
		
		System.out.println("Digite o valor da diária em Reais: ");
		carroNovo.setValorDiaria(lerDouble.nextDouble());
		
		carroNovo.setDisponivel(true);
		
		return carroNovo;
	}
	
	private String menuRemocao () {
		
		System.out.println("Digite a placa do carro a ser removido: ");
		return lerOpcao.nextLine ();
	}
	
	private Cliente menuCliente () {
		
		Cliente cliente = new Cliente ();
		Endereco endereco = new Endereco();
		Carro carro = new Carro ();
		
		System.out.println("Digite o nome: ");
		cliente.setNome (lerOpcao.nextLine());
		
		System.out.println("Digite o telefone com o DDD (somente números): ");
		cliente.setTelefone(lerOpcao.nextLine());
		
		System.out.println("Digite o logradouro (rua, avenida, etc e número): ");
		endereco.setLogradouro(lerOpcao.nextLine());
		
		System.out.println("Digite o complemento: ");
		endereco.setComplemento(lerOpcao.nextLine());
		
		System.out.println("Digite o CEP: ");
		endereco.setCEP(lerOpcao.nextLine());
		
		cliente.setEndereco(endereco);
				
		System.out.println("Digite o modelo do carro desejado: ");
		carro.setModelo(lerOpcao.nextLine());
		cliente.setCarroDesejado(carro);
		
		return cliente;
		
	}
	
	private int buscaPlaca (String placa, Carro [] fiftyCar, int indice) { // busca burra da placa, retorna indice em frota ou -1
		
		int i;
		for (i = 0; i < indice; i++) {
			if (placa.equalsIgnoreCase(fiftyCar [i].getPlaca())) {
				return i;
			} 
		}
		return -1;
	}
	
	private int buscaModeloDisponivel (String modelo, Carro [] fiftyCar, int indice) { // busca burra do modelo
		int i;
		for (i = 0; i < indice; i++) {
			if (modelo.equalsIgnoreCase(fiftyCar [i].getModelo())) {
				if (fiftyCar [i].isDisponivel())
				return i;
			} 
		}
		return -1;
	}
	
	private void checaFila (String modelo, ArrayList <Cliente> fila) {
		fila.stream().forEach((Cliente cliente) -> {					// lambda!!!!!!
			if (cliente.getCarroDesejado().getModelo().equalsIgnoreCase(modelo)) {
				System.out.printf("ATENÇÃO! cliente %s, fone: %s está na fila de espera por carro deste modelo. "
						+ "AVISÁ-LO IMEDIATAMENTE%n%n",cliente.getNome(), cliente.getTelefone());
			}
		});
	}
		
}
