package exercicio_EDados;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Stack;
import java.util.stream.Collectors;

public class Log {
	private Date dataEntrada;
	private Date dataSaida;
	private Cliente cliente;
	private Carro carro;

	private static Stack <Log> log = new Stack<Log>();

	public void gravaLog(Log log) {
		Log.log.push(log);
	}
	
	public void imprimeLog () {
		Stack <Log> logaux = new Stack <> ();
		logaux.addAll(log);
//		logaux = log;
		while (!logaux.isEmpty()) {
			Log registro = new Log();
			registro = logaux.pop();
			String dataSaida = new SimpleDateFormat ("dd/MM/yyyy 'às' HH:mm 'horas'").format (registro.getDataSaida());
			System.out.printf("Em %s, carro %s, modelo %s, placa %s foi DEVOLVIDO por %s%n", dataSaida, registro.getCarro().getMarca(),
					registro.getCarro().getModelo(), registro.getCarro().getPlaca(), registro.getCliente().getNome());
			String dataEntrada = new SimpleDateFormat ("dd/MM/yyyy 'às' HH:mm 'horas'").format (registro.getDataEntrada());
			System.out.printf("Em %s, carro %s, modelo %s, placa %s foi EMPRESTADO por %s%n",dataEntrada, registro.getCarro().getMarca(),
					registro.getCarro().getModelo(), registro.getCarro().getPlaca(), registro.getCliente().getNome());
		}
	}
	

	public Date getDataEntrada() {
		return dataEntrada;
	}

	public Date getDataSaida() {
		return dataSaida;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public Carro getCarro() {
		return carro;
	}

	public void setDataEntrada(Date dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public void setDataSaida(Date dataSaida) {
		this.dataSaida = dataSaida;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}
	
	
		
	
}
