package exercicio_EDados;

public class Cliente {
	private String nome;
	private String telefone;
	private Endereco endereco;
	private Carro carroDesejado;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public Carro getCarroDesejado() {
		return carroDesejado;
	}
	public void setCarroDesejado(Carro carroDesejado) {
		this.carroDesejado = carroDesejado;
	}
	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", telefone=" + telefone + ", endereco=" + endereco.toString() + ", carroDesejado="
				+ carroDesejado.toString() + "]\n";
	}
	
	

}
