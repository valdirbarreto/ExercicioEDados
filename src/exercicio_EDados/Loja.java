package exercicio_EDados;

import java.util.ArrayList;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;

public class Loja  {
	private String nome;
	private AtomicInteger indice;
	private Carro [ ] frota; 
	private ArrayList <Cliente> clientes;
	private ArrayList <Cliente> filaEspera;
	private ArrayList <RegistroLog> alugados;
	private  Stack <RegistroLog> log;
	
	public Loja () {
		
	}
	
	public Loja(String nome, AtomicInteger indice, Carro[] frota, ArrayList<Cliente> clientes, ArrayList<Cliente> filaEspera,
			ArrayList<RegistroLog> alugados, Stack<RegistroLog> log) {
		super();
		this.nome = nome;
		this.indice = indice;
		this.frota = frota;
		this.clientes = clientes;
		this.filaEspera = filaEspera;
		this.alugados = alugados;
		this.log = log;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public AtomicInteger getIndice() {
		return indice;
	}

	public void setIndice(AtomicInteger indice) {
		this.indice = indice;
	}

	public Carro[] getFrota() {
		return frota;
	}

	public void setFrota(Carro[] frota) {
		this.frota = frota;
	}

	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}

	public ArrayList<Cliente> getFilaEspera() {
		return filaEspera;
	}

	public void setFilaEspera(ArrayList<Cliente> filaEspera) {
		this.filaEspera = filaEspera;
	}

	public ArrayList<RegistroLog> getAlugados() {
		return alugados;
	}

	public void setAlugados(ArrayList<RegistroLog> alugados) {
		this.alugados = alugados;
	}

	public Stack<RegistroLog> getLog() {
		return log;
	}

	public void setLog(Stack<RegistroLog> log) {
		this.log = log;
	}

	
	
	
	
}