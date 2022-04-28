package exercicio_EDados;


public class Carro implements Comparable <Carro>{
	
//	Atributos: Placa, Marca, Cor, Modelo, valor da diária do carro , se está disponível
	
	private String placa;
	private String marca;
	private String cor;
	private String modelo;
	private double valorDiaria;
	private boolean disponivel;
	
	
	public Carro (String placa, String marca, String cor, String modelo,
			double valorDiaria, boolean disponivel) {
		this.placa = placa;
		this.marca = marca;
		this.cor = cor;
		this.modelo = modelo;
		this.valorDiaria = valorDiaria;
		this.disponivel = disponivel;
		
		
	}
	
	public Carro() {
		// TODO Auto-generated constructor stub
	}

	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public double getValorDiaria() {
		return valorDiaria;
	}
	public void setValorDiaria(double valorDiaria) {
		this.valorDiaria = valorDiaria;
	}
	public boolean isDisponivel() {
		return disponivel;
	}
	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}
	
	@Override
	public int compareTo (Carro carro) {
		return Double.valueOf(getValorDiaria()).compareTo (Double.valueOf(carro.getValorDiaria()));
	}

	@Override
	public String toString() {
		return "Carro [modelo=" + modelo + "]";
	}
	
	
	
	
	

}
